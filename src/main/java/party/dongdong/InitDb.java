//package party.dongdong;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import party.dongdong.domain.Category;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//
//@RequiredArgsConstructor
//@Component
//public class InitDb {
//
//    private final InitService initService;
//
//    @PostConstruct
//    public void init() {
//        initService.init();
//    }
//
//    @RequiredArgsConstructor
//    @Component
//    @Transactional
//    static class InitService {
//
//        private final EntityManager em;
//
//        public void init() {
//            Category category1 = new Category();
//            Category category2 = new Category();
//            category1.setName("맛집");
//            category2.setName("카페");
//            em.persist(category1);
//            em.persist(category2);
//        }
//
//    }
//
//}
