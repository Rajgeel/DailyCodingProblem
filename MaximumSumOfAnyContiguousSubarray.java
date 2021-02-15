// Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

// For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

// Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

// Do this in O(N) time.


// Time Complexity is O(n) and space complexity is O(1).
class MaximumSumOfAnyContiguousSubarray {
	
    public int solution(int... arr) {

        int sum = arr[0];
        int newSum = arr[0];
        
        for(int i=1; i<arr.length; i++) {
            
            newSum = Math.max(newSum + arr[i], arr[i]);
            sum = Math.max(newSum, sum);
        }
        
        return sum;
    }

    public static void main(String... args) {

    	MaximumSumOfAnyContiguousSubarray obj = new MaximumSumOfAnyContiguousSubarray();

    	int ans  = obj.solution(-5, -1, -8, -9); //obj.solution(34, -50, 42, 14, -5, 86); 
        
        if(ans < 0) {

        	System.out.println("0");

        }
        else {
        	System.out.println(ans);
        }
    }
}