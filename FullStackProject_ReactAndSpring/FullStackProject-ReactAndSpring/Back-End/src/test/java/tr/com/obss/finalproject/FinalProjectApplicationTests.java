package tr.com.obss.finalproject;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import tr.com.obss.finalproject.dao.BlackListRepository;
import tr.com.obss.finalproject.dao.SellerRepository;
import tr.com.obss.finalproject.dao.UserRepository;
import tr.com.obss.finalproject.model.Seller;
import tr.com.obss.finalproject.model.User;
import tr.com.obss.finalproject.service.impl.AdminServiceImpl;
import tr.com.obss.finalproject.service.impl.UserServiceImpl;

import javax.transaction.Transactional;
import java.util.Set;

@Slf4j
@SpringBootTest
@Transactional
class FinalProjectApplicationTests {
    @Test
    @Modifying
    void contextLoads() {
    }
}
