package algorithm;

import java.util.HashMap;
import java.util.HashSet;

public class LongestArithSeqLength {
	public int longestArithSeqLength(int[] nums) {
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
			
		int max = 0;
		int key = 0;
		
		for(int i = 0; i < nums.length-1; i++){
			for(int j = i+1; j < nums.length; j++){
				key = nums[j]-nums[i];
				if(!map.containsKey(key)){
					map.put(key, new HashSet<>());
				}
				map.get(key).add(j);
				map.get(key).add(i);
			}
		}
		
		for(int k : map.keySet()){
			max = Math.max(max, map.get(k).size());
			System.out.println("key : " +k+" and set : " +map.get(k));
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		LongestArithSeqLength s = new LongestArithSeqLength();
		System.out.println(s.longestArithSeqLength(new int[] {3,6,9,12}));
		System.out.println(s.longestArithSeqLength(new int[] {9,4,7,2,10}));
		System.out.println(s.longestArithSeqLength(new int[] {20,1,15,3,10,5,8}));
	}
}
