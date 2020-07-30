package party.dongdong.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import party.dongdong.domain.*;
import party.dongdong.dto.StoreListDto;


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

        List<Store> stores = query.select(store)
                                .from(store)
                                .leftJoin(store.images, storeImage)
                                .fetchJoin()
                                .distinct()
                                .fetch();

        return stores;
    }
}
