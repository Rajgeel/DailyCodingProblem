// Given a string s and an integer k, break up the string into multiple lines such that each line has a length of k or less. You must break it up so that words don't break across lines. Each line has to have the maximum possible amount of words. If there's no way to break the text up, then return null.

// You can assume that there are no spaces at the ends of the string and that there is exactly one space between each word.

// For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Time complexity is O(n) and space complexity is O(n)
class BreakStringIntoMultipleLines  {
	

    public List<String> breakIntoWords(String str, int k) {

        String[] words = str.split("\\s+");
        List<String> res = new ArrayList<>(words.length);
        StringBuilder sb = null;

        for (String word : words) {
            if (word.length() > k)
                return null;
            if (sb == null)
                sb = new StringBuilder(word);
            else if (sb.length() + word.length() + 1 <= k)
                sb.append(' ').append(word);
            else {
                res.add(sb.toString());
                sb = new StringBuilder(word);
            }
        }

        if (sb != null)
            res.add(sb.toString());

        return res;
    }

    public static void main(String... args) {

    	BreakStringIntoMultipleLines obj = new BreakStringIntoMultipleLines();

        List<String> ans = obj.breakIntoWords("the quick brown fox jumps over the lazy dog", 10);

        System.out.println(ans != null ? Arrays.toString(ans.toArray(new String[0])) : null);
    }
}