package com.genscript.DroolsSpring.controller;

import javax.annotation.Resource;

import org.kie.api.KieBase;
import org.kie.api.cdi.KBase;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genscript.DroolsSpring.service.CustomerService;

@Controller
@RequestMapping("/test")
public class TestController {

    @Resource
    private ApplicationContext context;

    @Resource
    private CustomerService customerService;

    @Resource
    @KBase(value = "rules")
    private KieBase kiebase;

    @RequestMapping("/hello")
    public String hello() {
        // Customer customer = customerService.getById(20002);
        // customer.setFirstName("罗进勇xxx");
        // this.customerService.save(customer);

        try {
            // load up the knowledge base
            // KieServices ks = KieServices.Factory.get();
            // KieContainer kContainer = ks.getKieClasspathContainer();
            // KieSession kSession = kContainer.newKieSession("ksession-rules");
            customerService.executeRule();

            // // 新实例
            // KieSession newKieSession = kiebase.newKieSession();
            // Message message = new Message();
            // message.setMessage("Hello World");
            // message.setStatus(Message.HELLO);
            // newKieSession.insert(message);
            // newKieSession.fireAllRules();
            //
            // // 单例
            // KieSession ksessionRules = (KieSession)
            // context.getBean("ksession-rules");
            // message = new Message();
            // message.setMessage("Hello World");
            // message.setStatus(Message.HELLO);
            // ksessionRules.insert(message);
            // ksessionRules.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return "/test/hello";
    }

}
