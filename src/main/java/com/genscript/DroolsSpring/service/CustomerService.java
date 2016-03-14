/**
 * <p>Project: DroolsSpring</p>
 * <p>File: ICustomerService.java</p>
 * <p>Copyright: Copyright (c) 2016.All rights reserved.</p>
 * <p>Company:www.genscript.com</p>
 * Date:2016-3-9
 * @author:Administrator
 */
package com.genscript.DroolsSpring.service;

import com.genscript.DroolsSpring.model.Customer;

public interface CustomerService {

    public Customer getById(Integer custNo);

    public Customer save(Customer customer);

    public void executeRule();
}
