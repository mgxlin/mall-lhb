package com.lhb.mall.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author lhb
 * @date 2022/1/17 19:33
 */
@Component
public class OrderTimeOutCancelTask {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    /**
     * 定时器，每十分钟检查一次
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    public void cancelTimeOutOrder() {
        LOGGER.info("取消订单");
    }
}
