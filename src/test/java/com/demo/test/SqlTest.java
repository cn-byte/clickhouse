package com.demo.test;

import com.demo.DemoClickHouse;
import com.demo.domain.config.ClickHouseConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoClickHouse.class)
public class SqlTest {

    @Test
    public void select_Test() {
        String sql="select cluster,shard_num from clusters where  cluster like '%test%'";
        List<Map<String,String>> result= ClickHouseConfig.exeSql(sql);

        System.out.println(result);
    }
}
