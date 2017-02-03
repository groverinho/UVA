import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        int numPeople = sn.nextInt();
        String[] people = new String[numPeople];
        for(int i=0;i<numPeople;i++){
            people[i]=sn.next();
        }
        
        String[] lyric = {"Happy","birthday","to","you","Happy","birthday","to","you","Happy","birthday","to","Rujia","Happy","birthday","to","you"};
        int songLength=16;
        while(numPeople>songLength){
            songLength+=16;
        }
        
        for(int i=0;i<songLength;i++){
            System.out.printf("%s: %s\n",people[i%numPeople],lyric[i%16]);
        }
    }
    
}
