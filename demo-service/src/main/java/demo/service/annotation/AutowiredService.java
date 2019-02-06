package demo.service.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.concurrent.ExecutorService;

@Service
public class AutowiredService {
    @Autowired
    ExecutorService[] pools;

    @Autowired
    @Qualifier(value="stockExecutor")
    ExecutorService firstpool;

    public void testAutowiredService(){
        Assert.isTrue(pools.length>1,"pools should be more than one");
    }

}
