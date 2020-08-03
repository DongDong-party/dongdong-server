package party.dongdong.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import party.dongdong.domain.Category;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CategoryQueryRepositoryTest {

    @Autowired EntityManager em;
    @Autowired CategoryQueryRepository categoryQueryRepository;

    @Test
    public void findAllTest() {
        Category category1 = new Category();
        category1.setNameForTest("맛집");
        category1.setCustomOrderForTest(1);
        em.persist(category1);

        Category category2 = new Category();
        category2.setNameForTest("카페");
        category2.setCustomOrderForTest(2);
        em.persist(category2);

        em.flush();

        List<Category> result = categoryQueryRepository.findAll();

        assertEquals(category1.getId(), result.get(0).getId());
        assertEquals(category2.getId(), result.get(1).getId());
    }
}