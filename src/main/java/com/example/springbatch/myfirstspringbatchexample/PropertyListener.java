package com.example.springbatch.myfirstspringbatchexample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;

import com.example.springbatch.myfirstspringbatchexample.model.Report;

public class PropertyListener implements JobExecutionListener{
//use as context
	private Map<String, Properties> map;
	@Override
	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		System.out.println("After Running Job");
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		
		//Move commented code from writer to listner , will set header in listener and pass it to writer
		/*System.out.println("Init method called ...........");
		//read header from properties file
		Properties prop = new MyProperties();
		try {
			prop.load(new FileInputStream(new File("C:\\Users\\Qasim\\Documents\\projects\\spring-batch-jobs-test\\src\\main\\resources\\custome_header.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(propertyFilePath));
			String line = null;
				while((line = bf.readLine()) != null){
					String[] keyValue = line.split("=");
					prop.put(keyValue[0], keyValue[1]);
				}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//set property object in cache , key would be file name
		Map<String, Properties> propertiesMap = new HashedMap();
		propertiesMap.put("custome_header", prop);
		
		
		StringBuilder headerBuilder = new StringBuilder();
		List<String> columnNames = new LinkedList<>();
		Enumeration<String> enums = (Enumeration<String>) prop.propertyNames();
		while(enums.hasMoreElements()){
			String key = enums.nextElement();
			headerBuilder.append(key+",");
			columnNames.add(prop.getProperty(key));
		}
		headerBuilder.deleteCharAt(headerBuilder.lastIndexOf(","));
		
		headerCallback.setHeader(headerBuilder.toString());
		super.setHeaderCallback(headerCallback);
		
		DelimitedLineAggregator<Report> aggregator = new DelimitedLineAggregator<Report>();
		aggregator.setDelimiter(",");		
		BeanWrapperFieldExtractor<Report> extractor = new BeanWrapperFieldExtractor();
		//read header from properties file
		String[] strArr = columnNames.stream().toArray(String[]::new);
		extractor.setNames(strArr);
		aggregator.setFieldExtractor(extractor);
		this.setLineAggregator(aggregator);*/		
		
		// TODO Auto-generated method stub
		System.out.println("Before Running Job");
		System.out.println("Setting Header");
		jobExecution.getExecutionContext().put("header", "id,sales,qty,staffName,date");
		
		map = new HashMap<String, Properties>();
		File directory = new File("C:\\Users\\Qasim\\Documents\\pardir");
		
		File[] files = directory.listFiles();
		try {
			this.listFiles(files);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setPropertiesExecutionContext(jobExecution);
		
		/*System.out.println(jobExecution.getExecutionContext().get("par.txt.txt"));
		System.out.println(jobExecution.getExecutionContext().get("par.txt.txtaggregator"));
		System.out.println(jobExecution.getExecutionContext().get("ch1.txt.txt"));
		System.out.println(jobExecution.getExecutionContext().get("ch1.txt.txtaggregator"));
		System.out.println(jobExecution.getExecutionContext().get("ch2.txt.txt"));
		System.out.println(jobExecution.getExecutionContext().get("ch2.txt.txtaggregator"));*/
		/*System.out.println(jobExecution.getExecutionContext().get("ifrs"));
		System.out.println(jobExecution.getExecutionContext().get("ifrs_aggregator"));*/
	}
	
	public void setPropertiesExecutionContext(JobExecution jobExecution){
		
		Set<String> keyset = map.keySet();
		for(String filename: keyset){
			Properties prop = map.get(filename);
			StringBuilder headerBuilder = new StringBuilder();
			List<String> columnNames = new LinkedList<>();
			Enumeration<String> enums = (Enumeration<String>) prop.propertyNames();
			while(enums.hasMoreElements()){
				String key = enums.nextElement();
				headerBuilder.append(key+",");
				columnNames.add(prop.getProperty(key));
			}
			headerBuilder.deleteCharAt(headerBuilder.lastIndexOf(","));
			jobExecution.getExecutionContext().put(filename, headerBuilder.toString());
			jobExecution.getExecutionContext().put(filename+"_aggregator", String.join(",", columnNames));
		}
	}
	
	public  void listFiles(File[] entry) throws IOException{
		for(File file: entry){
			if(file.isDirectory()){
				listFiles(file.listFiles());
			}else{				
				String fileName = file.getName();
				String filePath = file.getAbsolutePath();
				Properties prop = new Properties();
				prop.load(new FileInputStream(file.getAbsolutePath()));
				
				//add in context
				String[] arr = fileName.split(".properties");
				fileName =  arr[0];
				map.put(fileName, prop);
			}
			
		}
	}

}
