package org.codetest.persistence;

import java.util.List;

public class Fetch
{
	private StringBuilder sb;
	private List<String> selectColumnsList;
	
	public void select(String tableName)
	{
		sb.append("SELECT " + selectColumns() + " FROM " + tableName);
	}
	
	public void where(String columnName, Object compareValue, String comparator)
	{
		sb.append("WHERE " + columnName + " " + comparator + " " + compareValue);
	}
	
	public void and(String columnName, Object compareValue, String comparator)
	{
		sb.append("AND"  + columnName + " " + comparator + " " + compareValue);
	}
	
	public void groupBy(String columnName)
	{
		sb.append("GROUP BY " + columnName);
	}
	
	public void orderBy(String columnName)
	{
		sb.append("ORDER BY" + columnName);
	}
	
	public void limit(int lowerLimit, int upperLimit)
	{
		sb.append("LIMIT " + lowerLimit + "," + upperLimit);
	}
	
	
	private String selectColumns()
	{
		String columnListString = Entity.getCommaSeperatedList(selectColumnsList);
		return columnListString.isEmpty() ? "*" : columnListString;
	}
	
	class Comparator
	{
		public static final String EQUAL = "=";
		public static final String NOT_EQUAL = "!=";
		public static final String GREATER_THAN = ">";
		public static final String GREATER_THAN_EQUAL = ">=";
		public static final String LESS_THAN = "<";
		public static final String LESS_THAN_EQUAL = "<=";
	}
}
