import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in=new Scanner (System.in);
		//Creating the initial graph
		boolean[][] friends = new boolean[51][51];
		friends[1][6] = true; 
		friends[2][6] = true; 
		friends[3][6] = true; friends[3][4] = true; friends[3][5] = true; friends[3][15] = true;
		friends[4][6] = true; friends[4][3] = true; friends[4][5] = true;
		friends[5][6] = true; friends[5][3] = true; friends[5][4] = true;
		friends[6][1] = true; friends[6][3] = true; friends[6][4] = true; friends[6][2] = true; friends[6][5] = true; friends[6][7] = true;
		friends[7][6] = true; friends[7][8] = true; 
		friends[8][7] = true; friends[8][9] = true; 
		friends[9][10] = true; friends[9][12] = true; friends[9][8] = true; 
		friends[10][11] = true; friends[10][9] = true; 
		friends[11][10] = true; friends[11][12] = true;
		friends[12][13] = true; friends[12][9] = true; friends[12][11] = true; 
		friends[13][12] = true; friends[13][14] = true; friends[13][15] = true; 
		friends[14][13] = true; 
		friends[15][13] = true; friends[15][3] = true;
		friends[16][17] = true; friends[16][18] = true;
		friends[17][16] = true; friends[17][18] = true;
		friends[18][17] = true; friends[18][16] = true;
		
		char com = ' ';
		int x = 0;
		int y = 0;
		int count = 0;
		Queue<Integer> q = new LinkedList();
		
		while(in.hasNext())
		{	
			com = in.next().charAt(0);
			if(com == 'i')
			{
				x = in.nextInt();
				y = in.nextInt();
				friends[x][y] = true;
				friends[y][x] = true;
			}
			else if(com == 'd')
			{
				x = in.nextInt();
				y = in.nextInt();
				friends[x][y] = false;
				friends[y][x] = false;
			}
			else if(com == 'n')
			{
				count = 0;
				x = in.nextInt();
				for(int i=1;i<51;i++)
				{
					if(friends[x][i])
					{
						count++;
					}
				}
				System.out.println(count);
				
			}
			else if(com == 'f')
			{
				x = in.nextInt();
				q.clear();
				int[] dist = new int[51];
				boolean[] vis = new boolean[51];
				q.add(x); dist[x] = 0; vis[x] = true;
				count = 0;
				
				while(!q.isEmpty())
				{
					int node = q.poll();
					
					for(int i=1;i<51;i++)
					{
						if(friends[node][i] && !vis[i])
						{
							
							dist[i] = dist[node]+1; vis[i] = true; 
							if(dist[i] < 2)
							{
								q.add(i);
							}
							else if(dist[i] == 2)
							{
								count++;
							}
							else
							{
								System.out.println("ERROR");
							}
						}
					}
				}
				System.out.println(count);
			
			}
			else if(com == 's')
			{
				x = in.nextInt();
				y = in.nextInt();
				q.clear();
				int[] dist = new int[51];
				boolean[] vis = new boolean[51];
				q.add(x); dist[x] = 0; vis[x] = true;
				boolean done = false;
				
				while(!q.isEmpty())
				{
					int node = q.poll();
					if(node == y)
					{
						System.out.println(dist[y]);
						done = true;
						break;
					}
					
					for(int i=1;i<51;i++)
					{
						if(friends[node][i] && !vis[i])
						{
							q.add(i); vis[i] = true; dist[i] = dist[node]+1;
						}
					}
				}
				if(!done)
				{
					System.out.println("Not connected");
				}
				
			}
			else if(com == 'q')
			{
				return;
			}
			else
			{
				System.out.println("ERROR");
			}	
		}
	}
}