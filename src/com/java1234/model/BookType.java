package com.java1234.model;

public class BookType {
     private int id;
     private String BookTypeName;
     private String BookTypeDesc;
    public BookType() {
	
	}
    
	public BookType(int id, String bookTypeName, String bookTypeDesc) {
		super();
		this.id = id;
		BookTypeName = bookTypeName;
		BookTypeDesc = bookTypeDesc;
	}
	
	public BookType(String bookTypeName, String bookTypeDesc) {
		this.BookTypeDesc=BookTypeDesc;
		this.BookTypeName=bookTypeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return BookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		BookTypeName = bookTypeName;
	}
	public String getBookTypeDesc() {
		return BookTypeDesc;
	}
	public void setBookTypeDesc(String bookTypeDesc) {
		BookTypeDesc = bookTypeDesc;
	}

	@Override
	public String toString() {
		return BookTypeName;
	}
    
}
