// Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum length, return any one.

// For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana".


// Time Complexity is O(n^2) and space complexity is O(n^2).
class LongestPalindromicSubstring {

    int longestPalSubstr(String str){

        int n = str.length();
 
        boolean table[][] = new boolean[n][n];
 
        int maxLength = 1;

        for(int i = 0; i < n; ++i){

            table[i][i] = true;
        }

        int start = 0;

        for(int i = 0; i < n - 1; ++i) {

            if (str.charAt(i) == str.charAt(i + 1)) {

                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
 

        for(int k = 3; k <= n; ++k) {
 
            for (int i = 0; i < n - k + 1; ++i) {

                int j = i + k - 1;

                if(table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {

                    table[i][j] = true;
 
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        System.out.print("Longest palindrome substring is ");

        printSubStr(str, start, start + maxLength - 1);

        return maxLength;
    }

    void printSubStr(String str, int low, int high) {

        System.out.println(str.substring(low, high + 1));
    }

    public static void main(String[] args) {

    	LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
 
        String str = "aabcdcb";

        System.out.println(obj.longestPalSubstr(str));
    }
}