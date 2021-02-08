package org.lcm.observerdesignpattern.commons;

import org.springframework.context.ApplicationEvent;

/**
 *
 * 事件Event是所有模块之间通讯互动的纽带
 * 以事件为中心
 * 用户注册事件 UserRegistrationEvent
 *
 * UserService 在完成自身的用户注册逻辑之后，仅仅只需要发布一个 UserRegisterEvent 事件，而无需关注其它拓展逻辑。
 * 其它 Service 可以自己订阅 UserRegisterEvent 事件，实现自定义的拓展逻辑。
 *
 * Spring的事件机制主要由3个部分组成。
 *
 * ApplicationEvent：通过继承它，实现自定义事件。另外，通过它的 source 属性可以获取事件源，timestamp 属性可以获得发生时间。
 * ApplicationEventPublisher：通过实现它，来发布变更事件。
 * ApplicationEventListener：通过实现它，来监听指定类型事件并响应动作。
 *
 * 这里就以上面的用户注册为例，来看看代码示例。首先定义用户注册事件 UserRegisterEvent。
 *
 *
 */
public class UserRegistrationEvent extends ApplicationEvent {
    private Integer userId;

    /**
     * Create a new {@code UserRegistrationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserRegistrationEvent(Object source) {
        super(source);
    }

    public UserRegistrationEvent(Object source, Integer userId) {
        super(source);
        this.userId = userId;
    }

    public Integer getUserId(){
        return userId;
    }
}
