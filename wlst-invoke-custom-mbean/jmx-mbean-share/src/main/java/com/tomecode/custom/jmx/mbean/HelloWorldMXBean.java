package com.tomecode.custom.jmx.mbean;

import java.io.Serializable;

/**
 * 
 * Interface for JMX Bean implementation
 * 
 * @author tomecode.com
 * 
 */
public interface HelloWorldMXBean extends Serializable {

	/**
	 * 
	 */
	public void printMessage();
}
