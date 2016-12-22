package com.inspiry;

import com.inspiry.model.User;
import com.inspiry.service.FooService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by zijiao on 12/21/16.
 */
@SpringBootApplication
@MapperScan("com.inspiry.mapper")
@ImportResource("classpath:/datasource-application.xml")
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private FooService fooService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    public void run(String[] args) throws Exception {
        fooService.count();
        fooService.getUser(2);

        User user = new User();
        user.setName("nicole");
        fooService.addUser(user);
        fooService.getUser(2);
    }
}
