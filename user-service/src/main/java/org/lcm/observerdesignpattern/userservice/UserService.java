package org.lcm.observerdesignpattern.userservice;

import org.lcm.observerdesignpattern.commons.UserRegistrationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 *
 *
 * 定义用户注册服务类，实现 ApplicationEventPublisherAware 接口，从而将 ApplicationEventPublisher 注入进来。
 * 从下面代码可以看到，在执行完注册逻辑后，
 * 调用了 ApplicationEventPublisher的 publishEvent(ApplicationEvent event) 方法，发布了 UserRegisterEvent 事件。
 */

public class UserService implements ApplicationEventPublisherAware {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(Integer userId){

        // (1) 执行用户注册逻辑
        logger.info("[UserService.register()][执行用户{}的注册逻辑]", userId);

        // (2)发布用户注册事件
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("[UserService.register()][发布用户{}的注册事件]", userId);
        applicationEventPublisher.publishEvent(new UserRegistrationEvent(this, userId));
    }
}
