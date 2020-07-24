package party.dongdong.dto;

import lombok.Getter;
import lombok.Setter;
import party.dongdong.domain.Address;

import java.time.LocalDateTime;

@Getter
@Setter
public class StoreListDto {

    private Long storeId;
    private String category;
    private String name;
    private String storeOwner;
    private String description;
    private String benefits;
    private Address address;
    private LocalDateTime created;

    public StoreListDto(Long storeId, String category, String name, String storeOwner, String description, String benefits, Address address, LocalDateTime created) {
        this.storeId = storeId;
        this.category = category;
        this.name = name;
        this.storeOwner = storeOwner;
        this.description = description;
        this.benefits = benefits;
        this.address = address;
        this.created = created;
    }
}
