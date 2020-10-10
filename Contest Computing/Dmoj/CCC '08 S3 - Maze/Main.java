import java.io.*;
import java.util.*;

//Maze
public class Main {
	public static void main(String[] args) {
		Scanner in=new Scanner (System.in);
		int num = in.nextInt();
		for(int q=0;q<num;q++)
		{
			int row = in.nextInt();
			int col = in.nextInt();
			in.nextLine();
			char[][] map = new char[row][col];
			int[][] path = new int[row][col];
			
			String line = "";
			for(int r=0;r<row;r++)
			{
				line = in.nextLine();
				for(int c=0;c<col;c++)
				{
					map[r][c] = line.charAt(c);
				}
			}
			
			int counter = 1;
			int check = 0;
			path[0][0] = 1;
			boolean done = false;
			
			//Loop until the south-east most tile has been reached
			while(path[row-1][col-1] == 0)
			{
				check = 0;
				//Looping through the entire pathway
				for(int r=0;r<row;r++)
				{
					for(int c=0;c<col;c++)
					{
						//Check if a tile equals the current count/turn
						if(path[r][c] == counter)
						{
							check++;
							//Checks which directions you can go from the current tile 
							//Must be possible from the sender and receiver, not on the border and not visited yet
							if(map[r][c] == '+')
							{
								//North
								if(r != 0 && map[r-1][c] != '*' && path[r-1][c] == 0)
								{
									path[r-1][c] = counter+1;
								}
								//South
								if(r != row-1 && map[r+1][c] != '*' && path[r+1][c] == 0)
								{
									path[r+1][c] = counter+1;
								}
								//East
								if(c != 0 && map[r][c-1] != '*' && path[r][c-1] == 0)
								{
									path[r][c-1] = counter+1;
								}
								//West
								if(c != col-1 && map[r][c+1] != '*' && path[r][c+1] == 0)
								{
									path[r][c+1] = counter+1;
								}
								
							}
							else if(map[r][c] == '-')
							{
								//East
								if(c != 0 && map[r][c-1] != '*' && path[r][c-1] == 0)
								{
									path[r][c-1] = counter+1;
								}
								//West
								if(c != col-1 && map[r][c+1] != '*' && path[r][c+1] == 0)
								{
									path[r][c+1] = counter+1;
								}
								
							}
							else if(map[r][c] == '|')
							{
								//North
								if(r != 0 && map[r-1][c] != '*' && path[r-1][c] == 0)
								{
									path[r-1][c] = counter+1;
								}
								//South
								if(r != row-1 && map[r+1][c] != '*' && path[r+1][c] == 0)
								{
									path[r+1][c] = counter+1;
								}
							}
							else
							{
								System.out.println("ERROR");
							}
						}
					}
				}
				//Will equal 0 when the path is completely blocked
				if(check == 0)
				{
					System.out.println(-1);
					done = true;
					break;
				}
				counter++;
			}
			if(!done)
			{
				System.out.println(path[row-1][col-1]);
			}
		}
	}
}
