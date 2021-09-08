package org.dmonix.area51.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest // needed or else the application.yaml is not read
@EnableConfigurationProperties(
    value = ConfigurationObject.class) // must be set or we get FUBAR exception at startup
public class ConfigurationObjectTest {
  @Autowired ConfigurationObject config;

  @Test
  public void assertHost() {
    Assert.assertEquals("127.0.0.1", config.host);
  }

  @Test
  public void assertPort() {
    Assert.assertEquals(8080, config.port);
  }

  @Test
  public void assertInterval() {
    Assert.assertEquals(69, config.interval.toSeconds());
  }
}
