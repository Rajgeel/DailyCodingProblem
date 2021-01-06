/*
	Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

	For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
*/




import java.util.*;



// Time complexity is O(nlogn) and space complexity is O(1)
class MinClassRoomRequire {


	static int findClassroom(int hr[], int min[], int n) 
    { 
        Arrays.sort(hr); 
        Arrays.sort(min); 
  
        
        int class_needed = 1, result = 1; 
        int i = 1, j = 0; 
  
        
        while (i < n && j < n) { 
 
            if (hr[i] <= min[j]) {

                class_needed++; 
                i++; 
            } 
  
            
            else if (hr[i] > min[j]) { 
            	
                class_needed--; 
                j++; 
            } 
  
            
            if (class_needed > result) 
                result = class_needed; 
        } 
  
        return result; 
    } 
  

	public static void main(String... s) {

		MinClassRoomRequire obj = new MinClassRoomRequire();
		Scanner sc = new Scanner(System.in);

		int lecture = sc.nextInt();

		int hr[] = new int[lecture];
		int min[] = new int[lecture];

		for(int i=0; i<lecture; i++) {

			hr[i] = sc.nextInt();
		}

		for(int i=0; i<lecture; i++) {

			min[i] = sc.nextInt();
		}

		System.out.println(findClassroom(hr, min, lecture));


	}
}