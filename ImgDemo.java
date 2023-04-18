package com.dlsp.demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class ImgDemo {
	/**
	 * 图片拷贝 Copy --字节  InputStream OutputStream
	 * 先读再写 
	 * 源文件
	 * 目标文件
	 * 
	 * 读一个字节 写入一个字节
	 * 
	 */
	public static void copyImg() {
		InputStream fis = null;
		OutputStream fos = null;
		
		try {
			File oldFile = new File("D:/file_io/0831.jpg");
			fis = new FileInputStream(oldFile);
			//提取出文件名 ，截取出后缀，用UUID生成新名 
			String fileName = oldFile.getName();
			System.out.println("原始文件名：" + fileName);
			String sufix = fileName.substring(fileName.lastIndexOf("."));
			System.out.println("后缀：" + sufix);
			String newName = UUID.randomUUID()+sufix;
			System.out.println("新名字：" + newName);
			
			String path = "D:"+File.separator+"file_io"+File.separator+newName;
			System.out.println("path===============" + path);
			File newFile = new File(path);
			fos = new FileOutputStream(newFile);
			long start = System.currentTimeMillis();
			int len = fis.read();
			while(len != -1) {
				fos.write(len);
				len = fis.read();
			}
			long end = System.currentTimeMillis();
			System.out.println("时间：" + (end - start));
			System.out.println("拷贝成功");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos != null)
					fos.close();
				if(fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		copyImg();

	}

}
