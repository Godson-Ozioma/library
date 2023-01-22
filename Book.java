import java.util.*;
/**
 * Write a description of class Book here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Book extends PrintedItem
{
    // the author of the book
    private String author;
    // the isbn of the book
    private String isbn;
    
    /**
     * Constructor for objects of class Book
     */
    public Book()
    {
        author = "";
        isbn = "";
    }
    
    /**
     * Read the data using the scanner object in the parameter
     */
    public void readData(Scanner reader){
        author = reader.next();
        isbn = reader.next();
        super.readData(reader);
    }
    
    /**
     * Display the details of the book
     */
    public void printDetails(){
        super.printDetails();
        System.out.println(author);
        System.out.println(isbn);
        System.out.println("**********************************************");
    }
}
