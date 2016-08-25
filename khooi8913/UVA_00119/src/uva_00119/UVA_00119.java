package uva_00119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class UVA_00119 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int z=0;
        while((s=br.readLine())!=null){
            int numFriends = Integer.parseInt(s);
            HashMap<String,Integer> fList = new HashMap();
            String listFriends = br.readLine();
            String[] friendList = new String[numFriends];
            StringTokenizer st = new StringTokenizer(listFriends);
            for(int i=0;i<numFriends;i++){
                String friend = st.nextToken();
                friendList[i]=friend;
                fList.put(friend, 0);
            }
            
            for(int i=0;i<numFriends;i++){
                st=new StringTokenizer(br.readLine());
                String gifter = st.nextToken();
                int priceSpent = Integer.parseInt(st.nextToken());
                int numGiven = Integer.parseInt(st.nextToken());
                
                if(numGiven!=0){
                    int average = priceSpent/numGiven;
                    int remainder = priceSpent%numGiven;
                    priceSpent-=remainder;
                    
                    for(int j=0;j<numGiven;j++){
                        String theFriend = st.nextToken();
                        fList.put(theFriend, fList.get(theFriend)+average);
                    }
                    fList.put(gifter, fList.get(gifter)-priceSpent);
                }
                
            }
            
            if(z>0)
                System.out.println("");
            
            for(int i=0;i<numFriends;i++){
                System.out.printf("%s %d\n",friendList[i],fList.get(friendList[i]));
            }
            z++;        
        }
    }
}
