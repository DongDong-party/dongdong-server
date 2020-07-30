package party.dongdong.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String storeOwner;

    private String description;

    private String benefits;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "store")
    private List<StoreImage> images;

    private LocalDateTime created;

    @Column(columnDefinition = "boolean default false", nullable = false)
    private Boolean isRemoved;

    //==생성 관련 메서드==/
    public Store(String name, String storeOwner, String description, String benefits, Address address) {
        this.name = name;
        this.storeOwner = storeOwner;
        this.description = description;
        this.benefits = benefits;
        this.address = address;
    }

    public static Store createStore(String name,
                                    String storeOwner,
                                    String description,
                                    String benefits,
                                    Address address) {
        return new Store(name, storeOwner, description, benefits, address);
    }

    public void registerCategory(Category category) {
        this.category = category;
    }

    @PrePersist
    public void prePersist() {
        if (this.isRemoved == null) this.isRemoved = false;
        if (this.created == null) this.created = LocalDateTime.now();
    }
}
