package demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book") // optional only needed if Classname differs from tablename --> not needed here
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // id column in db has to be marked with "auto-increment" for this to work
	@Column(name="id") //optional only needed if fieldname differs from columnname --> not needed here
	int id;
	
	@Column(name="book_name")
	String bookName;
	@Column(name="book_author")
	String bookAuthor;
	
	
	public Book(String bookName, String bookAuthor) {
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + "]";
	}
	
	

}
