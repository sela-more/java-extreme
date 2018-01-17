package jmx;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import com.example.mbean.PoolGate;

public class Test {

	/**
	 * @param args
	 * @throws NullPointerException 
	 * @throws MalformedObjectNameException 
	 * @throws MBeanException 
	 * @throws ReflectionException 
	 * @throws NotCompliantMBeanException 
	 * @throws MBeanRegistrationException 
	 * @throws InstanceAlreadyExistsException 
	 */
	public static void main(String[] args) throws MalformedObjectNameException, NullPointerException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, ReflectionException, MBeanException {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
	    ObjectName mbeanObjectName =
			ObjectName.getInstance("com.example.mbeans:type=Pool");
		    ObjectInstance gate = mbs.createMBean("com.example.mbean.PoolGate.java", mbeanObjectName);
		    System.out.println(gate.getClassName());


	}

}
