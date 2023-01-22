import java.util.Scanner;
/**
 * Write a description of class CD here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CD extends AudioVisual
{
    // the artist of the cd
    private String artist;
    private int noOfTracks;
    /**
     * Constructor for objects of class CD
     */
    public CD()
    {
        artist = "";
        noOfTracks = 0;
    }
    
    /**
     * Read the data of the class using the scanner object
     */
    public void readData(Scanner reader){
        artist = reader.next();
        noOfTracks = reader.nextInt();
        super.readData(reader);
    }
    
    /**
     * Print the details of the CD to the terminal window
     */
    public void printDetails(){
        super.printDetails();
        System.out.println("This artist of this CD is " + artist + ", and it has " + noOfTracks + " tracks.");
        System.out.println("*********************************************************");
    }
}
