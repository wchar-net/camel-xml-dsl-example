package net.wchar.camel.sample;

import org.apache.camel.ExtendedCamelContext;
import org.apache.camel.spi.Resource;
import org.apache.camel.support.ResourceHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * demo01
 * 查询用户表表中符合规范的数据 -> 然后插入到结果表中
 *
 * @author wchar.net
 */
public class Demo01Test extends CamelSampleApplicationTests {


    @BeforeEach
    public void init() throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get(this.getClass().getResource("/demo01.xml").toURI()));
        ExtendedCamelContext ecc = camelContext.adapt(ExtendedCamelContext.class);
        Resource resource = ResourceHelper.fromBytes("resource.xml", bytes);
        ecc.getRoutesLoader().loadRoutes(resource);
    }

    @Test
    public void main() {
        producerTemplate.requestBody("direct:queryStandardData", null, String.class);
    }

}
