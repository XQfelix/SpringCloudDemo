package com.could.fegin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义接口服务的时候，需要指定这个接口服务对应在Eureka上对应的服务名称。 需要根据这个服务的名称获取对应的Application。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyService {
	String value() default "";

}
