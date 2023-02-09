package net.wchar.camel.sample.component;

import net.wchar.camel.sample.CamelSampleApplicationTests;
import org.apache.camel.CamelContext;
import org.apache.camel.ExtendedCamelContext;
import org.apache.camel.spi.Resource;
import org.apache.camel.support.ResourceHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpClientComponentTest extends CamelSampleApplicationTests {
    @BeforeEach
    public void init() throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get(this.getClass().getResource("/camel_component/HttpClientComponent.xml").toURI()));
        ExtendedCamelContext ecc = camelContext.adapt(ExtendedCamelContext.class);
        Resource resource = ResourceHelper.fromBytes("resource.xml", bytes);
        ecc.getRoutesLoader().loadRoutes(resource);
    }

    @Test
    public void main() {
        producerTemplate.requestBody("direct:sqlQueryComponent_88004797-49f9-4dc3-846f-216ae36428de", null, String.class);
    }
}
