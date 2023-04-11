package javaclasses;
import static java.lang.System.exit;
import java.util.Scanner;
public class Atm_Interface
{
    
    public static void main(String[] args) 
    {
        String cname = "Divyansh";
        System.out.println("Welcome! Insert your card");
        System.out.println("Enter your pin "+cname+" : ");
        Scanner s = new Scanner(System.in);
        int pin = s.nextInt();
        int amount = 5000;
        int cpin = 123456;
        int wamount = 0;
        int damount = 0;
        int tamount = 0;
        String name;
        if(cpin==pin)
                {
                    
                System.out.println("Successfully login");
                do
                    {
                System.out.println("***** Select option from below *****");
                System.out.println("1. Balance enquiry");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                int n = s.nextInt();
               switch(n)
               {
                   case 1:
                   {
                       System.out.println("----- Your balance -----");
                       System.out.println("   ");
                       System.out.println("   ");
                       System.out.println("Your Balance : "+amount);
                       System.out.println("   ");
                       System.out.println("   ");
                       break;
                    }
                   case 2:
                   {
                        System.out.println("Enter amount to withdraw : ");
                        wamount = s.nextInt();
                        if(wamount>amount)
                        {
                            System.out.println("Transaction failed due to exceeding amount.");
                        }
                            amount = amount - wamount;
                            System.out.println("----- successfully withdraw-----");
                            System.out.println("   ");
                            System.out.println("   ");
                            System.out.println("Current Balance : "+amount);
                            System.out.println("   ");
                            System.out.println("   ");
                            break;
                   }
                   case 3:
                   {
                        System.out.println("Enter amount to Deposit : ");
                        damount = s.nextInt();
                        amount = amount + damount;
                        System.out.println("----- successfully Deposited -----");
                        System.out.println("   ");
                        System.out.println("   ");
                        System.out.println("Current Balance : "+amount);
                        System.out.println("   ");
                        System.out.println("   ");  
                        break;
                    }
                   case 4:
                   {
                        System.out.println("Enter Recipient Name :");
                        name = s.next();
                        System.out.println("Enter amount to transfer : ");
                        tamount = s.nextInt();
                        if(tamount>amount)
                        {
                            System.out.println("Unable to proceed Due to insufficient balance");
                        }
                        else
                        {
                        amount = amount -tamount;
                        System.out.println("----- successfully transfered to "+name+"-----");
                        System.out.println("   ");
                        System.out.println("   ");
                        System.out.println("Current Balance : "+amount);
                        System.out.println("   ");
                        System.out.println("   "); 
                        }
                        break;
                   }
                   case 5:
                   {
                        System.out.println("----- Thank You -----");
                        System.out.println("!!!Don't forget to take your card!!!");
                        System.out.println("   ");
                        exit(0);
                   }
                   default:
                    {
                        System.out.println("Please enter a correcr choice.");       
                    }
                }
                }while(true);
                }
         else
                {
                System.out.println("Invalid credentials");
                }
     }
}

    

