package party.dongdong.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import party.dongdong.domain.Store;
import party.dongdong.dto.PageRequest;
import party.dongdong.dto.StoreListDto;
import party.dongdong.dto.StoreSaveDto;
import party.dongdong.dto.StoreSearchRequestDto;
import party.dongdong.service.StoreService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StoreApiController {

    private final StoreService storeService;

    @PostMapping("/api/v1/store")
    public Long register(@RequestBody StoreSaveDto saveDto) {
        return storeService.register(saveDto);
    }

    @GetMapping("/api/v1/store")
    public List<StoreListDto> findAllDesc(PageRequest page) {
        return storeService.findAllDesc(page);
    }

    @GetMapping("/api/v1/store/search")
    public List<StoreListDto> search(StoreSearchRequestDto requestDto) {
        return storeService.search(requestDto);
    }
}
