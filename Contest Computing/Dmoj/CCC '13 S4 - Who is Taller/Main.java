import java.io.*;
import java.util.*;

//Who is Taller?
public class Main {
	public static void main(String[] args) throws java.lang.Exception{ 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		String[] line = in.readLine().split(" ");
		int people = Integer.parseInt(line[0]);
		int num = Integer.parseInt(line[1]);
		ArrayList<Integer>[] height = (ArrayList<Integer>[])new ArrayList[people+1];
		
		for(int i=0; i<people+1;i++)
	    {
	        height[i] = new ArrayList<Integer>(); // initialize each element with ArrayList object
	    }
		
		for(int i=0;i<num;i++)
		{
			line = in.readLine().split(" ");
			height[Integer.parseInt(line[0])].add(Integer.parseInt(line[1]));
		}
		
		line = in.readLine().split(" ");
		int x = Integer.parseInt(line[0]);
		int y = Integer.parseInt(line[1]);
		
		boolean[] vis = new boolean[people+1];
		Queue<Integer> q = new LinkedList();
		q.add(x); vis[x] = true;
		int node = 0;
		
		while(!q.isEmpty())
		{
			node = q.poll();
			if(node == y)
			{
				System.out.println("yes");
				return;
			}
			
			for(int i=0;i<height[node].size();i++)
			{
				if(!vis[height[node].get(i)])
				{
					q.add(height[node].get(i)); vis[height[node].get(i)] = true;
				}
			}

		}
		
		Arrays.fill(vis,false); node = 0;
		q.add(y); vis[y] = true;
		
		while(!q.isEmpty())
		{
			node = q.poll();
			if(node == x)
			{
				System.out.println("no");
				return;
			}
			
			for(int i=0;i<height[node].size();i++)
			{
				if(!vis[height[node].get(i)])
				{
					q.add(height[node].get(i)); vis[height[node].get(i)] = true;
				}
			}

		}
		System.out.println("unknown");
	}
}
