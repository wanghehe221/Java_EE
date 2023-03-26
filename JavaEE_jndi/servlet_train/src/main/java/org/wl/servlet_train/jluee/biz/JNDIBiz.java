package org.wl.servlet_train.jluee.biz;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIBiz {
    private Context context = null;
    private static final String NAMESPACE = "java:jboss/exported/";

    public JNDIBiz() throws NamingException {
        context = new InitialContext();
    }

    public void bind(String name, Object obj) throws NamingException {
        context.bind(NAMESPACE + name, obj);
    }

    public void rebind(String name, Object obj) throws NamingException {
        context.rebind(NAMESPACE + name, obj);
    }

    public Object lookup(String name) throws NamingException {
        return context.lookup(NAMESPACE + name);
    }

    public void unbind(String name) throws NamingException {
        context.unbind(NAMESPACE + name);
    }
}
