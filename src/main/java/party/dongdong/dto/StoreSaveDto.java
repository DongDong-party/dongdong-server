package party.dongdong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import party.dongdong.domain.Address;
import party.dongdong.domain.Store;


@AllArgsConstructor
@Getter
@Setter
public class StoreSaveDto {

    private Long categoryId;
    private String storeOwner;
    private String description;
    private String benefits;

    private String metropolitan;
    private String city;
    private String gu;

    public Store toEntity() {
        Address address = new Address(metropolitan, city, gu);
        return Store.createStore(storeOwner, description, benefits, address);
    }
}
