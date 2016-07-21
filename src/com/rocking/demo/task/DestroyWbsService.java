package com.rocking.demo.task;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import weibo4j.Timeline;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;

@Component
public class DestroyWbsService {
	@Scheduled(cron="0 0 6,18 * * ?")
	public void destroyMethod(){
		String access_token = "2.00GVyqUDjbzJsDaf6672942cDplIWB";
		Timeline tm = new Timeline(access_token);
		int i = 0;
		while(i<100){
			try {
				StatusWapper wapper =  tm.getUserTimeline();
				List<Status> statuses = wapper.getStatuses();
				for (Status status : statuses) {
					String weiboId = status.getId();
					tm.destroy(weiboId);
					System.out.println(status.toString());
					System.out.println(++i+" deld");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Scheduled(cron="0 * 21,22 * * ?")
	public void testMethod(){
		String access_token = "2.00GVyqUDjbzJsDaf6672942cDplIWB";
		System.out.println(access_token);
	}
}
