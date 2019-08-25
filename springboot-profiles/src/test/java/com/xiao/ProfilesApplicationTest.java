package com.xiao;

import com.xiao.config.Production;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfilesApplication.class)
@ActiveProfiles("test")
public class ProfilesApplicationTest {


    @Autowired
    private Production production;

    @Test
    public void testProfile(){
        String name = production.getProductName();
        System.out.println("---------------");
        System.out.println(name);
    }
}
