package com.fourserveglobal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_table")
public class Book {
	
   @Id
   @GeneratedValue(strategy =  GenerationType.IDENTITY)
   private int bookId;
   private String bookName;
   
   
   public Book() {
	super();
	
   }
   
   public Book( String bookName) {
	super();
	
	this.bookName = bookName;
  }
  public int getBookId() {
	return bookId;
  }
  public void setBookId(int bookId) {
	this.bookId = bookId;
  }
  public String getBookName() {
	return bookName;
  }
  public void setBookName(String bookName) {
	this.bookName = bookName;
  }
   
   
}
