package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java1234.model.Book;
import com.java1234.util.StringUtil;

public class BookDao {
	
	public int add(Connection con,Book b) throws Exception {
		String sql="insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, b.getBookName());
		pstmt.setString(2, b.getAuthor());
		pstmt.setString(3, b.getSex());
		pstmt.setFloat(4, b.getPrice());
		pstmt.setString(5, b.getBookDesc());
		pstmt.setInt(6, b.getBookTypeId());
		
		return pstmt.executeUpdate();
	}
	
	public ResultSet list(Connection con,Book book) throws Exception {
		StringBuffer sql=new StringBuffer("select * from t_book b,t_bookType bt where  b.bookTypeId=bt.id");
		if(StringUtil.isNotEmpty(book.getBookName())) {
			sql.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}if(StringUtil.isNotEmpty(book.getAuthor())) {
			sql.append(" and b.author like '%"+book.getAuthor()+"%'");
		}if(book.getBookTypeId()!=null && book.getBookTypeId()!=-1) {
			sql.append(" and b.bookTypeId="+book.getBookTypeId()+"");
		}
		PreparedStatement pstmt=con.prepareStatement(sql.toString());
		return pstmt.executeQuery();
	}

	public int update(Connection con,Book book) throws Exception {
		String sql="update t_book set bookName=?,author=?,sex=?,price=?,bookDesc=?,bookTypeId=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setString(5, book.getBookDesc());
		pstmt.setInt(6, book.getBookTypeId());
		pstmt.setInt(7, book.getId());
		return pstmt.executeUpdate();
	}
	
	public int delete(Connection con,int id) throws SQLException {
		String sql="delete from t_book where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, id);
		return pstmt.executeUpdate();
	}
}
