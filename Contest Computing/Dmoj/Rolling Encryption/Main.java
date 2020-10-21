import java.io.*;
import java.util.*;

public class Main {
	  public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String code = in.next();
        int[] freq = new int[27];
        ArrayList <Character> al = new ArrayList();
        for(int i=0;i<num;i++)
        {
            freq[((int)code.charAt(i))-96]++;
            al.add(code.charAt(i));
        }

        int letter = 1;

        for(int f=num-1;f<code.length()-1;f++)
        {
            if(f >= num)
            {
                freq[(int)code.charAt(f-num)-96]--;
                freq[(int)code.charAt(f)-96]++;
            }
            letter = 1;
            for(int i=2;i<27;i++)
            {
                if(freq[i] > freq[letter])
                {
                    letter = i;
                }
            }

            int t = (int)code.charAt(f+1) + letter;
            if(t > 122)
            {
                t -= 26;
            }
            al.add((char)(t));
        }
        for (Character i : al)
        {
            System.out.print(i);   
        }
    }
}
