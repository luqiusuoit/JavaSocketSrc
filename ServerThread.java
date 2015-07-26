/*

ServerThread.java 

TCP

服务器端线程

*/

/*
 public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 
 src:源数组；
 srcPos:源数组要复制的起始位置； 
 dest:目的数组； 
 destPos:目的数组放置的起始位置；
 length:复制的长度。

例子:
	System.arraycopy(buffer, 0, nbuf, 0, pos);
 
	
*/
import java.io.*;
import java.net.*;

public class ServerThread extends Thread
{
	private Socket clientSocket;
	private InputStream clientInput;
	private OutputStream clientOutput;
	boolean goon=true;
	
	int retnum;//返回值
	
	
	public ServerThread(Socket socket) throws IOException,ArrayIndexOutOfBoundsException
	{
		clientSocket=socket;
		clientInput=clientSocket.getInputStream();
		this.start();//开始
	}
	
	public void run() 
	{
		byte [] pixels=new byte[256];//存储一帧图像的全部像素点
		
		//ImgMaker maker=new ImgMaker();
		
		int i=0;
		int j;
		try
		{
			System.out.println("run函数被调用");
			
			BufferedInputStream  bufInputStream=new BufferedInputStream(clientInput,921700);//使用默认缓冲区，8K
		
		
			int nIdx = 0; 
			int nTotalLen = pixels.length; 
			int nReadLen = 0; 
	
			
			System.out.println("开始读入");
                
			
			while (nIdx < nTotalLen) 
			{ 
				nReadLen = bufInputStream.read(pixels, nIdx, nTotalLen - nIdx); 
				System.out.println("nReadLen="+nReadLen);				
				if (nReadLen > 0) 
				{ 
					nIdx = nIdx + nReadLen; 
				} 
				else 
				{ 
					break; 
				} 
			}
			
			System.out.println("读入完毕");
			
			
			for(i=0;i<256;++i)
			{
				System.out.print("pixels["+i+"]="+pixels[i]+"\t");
				
			}
			
			
			/*
			for(i=0;i<1200;++i)
			{
				retnum=bufInputStream.read(pixels,i,1);
			}
			System.out.println("读入完毕");
			*/
			//PrintStream ps=new PrintStream(new FileOutputStream("ServerMsg.txt"));
			//System.setOut(ps);//重定向输出
			
			//maker.makeImg(pixels);//传出参数，生成图片
			//System.exit(0);//正常退出程序
			
			
			
			clientInput.close();
			clientSocket.close();
			
			
			/*
			for(i=0;i<pixels.length;++i)
			{
				System.out.println((int)pixels[i]);
				
			}
			
			System.exit(0);//正常退出程序
			*/
			
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
}