package com.somoim.app.payment.scheduler;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.somoim.app.payment.SubsDTO;
import com.somoim.app.payment.SubscriptionService;

@Component
public class SubscriptionRenewal {

	@Autowired
	private SubscriptionService subscriptionService;
	
	
    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public void checkSubscriptions() throws Exception {
		System.out.println("start");
        
    	List<SubsDTO> list = subscriptionService.getAll();
        LocalDateTime currentDateTime = LocalDateTime.now(); // 현재 시간 가져오기

    	for (SubsDTO subscription : list) {
            Date startDate = subscription.getStartDate();
            Date doneDate = subscription.getDoneDate();

            if (startDate != null && doneDate != null) {
                LocalDateTime startDateTime = startDate.toLocalDate().atStartOfDay();
                LocalDateTime doneDateTime = doneDate.toLocalDate().atStartOfDay();

                Duration startToDoneDuration = Duration.between(startDateTime, doneDateTime);
                Duration startToCurrentDuration = Duration.between(startDateTime, currentDateTime);

                // 만료되지 않았고, 현재 시간이 doneDate보다 미래에 있는 경우
                if (!startToCurrentDuration.minus(startToDoneDuration).isNegative()) {
                    // svs를 0으로 업데이트
                    subscription.setSvs(false);
                    subscriptionService.updateSVS(subscription);
                }else {
                	subscription.setSvs(true);
                    subscriptionService.updateSVS(subscription);
                }
            }
        }
    	
    }
}
