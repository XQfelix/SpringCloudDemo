package org.ygq.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@RestController
@Configuration
public class TestController {
	
	
	//引入调用web的一个工具类,本身和cloud没什么关系
	@Bean
	@LoadBalanced
	public static RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value="/rou")
	public String router() {
		//使用刚才建立的bean调用服务
		RestTemplate tp1 = getRestTemplate();
	    String json = tp1.getForObject("http://cloud1", String.class);
	    System.out.println(json);
	    return json;
	}
	
	
	
	
	/**feign**/
	@Autowired
	private HelloClient hClient;
	
	
	@RequestMapping(value = "/router", method = RequestMethod.GET)
	public String route() {
		String result = hClient.hi();
		return result;
	}
	
	@RequestMapping(value = "/police", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Police callRoute() {
		Police result = hClient.call(1);
		return result;
	}
	
	
	
	/**cloud**/
	@Autowired
	DixCloud dixCloud;
	
	@RequestMapping(value = "/clo", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String cloud() {
		return dixCloud.cloud1();
	}
	
}
