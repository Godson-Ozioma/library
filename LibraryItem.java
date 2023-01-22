import java.util.*;
/**
 * Write a description of class LibraryItem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class LibraryItem
{
    
    private String title;
    // the code used to identify each item
    private String itemCode;
    // the cost of the item when new in pence
    private int cost;
    // the number of times the item has been borrowed
    private int timesBorrowed;
    // true if the item has been loaned out
    private boolean onLoan;
    /**
     * Constructor for objects of class LibraryItem
     */
    public LibraryItem(String title, String itemCode, int cost, int timesBorrowed, boolean onLoan)
    {
        this.title = title;
        this.itemCode = itemCode;
        this.cost = cost;
        this.timesBorrowed = timesBorrowed;
        this.onLoan = onLoan;
    }
    
    /**
     * Hard-coded constructor
     */
    public LibraryItem(){
        title = "";
        itemCode = "";
        cost = 0;
        timesBorrowed = 0;
        onLoan = false;
    }
    
    /**
     * return the title of the item
     */
    public String getTitle(){
        return title;
    }
    
    public String getItemCode(){
        return itemCode;
    }
    
    /**
     * Display the detaild of the library item
     */
    public void printDetails(){
        // displays on loan or not on loan depending on the value of onLoan
        String onLoanString = "";
        if(onLoan){
            onLoanString = "on loan";
        }else{
            onLoanString = "not on loan";
        }
        System.out.println("**********************************************");
        System.out.println(title + " with code " + itemCode + " has been borrowed "
        + "\n " + timesBorrowed + " times." + " This item is at present " + onLoan + " and when new costs \n"
        + cost + " pence.");
    }
    
    /**
     * Read data using the scanner in the parameter
     */
    public void readData(Scanner reader){
        title = reader.next();
        // System.out.println(title);
        itemCode = reader.next();
        // System.out.println(itemCode);
        cost = reader.nextInt();
        // System.out.println(cost);
        timesBorrowed = reader.nextInt();
        onLoan = reader.nextBoolean();
        // System.out.println(onLoan);
    }
}
