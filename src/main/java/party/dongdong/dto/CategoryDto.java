package party.dongdong.dto;

import lombok.Getter;

@Getter
public class CategoryDto {

    private Long categoryId;
    private String name;

    public CategoryDto (Long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }
}
