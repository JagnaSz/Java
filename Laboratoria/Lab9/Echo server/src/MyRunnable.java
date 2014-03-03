import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class MyRunnable implements Runnable {
	ServerSocket serverSocket;
	Socket clientSocket;
	
	public MyRunnable(ServerSocket serverSocket, Socket clientSocket) {
		this.clientSocket = clientSocket;
		this.serverSocket = serverSocket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Connected!");
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                clientSocket.getInputStream()));
        String inputLine;
 
        while ((inputLine = in.readLine()) != null) {
             out.println(inputLine);
        }
        out.close();
        in.close();
        clientSocket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
