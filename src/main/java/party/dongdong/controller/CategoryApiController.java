package party.dongdong.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import party.dongdong.domain.Category;
import party.dongdong.dto.CategoryDto;
import party.dongdong.repository.CategoryQueryRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class CategoryApiController {

    private final CategoryQueryRepository categoryQueryRepository;

    @GetMapping("/api/v1/category")
    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryQueryRepository.findAll();
        List<CategoryDto> result = categoryList.stream().map(c -> new CategoryDto(c.getId(), c.getName()))
                .collect(Collectors.toList());

        return result;
    }
}
