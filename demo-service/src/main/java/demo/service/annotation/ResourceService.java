package demo.service.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

@Service
public class ResourceService implements IService {

    @Resource
    ExecutorService[] pools;

    /***
     * @Resource 优先按照名称查找，在名称查找不到的时候按照类型查找
     */
    @Resource(name="stockExecutor")
    ExecutorService firstpool;

    ExecutorService secondpool;

    @Resource
    ApplicationContext ctx;


    @Resource
    public void AutowiredService(@Qualifier(value="stockExecutor2") ExecutorService pool)
    {
        secondpool =pool;
    }

    @Override
    public void dowork() {
        Assert.isTrue(pools.length>1,"pools should be more than one");
        Assert.notNull(firstpool,"firstpool should not be null");
        Assert.notNull(secondpool,"secondpool should not be null");
        Assert.notNull(ctx,"ctx should not be null");
    }
}
