import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=0;
        String s;
        int round=1;
        while (!(s=br.readLine()).equals("0")) {
            n=Integer.parseInt(s);
            int[] answer=new int [n];
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int i=0;i<n;i++) {
                answer[i]=Integer.parseInt(st.nextToken());
            }
                
            int [] curr=new int [n];
            boolean [] flag1=new boolean [n];
            boolean [] flag2=new boolean [n];
            
            StringBuilder sb=new StringBuilder("Game ");
            sb.append(round);
            sb.append(":\n");
            while (true) {
                Arrays.fill(curr,0);
                Arrays.fill(flag1,false);
                Arrays.fill(flag2,false);
                st=new StringTokenizer(br.readLine());
                
                int zeroCount=0;
                for (int i=0;i<n;i++) {
                    curr[i]=Integer.parseInt(st.nextToken());
                    if (curr[i]==0) {
                        zeroCount++;
                    }
                }
                
                if (zeroCount==n) {
                    break;
                }
                int strongCount=0;
                int weakCount=0;
                for (int i=0;i<n;i++) {
                    if (answer[i]==curr[i]) {
                        strongCount++;
                        flag1[i]=true;
                        flag2[i]=true;
                    }
                }
                
                for (int i=0;i<n;i++) {
                    if (!flag1[i]) {
                        for (int i2=0;i2<n;i2++) {
                            if (!flag2[i2] && answer[i]==curr[i2]) {
                                weakCount++;
                                flag1[i]=true;
                                flag2[i2]=true;
                                break;
                            }
                        }
                    }
                }
                sb.append("    (");
                sb.append(strongCount);
                sb.append(",");
                sb.append(weakCount);
                sb.append(")\n");
            }
            System.out.print(sb.toString());
            round++;
        }
    }
    
}
