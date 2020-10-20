import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int totalNum = in.nextInt();
		int swapNum = in.nextInt();
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		ArrayList<Integer> AL=new ArrayList<Integer>();
		
		for(int i=0;i<totalNum;i++)
		{
			int transfer = in.nextInt();
			al.add(transfer);	
		}
		
		for(int i=0;i<swapNum;i++)
		{
			
			int index = al.indexOf(totalNum);
			
			if(al.size() < 1)
			{
				break;
			}
			else if(index == 0)
				
			{
				AL.add(totalNum);
				al.remove(index);
				i -= 1;
				totalNum -= 1;
			}
			
			else
			{
				AL.add(totalNum);
				al.remove(index);
				al.add(index, al.get(0));
				al.remove(0);
				totalNum -= 1;
			}
		}
		
		for(int i=0;i<al.size();i++)
		{
			AL.add(al.get(i));
		}
		
		for(int i=0;i<AL.size();i++)
		{
			System.out.print(AL.get(i) + " ");
		}
	}
}