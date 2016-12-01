package ch.makery.Book.model;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

/**
 * Data information
 * @author Daniel Morgado and Joselu
 *
 */
public class Book  {

	
	private static StringProperty title;
    private static StringProperty type;
    private static StringProperty author;
    private static StringProperty editorial;
    private static IntegerProperty pages;
    private static ObjectProperty<LocalDate> version;

    /**
     * Default constructor.
     */
    public Book() {
        this(null, null);
    }
    /**
     * Info of the book
     * @param title
     * @param type
     */
    public Book(String title, String type) {
        this.title = new SimpleStringProperty(title);
        this.type = new SimpleStringProperty(type);

        // Some initial dummy data, just for convenient testing.
        this.author = new SimpleStringProperty("someone");
        this.pages = new SimpleIntegerProperty(100);
        this.editorial = new SimpleStringProperty("some city");
        this.version = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }
	public StringProperty getTitle() {
		return title;
	}
	public StringProperty getType() {
		return type;
	}
	public StringProperty getAuthor() {
		return author;
	}
	public StringProperty getEditorial() {
		return editorial;
	}
	public IntegerProperty getPages() {
		return pages;
	}
	public ObjectProperty<LocalDate> getVersion() {
		return version;
	}
	
	public void setTitle(StringProperty title){
		this.title=title;
	}
	public void setType(StringProperty type){
		this.type=type;
	}
	public void setAuthor(StringProperty author){
		this.author=author;
	}
	public void setPages(IntegerProperty pages){
		this.pages=pages;
	}
	public void setVersion(ObjectProperty <LocalDate> version){
		this.version=version;
	}
	
}