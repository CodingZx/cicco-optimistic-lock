package lol.cicco;

import lol.cicco.service.RetryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {
    @Autowired
    private RetryService service;


    @Test
    public void test1(){
        service.set(10);

        Assert.assertEquals(service.get(), 11);
    }

    @Test
    public void test2(){
        service.set(0);

        String exceptionMsg = "";
        try{
            service.alwaysRetry();
        }catch (Exception e){
            exceptionMsg = e.getMessage();
        }
        Assert.assertEquals(exceptionMsg, "error:10");
    }

}
