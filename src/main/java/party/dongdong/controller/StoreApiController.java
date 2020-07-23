package party.dongdong.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import party.dongdong.dto.StoreSaveDto;
import party.dongdong.service.StoreService;

@RequiredArgsConstructor
@RestController
public class StoreApiController {

    private final StoreService storeService;

    @PostMapping("/api/v1/store")
    public Long register(@RequestBody StoreSaveDto saveDto) {
        return storeService.register(saveDto);
    }
}
