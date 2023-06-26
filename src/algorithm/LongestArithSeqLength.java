package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LongestArithSeqLength {
	public int longestArithSeqLength(int[] nums) {
		HashMap<Integer, ArrayList<Integer>> valueIndexMap = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			if(!valueIndexMap.containsKey(nums[i])) valueIndexMap.put(nums[i], new ArrayList<>());
			valueIndexMap.get(nums[i]).add(i);
		}
		gogo(valueIndexMap, nums, 0, 0, new ArrayList<>());
		int max = 0;
		return max;
	}

	private void gogo(HashMap<Integer, ArrayList<Integer>> map, int[] nums, int startIndex, int value, ArrayList<Integer> valueList){
		int start = nums[startIndex];
		int targetKey = 0;
		valueList.add(start);
		System.out.println("startIndex :: " +startIndex);
		System.out.println("valueList :: "+valueList);
		if(value > 10) {
			return;
		}
		for(int i = startIndex+1; i < nums.length; i++){
			targetKey = nums[i]*2 - start;
			if(!map.containsKey(targetKey)) continue;
			ArrayList<Integer> indexList = map.get(targetKey);
			int binary = binary(indexList, i);
			ArrayList<Integer> newValueList = new ArrayList<>();
			newValueList.addAll(valueList);
			newValueList.add(nums[i]);
			gogo(map, nums, binary, value+1, newValueList);
		}
	}

	private int binary(List<Integer> list, int target){
		int low = 0, high = list.size()-1;
		int middle = (low+high)/2;
		while(low <= high){
			if(list.get(middle) <= target){
				low = middle+1;
				middle = (low+high)/2;
				continue;
			}
			high = middle-1;
			middle = (low+high)/2;
		}
		return list.get(middle);
	}
	
	public static void main(String[] args) {
		LongestArithSeqLength s = new LongestArithSeqLength();
		System.out.println(s.longestArithSeqLength(new int[] {3,6,9,12}));
//		System.out.println(s.longestArithSeqLength(new int[] {9,4,7,2,10}));
//		System.out.println(s.longestArithSeqLength(new int[] {20,1,15,3,10,5,8}));
//		List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[] {1,3,5,6,8,9,12}));
//		for(int i = 1; i <= 14; i++) {
//			System.out.println("target : " +i +" and its index = " +s.binary(list, i));
//		}
	}
}
