import java.io.*;
import java.util.*;

//Floor plan
public class Main {
	public static void main(String[] args) {
		Scanner in=new Scanner (System.in);
		int num = in.nextInt();
		int row = in.nextInt();
		int col = in.nextInt();
		
		//Setting up the initial diagram
		ArrayList<Integer> room = new ArrayList();
		int[][] plan = new int[row][col];
		
		for(int r=0;r<row;r++)
		{
			String line = in.next();
			for(int c=0;c<col;c++)
			{
				if(line.charAt(c) == 'I')
				{
					plan[r][c] = -1;
				}
				else
				{
					plan[r][c] = 0;
				}
			}
		}

		while(true)
		{
			Queue<Integer> x=new LinkedList();
			Queue<Integer> y=new LinkedList();
			
			boolean done = false;
			for(int r=0;r<row;r++)
			{
				for(int c=0;c<col;c++)
				{
					if(plan[r][c] == 0)
					{
						x.add(r);
						y.add(c);
						done = true;
						break;
					}
				}
				if(done)
				{
					break;
				}
			}
			
			int count = 1;
			plan[x.peek()][y.peek()] = count;
			
			while(!x.isEmpty())
			{
				
				int r = x.poll();
				int c = y.poll();
				
				//Right
				if(c < col-1 && plan[r][c+1] == 0)
				{
					x.add(r);
					y.add(c+1);
					count++;
					plan[r][c+1] = count;
					
				}
				//Left
				if(c > 0 && plan[r][c-1] == 0)
				{
					
					x.add(r);
					y.add(c-1);
					count++;
					plan[r][c-1] = count;
				}
				//Down
				if(r < row-1 && plan[r+1][c] == 0)
				{
					x.add(r+1);
					y.add(c);
					count++;
					plan[r+1][c] = count;
				}
				//Up
				if(r > 0 && plan[r-1][c] == 0)
				{
					x.add(r-1);
					y.add(c);
					count++;
					plan[r-1][c] = count;
				}
			}
			room.add(count);
			
			
			//Checks that every square has been 
			for(int r=0;r<row;r++)
			{
				for(int c=0;c<col;c++)
				{
					if(plan[r][c] == 0)
					{
						done = false;
						break;
					}
				}
				if(!done)
				{
					break;
				}
				
			}
			if(done)
			{
				break;
			}		
		}
		
		//Answer specifications and output
		Collections.sort(room);
		Collections.reverse(room);
		int total = 0;
		int roomNum = room.size();
		for(int i=0;i<room.size();i++)
		{
			if(total + room.get(i) <= num)
			{
				total += room.get(i);
			}
			else
			{
				roomNum = i;
				break;
			}
		}
		
		if(roomNum == 1)
		{
			System.out.println("1 room, " + (num-total) + " square metre(s) left over");
		}
		else
		{
			System.out.println(roomNum + " rooms, " + (num-total) + " square metre(s) left over");
		}
	}
}