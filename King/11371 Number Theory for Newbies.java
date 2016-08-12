import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	
	public static long first;
	public static long last;
	
	public static void findFirst (int [] v, int mask, long currValue, int level) {
		if (level==v.length) {
			first=currValue;
		} else {
			for (int i=0;i<v.length;i++) {
				if (!(v[i]==0 && level==0) && (mask & (1 << i))==0 && first==-1) {
					findFirst(v,mask|(1<<i),currValue*10+v[i],level+1);
				}
			}
		}
	}
	
	public static void findLast (int [] v, int mask, long currValue, int level) {
		if (level==v.length) {
			last=currValue;
		} else {
			for (int i=v.length-1;i>=0;i--) {
				if (!(v[i]==0 && level==0) && (mask & (1 << i))==0 && last==-1) {
					findLast(v,mask|(1<<i),currValue*10+v[i],level+1);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			char [] c=s.toCharArray();
			Arrays.sort(c);
			int [] v=new int [c.length];
			for (int i=0;i<c.length;i++) {
				v[i]=c[i]-'0';
			}
			first=-1;
			findFirst(v,0,0,0);
			last=-1;
			findLast(v,0,0,0);
			long diff=last-first;
			System.out.println(last+" - "+first+" = "+diff+" = 9 * "+diff/9);
		}
	}
}