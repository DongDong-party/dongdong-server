package party.dongdong.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import party.dongdong.domain.Category;
import party.dongdong.domain.Store;
import party.dongdong.dto.StoreSaveDto;
import party.dongdong.repository.StoreRepository;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StoreServiceTest {

    @Autowired EntityManager em;
    @Autowired StoreService storeService;
    @Autowired StoreRepository storeRepository;

    @Test
    public void storeRegisterTest() {
        //when
        Category category = new Category();
        category.setName("맛집");
        em.persist(category);

        //given
        StoreSaveDto saveDto = new StoreSaveDto(
                category.getId(),
                "짱짱맛집",
                "정원",
                "돈까스가 맛있는집",
                "할인10%!",
                "서울",
                "용산구",
                "무슨동",
                "서울시 용산구 무슨동 어쩌구 건물");
        Long storeId = storeService.register(saveDto);

        //then
        Store store = storeRepository.findById(storeId).get();

        assertEquals("짱짱맛집", store.getName());
        assertEquals("정원", store.getStoreOwner());
        assertEquals("서울", store.getAddress().getBigCity());
    }

}