import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Euler {

	public static void main(String[]args)throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		String [] condition={"You win.","You chickened out.","You lose."};
		while (!(s=br.readLine()).equals("-1")) {
			int testCase=Integer.parseInt(s);
			char [] question=br.readLine().toCharArray();
			char [] answer=br.readLine().toCharArray();
			
			int [] flag=new int [128];
			int qCharCount=0;
			//0 = not exists, not guessed, 1 = not exists, guessed, 2 = exists, but not guessed, 3 = exists & guessed
			for (int i=0;i<question.length;i++) {
				if (flag[question[i]]==0) {
					flag[question[i]]=2;
					qCharCount++;
				}
			}
			
			int wrongCount=0;
			for (int i=0;i<answer.length && wrongCount<7;i++) {
				if (flag[answer[i]]==2) {
					flag[answer[i]]=3;
					qCharCount--;
				}else if (flag[answer[i]]==0) {
					flag[answer[i]]=1;
					wrongCount++;
				}
			}
			
			StringBuilder sb=new StringBuilder("Round ");
			sb.append(testCase);
			sb.append("\n");
			if (qCharCount==0) {
				sb.append(condition[0]);
			} else if (wrongCount>=7) {
				sb.append(condition[2]);
			} else {
				sb.append(condition[1]);
			}
			System.out.println(sb.toString());
		}
	}
}