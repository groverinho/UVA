package uva_11292;
//NOT SOLVED -- TLE
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_11292 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        String s;
        while(!(s=br.readLine()).equals("0 0")){
            StringTokenizer st = new StringTokenizer(s);
            int numDragon = Integer.parseInt(st.nextToken());
            int numKnight = Integer.parseInt(st.nextToken());
            ArrayList<Integer> dragon = new ArrayList<>();
            ArrayList<Integer> knight = new ArrayList<>();
            ArrayList<Integer> sum = new ArrayList<>();
            for(int i=0;i<numDragon;i++){
                dragon.add(Integer.parseInt(br.readLine()));
            }
            for(int i=0;i<numKnight;i++){
                knight.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(dragon);
            Collections.sort(knight);
            boolean doomed = false;
            if(dragon.size()>knight.size()){
                doomed=true;
            }else{
                int fulfill =0;
                for(int i=0;i<dragon.size();i++){
                    int x = dragon.get(i);
                    int min =Integer.MAX_VALUE;
                    int temp=0;
                    for(int j=0;j<knight.size();j++){
                        if(knight.get(j)>=x){
                            if(knight.get(j)<min){
                                min = knight.get(j);
                                temp=j;
                            }
                        }
                    }
                    sum.add(min);
                    knight.remove(temp);
                    fulfill++;
                }
                if(fulfill!=dragon.size())
                    doomed=true;
            }
            
            if(doomed)
                pr.println("Loowater is doomed!");
            else{
                int w=0;
                for(int i=0;i<sum.size();i++){
                    w+=sum.get(i);
                }
                pr.println(w);
            }
        }
        pr.close();
    }
    
}
