package com.example.web;

import com.example.DemoApplication;
import com.example.domain.JsonMessage;
import com.example.util.Constants;
import com.example.util.ParamsUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping(value="/mail")
@PropertySource("classpath:mail.properties")
public class MailController {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    @Value("${mail.username}")
    private String from;

    @Autowired
    private JavaMailSender jms;

    @PostMapping("/send")
    public JsonMessage send(HttpServletRequest request, HttpServletResponse response){
        JsonMessage result = new JsonMessage();
        try {
            Map<String, Object> param = ParamsUtils.getParmas(request);
            String to = param.get("to").toString();
            String subject = param.get("subject").toString();
            String test = param.get("test").toString();
            //建立邮件消息
            SimpleMailMessage mainMessage = new SimpleMailMessage();
            //发送者
            mainMessage.setFrom(from);
            //接收者
            mainMessage.setTo(to);
            //发送的标题
            mainMessage.setSubject(subject);
            //发送的内容
            mainMessage.setText(test);
            jms.send(mainMessage);
            logger.info("邮件发送成功, cost {} million seconds", System.currentTimeMillis());
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
        }catch (Exception e){
            logger.error("邮件发送失败, error message is : {} \n", e.getMessage());
            result.setResponseCode(Constants.RES_CODE_908);
            result.setErrorMessage(Constants.RES_MESSAGE_908);
        }

        return result;
    }

}
