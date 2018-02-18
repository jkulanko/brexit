package brexit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;


public class main {
static HashMap<Integer,Integer> count = new HashMap<>();
    static  HashMap<Integer,Integer> leave = new HashMap<>();
    static boolean flag = false; 
    static HashMap<Integer, HashSet<Integer>> edges = new HashMap<Integer, HashSet<Integer>>();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FastReader in = new FastReader();
        int numCountries = in.nextInt();
        int partnerships = in.nextInt();
        int home = in.nextInt();
        int left = in.nextInt();
        
        
        
        
        for(int i = 0;i<partnerships;i++){
        	 int x = in.nextInt();
        	    int y = in.nextInt();

        	    if (!edges.containsKey(x))
        	        edges.put(x , new HashSet<>());
        	    
        	    edges.get(x).add(y);
        	    
        	    if (!edges.containsKey(y))
        	        edges.put(y , new HashSet<>());
        	    
        	    edges.get(y).add(x);
        	    

           
        }
        for (int x : edges.keySet())
            count.put(x , edges.get(x).size());
        if(left==home)
            System.out.print("leave");
        else{
            removeEdges(left,home);
        
        if(!flag)
        System.out.print("stay");
        else
        System.out.print("leave");
        }
        
       
    
    }
    public static boolean half(int c) {
    	  return edges.get(c).size() <= count.get(c) / 2.0;
    	}
public static void removeEdges(int left,int home){
    if(left==home)
        flag=true;
    if(!flag&&edges.get(left)!=null){
    for(int x : edges.get(left)){
            
        edges.get(x).remove(left);
        }
        
    for(int x : edges.get(left))
    	if(half(x))
    		removeEdges(x,home);
    edges.get(left).clear();
    }
}

static class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
                 InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException  e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

}
}