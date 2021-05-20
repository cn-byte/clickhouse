package com.demo.test;

import com.demo.DemoClickHouse;
import com.demo.domain.dataobject.User;
import com.demo.domain.service.UserService;
import com.demo.infrastructure.util.page.PageResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoClickHouse.class)
public class UserMapperTest {

    @Autowired
    UserService userService;


    @Test
    public void findById_Test() {
        User byId = userService.findById(1);
        System.out.println("查询用户ID=1信息：" + byId);
    }

    @Test
    public void page_Test() {
        User user = new User();
        Integer page = 1;
        Integer limit = 2;
        PageResult<User> userList = userService.page(user, page, limit);
        System.out.println("查询用户信息分页：" + userList);
    }

    @Test
    public void create_Test() {
        User user = new User();
        user.setUserName("张三");
        user.setPassWord("123");
        user.setPhone("12312222");
        user.setEmail("326427540@qq.com");
        userService.create(user);
        System.out.println("创建：" + user);
    }

    @Test
    public void update_Test() {
        User user = new User();
        user.setId(1395347901827317761l);
        user.setUserName("小李飞刀");
        user.setPassWord("123");
        user.setPhone("12312222");
        user.setEmail("326427540@qq.com");
        userService.update(user);
        System.out.println("创建：" + user);
    }


    @Test
    public void delete_Test() {
        userService.delete(1l);
        System.out.println("删除：" + 1l);
    }

}
