import java.util.Date;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 * Write a description of class ItemReservation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ItemReservation
{
    // instance variables - replace the example below with your own
    // the id of the reservation
    private String reservationNo;
    // the id of the item reserved
    private String itemCode;
    // the id of the user reserving the item
    private String userID;
    // the start date of the reservation
    private Date startDate;
    // no of days the reservation will last for
    private int noOfDays;

    /**
       * Constructor for objects of class ItemReservation
     */
    public ItemReservation(String reservationNo, String itemCode, String userID, String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.itemCode = itemCode;
        this.userID = userID;
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
    }
    
    public ItemReservation(){
        this("", "", "", "", 0);
    }
    
    public String getReservationNo(){
        return reservationNo;
    }
    
    public Date getStartDate(){
        return startDate;
    }
    
    public int getNoOfDays(){
        return noOfDays;
    }
    
    public void printDetails(){
        System.out.println(reservationNo + " " + itemCode + " " + userID + " " + startDate + " " + noOfDays);
    }
    
    public void readData(Scanner reader){
        reservationNo = reader.next();
        itemCode = reader.next();
        userID = reader.next();
        startDate = DateUtil.convertStringToDate(reader.next());
        noOfDays = reader.nextInt();
    }
    
    public void writeData(PrintWriter writer){
        writer.println(reservationNo + " " + itemCode + " " + userID + " " + startDate + " " + noOfDays);
    }
    
    public String toString(){
        return reservationNo + " " + itemCode + " " + userID + " " + startDate + " " + noOfDays;
    }
}
