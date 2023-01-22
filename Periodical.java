import java.util.Scanner;
/**
 * Write a description of class Periodical here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Periodical extends PrintedItem
{
    private String publicationDate;
    /**
     * Constructor for objects of class Periodical
     */
    public Periodical()
    {
        publicationDate = "";
    }
    
    /**
     * Read the data using scanner object
     */
    public void readData(Scanner reader){
        publicationDate = reader.next();
        super.readData(reader);
    }
    
    /**
     * Display the details of the item
     */
    public void printDetails(){
        super.printDetails();
        System.out.println("The publication date is " + publicationDate);
        System.out.println("******************************************");
    }
}
