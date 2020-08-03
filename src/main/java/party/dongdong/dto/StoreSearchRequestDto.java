package party.dongdong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StoreSearchRequestDto {
    private String keyword;
    private Long categoryId;
}
