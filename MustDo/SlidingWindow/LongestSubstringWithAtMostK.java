import java.util.*;
public class Solution {

	public static int kDistinctChars(int k, String str) {
		int n = str.length();
		int i = 0, j = 0;
		Map<Character, Integer> mp = new HashMap<>();
		int maxLen = 0;
		while(j < n) {
			mp.put(str.charAt(j), mp.getOrDefault(str.charAt(j), 0) + 1);
			if(mp.size() > k){
				int count = mp.get(str.charAt(i));
				if(count == 1) mp.remove(str.charAt(i));
				else mp.put(str.charAt(i), count-1);
				i++;	
			}
			else if(mp.size() <= k){
				maxLen = Math.max(maxLen, j - i + 1);
			}

			j++;
		}

		return maxLen;
	}

}
