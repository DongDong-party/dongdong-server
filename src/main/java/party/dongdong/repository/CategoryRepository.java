package party.dongdong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import party.dongdong.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
