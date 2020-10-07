import java.io.*;
import java.util.*;

//Pyramid message scheme
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int z=0;z<t;z++)
		{
			int num = in.nextInt();
			String[] temp = new String[num];
			ArrayList<String> al = new ArrayList();
			String home = "";
			in.nextLine();
			
			
			for(int i=0;i<num;i++)
			{
				temp[i] = in.nextLine();
				if(!al.contains(temp[i]))
				{
					al.add(temp[i]);
				}
				if(i == num - 1)
				{
					home = temp[i];
				}
			}
			
			boolean[][] graph = new boolean[al.size()][al.size()];
			for(int i=0;i<num;i+=2)
			{
				graph[al.indexOf(temp[i])][al.indexOf(temp[i+1])] = true; 
				graph[al.indexOf(temp[i+1])][al.indexOf(temp[i])] = true; 
			}
			
			Queue<Integer> q = new LinkedList();
			boolean vis[] = new boolean[al.size()];
			int dist[] = new int[al.size()];
			q.add(al.indexOf(home)); vis[al.indexOf(home)] = true; dist[al.indexOf(home)] = 0;
			
			while(!q.isEmpty())
			{
				int node = q.poll();
				
				for(int i=0;i<al.size();i++)
				{
					if(graph[node][i] && !vis[i])
					{
						q.add(i); vis[i] = true; dist[i] = dist[node]+1;
					}
				}
			}
			Arrays.sort(dist);
			System.out.println(num*10-20*dist[dist.length-1]);
			
		}
	}
}