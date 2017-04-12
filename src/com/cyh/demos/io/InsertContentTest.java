package com.cyh.demos.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContentTest {

	public static void insert(String fileName,
		String insertContent,long position) throws IOException {
		File temp = File.createTempFile("temp", null);
		temp.deleteOnExit();
		
		RandomAccessFile raf = new RandomAccessFile("output.txt", "rw");
		
		FileOutputStream fos = new FileOutputStream(temp);
		FileInputStream fis = new FileInputStream(temp);
		
		byte[] bys = new byte[32];
		int hasRead = 0;
		raf.seek(position);
		//读取特定文件位置之后的数据到临时文件中
		while((hasRead = raf.read(bys)) > 0){
			fos.write(bys, 0, hasRead);
		}
		//重新定位要插入的位置
		raf.seek(position);
		//插入要插入到文本内容
		raf.write(insertContent.getBytes());
		while((hasRead = fis.read(bys)) > 0){
			raf.write(bys, 0, hasRead);
		}
 	}
	
	public static void main(String[] args) throws IOException{
		insert("output.txt","要插入的内容",60);
	}

}
