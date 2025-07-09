package multidimentionalarray;

import java.util.Arrays;

public class MultiDimentionalArray {

    public static void main(String[] args) {

        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        
        sumOfMatrix(matrix);

        //System.out.println(Arrays.deepToString(matrix));
//        for (int[] rows : matrix) {
//            // row= 1 2 3 // row = 4 5 6
//            for (int item : rows) {
//                System.out.print(item + " ");
//            }
//            System.out.println("");
//        }
//
//        System.out.println("-----------------------");
//        int sum = 0;
//        for (int i = 0; i < matrix.length; i++) {
//
//            for (int j = 0; j < matrix[i].length; j++) {
//                sum += matrix[i][j];
//                //System.out.print(matrix[i][j]+ " ");
//            }
//
//            // System.out.println("");
//        }
//        System.out.println(sum);

    }
    
    
    public  static  void sumOfMatrix(int[][] numbers){
        int sum = 0;
        
        for (int[] rows : numbers) {
            // row= 1 2 3 // row = 4 5 6
            for (int item : rows) {
                sum += item;
            }
            
        }
        System.out.println(sum);
        
    }

}
