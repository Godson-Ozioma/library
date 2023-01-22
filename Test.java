
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    
    private Library library;
    
    private LibraryUser user1;
    private LibraryUser user2;
    
    private ItemReservation reservation1;
    private ItemReservation reservation2;
    
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        library = new Library();
        user1 = new LibraryUser("AB-123", "Ozioma", "Godson", "N", "Mr");
        user2 = new LibraryUser("AB-1234", "Ozi", "Speed", "N", "Mr");
        
        // testReadItemData();
        runGeneralTest();
    }
    
    public void testReadItemData(){
        System.out.println("-----TESTING READITEMDATA-----");
        library.printAllItems();
        library.readItemData("items_and_user_data");
        library.printAllItems();
        System.out.println("------------------------------");
    }

    public void runGeneralTest(){
        library.readItemData("items_and_user_data");
        
        library.printAllUsers();
        library.storeUser(user1);
        library.storeUser(user2);
        library.printAllUsers();
        
        library.makeItemReservation("AB-123", "LM003773", "21-05-2021", 4);
        library.printItemReservations();
        library.makeItemReservation("AB-1234", "LM003580", "23-05-2021", 6);
        library.printItemReservations();
        
        library.printDiaryEntries("19-05-2021", "10-06-2021");
    }
    
}
