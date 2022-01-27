package emailapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {
    public Scanner sc = new Scanner(System.in);
    private final String first_name;
    private String last_name;
    private String depart;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;
    public Email(String first_name,String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
        System.out.println("New Employee :"+ this.first_name+" "+this.last_name);
        this.depart = setDept();
        this.password = generate_Password(8);
        this.email = this.generateEmail();
    }
    private String generateEmail(){
        return this.first_name.toLowerCase()+"."+this.last_name.toLowerCase()+"@"+this.depart.toLowerCase()+"sayarp.com";
    }
    private String setDept(){
        System.out.println("Department codes \n 1.for sales\n 2.for Development\n 3.Accounting\n 0.null");
        boolean flag = false;
        do{
            System.out.println("Enter Department code :");
            int choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1 -> { return "Sales"; }
                case 2 -> { return "Development"; }
                case 3 -> { return "Accounting"; }
                case 0 -> { return "None";}
                default -> System.out.println("Invalid choice! Please enter a valid choice");
            }
            System.out.println("Do you want to enter another record ?\n Press 1 for yes \n Press 0 for no");
            int f = new Scanner(System.in).nextInt();
            if(f==1) flag = true;
        }while (!flag);
        return null;
    }
    private String generate_Password(int length){
        Random r = new Random();
        String Capital_char="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_char = Capital_char.toLowerCase();
        String nums = "0123456789";
        String symbols = "!@#$%^&*()";
        String values = Capital_char+small_char+nums+symbols;
        password = "";
        for (int i = 0; i < length; i++) {
            password = password+ values.charAt(r.nextInt(values.length()));
        }
        return password;
    }
    public String setPassword(){
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password?(Y/N)");
            char choice = new Scanner(System.in).next().charAt(0);
            if(choice=='Y'||choice=='y') {
                flag = true;
                System.out.println("Enter current password :");
                String temp = new Scanner(System.in).next();
                if(temp.equals(this.password)){
                    System.out.println("Enter new password : ");
                    this.password = new Scanner(System.in).next();
                    System.out.println("Password Changed Successfully");
                }
                else {
                    System.out.println("Incorrect password");
                }
            }else if(choice=='N'||choice=='n'){
                flag = true;
                System.out.println("Password changed option cancelled");
            }
            else System.out.println("Invalid choice. \n Enter valid choice.");
        }while(!flag);
        return null;
    }
    public void setMailCapacity(){
        System.out.println("Current capacity : "+this.mailCapacity + "MB");
        System.out.println("Enter new mailbox capacity :");
        this.mailCapacity = sc.nextInt();
        System.out.println("MailBox capacity changed successfully.");
    }
    public void setAlter_email(){
        System.out.println("Enter new alternate mail: ");
        this.alter_email = sc.next();
        System.out.println("Alternate mail is set");
    }
    //Display user Information
    public void getInfo(){
        System.out.println("New :"+ this.first_name+" "+this.last_name);
        System.out.println("Department :"+this.depart);
        System.out.println("Email :"+this.email);
        System.out.println("Password :"+this.password);
        System.out.println("MailBox Capacity :"+this.mailCapacity);
        System.out.println("Alternate email :"+this.alter_email);
    }
    public void storeFile(){
        try{
            FileWriter in = new FileWriter("C:\\Users\\prayas gautam\\Desktop\\info.txt");
            in.write("First name :"+this.first_name);
            in.append("\nLast Name : "+this.last_name);
            in.append("\nEmail :"+this.email);
            in.append("\nPassword : "+this.password);
            in.append("\nCapacity :"+this.mailCapacity);
            in.append("\nAlternate Email :"+this.alter_email);
            in.close();
            System.out.println("Data Stored..");

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void readFile(){
        try(FileReader f = new FileReader("C:\\Users\\prayas gautam\\Desktop\\info.txt")){
            int i;
            while((i=f.read())!=-1){
                System.out.print((char)i);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
