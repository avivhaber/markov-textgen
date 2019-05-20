import java.util.*;
import java.io.*;

public class Markov {
    HashMap<String,List<Character>> chain;
    List<String>starts;
    int n;
    int m;
    int order;

    public Markov (int order,int n, int m){
        chain = new HashMap<>();
        starts=new ArrayList<>();
        this.order=order;
        this.n=n;
        this.m=m;
    }

    public static void main (String [] args)
    {
        BufferedReader  br;
        Markov c;

        int order=0,a=0,b=0;
        if (args.length<4){
            System.out.println("Missing parameters.");
            return;
        }
        try{
            order=Integer.parseInt(args[1]);
            a=Integer.parseInt(args[2]);
            b=Integer.parseInt(args[3]);
        }
        catch (Exception e){
            System.out.println("Incorrect paramater format.");
            return;
        }
        c=new Markov(order,a,b);
        try{
            br = new BufferedReader(new FileReader(args[0]));
            String ln=br.readLine();
            while (ln != null){
                c.processLine(ln);
                ln=br.readLine();
            }
            //System.out.println(c.chain);
            //System.out.println(c.starts);
            c.generate();
            br.close();
        }
        catch(Exception e){
            e.printStackTrace();
            return;
        }
    }

    void processLine(String s){
        for (int x=0;x<s.length()-order+1;x++){
            String gram= s.substring(x, x+order);
            if (x==0) starts.add(gram);
            chain.putIfAbsent(gram, new ArrayList<Character>());
            if (x+order<s.length()) {
                chain.get(gram).add(s.charAt(x+order));
            }
        }
    }

    void generate(){
        for (int i=0;i<n;i++){
            String gram=getRand(starts);
            System.out.print(gram);
            for (int j=0;j<m;j++){
                if (chain.get(gram).size()==0) break;
                char c=getRand(chain.get(gram));
                System.out.print(c);
                gram=gram.substring(1)+c;
            }
            System.out.println();
        }
    }

    static <E> E getRand (List<E> li){
        int index=(int)(Math.random()*li.size());
        return li.get(index);
    }
}