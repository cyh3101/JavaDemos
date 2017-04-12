package com.cyh.demos.nio2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Files.copy(Paths.get("FilesTest.java"), 
				new FileOutputStream("FilesTest_bak.java"));

		//判断问件是否为隐藏文件
		System.out.println("FileTest.java是否为隐藏文件:" 
				+ Files.isHidden(Paths.get("FilesTest.java")));
		
		//一行行读取文件中数据
		List<String> lines = Files.readAllLines(Paths.get("FilesTest.java"), 
				Charset.forName("GBK"));
		System.out.println(lines);
		
		//判断文件的大小
		System.out.println("FilesTest.java文件大小为:" 
				+ Files.size( Paths.get("FilesTest.java")));
		
		List<String> ppp = new ArrayList<>();
		ppp.add("喔喔喔喔喔喔");
		ppp.add("尽快尽快将空间看看");
		Files.write(Paths.get("wowowo.txt"), ppp, Charset.forName("GBK"));
		
		Files.list(Paths.get(".")).forEach(path->System.out.println(path));
		
		Files.lines(Paths.get("FilesTest.java"), Charset.forName("GBK"))
			.forEach(line->System.out.println(line));
		
		FileStore fileStore = Files.getFileStore(Paths.get("c:"));
		System.out.println("c:共有空间:" + fileStore.getTotalSpace());
		System.out.println("c:可用空间:" + fileStore.getUsableSpace());
		System.out.println("c:未分配空间:" + fileStore.getUnallocatedSpace());
		
	}

}
