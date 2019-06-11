package com.example.springbatch.myfirstspringbatchexample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;

import com.example.springbatch.myfirstspringbatchexample.model.Report;

public class CustomFlatFileItemWriter extends FlatFileItemWriter{	
	private StringHeaderWriter headerCallback; 
	private String header;
	
	
	public void init(){
		System.out.println("Init method called ...........");
		headerCallback.setHeader(header);
		super.setHeaderCallback(headerCallback);
				
	}
	public StringHeaderWriter getHeaderCallback() {
		return headerCallback;
	}
	public void setHeaderCallback(StringHeaderWriter headerCallback) {
		this.headerCallback = headerCallback;
	}
	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	
	
	
	
	
}
