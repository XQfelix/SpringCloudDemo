package com.noWebSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class NoWebSpringApplication{

	public static void main(String[] args) throws InterruptedException {
      
      SpringApplication app = new SpringApplication(NoWebSpringApplication.class);
      //禁用Web服务, 这样就可以使用Spring的注解, 并且不会加载tomcat等组件
      app.setWebApplicationType(WebApplicationType.NONE); 
      ConfigurableApplicationContext appContext = app.run(args);
      NoWebSpringApplication mainAPP = appContext.getBean(NoWebSpringApplication.class);
      mainAPP.callRoute();
      
      Thread.sleep(2000);
      
      mainAPP.callRoute();
      
      Thread.sleep(2000);
      
      mainAPP.callRoute();
      
      Thread.sleep(2000);
      
      mainAPP.callRoute();
      
}
	
	
	/**注入feign**/
	@Autowired
	private HelloClient hClient;
	
	public void callRoute() {
		Police result = hClient.call(1);
		System.out.println("------------" + result.getId()+"-----" + result.getName()+"------" + result.getMessage());
//		return result;
	}

}
