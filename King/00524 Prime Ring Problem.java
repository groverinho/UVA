import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static boolean [] isPrime=new boolean [32];
    public static StringBuilder display=new StringBuilder();
    
    public static void dfs (int [] values, boolean [] flag, int level) {
        if (level==values.length) {
            if (isPrime[values[level-1]+values[0]]) {
                StringBuilder sb=new StringBuilder();
                for (int i=0;i<level;i++) {
                    sb.append(values[i]);
                    if (i<level-1) {
                        sb.append(" ");
                    }
                }
                sb.append("\n");
                display.append(sb.toString());
            }
        } else if (level==0) {
            values[level]=1;
            flag[0]=true;
            dfs(values,flag,level+1);
        } else {
            for (int i=0;i<values.length;i++) {
                if (!flag[i] && isPrime[values[level-1]+i+1]) {
                    values[level]=i+1;
                    flag[i]=true;
                    dfs(values,flag,level+1);
                    flag[i]=false;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        int [] primes={2,3,5,7,11,13,17,19,23,29,31};
        for (int i=0;i<primes.length;i++) {
            isPrime[primes[i]]=true;
        }
        int caseCount=1;
        while ((s=br.readLine())!=null) {
            int length=Integer.parseInt(s);
            if (caseCount>1) {
                System.out.println();
            }
            display=new StringBuilder();
            display.append("Case ");
            display.append(caseCount++);
            display.append(":\n");
            dfs(new int [length],new boolean [length],0);
            
            System.out.print(display.toString());
        }
    }
    
}