/*
 * © Copyright 2016 Resolve Software Pty Ltd.
 * All rights reserved.
 *
 * This software is the confidential and proprietary property of
 * Resolve Software Pty Ltd.
 */
package com.resolvesw.demo.jeedeployment;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.whatever.hostinterface.ServiceInterface;
import com.whatever.hostinterface.ServiceLogic;

/**
 * @author sfcoy
 */
@Path("")
public class Demo {

//  @EJB(lookup = "java:global/demoejb/ServiceBean")
    private ServiceInterface demoEJB;
    private ServiceLogic remoteEJB;
    @PostConstruct
    void initialise() {
        try {
            InitialContext initialContext = new InitialContext();
            demoEJB = (ServiceInterface)initialContext.lookup("java:global/WhizBangSessionEJB/WhizBangSessionEJB!com.whatever.hostinterface.ServiceLogicLocal");
            remoteEJB = (ServiceLogic)initialContext.lookup("java:global/WhizBangSessionEJB/WhizBangSessionEJB!com.whatever.hostinterface.ServiceLogic");
        } catch (NamingException e) {
            throw new RuntimeException("Failed to lookup demoEJB", e);
        }
    }

    @GET
    public String sayHello() {
        return demoEJB.sayHello();
    }

    @GET
    @Path("remote")
    public String sayRemoteHello() {
        return "remote " + remoteEJB.sayHello();
    }
}
