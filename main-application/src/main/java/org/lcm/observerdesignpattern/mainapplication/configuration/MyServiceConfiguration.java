package org.lcm.observerdesignpattern.mainapplication.configuration;

import org.lcm.observerdesignpattern.couponservice.CouponService;
import org.lcm.observerdesignpattern.emailservice.EmailService;
import org.lcm.observerdesignpattern.userservice.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册组件到容器中
 */
@Configuration
public class MyServiceConfiguration {

    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean
    public EmailService emailService(){
        return new EmailService();
    }

    @Bean
    public CouponService couponService(){
        return new CouponService();
    }
}
