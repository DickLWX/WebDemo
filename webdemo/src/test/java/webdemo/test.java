package webdemo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dick.entity.User;
import dick.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/application-context.xml"})
public class test {
    @Autowired
    private UserService userService;

    @Test
    public void add() {
       User entity = new User();
       entity.setUserId("test");
       entity.setUserNickname("testnickname");
       entity.setUserPassword("123456");
       entity.setUserEmail("123@132.com");
       entity.setActiState(1);
       entity.setActiCode("123");
       entity.setSalt("123");
       entity.setTokenExptime(new Date());
       userService.insert(entity);
    }
}
