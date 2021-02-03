import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NGF {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] f = new int[N+1];
		int[] ngf = new int[N+1];
		Stack<Integer> stk = new Stack<>();
		String[] strs = br.readLine().split(" ");
		for(int i = N;i>=1;i--) {
			int num = Integer.parseInt(strs[i-1]);
			stk.push(num);
			f[num]++;
		}
		Stack<Integer> stk2 = (Stack<Integer>)stk.clone();
//		while(!stk2.isEmpty()) {
//			System.out.println(stk2.pop());
//		}
		int max=0;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, f[i]);			
		}
		Loop:for(int i=1; i<=N-1; i++) {
			stk2 = (Stack<Integer>)stk.clone();
//			while(!stk2.isEmpty()) {
//			System.out.print(stk2.pop()+", ");
//			}
//			System.out.println();
			while(stk2.size()>1) {
				int target = stk2.pop();
				int compare = stk2.pop();
//				System.out.println("i:"+i+",taget : "+target+", f[target] : "+f[target]+", compare : " + compare+", f[compare] : "+f[compare]+",stack size: "+stk2.size());
				if(f[target]>=f[compare]) {//ngf아닌경우
//					System.out.println("push again");
					stk2.push(target);
				}else if(f[i]==max){
					break;
				}else {//ngf찾은경우
//					System.out.println("found ngf");
					ngf[i] = compare;
					stk.pop();
					continue Loop;
				}
			}
//			System.out.println("not found ngf");
			stk.pop();
			ngf[i] = -1;
			
		}
		ngf[N] = -1;
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(ngf[i]).append(" ");
		}
		System.out.println(sb);
	}

}
