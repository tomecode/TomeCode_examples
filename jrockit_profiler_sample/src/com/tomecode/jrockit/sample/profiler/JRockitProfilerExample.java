package com.tomecode.jrockit.sample.profiler;
import java.io.StringWriter;
import java.lang.reflect.Method;

import com.bea.jvm.JVMFactory;
import com.bea.jvm.MethodProfileEntry;
import com.bea.jvm.ProfilingSystem;

/**
 * A simple example for profiling code/API with JRockit R28 - JMAPI - using
 * Profiling System.
 * 
 * @see http://www.tomecode.com
 * @author Tomas Frastia
 * 
 */
public class JRockitProfilerExample {

	public static final void main(String[] arg) throws Exception {
		// get Profling System 
		ProfilingSystem profiler = JVMFactory.getJVM().getProfilingSystem();
		// get method append from StringBuffer class
		Method method = Worker.class.getMethod("methodForProfiling");
		// set method to profiler
		MethodProfileEntry methodProfileEntry = profiler.newMethodProfileEntry(method);
		methodProfileEntry.setInvocationCountEnabled(true);
		methodProfileEntry.setTimingEnabled(true);

	
		System.out.println("--------------------FIRST TEST--------------------");

		
		Worker worker = new Worker();
		worker.methodForProfiling();

		System.out.println("Did " + methodProfileEntry.getInvocations() + " invocations");
		long microsecond = (long) (methodProfileEntry.getTiming() * 1000.0d) / methodProfileEntry.getInvocations();
		System.out.println("Average invocation time is " + microsecond + " microseconds");

		System.out.println("--------------------SECOND TEST--------------------");

		int i = 0;
		for (i = 0; i <= 100; i++) {
			worker.methodForProfiling();
		}

		System.out.println("Did " + methodProfileEntry.getInvocations() + " invocations");
		microsecond = (long) (methodProfileEntry.getTiming() * 1000.0d) / methodProfileEntry.getInvocations();
		System.out.println("Average invocation time is " + microsecond + " microseconds");

	}

	public static class Worker {

		public Worker() {

		}

		public final void methodForProfiling() {
			StringWriter sw = new StringWriter(1000);
			for (int i = 0; i < 1000; i++) {

				if (i == 100) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// Build a string containing the characters
				// A to Z repeatedly.
				sw.append((char) (i % 26 + 65));
			}
		}

	}
}
