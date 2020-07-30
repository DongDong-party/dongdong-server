package party.dongdong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import party.dongdong.domain.Category;
import party.dongdong.domain.Image;
import party.dongdong.domain.Store;
import party.dongdong.domain.StoreImage;
import party.dongdong.dto.StoreListDto;
import party.dongdong.dto.StoreSaveDto;
import party.dongdong.repository.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreQueryRepository storeQueryRepository;
    private final CategoryRepository categoryRepository;
    private final ImageRepository imageRepository;
    private final StoreImageRepository storeImageRepository;

    @Transactional
    public Long register(StoreSaveDto saveDto) {
        Store store = saveDto.toEntity();
        Category category = categoryRepository.findById(saveDto.getCategoryId())
                                        .orElseThrow(EntityNotFoundException::new);

        store.registerCategory(category);
        storeRepository.save(store);

        List<Long> imageIds = saveDto.getImageIds();

        for (Long imageId : imageIds) {
            Image image = imageRepository.findById(imageId).orElseThrow(EntityNotFoundException::new);
            storeImageRepository.save(StoreImage.createStoreImage(store, image));
        }
        return store.getId();
    }

    public List<StoreListDto> findAllDesc() {
        List<Store> stores = storeQueryRepository.findAllDesc();

        List<StoreListDto> result = stores.stream().map(StoreListDto::new).collect(Collectors.toList());
        return result;
    }
}
