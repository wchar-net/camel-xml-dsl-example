package net.wchar.camel.sample;

import org.apache.camel.ExtendedCamelContext;
import org.apache.camel.spi.Resource;
import org.apache.camel.support.ResourceHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * demo04
 * node1(取用户表中最大的id) -> node2(调用http接口) -> node3(将http接口返回值存储到表中)
 *
 * @author wchar.net
 */
public class Demo04Test extends CamelSampleApplicationTests {


    @BeforeEach
    public void init() throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get(this.getClass().getResource("/demo04.xml").toURI()));
        ExtendedCamelContext ecc = camelContext.adapt(ExtendedCamelContext.class);
        Resource resource = ResourceHelper.fromBytes("resource.xml", bytes);
        ecc.getRoutesLoader().loadRoutes(resource);
    }

    @Test
    public void main() {
        producerTemplate.requestBody("direct:queryStandardData", null, String.class);
    }

}
