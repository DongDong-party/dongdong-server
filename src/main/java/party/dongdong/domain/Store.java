package party.dongdong.domain;

import com.sun.tools.corba.se.idl.StringGen;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Store {

    @Id @GeneratedValue
    @Column(name = "store_id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String storeOwner;

    private String description;

    private String benefits;

    @Embedded
    private Address address;

    private LocalDateTime created;

    @Column(columnDefinition = "boolean default false")
    private Boolean isRemoved;

    //==생성 관련 메서드==/
    public Store(String storeOwner, String description, String benefits, Address address) {
        this.storeOwner = storeOwner;
        this.description = description;
        this.benefits = benefits;
        this.address = address;
    }

    public static Store createStore(String storeOwner,
                                    String description,
                                    String benefits,
                                    Address address) {
        return new Store(storeOwner, description, benefits, address);
    }

    public void registerCategory(Category category) {
        this.category = category;
    }
}
