package net.wchar.camel.sample;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author wchar.net
 */
@SpringBootTest(classes = CamelSampleApplication.class)
class CamelSampleApplicationTests {

    @Autowired
    protected CamelContext camelContext;

    @Autowired
    protected ProducerTemplate producerTemplate;

    @Test
    void contextLoads() {
    }

}
