// Given a function that generates perfectly random numbers between 1 and k (inclusive), where k is an input, 
// write a function that shuffles a deck of cards represented as an array using only swaps.

// It should run in O(N) time.

// Hint: Make sure each one of the 52! permutations of the deck is equally likely.


import java.util.Arrays; 
import java.util.Random; 


// Time Complexity is O(n) and space complexity is O(1).
class ShuffleRandam {
	
	void solution( int arr[], int n) { 
     
        Random r = new Random(); 
         
        for(int i = n-1; i > 0; i--) { 

            int j = r.nextInt(i+1); 

            int temp = arr[i]; 
            arr[i] = arr[j]; 
            arr[j] = temp; 
        } 

        System.out.println(Arrays.toString(arr)); 
    } 
      
    public static void main(String[] args)  
    { 
        ShuffleRandam obj = new ShuffleRandam();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8}; 
        int n = arr.length; 

        obj.solution(arr, n); 
    }
} 