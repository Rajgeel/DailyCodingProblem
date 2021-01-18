// Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

// Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.



import java.util.Scanner;


// Time complexity is O(n) and space complexity is O(1).
class EncodingString {

	String solution(String s) {

		String ans = "";

		if(s.length() == 0) {

			return " ";
		}

		if(s.length() == 1) {

			ans = "1" + s.charAt(0);
			return ans;
		}

		int countChar = 1;

		for(int i=0; i<s.length()  - 1; i++) {


			if(s.charAt(i) != s.charAt(i+1)) {

				ans = ans + countChar + s.charAt(i);
				countChar = 1;
			}
			else {

				countChar++;
			}
		}

		if(s.charAt(s.length() -2) != s.charAt(s.length() -1)) {
			ans = ans + 1 + s.charAt(s.length() -1);
		}
		else {
			ans = ans + countChar++ + s.charAt(s.length() -1);
		}


		return ans;
	}
	
	public static void main(String... s) {

		EncodingString obj = new EncodingString();
		Scanner sc = new Scanner(System.in);

		String string = sc.next();

		System.out.println(obj.solution(string));
	}
}