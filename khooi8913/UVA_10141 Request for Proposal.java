import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader systemInput=new BufferedReader(new InputStreamReader(System.in));
        int w=0;
        String a;
        
        while((a = systemInput.readLine())!=null && !a.equals("0 0")){
            
            double compliance=0;
            double selectedPrice=0;
            String selectedProposal="";
            
            StringTokenizer st = new StringTokenizer(a);
            double numRequirement = Double.parseDouble(st.nextToken());
            int numProposal = Integer.parseInt(st.nextToken());
            
            for(int i=0; i<numRequirement;i++){
                systemInput.readLine();
            }
            
            for(int k=0;k<numProposal;k++){
                
                String nameProposal = systemInput.readLine();
                a = systemInput.readLine();
                st = new StringTokenizer(a);
                double priceProposal = Double.parseDouble(st.nextToken());
                double numProposed = Double.parseDouble(st.nextToken());

                for(int i=0;i<numProposed;i++){
                    systemInput.readLine();
                }
                
                double compliance1 = numProposed/numRequirement;
                if(compliance1>compliance){
                    selectedProposal = nameProposal;
                    selectedPrice = priceProposal;
                    compliance = compliance1;
                }
                else if(compliance1==compliance){
                    if(priceProposal<selectedPrice){
                        selectedProposal = nameProposal;
                        selectedPrice = priceProposal;
                        compliance = compliance1;
                    }                    
                }
            }
            
            w++;
            if(w>1) System.out.println("");
            
            System.out.println("RFP #"+w);
            System.out.println(selectedProposal);
        }
    }
}
