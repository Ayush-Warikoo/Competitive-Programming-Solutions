import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		int gateNum = in.nextInt();
		int flightNum = in.nextInt();
		
		int[] flight = new int[flightNum];
		for(int i=0;i<flightNum;i++)
		{
			flight[i] = in.nextInt();
		}
		
		TreeSet<Integer> ts=new TreeSet();
		for(int i=0;i<gateNum;i++)
		{
			ts.add(i+1);
		}
		
		
		for(int i=0;i<flightNum;i++)
		{
			if(ts.floor(flight[i]) == null)
			{
				break;
			}
			else
			{
				ts.remove(ts.floor(flight[i]));
			}
		}
		System.out.println(gateNum - ts.size());
	}
}