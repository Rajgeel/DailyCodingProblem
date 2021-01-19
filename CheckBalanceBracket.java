// Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

// For example, given the string "([])[]({})", you should return true.

// Given the string "([)]" or "((()", you should return false.


import java.util.*;


// Time Complexity is O(n) and space complexity is O(n).
class CheckBalanceBracket {


	boolean solution(String s) {

		Deque<Character> dq = new ArrayDeque<Character>();

		for(int i=0; i<s.length(); i++) {

			char ch = s.charAt(i);

			if(ch == '(' || ch == '{' || ch == '[') {

				dq.push(ch);
				continue;
			}

			if(dq.isEmpty()) {

				return false;
			}

			char check;

			switch(ch) {

				case ')':

					check = dq.pop();

					if(check == '{' || check == '[') {
						return false;
					}
					break;

				case '}':

					check = dq.pop();

					if(check == '(' || check == '[') {
						return false;
					}
					break;

				case ']':

					check = dq.pop();

					if(check == '(' || check == '{') {
						return false;
					}
					break;
			}
		}

		return (dq.isEmpty());
	}
	

	public static void main(String... s) {

		CheckBalanceBracket obj = new CheckBalanceBracket();
		Scanner sc = new Scanner(System.in);

		String string = sc.next();

		System.out.println(obj.solution(string));
	}
}