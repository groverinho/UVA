import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list=new ArrayList<>();
		list.add(0);
		list.add(1);
		for (int i=2;i<10000;i++) {
			list.add(i*i);
		}
		
		int [] tens=new int [9];
		tens[0]=1;
		for (int i=1;i<tens.length;i++) {
			tens[i]=tens[i-1]*10;
		}
		
		String s;
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);
			for (int i=0;i<list.size() && list.get(i)<tens[n];i++) {
				String v=String.format("%0"+n+"d", list.get(i));
				int i1=list.get(i)/tens[n/2];
				int i2=list.get(i)%tens[n/2];
				if ((i1+i2)*(i1+i2)==list.get(i)) {
					System.out.println(v);
				}
			}
		}
	}
}