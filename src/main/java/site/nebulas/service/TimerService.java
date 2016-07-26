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
	 * 每天3点将昨天未支付的订单状态改为已删除
	 * 
	 * */
	@Scheduled(cron="0/5 * * * * *")
	public void timer() {
		System.out.println("121");
	}
	
}
