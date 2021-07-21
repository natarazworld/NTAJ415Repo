//FilteredRowSetDemo.java
package com.nt.jdbc4;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.Predicate;

import oracle.jdbc.rowset.OracleFilteredRowSet;

public class FilteredRowSetDemo {
	
	private static class Filter1 implements Predicate{
		  private String cond;
		  public Filter1(String cond) {
			this.cond=cond;
		}

		@Override
		public boolean evaluate(RowSet rs) {
			System.out.println("FilteredRowSetDemo.Filter1.evaluate()");
			try {
			if(rs.getString("ENAME").startsWith(cond))
				return true;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		@Override
		public boolean evaluate(Object value, int column) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean evaluate(Object value, String columnName) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}
		
	}

	public static void main(String[] args) {
		try(OracleFilteredRowSet frs1=new  OracleFilteredRowSet();){
			frs1.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			frs1.setUsername("system");
			frs1.setPassword("manager");
			frs1.setCommand("SELECT * FROM EMP ");
			frs1.setFilter(new Filter1("A"));
			frs1.execute();			
			
			while(frs1.next()) {
				System.out.println(frs1.getInt(1)+"  "+frs1.getString(2)+" "+frs1.getString(3)+" "+frs1.getString(4));
			}//while
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}

	}//try
}//class
