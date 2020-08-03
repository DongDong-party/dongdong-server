package party.dongdong.modules;

import org.springframework.stereotype.Component;

@Component
public class PagingManager {

    int pageSize = 3;

    public int getPageSize(){
        return this.pageSize;
    }

}
