package org.codetest.webservice;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.catalina.startup.Catalina;

public class WebStart 
{
	public static void main(String args[]) throws Exception
	{
	    String path = WebStart.class.getProtectionDomain().getCodeSource().getLocation().getFile();
	    File confPath = new File(path).getParentFile().getParentFile();
		System.setProperty("catalina.base", confPath.toString());
		Service webService = new Service();
		webService.start();
	}
}

class Service 
{
	private Catalina cl;
	private static Logger LOGGER = Logger.getLogger(Service.class.getName());
	private boolean start = true;

	public void start() throws Exception
	{
		cl = new Catalina();
		cl.start();
		addShutdownHook();
		LOGGER.log(Level.INFO, "Starting Web Service");
		while (start)
		{
			continue;
		}
		stop();
	}

	private void addShutdownHook()
	{
		Runtime.getRuntime().addShutdownHook(new Thread()
		{
			@Override
			public void run()
			{
				LOGGER.log(Level.INFO, "Stopping Web Service");
				start = false;
			}
		});
	}

	public void stop() throws Exception
	{
		cl.stop();
	}
}

