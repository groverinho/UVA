import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        int numCases = sn.nextInt();
        for(int i=0;i<numCases;i++){
            int[] array = new int[10];
            
            for(int j=0;j<array.length;j++){
                array[j]=sn.nextInt();
            }
            
            boolean ascend=false;
            boolean descend=false;
            boolean lumber=true;
            for(int j=0;j<array.length-1;j++){
                if(j==0){
                    if(array[j]<array[j+1])
                        ascend=true;
                    else
                        descend=true;
                }
                if(descend && lumber){
                    if(array[j]<array[j+1]){
                        lumber = false;
                        break;
                    }
                    
                }
                else if(ascend && lumber)
                    if(array[j]>array[j+1]){
                        lumber = false;
                        break;
                    }
            }
            
            if(i==0)
                System.out.println("Lumberjacks:");
            
            if(lumber)
                System.out.println("Ordered");
            else
                System.out.println("Unordered");
            
        }
    }
    
}
