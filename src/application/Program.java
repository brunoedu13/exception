package application;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

    public static void main(String[] args) throws ParseException{

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


            System.out.println("Enter account data");
            System.out.print("Number: ");
            Integer numberAccount = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            Double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withDrawLimit = sc.nextDouble();

            Account c1 = new Account(numberAccount,holder,initialBalance,withDrawLimit);

            System.out.print("Enter amount for withdraw: ");
            Double withDraw = sc.nextDouble();

         try{
            c1.withDraw(withDraw);
             System.out.println("New Balance: " + String.format("%.2f", c1.getBalance()));

         }


        catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }


        sc.close();







    }



}
