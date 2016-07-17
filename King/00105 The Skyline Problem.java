import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		int [] heights=new int [10001];
		int minX=10000;
		int maxX=0;
		while ((s=br.readLine())!=null) {
			if (s.equals("")) {
				break;
			}
			StringTokenizer st=new StringTokenizer(s);
			int min=Integer.parseInt(st.nextToken());
			int h=Integer.parseInt(st.nextToken());
			int max=Integer.parseInt(st.nextToken());
			
			for (int i=min;i<max;i++) {
				heights[i]=Math.max(heights[i], h);
			}
			
			minX=Math.min(minX,min);
			maxX=Math.max(maxX,max);
		}
		
		StringBuilder sb=new StringBuilder();
		int last=0;
		for (int i=minX;i<maxX;i++) {
			if (heights[i]!=last) {
				sb.append(i+" "+heights[i]+" ");
				last=heights[i];
			}
		}
		sb.append(maxX+" 0");
		System.out.println(sb.toString());
	}  
}