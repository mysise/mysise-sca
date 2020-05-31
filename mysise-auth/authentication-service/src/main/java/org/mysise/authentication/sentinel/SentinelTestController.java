package org.mysise.authentication.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaojing
 */
@RestController
public class SentinelTestController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/hello")
	@SentinelResource("resource")
	public String hello() {
		return "Hello";
	}

	@GetMapping(value = "/aa")
	@SentinelResource("aa")
	public String aa(int b, int a) {
		return "Hello test";
	}

	@GetMapping(value = "/test")
	public String test1() {
		return "Hello test";
	}

	@GetMapping(value = "/template")
	public String client() {
		return restTemplate.getForObject("http://www.taobao.com/test", String.class);
	}

}
