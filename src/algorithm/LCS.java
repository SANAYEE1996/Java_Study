package algorithm;

public class LCS {
	public String gogo(String a, String b){

		int[][] map = new int[a.length()+1][b.length()+1];
		for(int i = 1; i < map.length; i++){
			for(int j = 1; j < map[i].length; j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					map[i][j] = map[i-1][j-1] + 1;
					continue;
				}
				map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
			}
		}
		int i = a.length(), j = b.length();
		StringBuilder sb = new StringBuilder();
		while(map[i][j] != 0){
			if(map[i][j] == map[i-1][j]){
				i -= 1;
				continue;
			}
			else if(map[i][j] == map[i][j-1]){
				j -= 1;
				continue;
			}
			sb.insert(0,a.charAt(i-1));
			i -= 1;
			j -= 1;
		}
		return sb.toString();
	}
}
