package party.dongdong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import party.dongdong.domain.Category;
import party.dongdong.domain.Store;
import party.dongdong.dto.StoreListDto;
import party.dongdong.dto.StoreSaveDto;
import party.dongdong.repository.CategoryRepository;
import party.dongdong.repository.StoreQueryRepository;
import party.dongdong.repository.StoreRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreQueryRepository storeQueryRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public Long register(StoreSaveDto saveDto) {
        Store store = saveDto.toEntity();
        Category category = categoryRepository.findById(saveDto.getCategoryId())
                                        .orElseThrow(EntityNotFoundException::new);

        store.registerCategory(category);
        storeRepository.save(store);

        return store.getId();
    }

    public List<StoreListDto> findAllDesc() {
        return storeQueryRepository.findAllDesc();
    }
}
