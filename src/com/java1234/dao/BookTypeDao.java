package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java1234.model.BookType;
import com.java1234.util.StringUtil;

/**
 * Õº È¿‡–Õ
 * @author zsw
 *
 */
public class BookTypeDao {
   
	public int add(Connection con,BookType bt) throws Exception {
		String sql="insert into t_bookType value(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bt.getBookTypeName());
		pstmt.setString(2, bt.getBookTypeDesc());
		return pstmt.executeUpdate();
	}
	
	public ResultSet list(Connection con,BookType bt) throws SQLException {
		StringBuffer sb=new StringBuffer("select * from t_bookType");
		if(StringUtil.isNotEmpty(bt.getBookTypeName())) {
			sb.append(" and bookTypeName like '%"+bt.getBookTypeName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int update(Connection con,BookType bt) throws Exception {
		String sql="update t_bookType set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bt.getBookTypeName());
		pstmt.setString(2, bt.getBookTypeDesc());
		pstmt.setInt(3, bt.getId());
		return pstmt.executeUpdate();
	}
	
	public int delete(Connection con,int id) throws Exception {
		String sql="delete from t_bookType where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, id);
		return pstmt.executeUpdate();
	}
}
