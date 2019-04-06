/**
 * CISC 380
 * Algorithms Assignment 4
 * 
 * Implements dynamic programming solutions to see if a subset adds up to a value.
 * 
 * @author Steffan Musoke
 * 			Nathan Taylor
 * Due Date: 04/03/19
 */

import java.util.*;

public class DynamicSum{
	
	private boolean[][] T;
	
    public DynamicSum(){
    		this.T = new boolean[0][0];
    }//constructor

    /**
     *Checks to see if a subset of arr adds up to exactly t with an iterative solution.
	 *
     * @param arr the array of integers to take subsets from.
     * @param t   the value the subset could add up to.
     * @return True, if a subset adds up to t, false otherwise.
     * 
     */
    public boolean isSum(int[] arr, int t){
    		/*
    		 * Analysis: The input check, base cases, and variable initialization are constant O(1)
    		 * operations.  We will reference those as C1.  The initialization of the table, T,
    		 * will require initially set each position in the table to false, therefore this would
    		 * take constant time O(1), we will call this C2.  The first for loop will occur n times,
    		 * and each occurrence will do constant work.  This allows us to conclude it will be O(n). 
    		 * The next loop occurs t times, the inner loop occurs n times, and the innermost work
    		 * including the conditionals and assignments are all constant work.  Therefore, we
    		 * can conclude this nested loop does n*t work, O(n*t). The next set2dTable call is 
    		 * a simple constant time operation which we will call C3.  Finally the return statement
    		 * at the end is constant time, because the table lookup takes constant time.
    		 * 
    		 * We find:
    		 * O(n*t) + O(n) + C1 + C2 + C3 = O(n*t)
    		 * 
    		 * The runtime is O(n*t)
    		 */
    	
    	
    		//Check input
    		if( t < 0 ) { throw new IllegalArgumentException("Subset sum is negative"); }
    	
    		//Base cases
    		if( t == 0 ) { return true; }
    		if( arr.length == 0 ) { return false; }
    	
    		
    		//Table dimensions
    		int i = arr.length;
    		int x = t + 1;
    		
    		boolean[][] T = new boolean[x][i];
    		
    		//Initialize the first row as true, as sum 0 is always true
    		for(int ind = 0; ind < i; ind++)
    		{
    			T[0][ind] = true;
    		}
    		
    		for(int sum = 1; sum < x; sum++)	
    		{
    			for(int ind = 0; ind < i; ind++)
    			{
    				//Base cases
    				//Array item i is equal to the sum
    				if( arr[ind] == sum )
    				{
    					T[sum][ind] = true;
    				}
    				
    				//Index - 1 if not first index
    				if( ind > 0 && T[ sum ][ ind-1 ] == true )
    				{
    					T[sum][ind] = true;
    				}

    				//Sum is not below 0 when subtracted by Array item i 
    				if( sum - (arr[ind]) >= 0 && ind > 0 && T[ sum-arr[ind] ][ ind-1 ] == true )
    				{
    					T[sum][ind] = true;
    				}
    				
    			}
    		}
    		
    		set2dTable(T);
    		
    		return T[x - 1][i - 1];
    }//isSum
    
    
    private boolean[][] get2dTable()
    {
    		return this.T;
    }
    
    
    private void set2dTable( boolean[][] table )
    {
    		this.T = table;
    }
    


    /**
     *Checks to see if a subset of arr adds up to exactly t with a memoizied solution.
	 *
     * @param arr the array of integers to take subsets from.
     * @param t   the value the subset could add up to.
     * @return    True, if a subset adds up to t, false otherwise.
     * 
     */
    public boolean isSumMem(int[] arr, int t ){
    		/*
    		 * The input check and base cases are all constant time operations, O(1).  Therefore
    		 * we can call this C1.  The recursive call will have n levels with each call doing
    		 * constant work disregarding the next recursive call. So we will be doing n * c work.
    		 * This allows us to conclude the recursive call is O(n).
    		 * 
    		 * O(n) + C1 = O(n)
    		 * 
    		 * So we conclude the runtime is: O(n)
    		 */
    	
    	
    	
		//Check input
		if( t < 0 ) { throw new IllegalArgumentException("Subset sum is negative"); }
	
		//Base cases
		if( t == 0 ) { return true; }
		if( arr.length == 0 ) { return false; }
		


        
        return isSumMem( arr, t, arr.length - 1 );
    }//isSumMem
    
    
    private boolean isSumMem( int[] arr, int t, int index )
    {
    		//Base cases
		if( t < 0 ) {  return false; }
		if( index < 0 ) {  return false; }
		if( arr.length == 0 ) { return false; }
		if( t == 0 ) { return true; }
		if(  arr[index] == t ) { return true; }

		//Recursion to obtain needed positions
    		return isSumMem( arr, t, index-1 ) || isSumMem( arr, t - arr[index], index-1 );
    }

    /**
     * Recovers the subset of arr that adds up to t, if it exists.
	 *
     * @param arr the array of integers to take subsets from.
     * @param t   the value the subset could add up to.
     * @return a subset of arr that adds up to t, null otherwise.
     * 
     */
    public int[] getSubset(int[] arr, int t){
    		/*
		 * Analysis: The input check, base cases, and variable initialization are constant O(1)
		 * operations.  We will reference those as C1.  The initialization of the table, T, 
		 * requires the call of isSum which has a runtime of n*t as we stated above.  The
		 * while loop will occur at most n times with the inside of the loop doing conditionals
		 * and assignment which is constant work.  Therefore the while loop will be O(n).  The
		 * final loop will occur at most n times. And the inside of the loop will do constant
		 * work.  Therefore we conclude the final loop will be O(n).  Finally, the return
		 * statement is constant.  We will call this C2.
		 * 
		 * 
		 * 
		 * We find:
		 * O(n*t) + O(n) + C1 + C2 = O(n*t)
		 * 
		 * The runtime is O(n*t)
		 */
    	
    	
    		boolean[][] T;
    		LinkedList<Integer> linkedList = new LinkedList<Integer>();
    		int[] finalList = null;
    		int index;
    		int sum;

		//Check input
		if( t < 0 ) { throw new IllegalArgumentException("Subset sum is negative"); }
	
		
		//Get table
		this.isSum(arr, t);
		T = this.get2dTable();
		
		if( T.length == 0 ) { return finalList; }
		
		sum = T.length - 1;
		index = T[0].length - 1;
		
		
		//Backtrack from bottom left of table
		while( index > -1 )
		{
			if( T[sum][index] )
			{
				//Only add integers that helped us come closer to 0 sum
				//subtracting array[i] doesnt make negative, AND either it brought us closer to sum 0 or IS sum 0
				if( sum - arr[index] >= 0 && ( index == 0 || T[ sum - arr[index] ][index - 1] ) )
				{
					linkedList.add(arr[index]);
					sum = sum - arr[index];
				}
			}
			
			
			index = index - 1;
		}
		

		//Fill int[] from linkedList
		if( linkedList.size() >= 1 )
		{
			finalList = new int[linkedList.size()];
			
			for( int i = 0; i < linkedList.size(); i++ )
			{
				finalList[i] = linkedList.get(i);
			}
		}
		
	
        
        return finalList;

    }//getSubset
    

    
    
    private void testTable(boolean[][] T)
    {
		//Test table
		for(int sum = 0; sum < T.length; sum++)
		{
			System.out.println("");
			for(int ind = 0; ind < T[sum].length; ind++)
			{
				System.out.print( T[sum][ind] +" ,");
			}
		}
    }
}//class