package org.codetest.webservice;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.catalina.startup.Catalina;
import org.codetest.constants.EventConstants;
import org.codetest.annotations.Service;

public class WebStart
{
	private Catalina cl;
	private static Logger LOGGER = Logger.getLogger(WebStart.class.getName());
	private boolean start = true;

	@Service(start = true)
	public void start() throws Exception
	{
		System.setProperty("java.util.logging.manager", "org.apache.juli.ClassLoaderLogManager");
		System.setProperty("java.util.logging.config.file", EventConstants.APP_PATH + "/conf/logging.properties");
		System.setProperty("catalina.base", EventConstants.APP_PATH);
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
