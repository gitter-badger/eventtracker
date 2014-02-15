package org.codetest.constants;

import java.io.File;

public class EventConstants
{
	 public static final String APP_PATH = getAppPath();
	
	 private static String getAppPath()
	 {
		 String path = EventConstants.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		 String appPath = new File(path).getParentFile().getParentFile().toString();
		 return appPath;
	 }
}
