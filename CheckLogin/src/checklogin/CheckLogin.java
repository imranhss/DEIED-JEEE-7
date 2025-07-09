
package checklogin;

import java.util.Scanner;


public class CheckLogin {

   
    public static void main(String[] args) {
        
        Scanner s=new Scanner(System.in);        
        System.out.println("Enter user name ");
        String userName= s.nextLine();        
        
        System.out.println("Enter password ");
        String password= s.nextLine();
        
        if(userName.equalsIgnoreCase("java") && password.equals("asd123")){
        
            System.out.println("Welcome "+ userName);
        
        }else{
        
            System.out.println("User name or Password is incorrect");
        }
        
        
    }
    
}
