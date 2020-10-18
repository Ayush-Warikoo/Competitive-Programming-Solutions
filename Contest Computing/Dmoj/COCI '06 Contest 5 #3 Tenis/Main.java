import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		String n1 = in.next();
		String n2 = in.next();
		
		int cond = 0;
		
		//Assess which if any of the players are federer
		if(n1.equals("federer"))		
		{
			cond = 1;
		}
		else if(n2.equals("federer"))
		{
			cond = 2;
		}
		
		int num = in.nextInt(); 
		String x = in.nextLine();
		
		for(int i=0;i<num;i++)
		{
			int abc = 0;
			int p1win = 0;
			int p2win = 0;
			
			String Score = in.nextLine();
			String[] y = Score.split(" ");
			
			//Tests that there are only 2 or 3 scores
			if(y.length > 3 || y.length < 2)
			{
				System.out.println("ne");
				continue;
			}
			
			int[] score = new int[y.length*2];
			
			//Puts the scores into an array so that the scores are from left to right  
			for(int z=0;z<y.length;z++)
			{
				String[] a = y[z].split(":");
				score[2*z] = Integer.parseInt(a[0]);
				score[2*z+1] = Integer.parseInt(a[1]);
			}
			
			for(int a=0;a<3;a+=2)
			{
				if(abc == 1)
				{
					continue;
				}
				//Makes sure that the two first sets have a valid winning score
				if((score[a] == 6 && score[a+1] < 5) || (score[a] < 5 && score[a+1] == 6))
				{
					
				}
				else if((score[a] == 7 && (score[a+1] == 5 || score[a+1] == 6)) || (score[a+1] == 7 && (score[a] == 5 || score[a] == 6)))
				{
					
				}
				else
				{
					System.out.println("ne");
					abc = 1;
					continue;
				}
				
				//Determines which player won
				if(score[a] > score[a+1])
				{
					p1win++;
				}
				else if(score[a+1] > score[a])
				{
					p2win++;
				}
				else
				{
					System.out.println("XXX");
				}
			}
			
			if(abc == 1)
			{
				continue;
			}
			//Validates whether the match should have a third game or not
			if(p1win == 2 && p2win == 0 && y.length == 2)
			{
				
			}
			else if(p1win == 0 && p2win == 2 && y.length == 2)
			{
				
			}
			else if(p1win == 1 && p2win == 1 && y.length == 3)
			{
				
			}
			else
			{
				System.out.println("ne");
				continue;
			}
			
			
			//Checks to see if federer lost
			if(cond != 0 && y.length != 2)
			{
				System.out.println("ne");
				continue;
			}
			else if(cond != 0)
			{
				if((cond == 1 && p1win == 2 && p2win == 0) || (cond == 2 && p2win == 2 && p1win == 0))
				{
					
				}
				else
				{
					System.out.println("ne");
					continue;
				}
			}
			
			//Verifies the score of the 3rd game if there is one
			if(y.length == 3)
			{
				if(score[4] > 5 && score[4] >= (score[5] + 2))
				{
					
				}
				else if(score[5] > 5 && score[5] >= (score[4] + 2))
				{
					
				}
				else
				{
					System.out.println("ne");
					continue;
				}
			}
			
			//Final answer if all tests are passed
			System.out.println("da");
		}
	}
}
