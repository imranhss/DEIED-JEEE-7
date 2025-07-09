package testdowhile;

public class TestBreakContinue {

    public static void main(String[] args) {
        int n = 1;

        while (n<=50) {
            if(n % 3==0 && n % 5 == 0){
                System.out.println(n);
                n++;
                continue;
            }
//            System.out.println(n);
            n++;
        }
    }

}
