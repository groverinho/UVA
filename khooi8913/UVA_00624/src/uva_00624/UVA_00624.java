package uva_00624;
//NOT SOLVED

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_00624 {
    
    static ArrayList bestPATH = new ArrayList();
    static int bestLENGTH;
    static int [] TRACKS;
    static int CD_LENGTH;
            
    public static void dfs(ArrayList path, int sum, int n){
        sum+=TRACKS[n];
        System.out.println("adding " + TRACKS[n]);
        path.add(TRACKS[n]);
        
        if(sum>bestLENGTH || (sum==bestLENGTH && path.size()>bestPATH.size())){
            bestLENGTH = sum;
            bestPATH = path;
        }
        boolean status=false;
        for(int i=n+1;i<TRACKS.length;i++){
            if( (sum+TRACKS[i]) <=CD_LENGTH){
                System.out.println((sum+TRACKS[i]));
                status=true;
                dfs(path,sum,i);
            }
        }
        
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(s);
            CD_LENGTH = Integer.parseInt(st.nextToken());
            int NUM_TRACK = Integer.parseInt(st.nextToken());
            TRACKS = new int[NUM_TRACK];
            
            for(int i=0;i<TRACKS.length;i++){
                TRACKS[i]=Integer.parseInt(st.nextToken());
            }
            
            bestLENGTH = 0;
            for(int i=0;i<TRACKS.length;i++){
                ArrayList path = new ArrayList();
                dfs(path,0,i);
            }
            
            for(int i=0;i<bestPATH.size();i++){
                System.out.print(bestPATH.get(i)+" ");
            }
            
            System.out.println("sum:"+bestLENGTH);
            
        }
    }
    
    
}
