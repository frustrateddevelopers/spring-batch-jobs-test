package com.example.springbatch.myfirstspringbatchexample;

import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;

public class CustomFlatFileItemWriter extends FlatFileItemWriter{

	private String header;
	private FlatFileHeaderCallback headerCallback;
	
	public void init(){
		super.setHeaderCallback(headerCallback);
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
	/**
	 * @return the headerCallback
	 */
	public FlatFileHeaderCallback getHeaderCallback() {
		return headerCallback;
	}
	/**
	 * @param headerCallback the headerCallback to set
	 */
	public void setHeaderCallback(FlatFileHeaderCallback headerCallback) {
		this.headerCallback = headerCallback;
	}
	
	
}
