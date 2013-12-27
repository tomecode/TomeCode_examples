package com.tomecode.custom.jmx.mbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.naming.InitialContext;

import weblogic.application.ApplicationException;
import weblogic.application.ApplicationLifecycleEvent;
import weblogic.application.ApplicationLifecycleListener;
import weblogic.logging.NonCatalogLogger;

/**
 * 
 * @author TomeCode.com
 * 
 */
public class HelloWorldMBeanLifeCycleListener extends ApplicationLifecycleListener {

	private static final NonCatalogLogger log = new NonCatalogLogger("HelloWord.HelloWorldMBeanLifeCycleListener");

	private static final String MB_NAME = "com.tomecode.custom.jmx:type=HelloWorldMBean,name=helloWorldMBean";

	public void postStart(ApplicationLifecycleEvent evt) throws ApplicationException {

		System.out.println("\n\n############# HelloWord  JMX Bean #############" + //
				"\n############# Version: " + HelloWorldMBeanLifeCycleListener.class.getPackage().getImplementationTitle() + //
				" BuildDate: " + HelloWorldMBeanLifeCycleListener.class.getPackage().getImplementationVersion() + " #############\n\n");
		try {
			// Lookup Oracle WebLogic Server 'Runtime' MBeanServer
			MBeanServer mbs = InitialContext.doLookup("java:comp/jmx/runtime");
			HelloWorldMBean mbean = new HelloWorldMBean();
			ObjectName oname = new ObjectName(MB_NAME);
			mbs.registerMBean(mbean, oname);
			log.info("Successful registration of HelloWord-JMX Bean[" + MB_NAME + "]");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	public final void preStop(ApplicationLifecycleEvent evt) throws ApplicationException {

		try {

			MBeanServer mbs = InitialContext.doLookup("java:comp/jmx/runtime");
			ObjectName oname = new ObjectName(MB_NAME);
			if (mbs.isRegistered(oname)) {
				mbs.unregisterMBean(oname);
				log.info("Successful unregistration HelloWord-JMX Bean[" + MB_NAME + "]");
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
