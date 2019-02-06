package demo.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadConfiguation {

    @PostConstruct
    public void init(){
        int i = 1;
    }

    @Bean(name = "stockExecutor")
    public ExecutorService stockExecutor(){
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()*10,
                        Runtime.getRuntime().availableProcessors()*20,
                        60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(1000));
        return threadPoolExecutor;
    }

    @Bean(name = "stockExecutor2")
    public ExecutorService stockExecutor2(){
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()*1,
                        Runtime.getRuntime().availableProcessors()*2,
                        60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(1000));
        return threadPoolExecutor;
    }
}
