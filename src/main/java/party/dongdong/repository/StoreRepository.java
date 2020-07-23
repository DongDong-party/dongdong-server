package party.dongdong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import party.dongdong.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
