/*
 * © Copyright 2016 Resolve Software Pty Ltd.
 * All rights reserved.
 *
 * This software is the confidential and proprietary property of
 * Resolve Software Pty Ltd.
 */
package com.whatever.hostinterface;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface ServiceLogicHome extends EJBHome {

    ServiceLogic create() throws RemoteException, CreateException;

}
