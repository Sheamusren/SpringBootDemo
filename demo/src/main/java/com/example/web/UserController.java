package com.example.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.JsonMessage;
import com.example.service.UserService;
import com.example.util.Constants;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
	private UserService userService;
	
    @GetMapping(value = "/getUser")
    public JsonMessage getUser() {
    	JsonMessage result = new JsonMessage();
        Map<String, Object> data = new HashMap<String, Object>();
        try {
        	List<Map<String,Object>> userList = userService.getUser();
        	data.put("userList", userList);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
            result.setData(data);
        }catch (Exception e){
            result.setData(data);
            result.setResponseCode(Constants.RES_CODE_904);
            result.setErrorMessage(Constants.RES_MESSAGE_904);
        }
        return result;
    }
}
