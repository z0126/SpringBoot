package com.example;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringBootTestApplicationTests {
    @Autowired
    JavaMailSenderImpl javaMailSender;
    //简单邮件
    @Test
    void contextLoads() {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setSubject("小狂神你好！！！");//z主题
        simpleMailMessage.setText("感谢你的课程");
        simpleMailMessage.setTo("2042438311@qq.com");
        simpleMailMessage.setFrom("2042438311@qq.com");
        javaMailSender.send(simpleMailMessage);
    }

    //复杂邮件
    @Test
    void MailTest() throws MessagingException {
        //邮件设置2：一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper= new MimeMessageHelper(mimeMessage,true);//"utf-8":可有可无;
        //异常处理快捷键   Ctrl+Alt+T

        helper.setSubject("通知-明天来狂神这听课");
        helper.setText("<b style='color:red'>今天 7:30来开会</b>",true);
        //参数为true，是否开启HTML

        //发送附件
        helper.addAttachment("1.png",new File("C:\\Users\\20424\\Pictures\\Saved Pictures\\1.png"));
        helper.addAttachment("QQ.png",new File("C:\\Users\\20424\\Pictures\\Saved Pictures\\QQ.png"));

        helper.setTo("2042438311@qq.com");
        helper.setFrom("2042438311@qq.com");

        javaMailSender.send(mimeMessage);
    }

}
