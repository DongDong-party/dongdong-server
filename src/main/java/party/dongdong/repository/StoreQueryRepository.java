package party.dongdong.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import party.dongdong.domain.Store;
import party.dongdong.domain.QCategory;
import party.dongdong.domain.QStore;
import party.dongdong.domain.QStoreImage;
import party.dongdong.dto.PageRequest;
import party.dongdong.dto.StoreSearchRequestDto;
import party.dongdong.modules.PagingManager;


import java.util.List;

@Repository
public class StoreQueryRepository extends QuerydslRepositorySupport {

    private final JPAQueryFactory query;
    private final PagingManager pagingManager;

    public StoreQueryRepository(JPAQueryFactory query, PagingManager pagingManager) {
        super(Store.class);
        this.query = query;
        this.pagingManager = pagingManager;
    }

    public List<Store> findAllDesc(PageRequest page) {
        QStore store = QStore.store;
        QStoreImage storeImage = QStoreImage.storeImage;
        QCategory category = QCategory.category;

        List<Store> stores = query.select(store)
                                .from(store)
                                .innerJoin(store.category, category)
                                .fetchJoin()
                                .leftJoin(store.images, storeImage)
                                .fetchJoin()
                                .leftJoin(storeImage.image)
                                .fetchJoin()
                                .distinct()
                                .where(idLt(page.getCursor()))
                                .limit(pagingManager.getPageSize())
                                .orderBy(store.id.desc())
                                .fetch();

        return stores;
    }

    public List<Store> search(StoreSearchRequestDto requestDto) {
        QStore store = QStore.store;
        QStoreImage storeImage = QStoreImage.storeImage;
        QCategory category = QCategory.category;

        List<Store> stores = query.select(store)
                .from(store)
                .innerJoin(store.category, category)
                .fetchJoin()
                .leftJoin(store.images, storeImage)
                .fetchJoin()
                .leftJoin(storeImage.image)
                .fetchJoin()
                .distinct()
                .where(categoryIdEq(requestDto.getCategoryId()),
                        keywordContains(requestDto.getKeyword()),
                        idLt(requestDto.getCursor()))
                .orderBy(store.id.desc())
                .limit(pagingManager.getPageSize())
                .fetch();

        return stores;
    }

    private BooleanExpression idLt(Integer cursor) {
        if (cursor == null) {
            return null;
        }
        return QStore.store.id.lt(cursor);
    }

    private BooleanExpression categoryIdEq(Long categoryId) {
        if (categoryId == null) {
            return null;
        }
        return QStore.store.category.id.eq(categoryId);
    }

    private BooleanExpression keywordContains(String keyword) {
        if (keyword == null) {
            return null;
        }

        BooleanExpression byName = QStore.store.name.contains(keyword);
        BooleanExpression byDescription = QStore.store.description.contains(keyword);

        return byName.or(byDescription);
    }
}
