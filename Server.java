/*

	Server.java
	
	TCP 
	
	·þÎñÆ÷¶Ë³ÌÐò
*/

import java.io.IOException;
import java.net.*;

public class Server
{
	public static void main(String [] arsg) throws IOException
	{
		System.out.println("Server is waiting .");
		
		ServerSocket serverSocket=new ServerSocket(6001);
		Socket clientSocket=null;
		
		while(true)
		{
			clientSocket=serverSocket.accept();
			new ServerThread(clientSocket);
		}
	}
}