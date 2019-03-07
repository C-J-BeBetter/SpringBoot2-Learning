package com.chaijin.annotation;

import com.chaijin.validater.DateTimeValidater;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: SpringBoot2-Learning
 * @Package: com.chaijin.annotation
 * @ClassName: DateTime
 * @Description:
 * @Author: 柴进
 * @Date: 2019/3/7 9:56
 * @Version: 1.0
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateTimeValidater.class)
public @interface DateTime {
    /**
     * 错误消息  - 关键字段
     *
     * @return 默认错误消息
     */
    String message() default "格式错误";

    /**
     * 格式
     *
     * @return 验证的日期格式
     */
    String format() default "yyyy-MM-dd";

    /**
     * 允许我们为约束指定验证组 - 关键字段（TODO 下一章中会介绍）
     *
     * @return 分组
     */
    Class<?>[] groups() default {};

    /**
     * payload - 关键字段
     *
     * @return 暂时不清楚, 知道的欢迎留言交流
     */
    Class<? extends Payload>[] payload() default {};
}
