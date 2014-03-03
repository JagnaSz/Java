import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
	
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        ExecutorService exec =  Executors.newFixedThreadPool(2);
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }
 
        Socket clientSocket = null;
        while(true){
        	clientSocket = null;
        	try {
        		clientSocket = serverSocket.accept();
        		if(clientSocket != null)
        			exec.execute(new MyRunnable(serverSocket,clientSocket));
        	} catch (IOException e) {
        		System.out.println("Accept failed: 6666");
        		System.exit(-1);
        	}	
        }
        
   
    }
}