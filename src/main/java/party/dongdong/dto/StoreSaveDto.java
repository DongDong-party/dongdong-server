package party.dongdong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import party.dongdong.domain.Address;
import party.dongdong.domain.Store;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class StoreSaveDto {

    private Long categoryId;
    private String name;
    private String storeOwner;
    private String description;
    private String benefits;

    private String bigCity;
    private String city;
    private String town;
    private String detailAddress;

    private List<Long> imageIds;

    public Store toEntity() {
        Address address = new Address(bigCity, city, town, detailAddress);
        return Store.createStore(name, storeOwner, description, benefits, address);
    }
}
