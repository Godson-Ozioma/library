import java.util.Scanner;
/**
 * Write a description of class DVD here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DVD extends AudioVisual
{
    // the director of the DVD
    private String director;
    /**
     * Constructor for objects of class DVD
     */
    public DVD()
    {
        director = "";
    }
    
    /**
     * Read the data of the class using the scanner object
     */
    public void readData(Scanner reader){
        director = reader.next();
        super.readData(reader);
    }
    
    /**
     * Print the details of the CD to the terminal window
     */
    public void printDetails(){
        super.printDetails();
        System.out.println("This director of this DVD is " + director + ".");
        System.out.println("*********************************************************");
    }
}
