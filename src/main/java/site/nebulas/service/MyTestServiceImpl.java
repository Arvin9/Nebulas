package site.nebulas.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component  //import org.springframework.stereotype.Component;
@Lazy(false)
public class MyTestServiceImpl implements InitializingBean {  
	@Scheduled(cron="0/5 * * * * ? ")
    public void myTest(){  
		System.out.println("进入测试");  
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		
		
	}  
}