package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Day1_BOJ4358_¹Ú¿ø¼® {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		Map<String, Integer> map = new TreeMap<>();
		int cnt = 0;
		
		while(true) {
			String line = in.readLine();
			
			if(line == null) break;
			
			if(map.containsKey(line)) {
				map.replace(line, map.get(line) + 1);
			} else {
				map.put(line, 1);
			}
			cnt++;
		}
		
		for(String key : map.keySet()) {
			double ratio = (double) map.get(key) / cnt * 100;
			sb.append(key).append(" ").append(String.format("%.4f", ratio)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
