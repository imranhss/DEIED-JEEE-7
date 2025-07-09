package testdowhile;

public class TestDoWhile {

    public static void main(String[] args) {

        int n = 10;

//        do {
//            System.out.println(n);
//            n++;
//        } while (n <= 20);
        String name = "java";
        String result="";

        for (int i = name.length()-1; i >=0 ; i--) {
            
          result = result + name.charAt(i);

        }
        
        System.out.println(result);

    }

}
