package com.could.fegin;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 这个工厂类管理了当前应用需要调用或者已经调用的接口实例。 因为通过动态代理对服务进行了封装。
 * 因此对于一个应用来讲，是需要对服务实例进行管理的，否则每次都会进行创建。
 * 
 */

public class MyEurekaFactory {
	private static final Logger logger = LoggerFactory.getLogger(MyEurekaFactory.class);
	/**
	 * 当前应用对应的服务Map
	 */
	public Map<Class<?>, Object> serviceMap = new HashMap<>();

	private static MyEurekaFactory factory;

	private static ReentrantLock lock = new ReentrantLock();

	private MyEurekaClient client;

	/**
	 * 这个是当前的启动入口
	 */
	private MyEurekaFactory() {
		client = new MyEurekaClient();
	}

	/**
	 * 单例模式创建对象，当然可以通过注解的形式进行创建
	 * 
	 * @return
	 */
	public static MyEurekaFactory gi() {
		if (factory == null) {
			lock.lock();
			if (factory == null) {
				factory = new MyEurekaFactory();
			}
			lock.unlock();
		}
		return factory;
	}

	@SuppressWarnings("unchecked")
	public <T> T createService(Class<T> serviceInterface) {
		if (serviceMap.containsKey(serviceInterface)) {
			logger.debug("Service存在" + serviceInterface);
			return (T) serviceMap.get(serviceInterface);
		} else {
			logger.debug("Service不存在" + serviceInterface);
			return add(serviceInterface);
		}
	}

	/**
	 * 此处未做同步，因为创建多个实例会被覆盖，不会出现问题！ 只会影响首次的创建效率
	 * 
	 * @param serviceInterface
	 * @return
	 */
	private <T> T add(Class<T> serviceInterface) {
		MyEurekaHandler handler = new MyEurekaHandler(client);
		T t = handler.create(serviceInterface);
		serviceMap.put(serviceInterface, t);
		return t;
	}
}