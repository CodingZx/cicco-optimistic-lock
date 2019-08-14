package lol.cicco.service;

import lol.cicco.optimisticlock.annotation.Retry;
import lol.cicco.optimisticlock.exception.OptimisticLockException;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RetryService {

    private AtomicInteger count = new AtomicInteger();

    @Retry(value = 5, forException = Exception.class)
    public int get(){
        int get = count.getAndIncrement();
        if(get % 10 ==0){
            throw new RuntimeException();
        }
        return get;
    }

    public void set(int val){
        count.set(val);
    }

    @Retry(value = 10)
    public int alwaysRetry(){
//        int get = count.get();
        throw new OptimisticLockException("error:"+count.incrementAndGet());
    }

}
