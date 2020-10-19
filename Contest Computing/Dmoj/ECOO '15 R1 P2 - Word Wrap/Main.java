import java.io.*;
import java.util.*;

public class Main {
	  public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        for(int t=0;t<10;t++)
        {
            int num = in.nextInt();
            in.nextLine();
            String[] word = in.nextLine().split(" ");
            String line = "";
            for(int i=0;i<word.length;i++)
            {
                if(word[i].length() > num)
                {
                    while(word[i].length() > num)
                    {
                        if(line != "")
                        {
                            System.out.println(line);
                            line = "";
                        }
                        System.out.println(word[i].substring(0,num));
                        word[i] = word[i].substring(num);
                    }
                    line += word[i];
                }
                else
                {
                    if(line == "")
                    {
                        line += word[i];
                    }
                    else
                    {
                        if(line.length() + 1 + word[i].length() <= num)
                        {
                            line += " " + word[i];
                        }
                        else
                        {
                            System.out.println(line);
                            line = word[i];
                        }
                    }
                }
            }
            if(line != "")
            {
                System.out.println(line);
            }
            System.out.println("=====");
        }
	}
}