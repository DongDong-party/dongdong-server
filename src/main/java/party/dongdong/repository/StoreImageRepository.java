package party.dongdong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import party.dongdong.domain.StoreImage;

public interface StoreImageRepository extends JpaRepository<StoreImage, Long> {
}
