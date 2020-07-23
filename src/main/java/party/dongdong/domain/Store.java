package party.dongdong.domain;

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
}
