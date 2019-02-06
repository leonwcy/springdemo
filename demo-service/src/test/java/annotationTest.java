import demo.service.annotation.AutowiredService;
import demo.service.annotation.ResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/applicationContext-bean.xml"
})
@SpringBootTest
public class annotationTest {
    @Autowired
    AutowiredService autowiredService;

    @Autowired
    ResourceService resourceService;

    @Test
    public void testAutowiredService(){
        autowiredService.dowork();
    }

    @Test
    public void testResourceService(){
        resourceService.dowork();
    }

}