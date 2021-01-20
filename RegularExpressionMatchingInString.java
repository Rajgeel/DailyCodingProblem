// Implement regular expression matching with the following special characters:

// . (period) which matches any single character
// * (asterisk) which matches zero or more of the preceding element
// That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.

// For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return false.

// Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.



import java.util.Scanner;


//Time Complexity is O(m+n) and space complexity is O(m+n).
class RegularExpressionMatchingInString {

	int dp[][];


	int solution(int i, int j, String A, String B) {

		if (i < 0 && j < 0) {
            return 1;
		}
   
        if (j < 0) {
            return 0;
        }
       
        if (i < 0) {
            
            while (j >= 0) {

                if (B.charAt(j) != '*') {
                    return 0;
                }

                j--;
            }

            return 1;
        }
        
        // if(dp[i][j] != -1){
            
        //     return dp[i][j];
        // }
        
        if (dp[i][j] == -1){
            
            if (B.charAt(j) == '*'){
                return dp[i][j] = solution(i - 1, j, A, B)
                                  | solution(i, j - 1, A, B);
            }
            else{

                if (B.charAt(j) != A.charAt(i) && B.charAt(j) != '.') {
                    return dp[i][j] = 0;
                }
                else {

                    return dp[i][j]
                           = solution(i - 1, j - 1, A, B);
                }
            }
        }

        return dp[i][j];
	}

	
	public static void main(String... s) {
		
		RegularExpressionMatchingInString obj = new RegularExpressionMatchingInString();
		Scanner sc = new Scanner(System.in);

		String string = sc.next();

		String key = sc.next();

		obj.dp = new int[string.length() + 1][key.length() + 1];

		for(int i=0; i<=string.length(); i++) {
			for(int j=0; j<=key.length(); j++) {

				obj.dp[i][j] = -1;
			}
		}

		int ans = obj.solution(string.length()-1, key.length()-1, string, key);

		if(ans == 1) {

			System.out.print("true");
		}
		else {
			System.out.print("false");
		}
	}
}