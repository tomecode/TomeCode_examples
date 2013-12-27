package com.tomecode.custom.jmx.mbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import weblogic.logging.NonCatalogLogger;

/**
 * Hello World mbean impl class
 * 
 * @author tomecode.com
 * 
 */
public class HelloWorldMBean implements javax.management.MBeanRegistration, HelloWorldMXBean {

	private static final long serialVersionUID = 5130870521892257315L;

	private static final NonCatalogLogger log = new NonCatalogLogger("HelloWord.HelloWorldMBean");

	public HelloWorldMBean() {
		log.info("init");
	}

	public ObjectName preRegister(MBeanServer server, ObjectName name) throws Exception {
		return name;
	}

	public void postRegister(Boolean registrationDone) {

	}

	public void preDeregister() throws Exception {

	}

	public void postDeregister() {

	}

	public final void printMessage() {
		log.info("Hello World from MBean - invoke from WLST");
	}

}
