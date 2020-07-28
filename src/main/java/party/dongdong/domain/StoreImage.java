package party.dongdong.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class StoreImage {

    @Id @GeneratedValue
    @Column(name = "store_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    public static StoreImage createStoreImage(Store store, Image image){
        StoreImage storeImage = new StoreImage();
        storeImage.store = store;
        storeImage.image = image;
        return storeImage;
    }
}
