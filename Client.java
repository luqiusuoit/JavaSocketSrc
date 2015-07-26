/*

Client.java TCP 客户端程序


发送100100img.jpg的像素点

*/

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


import java.awt.image.*;    
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.util.Arrays;

public class Client
{
	public static void main(String [] args) throws IOException
	{
		int width;
		int height;
		int [] sample=new int[3];
		int i,j;
		BufferedImage bufferedImage;
		
		Socket serverSocket=new Socket("192.168.0.122",6001);
		
		//获得服务器输出流
		OutputStream output=serverSocket.getOutputStream();
		PrintWriter printWriter=new PrintWriter(output,true);
		

		
		File img=new File("100100img.jpg");
		bufferedImage=ImageIO.read(img);
		width=bufferedImage.getWidth();
		height=bufferedImage.getHeight();
		
		System.out.println("width="+width+" ,height="+height);

		WritableRaster raster=bufferedImage.getRaster();
		
		System.out.println("开始发送信息");
		
		/*
		for(i=0;i<height;++i)
		{
			for(j=0;j<width;++j)
			{
				Arrays.fill(sample,0);
				raster.getPixel(j,i,sample);
				printWriter.write(sample[0]);
				printWriter.write(sample[1]);
				printWriter.write(sample[2]);	
			}
		}
		*/
		
		
		int num=255;
		for(i=0;i<=num;++i)
		{
			
			printWriter.print(i);
			printWriter.flush();
		}
		
		
		
		System.out.println("信息发送完毕");

	}
}