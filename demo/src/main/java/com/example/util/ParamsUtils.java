package com.example.util;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParamsUtils {

        /**
         * @Title: getParmas
         * @Description: 得到前台转来的参数
         * @param @param
         * @param @return
         * @return Map
         * @throws @author
         * @date
         */
        public static Map<String, Object> getParmas(ServletRequest request) {
            Map<String, Object> reMap = new HashMap<>();
            byte[] requestData = (byte[]) request.getAttribute(Constants.REQUEST_STREM);
            if (requestData == null || requestData.length == 0) {
                // GET方法获取参
                Map map = request.getParameterMap();
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    int i;
                    String key;
                    Object rvalue;
                    key = it.next().toString();
                    String[] value = (String[]) map.get(key);
                    rvalue = value[0];
                    reMap.put(key, rvalue);
                }
            } else {
                reMap = JsonUtils.readValue(requestData, Map.class);
            }
            return reMap;
        }

        public static Map<String, Object> getParmasAop(ServletRequest request) {
            // 拿到输入流，通过Request传给Controller，以便Controller相关方法执行JSON的反序列化
            Map<String, Object> reMap = new HashMap<>();

            byte[] requestData = (byte[]) request.getAttribute(Constants.REQUEST_STREM);
            if (requestData == null || requestData.length == 0) {
                // GET方法获取参
                Map map = request.getParameterMap();
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    int i;
                    String key;
                    Object rvalue;
                    key = it.next().toString();
                    String[] value = (String[]) map.get(key);
                    rvalue = value[0];
                    reMap.put(key, rvalue);
                }
            } else {
                reMap = JsonUtils.readValue(requestData, Map.class);
            }
            return reMap;
        }

}
