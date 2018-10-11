package com.example.util;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 接口返回工具类，支持ModelAndView
 * @author sheamus
 * @date 2018/9/18
 */
public class ResultUtil {

    public static ModelAndView view(String view) {
        return new ModelAndView(view);
    }

    public static ModelAndView view(String view, Map<String, Object> model) {
        return new ModelAndView(view, model);
    }

    public static ModelAndView redirect(String view) {
        return new ModelAndView("redirect:" + view);
    }

}
