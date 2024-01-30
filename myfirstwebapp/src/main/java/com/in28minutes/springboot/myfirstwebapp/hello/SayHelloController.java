package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! You weren't supposed to see this...";
    }

    @RequestMapping("say-hello-html-bad")
    @ResponseBody
    public String sayHelloHtmlInefficient() {
        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE html>");
        sb.append("<html lang=\"en\">");
        sb.append("<head>");
        sb.append("<meta charset=\"UTF-8\">");
        sb.append("<title>My HTML page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<p>Saying hello in HTML :)</p>");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    @RequestMapping("say-hello-html-good")
    public String sayHelloHtmlJsp() {
        return "sayHello";
    }
}
