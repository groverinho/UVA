import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			int S=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			int [] left=new int [S];
			int [] right=new int [S];
			for (int i=0;i<S;i++) {
				left[i]=i-1;
				right[i]=i+1;
			}
			left[0]=Integer.MIN_VALUE;
			right[S-1]=Integer.MIN_VALUE;
			
			StringBuilder sb=new StringBuilder();
			for (int b=0;b<B;b++) {
				st=new StringTokenizer(br.readLine());
				int L=Integer.parseInt(st.nextToken())-1;
				int R=Integer.parseInt(st.nextToken())-1;
				
				if (left[L]!=Integer.MIN_VALUE) {
					right[left[L]]=right[R];
					sb.append(left[L]+1);
				} else sb.append('*');
				
				sb.append(" ");
				
				if (right[R]!=Integer.MIN_VALUE) {
					left[right[R]]=left[L];
					sb.append(right[R]+1);
				} else sb.append('*');
				
				sb.append('\n');
			}
			sb.append('-');
			System.out.println(sb.toString());
		}
	}

}