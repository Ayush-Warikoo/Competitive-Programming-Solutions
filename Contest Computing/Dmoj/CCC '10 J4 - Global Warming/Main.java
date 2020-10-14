import java.io.*;
import java.util.*;

//Global Warming 
public class Main {
	  public static void main(String args[] ) throws Exception {
	      Scanner in = new Scanner(System.in);
	      while(in.hasNext())
	      {
	    	  int num = in.nextInt();
	    	  if(num == 0)
	    	  {
	    		  break;
	    	  }
	    	  else if(num == 1)
	    	  {
	    		  in.nextInt();
	    		  System.out.println("0");
	    	  }
	    	  else if(num == 2)
	    	  {
	    		  in.nextInt();
	    		  in.nextInt();
	    		  System.out.println("1");
	    	  }
	    	  else
	    	  {
	    		  int[] diff = new int[num-1];
	    		  int last = in.nextInt();
	    		  int current = in.nextInt();
	    		  diff[0] = current - last;
	    		  for(int i=1;i<diff.length;i++)
	    		  {
	    			  last = current;
	    			  current = in.nextInt(); 
	    			  diff[i] = current - last;
	    		  }
	    		  outerloop:
	    		  for(int i=1;i<diff.length;i++)
	    		  {
	    			  for(int l=0;l<diff.length-i;l++)
	    			  {
	    				  if(diff[l] != diff[l+i])
	    				  {
	    					  break;
	    				  }
	    				  else if(l == diff.length-i-1)
	    				  {
	    					  System.out.println(i);
	    					  break outerloop;
	    				  }
	    			  }
	    			  if(i == diff.length-1)
	    			  {
	    				  System.out.println(diff.length);
	    			  }
	    		  }  
	    	  }
	      }
	 }
}