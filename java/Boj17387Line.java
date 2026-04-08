import java.util.*;
import java.io.*;

public class Boj17387Line {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		int x4 = Integer.parseInt(st.nextToken());
		int y4 = Integer.parseInt(st.nextToken());
		
		int result = 0;
		
		long line3 = line(x3,y3,x1,y1,x2,y2);
		long line4 = line(x4,y4,x1,y1,x2,y2);
		long line1 = line(x1,y1,x3,y3,x4,y4);
		long line2 = line(x2,y2,x3,y3,x4,y4);
		
		if((line3 <=0 && line4>=0) || (line3 >=0 && line4<=0)) {
			if((line1<=0 && line2>=0) || (line1>=0 && line2<=0)) {
				result = 1;
			}
		}
		if((line1 | line2 | line3 | line4) ==0) {
			result = 0;

			if(((x1-x2)|(x3-x4)) != 0){
				if(isCrossStraigt(x1, x2, x3, x4)) result = 1;
			}
			else if(isCrossStraigt(y1, y2, y3, y4)) {
				result = 1;
			}
		}
		
		
		System.out.println(result);
		
	}
	
	private static long line(int x, int y, int x1, int y1, int x2, int y2) {
		return (long)(y-y1)*(long)(x2-x1)-(long)(y2-y1)*(long)(x-x1);
	}
	
	private static boolean isCrossStraigt(int x1, int x2, int x3, int x4) {
		int min1 = Math.min(x1, x2);
		int max1 = Math.max(x1, x2);
		int min2 = Math.min(x3, x4);
		int max2 = Math.max(x3, x4);
		if(min1<=min2 && max1>= min2) return true;
		else if(min2<=min1 && max2>=min1) return true;
		return false;
		
	}
}
