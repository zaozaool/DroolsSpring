/**
 * <p>Project: DroolsSpring</p>
 * <p>File: Message.java</p>
 * <p>Copyright: Copyright (c) 2016.All rights reserved.</p>
 * <p>Company:www.genscript.com</p>
 * Date:2016-3-9
 * @author:Administrator
 */
package com.genscript.DroolsSpring.drools.entity;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author Administrator
 * @see
 * @since
 */

public class Message {

    public static final int HELLO = 0;

    public static final int GOODBYE = 1;

    private String message;

    private int status;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
