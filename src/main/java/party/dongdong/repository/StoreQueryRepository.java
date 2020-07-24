package party.dongdong.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import party.dongdong.domain.QStore;
import party.dongdong.domain.Store;
import party.dongdong.dto.StoreListDto;


import java.util.List;

@Repository
public class StoreQueryRepository extends QuerydslRepositorySupport {

    private final JPAQueryFactory query;

    public StoreQueryRepository(JPAQueryFactory query) {
        super(Store.class);
        this.query = query;
    }

    public List<StoreListDto> findAllDesc() {
        QStore store = QStore.store;
        return query.select(
                Projections.constructor(StoreListDto.class,
                        store.id,
                        store.category.name,
                        store.name,
                        store.storeOwner,
                        store.description,
                        store.benefits,
                        store.address,
                        store.created))
                .from(store)
                .orderBy(store.id.desc())
                .fetch();
    }
}
