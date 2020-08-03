package party.dongdong.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import party.dongdong.domain.Store;
import party.dongdong.domain.QCategory;
import party.dongdong.domain.QStore;
import party.dongdong.domain.QStoreImage;


import java.util.List;

@Repository
public class StoreQueryRepository extends QuerydslRepositorySupport {

    private final JPAQueryFactory query;

    public StoreQueryRepository(JPAQueryFactory query) {
        super(Store.class);
        this.query = query;
    }

    public List<Store> findAllDesc() {
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
                                .orderBy(store.id.desc())
                                .fetch();

        return stores;
    }
}
