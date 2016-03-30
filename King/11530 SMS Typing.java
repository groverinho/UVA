import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount=Integer.parseInt(br.readLine());
        int [] charCount={1,2,3,  1,2,3,  1,2,3,  1,2,3, 1,2,3,  1,2,3,4,   1,2,3,   1,2,3,4};
        for (int testCase=1;testCase<=testCaseCount;testCase++) {
            int count=0;
            String s=br.readLine();
            for (int i=0;i<s.length();i++) {
                char c=s.charAt(i);
                if (Character.isAlphabetic(c)) {
                    count+=charCount[c-'a'];
                } else {
                    count++;
                }
            }
            StringBuilder sb=new StringBuilder("Case #");
            sb.append(testCase);
            sb.append(": ");
            sb.append(count);
            System.out.println(sb.toString());
        }
    }
}