import java.util.Scanner;
import java.io.PrintWriter;
/**
 * Write a description of class LibraryUser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LibraryUser
{
    // the id of the user
    private String userID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;
    
    public LibraryUser(String userID, String surname, String firstName, String otherInitials, String title)
    {
        this.userID = userID;
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
    }
    
    /**
     * Constructor for objects of class LibraryUser
     */
    public LibraryUser()
    {
        this("","","","","");
    }
    
    /**
     * Read the data of the class using the scanner object
     */
    public void readData(Scanner reader){
        userID = reader.next();
        surname = reader.next();
        firstName = reader.next();
        otherInitials = reader.next();
        title = reader.next();
    }
    
    /**
     * return the id of the user
     */
    public String getUserID(){
        return userID;
    }
    
    /**
     * Set the id of the user
     */
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    /**
     * Print the details of the CD to the terminal window
     */
    public void printDetails(){
        System.out.println("*********************************************************");
        System.out.println("user ID: " + userID + "\nsurname: " + surname + "\nfirstName:" + firstName + "\ninitials: " + otherInitials + "\ntitle: " + title);
        System.out.println("*********************************************************");
    }
    
    public void writeData(PrintWriter writer){
        writer.println(userID + " " + surname + " " + firstName + " " + otherInitials + " " + title);
    }
    
    public String toString(){
        return "user ID: " + userID + "\nsurname: " + surname + "\nfirstName:" + firstName + "\ninitials: " + otherInitials + "\ntitle: " + title;
    }
}
