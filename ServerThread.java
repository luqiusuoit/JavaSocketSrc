/*

ServerThread.java 

TCP

���������߳�

*/

/*
 public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 
 src:Դ���飻
 srcPos:Դ����Ҫ���Ƶ���ʼλ�ã� 
 dest:Ŀ�����飻 
 destPos:Ŀ��������õ���ʼλ�ã�
 length:���Ƶĳ��ȡ�

����:
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
	
	int retnum;//����ֵ
	
	
	public ServerThread(Socket socket) throws IOException,ArrayIndexOutOfBoundsException
	{
		clientSocket=socket;
		clientInput=clientSocket.getInputStream();
		this.start();//��ʼ
	}
	
	public void run() 
	{
		byte [] pixels=new byte[256];//�洢һ֡ͼ���ȫ�����ص�
		
		//ImgMaker maker=new ImgMaker();
		
		int i=0;
		int j;
		try
		{
			System.out.println("run����������");
			
			BufferedInputStream  bufInputStream=new BufferedInputStream(clientInput,921700);//ʹ��Ĭ�ϻ�������8K
		
		
			int nIdx = 0; 
			int nTotalLen = pixels.length; 
			int nReadLen = 0; 
	
			
			System.out.println("��ʼ����");
                
			
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
			
			System.out.println("�������");
			
			
			for(i=0;i<256;++i)
			{
				System.out.print("pixels["+i+"]="+pixels[i]+"\t");
				
			}
			
			
			/*
			for(i=0;i<1200;++i)
			{
				retnum=bufInputStream.read(pixels,i,1);
			}
			System.out.println("�������");
			*/
			//PrintStream ps=new PrintStream(new FileOutputStream("ServerMsg.txt"));
			//System.setOut(ps);//�ض������
			
			//maker.makeImg(pixels);//��������������ͼƬ
			//System.exit(0);//�����˳�����
			
			
			
			clientInput.close();
			clientSocket.close();
			
			
			/*
			for(i=0;i<pixels.length;++i)
			{
				System.out.println((int)pixels[i]);
				
			}
			
			System.exit(0);//�����˳�����
			*/
			
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
}