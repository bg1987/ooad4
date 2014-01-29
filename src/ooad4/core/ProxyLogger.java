package ooad4.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProxyLogger implements java.lang.reflect.InvocationHandler  {

    private Object obj;
    private PrintStream out = LogFiles.GetStream("proxyLogger.txt", true);
    public static Object newInstance(Object obj) {
    	//Class[] c = getAllIntefaces(obj.getClass());
        return java.lang.reflect.Proxy.newProxyInstance(
            obj.getClass().getClassLoader(),
            getAllIntefaces(obj.getClass()),
            new ProxyLogger(obj));
    }

    private ProxyLogger(Object obj) {
        this.obj = obj;
        log("-----ProxyLogger started------");
    }

    
    private void log (String msg){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		out.println("["+dateFormat.format(date)+"] ProxyLogger: "+msg);
    }
    public Object invoke(Object proxy, Method m, Object[] args)
        throws Throwable
    {
        Object result;
        try {
        	StringBuilder sbArgs = new StringBuilder();
        	if(args != null){
	            for (Object arg : args) {
					sbArgs.append(arg.getClass().toString()+":"+arg.toString()+",");
				}
        	}
        	log(m.getName()+"Called, with args("+sbArgs.toString()+")");
        	
            result = m.invoke(obj, args);
            
            
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " +
                                       e.getMessage());
        } finally {
        	
            log(m.getName()+" Ended");
        }
        return result;
    }
    
    /**
     * Code from http://stackoverflow.com/questions/9881710/getting-superinterfaces-in-java
     * because javas getInterfaces takes only first level interfaces and not the whole inheritance tree.
     * @param cl
     * @return
     */
    private static Class<?>[] getAllIntefaces(Class<?> cl){
    	Queue<Class<?>> queue = new LinkedList<Class<?>>();
    	Set<Class<?>> types =new HashSet<Class<?>>();
    	queue.add(cl);
    	types.add(cl);
    	while (queue.isEmpty() == false) {
    	    Class<?> curr = queue.poll();
    	    Class<?>[] supers = curr.getInterfaces();
    	    for (Class<?> next : supers) {
    	        if (next != null && types.contains(next) == false) {
    	            types.add(next);
    	            queue.add(next);
    	        }
    	    }
    	    Class<?> next = curr.getSuperclass();
    	    if (next != null && types.contains(next) == false) {
    	        queue.add(next);
    	        types.add(next);
    	    }
    	}
    	Set<Class<?>> interfaces =new HashSet<Class<?>>();
    	for (Class<?> curr : types) { 
    	    if (curr.isInterface()){ 
    	    	interfaces.add(curr);
    	    }
    	}
    	return interfaces.toArray(new Class<?>[]{});
    	
    }
    
    
}