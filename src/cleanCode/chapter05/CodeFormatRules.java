package cleanCode.chapter05;

import java.util.Arrays;
import java.util.HashMap;

public class CodeFormatRules {
	
	private HashMap<String, String> map;
	private HashMap<String, Integer> cal;
	private String[] records;
	private int[] fees;
	
	
	public int[] solution(int[] feesFrom, String[] recordsFrom) {
		this.map = new HashMap<>();
		this.cal = new HashMap<>();
		this.records = recordsFrom;
		this.fees = feesFrom;
		putRecords();
		putSumTime();
		putMoney();
		
        return getKeyArray();
    }
	
	public void putRecords() {
		for(String s : records) {
			putMap(s.split(" "));
		}
	}
	
	public void putMap(String[] exam) {
		if(!map.containsKey(exam[1])) {
			map.put(exam[1], exam[0]);
			return;
		}
		putCal(exam);
	}
	
	public void putCal(String[] exam) {
		if(exam[2].equals("OUT")) {
			putOutRecordToCal(exam[1]);
			cal.put(exam[1], cal.get(exam[1]) + getMin(map.get(exam[1]), exam[0]));
			map.put(exam[1], "");
			return;
		}
		map.put(exam[1], exam[0]);
	}
	
	public void putOutRecordToCal(String carNumber) {
		if(!cal.containsKey(carNumber))  
			cal.put(carNumber, 0);
	}
	
	public void putSumTime() {
		for(String key : map.keySet()) {
			putMinTime(key);
		}
	}

	public void putMinTime(String key) {
		if(!map.get(key).equals("") && cal.containsKey(key)) {
			cal.put(key, cal.get(key) + getMin(map.get(key), "23:59"));
		}
		else if(!map.get(key).equals("") && !cal.containsKey(key)) {
			cal.put(key, getMin(map.get(key), "23:59"));
		}
	}
	
	public int getMin(String in, String out) {
		int inHour = Integer.parseInt(in.substring(0,2));
		int outHour = Integer.parseInt(out.substring(0,2));
		int inMin = 60-Integer.parseInt(in.substring(3));
		int outMin = Integer.parseInt(out.substring(3));
		return (outHour - inHour - 1)*60 + inMin + outMin;
	}
	
	public void putMoney() {
		for(String key : cal.keySet()) {
			cal.put(key, getMoney(fees[0], fees[1], fees[2], fees[3], cal.get(key)));
		}
	}
	
	public int getMoney(int orTime, int orMon, int uniTime, int uniMon, int time) {
		if(time <= orTime)
			return orMon;
		time -= orTime;
		if(time <= uniTime) {
			return uniMon + orMon;
		}
		if(time % uniTime == 0) {
			return ((time/uniTime) * uniMon) + orMon;
		}
		return ((time/uniTime + 1) * uniMon) + orMon;
	}
	
	public int[] getKeyArray() {
		Object[] keyArr = cal.keySet().toArray();
		Arrays.sort(keyArr);
		return copyKeyToArray(keyArr, new int[keyArr.length]);
	}
	
	public int[] copyKeyToArray(Object[] keyArr, int[] answer) {
		int i = 0;
		for(Object key : keyArr) {
			answer[i] = cal.get(key);
			i++;
		}
		return answer;
	}
}