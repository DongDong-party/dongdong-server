package party.dongdong.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Image {

    @Id @GeneratedValue
    @Column(name = "image_id")
    private Long id;

    private String url;

    private LocalDateTime created;

    @PrePersist
    public void prePersist() {
        if (this.created == null) this.created = LocalDateTime.now();
    }

    public static Image createImage(String url) {
        Image image = new Image();
        image.url = url;

        return image;
    }
}
