package site.nebulas.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@Lazy(false)
public class TimerService implements InitializingBean {
	private Logger logger = LoggerFactory.getLogger(TimerService.class);
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	/*
	 * 0 0 3 * * *  
	 * 
	 * 
	 * 
	 * */
	@Scheduled(cron="0 0/1 * * * *")
	public void timer() {
		System.out.println("121");
	}
	
}
