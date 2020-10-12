import java.io.*;
import java.util.*;

//09 S2 Lights Going Off and On
public class Main {
	  public static void main(String args[] ) throws Exception {
	      Scanner in = new Scanner(System.in);
	      int row = in.nextInt();
	      int col = in.nextInt();
	      int[][] light = new int[row][col];
	      int[][] copy = new int[row][col];
	      
	      for(int r=0;r<row;r++)
	      {
	    	  for(int c=0;c<col;c++)
	    	  {
	    		  light[r][c] = in.nextInt();
	    		  copy[r][c] = light[r][c];
	    	  }
	      }
	      String comb = "";
	      HashSet<String> hs=new HashSet();
	      for(int c=0;c<col;c++)
	      {
	    	  comb += String.valueOf(light[row-1][c]);
	      }
	      hs.add(comb);
	      
	      for(int i=row-1;i>0;i--)
	      {
	    	  comb = "";
	    	  for(int b=i;b<row;b++)
	    	  {
	    		  
	    		  for(int c=0;c<col;c++)
	    		  {
	    			  if(b == row - 1)
	    			  {
	    				  comb += String.valueOf(light[b][c]^light[b-1][c]);
	    			  }
	    			  else
	    			  {
	    				  light[b][c] = light[b][c]^light[b-1][c];
	    			  }
	    		  }
	    	  }
	    	  hs.add(comb);
	    	  for(int r=0; r<row; r++)
		      {
		    	  for(int c=0; c<col; c++)
		    	  {
		    		  light[r][c]= copy[r][c];
		    	  }	    
		      }
	      }
	      System.out.println(hs.size());
	  }
}