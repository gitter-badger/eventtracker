package org.codetest.persistence;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.codetest.annotations.Column;
import org.codetest.annotations.Table;


public class Entity 
{
	public void insert(Object classObj) throws Exception
	{
		Model model = computeModel(classObj);
		List<String> columnNameList = model.getColumnNameList();
		int noOfColumns = columnNameList.size();
		getCommaSeperatedColumnTemplate(noOfColumns);
		String sql = "INSERT INTO " + model.getTableName() + " " + getCommaSeperatedList(columnNameList) + " VALUES "+ getCommaSeperatedColumnTemplate(noOfColumns) +" ;";
		PreparedStatement preparedStmt = Connector.getConnection().prepareStatement(sql);
		setPreparedStatmentValues(model, preparedStmt);
		preparedStmt.executeUpdate();
	}

	private void setPreparedStatmentValues(Model model, PreparedStatement preparedStmt) throws SQLException
	{
		List<String> columnNameList = model.getColumnNameList();
		int noOfColumns = columnNameList.size();
		for (int i = 1; i <= noOfColumns; i++)
		{
			String columnName = columnNameList.get(i - 1);
			String columnType = (String) model.getColumnType(columnName);
			Object columnValue = model.getColumnValue(columnName);
			if (columnType.equals("String"))
			{
				preparedStmt.setString(i, (String) columnValue);
			}
			else if (columnType.equals("Long"))
			{
				preparedStmt.setLong(i, (Long) columnValue);
			}
			else
			{
				preparedStmt.setObject(i, columnValue);
			}
		}
	}

	private static Model computeModel(Object classObj) throws Exception
	{
		Class<?> classInstance = Class.forName(classObj.getClass().getName());
		Annotation classAnnotation = classInstance.getAnnotation(Table.class);
		if(classAnnotation == null)
		{
			return null;
		}
	
		String tableName = ((Table) classAnnotation).name();
		if (tableName.isEmpty())
		{
			return null;
		}
		
		Method[] classMethods = classInstance.getDeclaredMethods();
		Model model = new Model();
		model.setTableName(tableName);
		for (Method method : classMethods)
		{
			Column methodAnnotation = method.getAnnotation(Column.class);
			if (methodAnnotation == null)
			{
				continue;
			}
			Object columnValue = method.invoke(classObj , (Object[]) null);
			if  (columnValue == null)
			{
				continue;
			}
			String columnName = ((Column)methodAnnotation).name();
			String columnType = ((Column)methodAnnotation).type();
			model.setColumnName(columnName);
			model.setColumnValue(columnName, columnValue);
			model.setColumnType(columnName, columnType);
		}
		return model;
	}
	
	public static String getCommaSeperatedList(List<String> columnNameList)
	{
		String columnNameString = columnNameList.toString();
		columnNameString = columnNameString.replace("[", "(");
		columnNameString = columnNameString.replace("]", ")");
		return columnNameString;
	}

	private static String getCommaSeperatedColumnTemplate(int noOfColumns)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= noOfColumns; i++)
		{
			if (i == 1)
			{
				sb.append("(?");
			}
			else if (i == noOfColumns)
			{
				sb.append(",?)");
			}
			else
			{
				sb.append(",?");
			}
		}
		return sb.toString();
	}
}
