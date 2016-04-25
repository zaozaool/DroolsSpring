/**
 * <p>Project: DroolsSpring</p>
 * <p>File: CustomerServiceImpl.java</p>
 * <p>Copyright: Copyright (c) 2016.All rights reserved.</p>
 * <p>Company:www.genscript.com</p>
 * Date:2016-3-9
 * @author:Administrator
 */
package com.genscript.DroolsSpring.service.impl;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.genscript.DroolsSpring.dao.CustomerDao;
import com.genscript.DroolsSpring.drools.entity.Message;
import com.genscript.DroolsSpring.model.Customer;
import com.genscript.DroolsSpring.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ApplicationContext context;

    // @Autowired
    // @KBase(value = "rules")
    // private KieBase kiebase;

    private Message message;

    public Customer getById(Integer custNo) {
        return customerDao.getById(custNo);
    }

    public Customer save(Customer customer) {
        customerDao.save(customer);
        return customer;
    }

    public void executeRule() {

        // // 新实例
        // KieSession newKieSession = kiebase.newKieSession();
        // message = new Message();
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

        // KieSession ksessionProcess = (KieSession)
        // context.getBean("ksession-dtables");
        // message = new Message();
        // message.setMessage("Hello World");
        // message.setStatus(Message.HELLO);
        // ksessionProcess.insert(message);
        // ksessionProcess.fireAllRules();

        // 单例
        KieSession ksession = (KieSession) context.getBean("ksession");
        // ksession.startProcess("com.genscript.DroolsSpring.drools.bpmn.hello");

        message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        message.setTimes(0);
        // System.setProperty("jxl.encoding", "UTF-8");
        ksession.insert(message);
        ksession.fireAllRules();

        QueryResults qr = ksession.getQueryResults("query fact count");
        System.out.println("Message 对象数目：" + qr.size());

    }
}
