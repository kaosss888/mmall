package com.mall.dao.test;

import com.mall.dao.UserMapper;
import com.mall.pojo.User;
import com.mall.test.TestBase;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;

public class DaoTest extends TestBase {

    @Autowired
    private UserMapper userMapper;

    @Ignore
    @Test
    public void testDao(){
        User a = new User();
        a.setPassword("111");
        a.setUsername("aaaaageely");
        a.setRole(0);
        a.setCreateTime(new Date());
        a.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(userMapper.insert(a));
        System.out.println("aaaaaaaaaaaaaa");
    }


}
