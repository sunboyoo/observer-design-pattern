package org.lcm.observerdesignpattern.couponservice;

import org.lcm.observerdesignpattern.commons.UserRegistrationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;

/**
 * 创建优惠券Service，
 * 不同于EmailService的实现 ApplicationListener 接口方式，
 * 在方法上，添加 @EventListener 注解，并设置监听的事件为 UserRegisterEvent。这是另一种使用方式。
 * 使用 Order 控制后续服务的处理顺序
 */
public class CouponService{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    // 指定要监听的事件类型
    // 参数 - The event classes that this listener handles.
    // 参数为唯一的时候，可以在方法中接收一个参数
    // 参数为多个的时候，方法中不能接收任何参数。必须为无参方法
    // If this attribute is specified with a single value, the annotated method may optionally accept a single parameter.
    // However, if this attribute is specified with multiple values, the annotated method must not declare any parameters.
    //@Order(0)
    @EventListener(UserRegistrationEvent.class)
    public void onApplicationEvent(UserRegistrationEvent event) {
        // (1) 监听到事件，获取事件信息
        logger.info("[CouponService.onApplicationEvent()][监听到了用户{}的注册事件]", event.getUserId());

        // (2) 执行CouponService的处理逻辑
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("[CouponService.onApplicationEvent()][执行用户{}的注册事件的后续服务CouponService逻辑]", event.getUserId());
    }
}
