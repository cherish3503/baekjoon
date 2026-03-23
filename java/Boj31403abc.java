import java.io.*;
import java.util.*;

public class Boj31403abc {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();
		int intA = Integer.parseInt(A);
		int intB = Integer.parseInt(B);
		int intC = Integer.parseInt(C);
		
		System.out.println(intA + intB - intC);
		System.out.println(Integer.parseInt(A+B)-intC);
		
	}
}
