package org.codetest.persistence;

import java.io.File;
import java.io.FileInputStream;
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

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SchemaBuilder
{
	private static Logger LOGGER = Logger.getLogger(SchemaBuilder.class.getName());
	private static Map<String, String> schemaMap = new HashMap<String, String>();

	@Service ( start = true)
	public static void setupSchema()
	{
		try
		{
			Connection conn = Connector.getConnection();
			Statement s = (Statement) conn.createStatement();
			schemaMap = getSchemaMap();
			Iterator<Entry<String, String>> schemaItr = schemaMap.entrySet().iterator();
			while (schemaItr.hasNext())
			{
				String tableName = schemaItr.next().getKey();
				String query = schemaMap.get(tableName);
				s.execute(query);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private static Map<String, String> getSchemaMap()
	{
		String confPath = EventConstants.APP_PATH;
		try
		{
			File file = new File(confPath + File.separator + "conf/schemadefinition.yml");
			LOGGER.log(Level.SEVERE, file.toString());
			if (schemaMap.isEmpty())
			{
				schemaMap = (Map<String, String>) new Yaml().load(new FileInputStream(file));
				Collections.unmodifiableMap(schemaMap);
			}
		}
		catch (Exception e)
		{
			LOGGER.log(Level.SEVERE, "Service Start up Configuration File Not Loaded");
		}
		return schemaMap;
	}
}
