import java.util.*;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.PrintWriter;
/**
 * Write a description of class Library here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Library
{
    // instance variables - replace the example below with your own
    
    // arraylist that stores all items in the library
    private Map<String, LibraryItem> itemMap;
    // arraylist that stores all the library users
    private Map<String, LibraryUser> userMap;
    private Map<String, ItemReservation> itemReservationMap;
    
    private Diary diary;
    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        // initialise the array list
        itemMap = new HashMap<String, LibraryItem>();
        userMap = new HashMap<String, LibraryUser>();
        itemReservationMap = new HashMap<String, ItemReservation>();
        diary = new Diary();
    }
    
    /**
     * Add the library item to the item list
     */
    public void storeItem(LibraryItem item){
        boolean found = false;
        for(LibraryItem i : itemMap.values()){
            if(i.equals(item)){
                found = true;
            }
        }
        
        if(!found){
            itemMap.put(item.getItemCode(), item);
        }else{
            System.out.println("The item is already stored");
        }
    }
    
    private String generateUserID(String prefix, int length){
        String userID = prefix;
        Random random = new Random();
        for(int i = 0; i < length; i++){
            userID += random.nextInt(9);
        }
        return userID;
    }
    
    /**
     * Add the library item to the item list
     */
    public void storeUser(LibraryUser user){
        if(user.getUserID().equalsIgnoreCase("unknown")){
            user.setUserID(generateUserID("AB-", 6));
        }
        userMap.put(user.getUserID(), user);
    }
   
    /**
     * Display all the items in the item list
     */
    public void printAllItems(){
        if(itemMap.size() != 0){
            for(LibraryItem item : itemMap.values()){
                item.printDetails();
            }
        }else{
            System.out.println("No item found!");
        }
    }
    
    /**
     * Display all the items in the item list
     */
    public void printAllUsers(){
        if(userMap.size() != 0){
            for(LibraryUser user : userMap.values()){
                user.printDetails();
            }
        }else{
            System.out.println("No user found!");
        }
    }
    
    public void readItemData(String filePath){
    
        File file = new File(filePath);
        Scanner scanner = null;
        
        try{
            scanner = new Scanner(file);
        }catch(Exception e){
            System.out.println("no file was not found");
        }
        
        if(scanner != null){
            //String lineOfText = "";
        LibraryItem item = null;
        
        String dataType = null;
        LibraryUser user = null;
        
        while(scanner.hasNext() == true){
            // each line from the file
            String lineOfText = scanner.nextLine().trim();
            // if the file is a real data
            if(lineOfText.startsWith("//") == false && lineOfText.equals("") == false){
                if(lineOfText.startsWith("[")){
                    
                    dataType = lineOfText;
                }else{
                    //System.out.println(lineOfText);
                    Scanner reader = new Scanner(lineOfText).useDelimiter("[ ]*,[ ]*");
                    if(dataType.contains("Book")){
                        item = new Book();
                    }else if(dataType.contains("periodical")){
                        item = new Periodical();
                    }else if(dataType.contains("CD")){
                        item = new CD();
                    }else if(dataType.contains("DVD")){
                        item = new DVD();
                    }else if(dataType.contains("User")){
                        user = new LibraryUser();
                    }
                    
                    if(user == null){
                        
                        item.readData(reader);
                        storeItem(item);
                    }else{
                        user.readData(reader);
                        storeUser(user);
                    }
                    
                }
            }
        }
        }
        
    }
    
    /**
     * Read data from the file
       */
    public void readItemData(){
        // the frame for the file dialog
        Frame frame = null;
        // file dialog
        FileDialog fileDialog = new FileDialog(frame);
        fileDialog.setVisible(true);
        String fileName = fileDialog.getFile();
        String dir = fileDialog.getDirectory();
        fileDialog.setDirectory(fileName);
        
        if(dir != null)
        {
            String filePath = dir + fileName;
            readItemData(fileName);
        }else{
            System.out.println("no file selected");
        }
    }
    
    /**
     * Save the details of each user in a file
     */
    public void writeUserData(){
        File file = new File("saved_user_data.txt");
        PrintWriter writer = null;
        try{
            writer = new PrintWriter(file);
        }catch(Exception e){
            System.out.println("File not found");
        }
        
        if(writer != null){
            for(LibraryUser user : userMap.values()){
                user.writeData(writer);
            }
        }
        
        writer.close();
    }
    
    public void storeItemReservation(ItemReservation reservation){
        diary.addReservation(reservation);
        itemReservationMap.put(reservation.getReservationNo(), reservation);
    }
    
    private String generateReservationNo(){
        String reservationNo = "";
        Random random = new Random();
        int n = itemReservationMap.size() + 1;
        // add padding
        reservationNo = String.format("%06d", n);
        return reservationNo;
    }
    
    public ItemReservation getReservation(String reservationNo)
    {
        ItemReservation reservation = itemReservationMap.get(reservationNo);
        return itemReservationMap.get(reservation);
    }
    
    public void makeItemReservation(String userID, String itemCode, String startDate, int noOfDays){
        String reservationNo = generateReservationNo();
        ItemReservation reservation = new ItemReservation(reservationNo, itemCode, userID, startDate, noOfDays);
        storeItemReservation(reservation);
    }
    
    public void printItemReservations(){
        for(ItemReservation reservation : itemReservationMap.values()){
            reservation.printDetails();
        }
    }
    
    public void writeItemReservationData(){
        File file = new File("saved_reservation_data.txt");
        PrintWriter writer = null;
        try{
            writer = new PrintWriter(file);
        }catch(Exception e){
            System.out.println("File not found");
        }
        
        if(writer != null){
            for(ItemReservation reservation : itemReservationMap.values()){
                reservation.writeData(writer);
            }
        }
        
        writer.close();
    }
    
    public void readItemReservationData(){
        // the frame for the file dialog
        Frame frame = null;
        // file dialog
        FileDialog fileDialog = new FileDialog(frame);
        fileDialog.setVisible(true);
        String fileName = fileDialog.getFile();
        String dir = fileDialog.getDirectory();
        fileDialog.setDirectory(fileName);
        
        File file = new File(fileName);
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
        }catch(Exception e){
            System.out.println("Sorry file not found");
        }
        
        while(scanner.hasNext()){
            // each line from the file
            String lineOfText = scanner.nextLine().trim();
            // if the file is a real data
            if(!lineOfText.startsWith("//") && !lineOfText.equals("")){
                Scanner reader = new Scanner(lineOfText).useDelimiter("[ ]*,[ ]*");
                ItemReservation reservation = new ItemReservation();    
                reservation.readData(reader);
                storeItemReservation(reservation);
                reader.close();
            }
        }
    }
    
    public void printDiaryEntries(String startDate, String endDate){
        diary.printEntries(DateUtil.convertStringToDate(startDate), DateUtil.convertStringToDate(endDate));
        
    }
    
    public void deleteItemReservation(String reservationNo){
        if(itemReservationMap.get(reservationNo) != null)
        {
            ItemReservation itemReservation = itemReservationMap.get(reservationNo);
            
            diary.deleteReservation(itemReservation);
            itemReservationMap.remove(reservationNo);
            
            System.out.println("-------------------------------------------------------");
            System.out.println(itemReservation + " deleted successfully...");
            System.out.println("-------------------------------------------------------");
        }else{
            System.out.println("-------------------------------------------------------");
            System.out.println("No item with reservation number, \n" + reservationNo + " was found...");
            System.out.println("-------------------------------------------------------");
        }
    }
}
