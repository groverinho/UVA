package uva_10945;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class UVA_10945 {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = "";


            while(!(s=br.readLine()).equals("DONE"))
            {
                StringBuilder a = new StringBuilder();
                StringBuilder b = new StringBuilder();
                s=s.toLowerCase();

                for(int i=0;i<s.length();i++)
                {
                    if(Character.isLetter(s.charAt(i)))
                    {
                        a.append(s.charAt(i));
                    }
                }

                for(int i=a.length()-1;i>=0;i--)
                {
                    b.append(a.charAt(i));
                }


                if(a.toString().equalsIgnoreCase(b.toString())){
                   System.out.println("You won't be eaten!");
                }
                else{
                    System.out.println("Uh oh..");
                }                
            }
        }

    }
