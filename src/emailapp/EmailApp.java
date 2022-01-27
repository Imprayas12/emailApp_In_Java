package emailapp;
import java.util.*;
public class EmailApp {
    static String first_name;
    static String last_name;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first name :");
        first_name = s.next();
        System.out.println("Enter last name");
        last_name = s.next();
        Email obj1 = new Email(first_name,last_name);
        int choice;
        do {
            System.out.println("\n***************\nEnter your choice\n1. Show info\n2. Change Password\n3. Change mailBox Calacity\n4. Set Alternate mail\n5. Store data in file\n6. Read data from file\n7. Exit");
            choice = s.nextInt();
            switch (choice){
                case 1 -> obj1.getInfo();
                case 2 -> obj1.setPassword();
                case 3 -> obj1.setMailCapacity();
                case 4 -> obj1.setAlter_email();
                case 5 -> obj1.storeFile();
                case 6 -> obj1.readFile();
                case 7 -> System.out.println("Thank you for choosing our app");
                default -> System.out.println("Invalid choice!!\n Enter proper choice please. ");
            }
        }while(choice != 7);
    }
}
