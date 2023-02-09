package net.wchar.camel.sample;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;


/**
 * @author wchar.net
 */
@SpringBootTest(classes = CamelSampleApplication.class)
public class CamelSampleApplicationTests {

    @Autowired
    protected CamelContext camelContext;

    @Autowired
    protected ProducerTemplate producerTemplate;

    @Autowired
    protected DataSource dataSource;

    @Test
    void contextLoads() {
    }

}
