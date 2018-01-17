package com.example.mbean;

import java.lang.management.ManagementFactory;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;




public class PoolGate extends StandardMBean implements PoolMBean{
	List<Customer> swimmers;
	
	
	public PoolGate() throws NotCompliantMBeanException{
		super(PoolMBean.class);
		swimmers = new LinkedList<Customer>();
	}
	
	public void addSwimmer(Customer cust){
		swimmers.add(cust);
	}

	public void removeSwimmer(Customer cust){
		swimmers.remove(cust);
	}
	
	public List<Customer> getSwimmers(){
		return Collections.unmodifiableList(swimmers);
	}

	
	/**
	 * @param args
	 * @throws Exception 
	 * @throws MalformedObjectNameException 
	 */
	public static void main(String[] args) throws MalformedObjectNameException, Exception {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

		// Construct the ObjectName for the MBean we will register
		ObjectName name = new ObjectName("com.example.mbeans:type=Pool");

		// Create the Hello World MBean
		PoolGate mbean = new PoolGate();
		mbean.addSwimmer(new Customer("moshe", "0543050857"));

		// Register the Hello World MBean
		mbs.registerMBean(mbean, name);

		// Wait forever
		System.out.println("Waiting forever...");
		Thread.sleep(Long.MAX_VALUE);

	}

}
