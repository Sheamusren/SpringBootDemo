package com.example.web;

import com.example.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sheamus
 * @date 2018.8.14
 */
@Controller
public class SystemController {
    @Autowired
    private SystemService systemService;
    /**
     * 本地访问内容地址 ：http://localhost:8084/login
     * @param map
     * @return
     */
    @RequestMapping("/")
    public String initPag(HashMap<String, Object> map) {
        Map systemConfig = systemService.getSystemConfig();
        map.put("systemConfig", systemConfig);
        return "login";
    }
}
