package party.dongdong.dto;

import lombok.Getter;
import lombok.Setter;
import party.dongdong.domain.Address;
import party.dongdong.domain.Store;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class StoreListDto {

    private Long storeId;
    private String category;
    private String name;
    private String storeOwner;
    private String shortDescription;
    private String benefits;
    private Address address;
    private List<String> images;
    private LocalDateTime created;

    public StoreListDto(Store store) {
        this.storeId = store.getId();
        this.category = store.getCategory().getName();
        this.name = store.getName();
        this.storeOwner = store.getStoreOwner();
        this.shortDescription = store.getShortDescription();
        this.benefits = store.getBenefits();
        this.address = store.getAddress();
        this.images = store.getImages().stream().map(i -> i.getImage().getUrl()).collect(Collectors.toList());
        this.created = store.getCreated();
    }
}
