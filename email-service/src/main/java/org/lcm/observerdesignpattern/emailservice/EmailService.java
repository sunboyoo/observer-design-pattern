package org.lcm.observerdesignpattern.emailservice;

import org.lcm.observerdesignpattern.commons.UserRegistrationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

/**
 * 创建邮箱Service，实现 ApplicationListener 接口，
 * 通过 E 泛型设置感兴趣的事件，实现 onApplicationEvent(E event) 方法，针对监听的 UserRegisterEvent 事件，进行自定义处理。
 * 使用 Order 控制后续服务的处理顺序
 */

//@Order(1)
public class EmailService implements ApplicationListener<UserRegistrationEvent> {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(UserRegistrationEvent event) {
        // (1) 监听到事件，获取事件信息
        logger.info("[EmailService.onApplicationEvent()][监听到了用户{}的注册事件]", event.getUserId());

        // (2) 执行EmailService的处理逻辑
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("[EmailService.onApplicationEvent()][执行用户{}的注册事件的后续服务EmailService逻辑]", event.getUserId());
    }
}
