import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] num = new int[10][9];
		
		for(int r=0;r<10;r++)
		{
			for(int c = 0;c<9;c++)
			{
				num[r][c] = -1;
			}
		}
		
		String[][] cur = new String[10][9];
		
		
		for(int r=0;r<10;r++)
		{
			
			for(int c=0;c<9;c++)
			{
				String input = in.next();
				//If it is a number
				if(input.toLowerCase().contains(input))
				{
					num[r][c] = Integer.parseInt(input); 
					cur[r][c] = " ";
				}
				//If it isn't a number
				else
				{
					cur[r][c] = input;
				}
			}
		}

		boolean done = false;
		boolean change = true;
		while(!done && change)
		{
			done = true;
			change = false;
			//Iterates through the spreadsheet
			for(int r=0;r<10;r++)
			{
				for(int c = 0;c<9;c++)
				{
					//If it is not finished
					if(!cur[r][c].contains(" "))
					{
						int sum = 0;
						String[] list = cur[r][c].split("\\+");

						//For each summing square
						for(int i=0;i<list.length;i++)
						{
							if(num[(int)list[i].charAt(0)-65][(int)list[i].charAt(1)-49] < 0)
							{
								break;
							}
							else if(i == list.length-1)
							{
								
								sum += num[(int)list[i].charAt(0)-65][(int)list[i].charAt(1)-49];
								num[r][c] = sum;
								cur[r][c] = " ";
								change = true;
							}
							else
							{
								sum += num[(int)list[i].charAt(0)-65][(int)list[i].charAt(1)-49];
							}
						}
					}
				}
			}
			
			//Checks that all of the boxes have been filled 
			for(int r=0;r<10;r++)
			{
				for(int c = 0;c<9;c++)
				{
					if(!cur[r][c].contains(" "))
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
		}
		
		for(int r=0;r<10;r++)
		{
			for(int c=0;c<9;c++)
			{
				if(num[r][c] < 0)
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print(num[r][c] + " ");
				}
			}
			System.out.println();
		}
	}	
}