package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.util.RedisUtils;

@RestController
@RequestMapping(value="/redis")
public class RedisController {
	@Autowired
	private RedisUtils redisService;
	 
	@RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
	public String redisTest(){
	    StringBuffer sb = new StringBuffer();
	    redisService.set("str", "str");
	    sb.append("str=").append(redisService.get("str").toString()).append(",");    
	    return sb.toString();
	}
}
