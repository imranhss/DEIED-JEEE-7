
package tsetstring;

import java.util.Scanner;


public class TsetString {

    public static void main(String[] args) {
       
        Scanner s=new Scanner(System.in);
        System.out.println("Enter a word");
        
        String name= s.nextLine();
        
        char firstPart= name.charAt(0);
        
        String lastPart= name.substring(1, name.length());
        
        
        String finalName= String.valueOf(firstPart).toUpperCase()+lastPart;
        System.out.println(finalName);
        
        
        
    }
    
}
