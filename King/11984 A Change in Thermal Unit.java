import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount=Integer.parseInt(br.readLine());
        for (int testCase=1;testCase<=testCaseCount;testCase++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            double temp=Integer.parseInt(st.nextToken());
            temp+=((Integer.parseInt(st.nextToken())*5.0 - 32) / 9.0)+(32/9.0);
            StringBuilder sb=new StringBuilder();
            sb.append("Case ");
            sb.append(testCase);
            sb.append(": ");
            sb.append(String.format("%.2f",temp));
            System.out.println(sb.toString());
        }
    }
}