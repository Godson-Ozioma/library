import java.util.Scanner;
/**
 * Write a description of class AudioVisual here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AudioVisual extends LibraryItem
{
    // the duration of the track in seconds
    private int playingTime;
    /**
     * Constructor for objects of class AudioVisual
     */
    public AudioVisual()
    {
        playingTime = 0;
    }
    
    /**
     * Read data using scanner object
     */
    public void readData(Scanner reader){
        playingTime = reader.nextInt();
        super.readData(reader);
    }
    
    /**
     * Display the details of the audio visual
     */
    public void printDetails(){
        super.printDetails();
        System.out.println("This audio visual will play for " + playingTime + " seconds.");
    }
}
