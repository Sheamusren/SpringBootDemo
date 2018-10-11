package com.example.web;

import com.example.domain.JsonMessage;
import com.example.service.SystemService;
import com.example.util.Constants;
import com.example.util.MD5Utils;
import com.example.util.ParamsUtils;
import com.example.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sheamus
 * @date 2018.8.14
 */
@RestController
public class SystemController {
    @Autowired
    private SystemService systemService;
    /**
     * 本地访问内容地址 ：http://localhost:8084
     * @param map
     * @return
     */
    @RequestMapping("/")
    public ModelAndView initPag(HashMap<String, Object> map) {
        Map systemConfig = systemService.getSystemConfig();
        map.put("systemConfig", systemConfig);
        return ResultUtil.view("login");
    }

    @PostMapping("/login")
    public JsonMessage login(HttpServletRequest request, HashMap<String, Object> map){
        JsonMessage result = new JsonMessage();
        try {
            Map<String, Object> param = ParamsUtils.getParmas(request);
            param.put("password",MD5Utils.getSaltMD5(param.get("password").toString()));
            if(systemService.countUserByUsername(param) !=0 ){
                if(systemService.countUserByPassword(param) != 0){
                    result.setResponseCode(Constants.RES_CODE_0);
                    result.setErrorMessage(Constants.RES_MESSAGE_0);
                    return result;
                }else{
                    result.setResponseCode(Constants.RES_CODE_903);
                    result.setErrorMessage(Constants.RES_MESSAGE_903);
                    return result;
                }
            }else{
                result.setResponseCode(Constants.RES_CODE_902);
                result.setErrorMessage(Constants.RES_MESSAGE_902);
                return result;
            }
        }catch (Exception e){
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
            return result;
        }
    }
}
