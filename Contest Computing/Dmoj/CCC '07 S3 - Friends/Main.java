import java.io.*;
import java.util.*;

//Friends
public class Main {
	public static void main(String[] args) {
		Scanner in=new Scanner (System.in);
		int[] friend = new int[10000];
		int num = in.nextInt();
		
		for(int i=0;i<num;i++)
		{
			friend[in.nextInt()] = in.nextInt();
		}
		
		int x = in.nextInt();
		int y = in.nextInt();
		
		while(x != 0 || y != 0)
		{
			//Implemented BFS, but where distance is measured and if something has already been visited close it
			Queue<Integer> q = new LinkedList();
			boolean[] vis = new boolean[10000];
			int[] dist = new int[10000];
			vis[x] = true; dist[x] = -1; q.add(x);
			int node = 0;
			
			while(!q.isEmpty())
			{
				node = q.poll();
				if(node == y)
				{
					System.out.println("Yes " + dist[y]);
					break;
				}
				
				if(friend[node] == 0 || vis[friend[node]])
				{
					System.out.println("No");
					break;
				}
				else
				{
					q.add(friend[node]);
					dist[friend[node]] = dist[node] + 1;
					vis[friend[node]] = true;
				}
			}
			x = in.nextInt();
			y = in.nextInt();
		}	
	}
}
