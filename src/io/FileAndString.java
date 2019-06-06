package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class FileAndString {

	/**
	 * 文件转字符串
	 * @param path 文件路径
	 * @return 文件内容字符串
	 */
	public static String fileToString(String path) {
		File file = new File(path);
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String content = "";
			StringBuilder sb = new StringBuilder();
			while(content!=null) {
				content = in.readLine();
				if(content == null) {
					break;
				}
				sb.append(content.trim());
			}
			in.close();
			return sb.toString();
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定路径的文件");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("读取文件内容异常");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将字符串写入指定路径的文件
	 * @param path 文件路径
	 * @param content 内容
	 */
	public static void StringToFile(String path,String content) {
		File file = new File(path);
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"utf-8"));
			out.write(content+"\r\n");
			System.out.println("写入数据成功");
			out.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println("转换编码异常");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定路径的文件");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("写入文件内容异常");
			e.printStackTrace();
		}
	}
	
	/**
	 * fileToString方法测试
	 */
	@Test
	public void fileToStringTest() {
		String str = fileToString("E://lilanz/cjj/201805/index.txt");
		System.out.println(str);
	}
	
	/**
	 * StringToFile测试
	 */
	@Test
	public void StringToFileTest() {
		StringToFile("D://test.txt","这只是一个测试");
	}
}
