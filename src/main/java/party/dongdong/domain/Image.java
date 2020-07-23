package party.dongdong.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
public class Image {

    @Id @GeneratedValue
    @Column(name = "image_id")
    private Long id;

    private String url;

    private LocalDateTime created;
}
