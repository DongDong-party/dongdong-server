package party.dongdong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import party.dongdong.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
