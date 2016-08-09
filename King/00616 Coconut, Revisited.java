import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static boolean test (long v, long people) {
		boolean flag=true;
		for (int i=0;i<=people && flag;i++) {
			flag=(i<people && v%people==1) || (i==people) && (v%people==0);
			v=((v-1)*(people-1))/people;
		}
		return flag;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			long ints=Long.parseLong(br.readLine());
			if (ints<0) {
				break;
			}
			boolean flag=false;
			for (long p=(long)Math.ceil(Math.sqrt(ints-1));p>=2;p--) {
				if (test(ints,p)) {
					System.out.println(ints+" coconuts, "+p+" people and 1 monkey");
					flag=true;
					break;
				}
			}
			if (!flag) {
				System.out.println(ints+" coconuts, no solution");
			}
		}
	}
}