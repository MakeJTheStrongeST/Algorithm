import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day3_BOJ17225_¹Ú¿ø¼® {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Order> pq = new PriorityQueue<>();
		int bEnd = 0, rEnd = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			char color = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());

			if (color == 'B') {
				for (int j = 0; j < num; j++) {
					int s = start + A * j;
					if (s >= bEnd) {
						pq.add(new Order(s, 'B'));
					} else {
						pq.add(new Order(bEnd, 'B'));
					}
					bEnd = s + A;
				}
			} else {
				for (int j = 0; j < num; j++) {
					int s = start + B * j;
					if (s >= rEnd) {
						pq.add(new Order(s, 'R'));
					} else {
						pq.add(new Order(rEnd, 'R'));
					}
					rEnd = s + B;
				}
			}
		}

		ArrayList<Integer> blue = new ArrayList<>();
		ArrayList<Integer> red = new ArrayList<>();

		int cnt = 1;
		while (!pq.isEmpty()) {
			if (pq.peek().color == 'B')
				blue.add(cnt++);
			else
				red.add(cnt++);
			pq.poll();
		}

		StringBuilder sb = new StringBuilder();
		sb.append(blue.size()).append("\n");
		for (Integer i : blue)
			sb.append(i).append(" ");
		sb.append("\n").append(red.size()).append("\n");
		for (Integer i : red)
			sb.append(i).append(" ");
		System.out.println(sb.toString());
	}
}

class Order implements Comparable<Order> {
	int time;
	char color;

	Order(int time, char color) {
		this.time = time;
		this.color = color;
	}

	@Override
	public int compareTo(Order o) {
		if (time == o.time)
			return color - o.color;
		return time - o.time;
	}
}
