import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Main {
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("#")) {
			int N=Integer.parseInt(s);
			if (N==0) {
				break;
			}
			
			LinkedList<Integer> list=new LinkedList<>();
			for (int i=1;i<=N;i++) {
				list.add(i);
			}
			
			int bestLength=0;
			int bestM=0;
			for (int m=1;m<N;m++) {
				LinkedList<Integer> tempList=new LinkedList<>();
				tempList.addAll(list);
				
				int curr=0;
				int count=1;
				while (true) {
					if (tempList.get(curr)==13) {
						break;
					} else {
						tempList.remove(curr);
						count++;
						curr--;
					}
					curr=(curr+m)%tempList.size();
				}
				
				if (count>bestLength) {
					bestLength=count;
					bestM=m;
				}
			}
			
			
			System.out.println(bestM);
		}
	}
}