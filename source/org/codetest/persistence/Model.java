package org.codetest.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model
{
	private String tableName;
	private List<String> columnNameList;
	private Map<String, Object> columnValueMap;
	private Map<String, Object> columnTypeMap;

	public Model()
	{
		columnNameList = new ArrayList<String>();
		columnValueMap = new HashMap<String, Object>();
		columnTypeMap = new HashMap<String, Object>();
	}

	public String getTableName()
	{
		return tableName;
	}

	public void setTableName(String tableName)
	{
		this.tableName = tableName;
	}

	public List<String> getColumnNameList()
	{
		return columnNameList;
	}

	public void setColumnName(String columnName)
	{
		columnNameList.add(columnName);
	}

	public Object getColumnValue(String columnName)
	{
		return columnValueMap.get(columnName);
	}

	public void setColumnValue(String columnName, Object columnValue)
	{
		columnValueMap.put(columnName, columnValue);
	}

	public Object getColumnType(String columnName)
	{
		return columnTypeMap.get(columnName);
	}

	public void setColumnType(String columnName, Object columnType)
	{
		columnTypeMap.put(columnName, columnType);
	}
}
