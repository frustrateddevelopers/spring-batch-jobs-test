package com.example.springbatch.myfirstspringbatchexample.tasklet;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.example.springbatch.myfirstspringbatchexample.formatter.Formatter;
import com.example.springbatch.myfirstspringbatchexample.formatter.XmlFormatter;

public class MyTasklet implements Tasklet{

	private XmlFormatter fileFormatter;
	private String name;
	
	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("executing tasklet");		
		fileFormatter.format();
		System.out.println(name);
		return RepeatStatus.FINISHED;
	}


	/**
	 * @return the fileFormatter
	 */
	public XmlFormatter getFileFormatter() {
		return fileFormatter;
	}


	/**
	 * @param fileFormatter the fileFormatter to set
	 */
	public void setFileFormatter(XmlFormatter fileFormatter) {
		this.fileFormatter = fileFormatter;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
