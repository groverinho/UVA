import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JavaApplication100 {
    
    static class Data {
        boolean disableDisplay;
        int on,id,m,b,t;
        
        @Override
        public String toString() {
            StringBuilder sb=new StringBuilder();
            sb.append(this.on);
            sb.append(" ");
            sb.append(this.id);
            sb.append(" ");
            sb.append(this.m);
            sb.append(" ");
            sb.append(this.b);
            sb.append(" ");
            sb.append(this.t);
            return sb.toString();
        }
    }
    
    public static int [] rangeMin ={0,30,90,150,210,270,330,390,450};
    public static int [] rangeMax ={29,89,149,209,269,329,389,449,479};
    public static int [] correction = new int [480];
    
    private static void setupTickCorrection () {
        for (int i=0;i<rangeMin.length;i++) {
            for (int i2=rangeMin[i];i2<=rangeMax[i];i2++) {
                correction[i2]=i*60;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        setupTickCorrection();
        while (!(s=br.readLine()).equals("-1")) {
            int perfCount=Integer.parseInt(s);
            Data [] records=new Data [perfCount];
            for (int i=0;i<perfCount;i++) {
               StringTokenizer st=new StringTokenizer(br.readLine());
               Data d=new Data();
               d.on=Integer.parseInt(st.nextToken());
               d.id=Integer.parseInt(st.nextToken());
               d.m=Integer.parseInt(st.nextToken());
               d.b=Integer.parseInt(st.nextToken());
               d.t=correction[Integer.parseInt(st.nextToken())];
               if (d.t==480) {
                   d.t=0;
                   d.b++;
                   if (d.b==5) {
                       d.b=1;
                       d.m++;
                   }
               }
               records[i]=d;
            }
            
            StringBuilder sb=new StringBuilder();
            int actualCount=0;
            for (int i=0;i<records.length;i++) {
                Data d=records[i];
                if (d.on==1) {
                    Data d2=null;
                    boolean found=false;
                    //search for next off.
                    for (int i2=i+1;i2<records.length && !found;i2++) {
                        d2=records[i2];
                        found=(d2.id==d.id && d2.on==0);
                    }
                    if (found) {
                        //found next off, compare duration.
                        if (d.m!=d2.m || d.b!=d2.b || d.t!=d2.t) {
                            actualCount++;
                            sb.append(d.toString());
                            sb.append("\n");
                        } else {
                            d2.disableDisplay=true;
                        }
                    } else {
                       //couldn't find ending, so it should have duration.
                       actualCount++;
                       sb.append(d.toString());
                       sb.append("\n");
                    }
                } else if (!d.disableDisplay) { //off and has duration.
                    actualCount++;
                    sb.append(d.toString());
                    sb.append("\n");
                }
            }
            StringBuilder display=new StringBuilder();
            display.append(actualCount);
            display.append("\n");
            display.append(sb);
            System.out.print(display.toString());
        }
        System.out.println("-1");
    }
}