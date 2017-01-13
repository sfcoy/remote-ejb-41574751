/*
 * © Copyright 2016 Resolve Software Pty Ltd.
 * All rights reserved.
 *
 * This software is the confidential and proprietary property of
 * Resolve Software Pty Ltd.
 */
package com.whatever.hostinterface;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface ServiceLogicLocalHome extends EJBLocalHome {

    ServiceLogicLocal create() throws CreateException;

}
