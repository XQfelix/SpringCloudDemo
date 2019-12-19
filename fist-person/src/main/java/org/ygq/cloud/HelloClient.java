package org.ygq.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("first-police")
public interface HelloClient {

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	String hi();
	
	@RequestMapping(value = "/call/{id}", method = RequestMethod.GET)
	Police call(@PathVariable("id") Integer id);
	
	
}
