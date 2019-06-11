package com.example.springbatch.myfirstspringbatchexample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Test {

	static Map<String, Properties> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		
		File directory = new File("C:\\Users\\Qasim\\Documents\\pardir");
		
		File[] files = directory.listFiles();
		listFiles(files);
	}
	
	public static void listFiles(File[] entry) throws IOException{
		for(File file: entry){
			if(file.isDirectory()){
				listFiles(file.listFiles());
			}else{
				System.out.println(file.isFile());
				System.out.println(file.getAbsolutePath());
				System.out.println(file.getName());
				String fileName = file.getName();
				String filePath = file.getAbsolutePath();
				Properties prop = new Properties();
				prop.load(new FileInputStream(file.getAbsolutePath()));
				map.put(fileName, prop);
			}
			
		}
	}
}
