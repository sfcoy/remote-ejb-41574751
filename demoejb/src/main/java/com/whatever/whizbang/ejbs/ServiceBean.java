/*
 * © Copyright 2016 Resolve Software Pty Ltd.
 * All rights reserved.
 *
 * This software is the confidential and proprietary property of
 * Resolve Software Pty Ltd.
 */
package com.whatever.whizbang.ejbs;

import java.io.Serializable;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.whatever.hostinterface.ServiceInterface;

/**
 * @author sfcoy
 */
public class ServiceBean implements ServiceInterface, SessionBean, Serializable {

    public ServiceBean() {}

    public void ejbCreate() {

    }

    public String sayHello() {
        return "hello";
    }

    @Override
    public void setSessionContext(SessionContext ctx) throws EJBException {

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void ejbRemove() throws EJBException {

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void ejbActivate() throws EJBException {

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void ejbPassivate() throws EJBException {

    }

}
