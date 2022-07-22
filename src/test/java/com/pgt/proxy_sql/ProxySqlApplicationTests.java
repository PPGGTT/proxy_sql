package com.pgt.proxy_sql;

import com.pgt.proxy_sql.bean.Country;
import com.pgt.proxy_sql.mapper.MyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProxySqlApplicationTests {
    @Autowired
    private MyMapper mapper;

    @Test
    void contextLoads() {
    }
    @Test
    public void test1(){
//        Country country = mapper.selectById(3);
//        System.out.println(country);
    }

}
