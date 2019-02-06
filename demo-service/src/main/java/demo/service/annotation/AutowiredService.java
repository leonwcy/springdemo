package demo.service.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.concurrent.ExecutorService;

@Service
public class AutowiredService {
    /***
     * Autowired 是默认根据类型注入的，而且必须找到唯一符合的对象，如果找到多个则可以定义为数组
     * Autowired 的实现源码主要是AutowiredAnnotationBeanPostProcessor ，Autowired可以标记在属性和方法上进行注入
     * 具体的匹配 调用 beanfactory 的 doresolvedependency
     * Autowired 需要指定名称的时候需要配合注解 Qualifier 使用
     */
    @Autowired
    ExecutorService[] pools;

    @Autowired
    @Qualifier(value="stockExecutor")
    ExecutorService firstpool;

    ExecutorService secondpool;

    @Autowired
    ApplicationContext ctx;

    @Autowired(required = false)
    @Qualifier(value="stockExecutor3")
    //@Nullable
    ExecutorService thirdpool;

    @Autowired
    public void AutowiredService(@Qualifier(value="stockExecutor2") ExecutorService pool)
    {
        secondpool =pool;
    }

    public void testAutowiredService(){
        Assert.isTrue(pools.length>1,"pools should be more than one");
        Assert.notNull(secondpool,"secondpool should not be null");
        Assert.notNull(ctx,"ctx should not be null");
    }

}
