import java.util.Scanner;
/**
 * Write a description of class PrintedItem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PrintedItem extends LibraryItem
{
    // the number of pages
    private int noOfPages;
    // the publisher of the book
    private String publisher;
    // the title of the item
    /**
     * Constructor for objects of class PrintedItem
     */
    public PrintedItem()
    {
        noOfPages = 0;
        publisher = "";
    }
    
    public void readData(Scanner reader){
        noOfPages = reader.nextInt();
        publisher = reader.next();
        super.readData(reader);
    }
    
    /**
     * Print the details of the item
     */
    public void printDetails(){
        super.printDetails();
        System.out.println("This item has " + noOfPages + " pages,  and was published by\n" 
        + publisher);
    }
}
