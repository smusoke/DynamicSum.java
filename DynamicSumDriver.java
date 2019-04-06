/**
 * CISC 380
 * Algorithms Assignment 4
 *
 * Tests the methods of the DynamicSum class.
 * 
 * @author YOUR NAME HERE
 * Due Date: xx/xx/xx
 *
 *  This driver file contains a single example test case to get you started.
 *  You should include more test cases to ensure that your implementation works correctly.
 *  You do NOT need to submit this file.
 *
 */



public class DynamicSumDriver{

    public static void main(String[] args){
    	
        DynamicSum test1 = new DynamicSum();

        int[] testArr1 = {5,2,4,3};
        System.out.println("Test1");
        System.out.println("\n\nResult for sum 6: " + test1.isSum    (testArr1, 6));
        System.out.println("\n\nResult for sum 20: " + test1.isSum    (testArr1, 20));
        System.out.println("\n\nResult for sum 0: " + test1.isSum    (testArr1, 0));
        System.out.println("\n\nResult for sumMem 6: " + test1.isSumMem    (testArr1, 6));
        System.out.println("\n\nResult for sumMem 20: " + test1.isSumMem    (testArr1, 20));
        System.out.println("\n\nResult for sumMem 0: " + test1.isSumMem    (testArr1, 0));
        test1.getSubset(testArr1, 14);
        test1.getSubset(testArr1, 6);
        System.out.println( test1.getSubset(testArr1, 20) );
        System.out.println( test1.getSubset(testArr1, 7) );
        printArray( test1.getSubset(testArr1, 7) );
        
        
        
        int[] testArr2 = {3,7,11,19,23,1};
        System.out.println("Test2");
        System.out.println("\n\nResult for sum 9: " + test1.isSum    (testArr2, 9));
        System.out.println("\n\nResult for sum 20: " + test1.isSum    (testArr2, 20));
        System.out.println("\n\nResult for sumMem 9: " + test1.isSumMem    (testArr2, 9));
        System.out.println("\n\nResult for sumMem 20: " + test1.isSumMem    (testArr2, 20)); 
        System.out.println("\n\nResult for sumMem 1: " + test1.isSumMem    (testArr2, 1));
        System.out.println("\n\nResult for sumMem 2: " + test1.isSumMem    (testArr2, 2));
        test1.getSubset(testArr2, 9);
        test1.getSubset(testArr2, 20);
        
        
        int[] testArr3 = {1};
        System.out.println("Test3");
        System.out.println("\n\nResult for sum 9: " + test1.isSum    (testArr3, 9));
        System.out.println("\n\nResult for sum 20: " + test1.isSum    (testArr3, 20));
        System.out.println("\n\nResult for sumMem 9: " + test1.isSumMem    (testArr3, 9));
        System.out.println("\n\nResult for sumMem 20: " + test1.isSumMem    (testArr3, 20));
        test1.getSubset(testArr3, 9);
        test1.getSubset(testArr3, 20);
        
        
        
        int[] testArr4 = {};
        System.out.println("Test4");
        System.out.println("\n\nResult for sum 9: " + test1.isSum    (testArr4, 9));
        System.out.println("\n\nResult for sum 20: " + test1.isSum    (testArr4, 20));
        System.out.println("\n\nResult for sumMem 9: " + test1.isSumMem    (testArr4, 9));
        System.out.println("\n\nResult for sumMem 20: " + test1.isSumMem    (testArr4, 20));
        test1.getSubset(testArr4, 9);
        test1.getSubset(testArr4, 20);
        
    		System.out.println("Done with my tests");
    		//
		
        DynamicSum dSum = new DynamicSum();

        int[] testArr = {3,1,4,1,5,9,2,6};

        System.out.println(dSum.isSum    (testArr, 14));
        System.out.println(dSum.isSumMem (testArr, 14));
        System.out.println(dSum.getSubset(testArr, 14));
        


    }//main
    
    public static void printArray(int[] arr)
    {
    		System.out.print("[");
    		for( int i = 0; i < arr.length; i++ )
    		{
    			System.out.print(arr[i] + ",");
    		}
    		System.out.print("]");
    }

}//class