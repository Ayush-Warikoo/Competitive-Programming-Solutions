import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int finNum = in.nextInt();
		int point = 0; int i = 2; int x = 0;
		while(finNum != 1)
		{
			if (finNum%i == 0)
			{
				x = finNum/i;
				finNum -= x;
				point += finNum/x;
				i = 2;
			}
			else if(i == finNum - 1)
			{
				point += i;
				finNum -= 1;
				i = 2;
			}
			else
			{
				i++;
			}
		}
		System.out.println(point);
		in.close();
	}
}