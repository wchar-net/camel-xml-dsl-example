package net.wchar.camel.sample;

import org.apache.camel.ExtendedCamelContext;
import org.apache.camel.spi.Resource;
import org.apache.camel.support.ResourceHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * demo03
 * 调用http接口 -> 将返回值写入到数据库表中
 *
 * @author wchar.net
 */
public class Demo03Test extends CamelSampleApplicationTests {


    @BeforeEach
    public void init() throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get(this.getClass().getResource("/demo03.xml").toURI()));
        ExtendedCamelContext ecc = camelContext.adapt(ExtendedCamelContext.class);
        Resource resource = ResourceHelper.fromBytes("resource.xml", bytes);
        ecc.getRoutesLoader().loadRoutes(resource);
    }

    @Test
    public void main() {
        producerTemplate.requestBody("direct:startHttp", null, String.class);
    }

}
