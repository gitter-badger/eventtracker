package org.codetest.service;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.codetest.annotations.Service;
import org.codetest.constants.EventConstants;
import org.yaml.snakeyaml.Yaml;

public class StartService
{
	private static Logger LOGGER = Logger.getLogger(StartService.class.getName());
	private static Map<String, String> serviceMap = new HashMap<String, String>();

	public static void main(String args[])
	{
		serviceMap = getServiceMap();
		Iterator<Entry<String, String>> serviceItr = serviceMap.entrySet().iterator();
		while (serviceItr.hasNext())
		{
			String serviceName = serviceItr.next().getKey();
			String className = serviceMap.get(serviceName);
			try
			{
				@SuppressWarnings("rawtypes")
				Class classInstance = Class.forName(className);
				for (Method method : classInstance.getMethods())
				{
					Service annotation = method.getAnnotation(Service.class);
					LOGGER.info(classInstance.getName());
					if (annotation != null && annotation.start())
					{
						method.invoke(classInstance.newInstance(), (Object[]) null);
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				LOGGER.log(Level.SEVERE, "Failed to load service {0}", serviceName);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Service(start = true)
	private static Map<String, String> getServiceMap()
	{
		String confPath = EventConstants.APP_PATH;
		try
		{
			File file = new File(confPath + File.separator + "conf/loadservice.yml");
			LOGGER.log(Level.SEVERE, file.toString());
			if (serviceMap.isEmpty())
			{
				serviceMap = (Map<String, String>) new Yaml().load(new FileInputStream(file));
				Collections.unmodifiableMap(serviceMap);
			}
		}
		catch (Exception e)
		{
			LOGGER.log(Level.SEVERE, "Service Start up Configuration File Not Loaded");
		}
		return serviceMap;
	}
}
