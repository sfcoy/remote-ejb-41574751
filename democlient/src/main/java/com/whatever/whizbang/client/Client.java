/*
 * © Copyright 2017 Resolve Software Pty Ltd.
 * All rights reserved.
 *
 * This software is the confidential and proprietary property of
 * Resolve Software Pty Ltd.
 */
package com.whatever.whizbang.client;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.whatever.hostinterface.ServiceLogic;
import com.whatever.hostinterface.ServiceLogicHome;

/**
 * @author sfcoy
 */
public class Client {

    public static void main(String[] args) throws NamingException, RemoteException, CreateException {
        doBeanLookup();
        doBeanLookupViaClientNaming();
    }

    static void doBeanLookup() throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
        // username
        jndiProps.put(Context.SECURITY_PRINCIPAL, "steve");
        // password
        jndiProps.put(Context.SECURITY_CREDENTIALS, "password");
        // This is an important property to set if you want to do EJB invocations via the remote-naming project
        jndiProps.put("jboss.naming.client.ejb.context", true);
        // create a context passing these properties
        Context ctx = new InitialContext(jndiProps);
        // lookup the bean     Foo
        ServiceLogic beanRemoteInterface = (ServiceLogic) ctx.lookup("WhizBangSessionEJB/WhizBangSessionEJB!com.whatever.hostinterface.ServiceLogic");
        String bar = beanRemoteInterface.sayHello();
        System.out.println("Remote bean returned " + bar);
        ctx.close();
        // after this point the beanRemoteInterface is not longer valid!
    }

    static void doBeanLookupViaClientNaming() throws NamingException, RemoteException, CreateException {
        Properties jndiProps = new Properties();
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context ctx = new InitialContext(jndiProps);
        // lookup the bean
        ServiceLogicHome beanRemoteHome = (ServiceLogicHome) ctx.lookup
                ("ejb:/WhizBangSessionEJB/WhizBangSessionEJB!com.whatever.hostinterface.ServiceLogicHome?stateful");
        ServiceLogic beanRemote = beanRemoteHome.create();
        String bar = beanRemote.sayHello();
        System.out.println("Remote bean returned " + bar);
        ctx.close();
        // after this point the beanRemoteInterface is not longer valid!
    }


}
