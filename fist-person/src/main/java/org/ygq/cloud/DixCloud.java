package org.ygq.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cloud1")
public interface DixCloud {
	
	@RequestMapping(value = "/")
	public String cloud1();
}
