import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
        for(int i=1;i<=10;i++) solve(i);
    }
     
    static void solve(int tc) throws NumberFormatException, IOException {
 
        int[] arr = new int[100];
        int n = Integer.parseInt(br.readLine());
         
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<100;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
         
        for(int i=0;i<n;i++) {
            Arrays.sort(arr);
            arr[0]++;
            arr[99]--;
        }
        Arrays.sort(arr);
        System.out.println("#"+tc+" "+(arr[99]-arr[0]));
    }
}
