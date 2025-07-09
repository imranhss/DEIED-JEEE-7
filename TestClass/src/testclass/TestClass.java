
package testclass;

import java.math.BigDecimal;
import java.math.BigInteger;
import testclass.object.Student;
import testclass.view.NewJFrame;

public class TestClass {

 
    public static void main(String[] args) {
        
        int a=10;
        Student s=new Student(110, "sdfdsf", "dfsef", "sdfsdfsd", "456465", "asdasdfsa", "adfeaseda", "Java");
        
        String name= "Java";
        
        NewJFrame frame =new NewJFrame();
        
       s.printStuInfo();
       
       
       Integer number= 10;
       
        BigInteger aa=new BigInteger("545454564564564564564646");
        
        BigDecimal bb=new BigDecimal("141564465465454646464.14541541415");
    
        System.out.println(aa.add(BigInteger.ONE));
        
    }
    
}
