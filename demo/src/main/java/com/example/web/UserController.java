package com.example.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.util.MD5Utils;
import com.example.util.ParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.domain.JsonMessage;
import com.example.service.UserService;
import com.example.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author sheamus
 * @date 2018.8.14
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
	private UserService userService;
	
    @GetMapping(value = "/listUser")
    public JsonMessage getUser() {
    	JsonMessage result = new JsonMessage();
        Map<String, Object> data = new HashMap<String, Object>(16);
        try {
        	List<Map<String,Object>> userList = userService.listUser();
        	data.put("userList", userList);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
            result.setData(data);
        }catch (Exception e){
            result.setData(data);
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }

    @PostMapping(value = "/saveUser")
    public JsonMessage saveUser(HttpServletRequest request, HttpServletResponse response) {
        JsonMessage result = new JsonMessage();
        Map<String, Object> data = new HashMap<String, Object>(16);
        try {
            Map<String, Object> param = ParamsUtils.getParmas(request);
            if(userService.countUser(param) == 0){
                String username1=request.getParameter("username");
                String password1=request.getParameter("password");
                String password = (String) param.get("password");
                param.put("password",MD5Utils.getSaltMD5(password));
                userService.saveUser(param);
                result.setResponseCode(Constants.RES_CODE_0);
                result.setErrorMessage(Constants.RES_MESSAGE_0);
                result.setData(data);
            }else{
                result.setResponseCode(Constants.RES_CODE_907);
                result.setErrorMessage(Constants.RES_MESSAGE_907);
                result.setData(data);
            }
        }catch (Exception e){
            result.setData(data);
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }
}
