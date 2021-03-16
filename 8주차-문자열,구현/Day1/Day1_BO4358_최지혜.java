import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Day1_BO4358_최지혜 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String,Integer> trees = new TreeMap<>((o1,o2)->o1.compareTo(o2));
		int total=0;
		String str;
		while((str = br.readLine())!=null) {

			if(trees.get(str) != null) trees.put(str, trees.get(str)+1);
			else trees.put(str, 1);
			total++;
		}

		for(String key : trees.keySet()) {
			System.out.printf("%s %.4f\n", key, (double)trees.get(key)/total*100);
		}

	}

}
