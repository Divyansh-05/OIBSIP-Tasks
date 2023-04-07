package javaclasses;

import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Online_Reservation_System {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ors?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "root");
        Statement smt = con.createStatement();

        String pnr;
        System.out.println("-----------------------------Welcome to online reservation system-----------------------------");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter username: ");
        String uname = s.nextLine();
        System.out.println("Enter password: ");
        String pass = s.nextLine();
        if (uname.equals("admin") && pass.equals("admin")) {
            System.out.println("-----------------------------Login successful-----------------------------");
            System.out.println("\n\nPlease select any of the below option.");
            System.out.println("1. Reservation");
            System.out.println("2. Cancellation");
            System.out.println("3. Quit");
            int n = s.nextInt();
            switch (n) {
                case 1: {
                    System.out.println("\n\nFor reservation complete the following details.");
                    s.nextLine(); // Consume the newline character left by nextInt()
                    System.out.println("\nName: ");
                    String name = s.nextLine();
                    System.out.println("\nContact Number: ");
                    String cno = s.nextLine();
                    s.nextLine(); // Consume the newline character left by nextInt()
                    System.out.println("\nEmail ID: ");
                    String eid = s.nextLine();
                    System.out.println("\nTrain Number: ");
                    int tnum = s.nextInt();
                    PreparedStatement pst = con.prepareStatement("select train_name from train where train_no = ?");
                    pst.setInt(1, tnum);
                    ResultSet rst = pst.executeQuery();
                    String tname = null;
                    if(rst.next()) {
                        tname = rst.getString(1);
                    }
                    System.out.println("\nTrain Name: " + tname);
                    System.out.println("\nClass Type: ");
                    String ctype = s.nextLine();
                    System.out.println("\nDate of birth (DD-MM-YYYY) : ");
                    String dob = s.nextLine();
                    System.out.println("\nNumber of people traveling: ");
                    int pt = s.nextInt();
                    s.nextLine(); // Consume the newline character left by nextInt()
                    System.out.println("\nDate of journey (DD-MM-YYYY) : ");
                    String doj = s.nextLine();
                    System.out.println("\nFrom : ");
                    String from = s.nextLine();
                    System.out.println("\nTo : ");
                    String to = s.nextLine();
                    pnr = name.charAt(5) + eid;
                    System.out.println("\n\nPress 1 to submit.");
                    int x = s.nextInt();
                    if(x==1) 
                    {
                            String query = "INSERT INTO customer(pnr, name, cno, email, class_type, dob, nop, doj, from_location, to_location) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement pst1 = con.prepareStatement(query);
                            pst1.setString(1, pnr);
                            pst1.setString(2, name);
                            pst1.setString(3, cno);
                            pst1.setString(4, eid);
                            pst1.setString(5, ctype);
                            pst1.setString(6, dob);
                            pst1.setInt(7, pt);
                            pst1.setString(8, doj);
                            pst1.setString(9, from);
                            pst1.setString(10, to);

                            System.out.println("\n\n--------------Sucessfully Registerd--------------");
                            
                        }
                    else 
                    {
                        System.out.println("Press one to submit.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("To proceed pleaase provide us a pn number allocated to you: ");
                    String pnr_no = s.nextLine();
                    String sql = "select * from admin where pnr ='"+pnr_no+"'";
                    ResultSet rs = smt.executeQuery(sql);
                    if(rs.next())
                    {
                        System.out.println("Your Details are as follows:");
                        System.out.println("");
                        System.out.println("PNR number : "+pnr_no);
                        System.out.println("Name : "+rs.getString(2));
                        System.out.println("Contact Number  : "+rs.getString(3));
                        System.out.println("Email ID : "+rs.getString(4));
                        System.out.println("Class Type : "+rs.getString(5));
                        System.out.println("Date Of Birth : "+rs.getString(6));
                        System.out.println("Number of person : "+rs.getInt(7));
                        System.out.println("Date of journy : "+rs.getString(8));
                        System.out.println("From : "+rs.getString(9));
                        System.out.println("To : "+rs.getString(10));
                        System.out.println("");
                        System.out.println("Would you like to cancel the journy ?");
                        System.out.println("\n 1. yes \n 2. No");
                        int x = s.nextInt();
                       switch(x)
                       {
                           case 1:
                           {
                               smt.executeUpdate("delete from customer where pnr = '"+pnr_no+"'");
                               System.out.println("Cancellation successful");
                           }
                           case 2:
                           {
                               System.out.println("Sure your cancellation has been cancelled.");
                               break;
                           }
                           default :
                               System.out.println("Enter a correct choice.");                               
                       }
                    }
                    else
                    {
                         System.out.println("Invalid PNR number");
                    }
                break;
                }
                case 3:
                {
                    System.out.println("\n\n\n\nThank you See You Soon.");
                    exit(0);
                }
                default :
                {
                    System.out.println("Enter correct choice.");
                }  
            }
        } 
        else 
        {
            System.out.println("Invalid credentials");
        }
    }
    
}
