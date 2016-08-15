package uva_11764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_11764 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());
        for(int i=1;i<=numCases;i++){
            int highJump=0;
            int lowJump=0;
            int numWalls = Integer.parseInt(br.readLine());
            
            String listWalls = br.readLine();
            StringTokenizer st = new StringTokenizer(listWalls);
            int [] wall = new int [st.countTokens()];
            for(int j=0;j<wall.length;j++){
                wall[j]=Integer.parseInt(st.nextToken());
            }
            
            if(wall.length>1){
                for(int j=0;j<wall.length-1;j++){
                    if(wall[j]>wall[j+1]){
                        lowJump++;
                    }
                    else if(wall[j]<wall[j+1]){
                        highJump++;
                    }    
                }
            }
            
            System.out.println("Case "+i+": "+highJump+" "+lowJump);
        }
    }
    
}
