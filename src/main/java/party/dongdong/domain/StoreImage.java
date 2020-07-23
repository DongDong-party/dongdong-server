package party.dongdong.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class StoreImage {

    @Id @GeneratedValue
    @Column(name = "store_image_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;
}
