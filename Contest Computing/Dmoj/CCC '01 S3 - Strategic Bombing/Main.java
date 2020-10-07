import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean[][] path = new boolean[26][26];
        String x = in.next();
        //65
        ArrayList<String> roads = new ArrayList();
        ArrayList<String> ans = new ArrayList();
        
        //Initialize the graph
        while(!x.equals("**"))
        {
            roads.add(x);
            path[(int)x.charAt(0)-65][(int)x.charAt(1)-65] = true;
            path[(int)x.charAt(1)-65][(int)x.charAt(0)-65] = true;
            x = in.next();
        }
        
        //Looping through taking out each road
        for(int i=0;i<roads.size();i++)
        {
            //Taking out a road
            path[(int)roads.get(i).charAt(0)-65][(int)roads.get(i).charAt(1)-65] = false;
            path[(int)roads.get(i).charAt(1)-65][(int)roads.get(i).charAt(0)-65] = false;
            
            Stack<Integer> s = new Stack();
            s.add(0); boolean[] vis = new boolean[26];
            
            while(!s.isEmpty())
            {
                int node = s.pop();
                if(node == 1)
                {
                    break;
                }
                for(int a=0;a<26;a++)
                {
                    if(path[node][a] && !vis[a])
                    {
                        s.add(a); vis[a] = true;
                    }
                }
            }
            if(!vis[1])
            {
                ans.add(roads.get(i));
            }
            //Putting the road back in at the end
            path[(int)roads.get(i).charAt(0)-65][(int)roads.get(i).charAt(1)-65] = true;
            path[(int)roads.get(i).charAt(1)-65][(int)roads.get(i).charAt(0)-65] = true;
        }
        if(ans.size() !=0)
        {
            for(int i=0;i<ans.size();i++)
            {
                System.out.println(ans.get(i));
            }
            System.out.println("There are " + ans.size() + " disconnecting roads.");
        }
        else
        {
            System.out.println("There are 0 disconnecting roads.");
        }
    }
}