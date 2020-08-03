package party.dongdong.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import party.dongdong.domain.Category;
import party.dongdong.domain.QCategory;
import party.dongdong.domain.Store;

import java.util.List;

@Repository
public class CategoryQueryRepository extends QuerydslRepositorySupport {

    private final JPAQueryFactory query;

    public CategoryQueryRepository(JPAQueryFactory query) {
        super(Store.class);
        this.query = query;
    }

    public List<Category> findAll() {
        QCategory category = QCategory.category;

        List<Category> categories = query.select(category)
                                        .from(category)
                                        .orderBy(category.customOrder.asc())
                                        .fetch();

        return categories;
    }

}
