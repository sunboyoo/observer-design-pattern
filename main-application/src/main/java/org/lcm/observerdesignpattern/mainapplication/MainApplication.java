package org.lcm.observerdesignpattern.mainapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用Spring优雅实现观察者模式
 *
 * 观察者模式定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新，
 * 其主要解决一个对象状态改变给其他关联对象通知的问题，保证易用和低耦合。
 * 一个典型的应用场景是：当用户注册以后，需要给用户发送邮件，发送优惠券等操作，如下图所示。
 *
 * 使用 Order 控制后续服务的处理顺序
 * UserService, EmailService, CouponService是在同一个线程内完成的
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
/*
其实观察者模式于发布订阅还是有区别的，简单来说，发布订阅模式属于广义上的观察者模式，
在观察者模式的 Subject 和 Observer 的基础上，引入 Event Channel 这个中介，进一步解耦。
图示如下，可以看出，观察者模式更加轻量，通常用于单机，
而发布订阅模式相对而言更重一些，通常用于分布式环境下的消息通知场景。
 */
/*
[nio-8080-exec-5] o.l.o.userservice.UserService            : [UserService.register()][执行用户-43054914的注册逻辑]
[nio-8080-exec-5] o.l.o.userservice.UserService            : [UserService.register()][发布用户-43054914的注册事件]
[nio-8080-exec-5] o.l.o.emailservice.EmailService          : [EmailService.onApplicationEvent()][监听到了用户-43054914的注册事件]
[nio-8080-exec-5] o.l.o.emailservice.EmailService          : [EmailService.onApplicationEvent()][执行用户-43054914的注册事件的后续服务EmailService逻辑]
[nio-8080-exec-5] o.l.o.couponservice.CouponService        : [CouponService.onApplicationEvent()][监听到了用户-43054914的注册事件]
[nio-8080-exec-5] o.l.o.couponservice.CouponService        : [CouponService.onApplicationEvent()][执行用户-43054914的注册事件的后续服务CouponService逻辑]
 */

/*
当指定了执行顺序之后，Order(), 按照指定顺序依次执行
不管是否指定执行顺序，前面的服务必须完成之后，后面的服务才会监听到并执行，如果前面的服务阻塞，后面的服务只能在后面排队
它们是在同一个线程内完成的
2021-02-05 12:11:05.851  INFO 16084 --- [nio-8080-exec-1] o.l.o.couponservice.CouponService        : [CouponService.onApplicationEvent()][监听到了用户-832840849的注册事件]
2021-02-05 12:11:10.856  INFO 16084 --- [nio-8080-exec-1] o.l.o.couponservice.CouponService        : [CouponService.onApplicationEvent()][执行用户-832840849的注册事件的后续服务CouponService逻辑]
2021-02-05 12:11:10.856  INFO 16084 --- [nio-8080-exec-1] o.l.o.emailservice.EmailService          : [EmailService.onApplicationEvent()][监听到了用户-832840849的注册事件]
2021-02-05 12:11:15.865  INFO 16084 --- [nio-8080-exec-1] o.l.o.emailservice.EmailService          : [EmailService.onApplicationEvent()][执行用户-832840849的注册事件的后续服务EmailService逻辑]
 */