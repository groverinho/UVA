import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    public static int targetSum=0;
    public static HashMap<String,Boolean> map;
    public static boolean hasSolution;
    
    public static void dfs(int [] values, boolean [] flag, int currSum, int min, String str) {
        if (currSum==targetSum) {
            hasSolution=true;
            System.out.println(str.substring(0,str.length()-1));
        } else if (currSum<targetSum) {
            for (int i=min;i<values.length;i++) {
                if (!flag[i]) {
                    String temp=str+values[i]+"+";
                    if (map.get(temp)==null) {
                        flag[i]=true;
                        map.put(temp,true);
                        dfs(values,flag,currSum+values[i],i,temp);
                        flag[i]=false;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s=br.readLine()).equals("0 0")) {
            StringTokenizer st=new StringTokenizer(s);
            targetSum=Integer.parseInt(st.nextToken());
            int n=Integer.parseInt(st.nextToken());
            
            int [] values=new int [n];
            for (int i=0;i<n;i++) {
                values[i]=Integer.parseInt(st.nextToken());
            }
            map=new HashMap<>();
            hasSolution=false;
            
            System.out.println("Sums of "+targetSum+":");
            dfs(values,new boolean [n],0,0,"");
            if (!hasSolution) {
                System.out.println("NONE");
            }
        }
    }
    
}
