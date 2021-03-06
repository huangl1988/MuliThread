import com.newtouch.fbb.mulithread.demo.Executors;
import com.newtouch.fbb.mulithread.demo.UserInfo;
import com.newtouch.fbb.mulithread.demo.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/**
 * Created by steven on 2018/1/8.
 */
public class ExecutorsTest {

    UserInfo userInfo;

    ExecutorService executor;

    UserService userService;

    @Before
    public void init(){
        if(userInfo==null){
            userInfo=new UserInfo();
        }
        if(executor==null){
            executor= Executors.getExecutor();
        }

        userService=UserService.getUserService();

    }

    @Test
    public void testMulidThread(){
        Long start=System.currentTimeMillis();
        Boolean hasError=false;
        CompletableFuture<String> future1=CompletableFuture.supplyAsync(()->{
            userInfo.setBasicInfo(userService.getUserBasicInfo("1"));
            return "succ";
        },executor);

        CompletableFuture<Void> future2=CompletableFuture.supplyAsync(()->{
            userInfo.setClassesInfo(userService.getClassesInfo("1"));
            return null;
        },executor);
        CompletableFuture<Void> future3=CompletableFuture.supplyAsync(()->{
            userInfo.setOtherInfo(userService.otherInfo("1"));
            return null;
        },executor);

        CompletableFuture<Void> allResult=CompletableFuture.allOf(future1,future2,future3);
        try {
            allResult.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(userInfo);
        Long end=System.currentTimeMillis();
        System.out.println(start-end);
    }

    @Test
    public void testNormal(){

        Long start=System.currentTimeMillis();

        userInfo.setBasicInfo(userService.getUserBasicInfo("1"));

        userInfo.setClassesInfo(userService.getClassesInfo("1"));

        userInfo.setOtherInfo(userService.otherInfo("1"));

        System.out.println(userInfo);
        Long end=System.currentTimeMillis();
        System.out.println(start-end);

    }


    @After
    public void doAfter(){
        executor.shutdown();
    }




}
