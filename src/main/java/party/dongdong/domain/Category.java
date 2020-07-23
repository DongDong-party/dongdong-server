package party.dongdong.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Store> stores = new ArrayList<>();

    private LocalDateTime created;

    @Column(columnDefinition = "boolean default false")
    private Boolean isRemoved;

    public void setName(String name) {
        this.name = name;
    }

    @PrePersist
    public void prePersist() {
        if (this.isRemoved == null) this.isRemoved = false;
        if (this.created == null) this.created = LocalDateTime.now();
    }
}
