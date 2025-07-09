package testmethods;

public class TestMethods {
    
    static  String name= "hello";

    public static void main(String[] args) {
//        doSum(5, 10);
//        doSum(1, 10);
//        doSum(3, 10);
//        doSum(2, 10);
//        doSum(8, 10);
        
//     int result= doSumReturn(20, 30);
//        System.out.println(result+20);
        System.out.println(doSumReturn(2, 20));
        
        
        sum(85,85,55);
    }

    // Start our method
    public static int doSumReturn(int startPoint, int endPoint) {

        int sum = 0;

        while (startPoint <= endPoint) {
            sum += startPoint; //sum = sum + startPoint
            startPoint++;
        }

        //System.out.println("Sum is "+sum);
        return sum;
    }

    public static void doSum(int startPoint, int endPoint) {

        int sum = 0;

        while (startPoint <= endPoint) {
            sum += startPoint; //sum = sum + startPoint
            startPoint++;
        }

        System.out.println("Sum is " + sum);

    }
    
    public static void doSum(int startPoint, int endPoint, int i) {

        int sum = 0;

        while (startPoint <= endPoint) {
            sum += startPoint; //sum = sum + startPoint
            startPoint++;
        }

        System.out.println("Sum is " + sum);

    }
    
    
    
    public  static  void sum(){
    
        System.out.println(20);
    }
    
    public  static  void sum(int n1, int n2){
    
        System.out.println(n1+n2);
    }
    
    public  static  void sum(int... n1){
    
        System.out.println(name);
    }
   
    

}
