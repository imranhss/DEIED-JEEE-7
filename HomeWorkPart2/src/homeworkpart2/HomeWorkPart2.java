
package homeworkpart2;


public class HomeWorkPart2 {

    
    public static void main(String[] args) {
        findMaxNumber(30, 50, 10);
        
        checkPrimeNuber(13);
        
    }
    
    
    public static  void findMaxNumber(int n1, int n2, int n3){
    
        if(n1> n2 && n1 >n3){
            System.out.println("Max numer is "+ n1);
        }
        else if(n2>n1 && n2>n3){
           System.out.println("Max numer is "+ n2); 
        }
        else{
        System.out.println("Max numer is "+ n3);
        }
    
    }
    
    
    public static  void checkPrimeNuber(int userInput){
        
        int count=0;
        
        for(int i=1; i<=userInput; i++ ){
        
                if(userInput % i == 0){
                    count ++;
                }        
        }
        
        if(count == 2){
            System.out.println(userInput+" It is Prime Number ");
        }
        else{
        System.out.println(userInput+" It is not Prime Number ");
        }
      
    }
    
}
