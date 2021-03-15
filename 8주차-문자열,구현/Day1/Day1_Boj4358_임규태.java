import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String,Integer> mp = new TreeMap<>();
		String in;
		int all = 0;
		while((in = br.readLine()) != null) {
			mp.put(in, mp.getOrDefault(in, 0)+1);
			all++;
		}
		StringBuilder sb = new StringBuilder();
		for(String key : mp.keySet()) {
			sb.append(key).append(String.format(" %.4f", (mp.get(key)/(double)all)*100)).append("\n");
		}
		System.out.println(sb);
	}
}
