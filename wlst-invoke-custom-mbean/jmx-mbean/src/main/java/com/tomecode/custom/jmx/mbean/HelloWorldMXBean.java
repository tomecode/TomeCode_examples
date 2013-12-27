package com.tomecode.custom.jmx.mbean;

import java.io.Serializable;

/**
 * 
 * @author tomecode.com
 *
 */
public interface HelloWorldMXBean extends Serializable{

	public void printMessage();
}
