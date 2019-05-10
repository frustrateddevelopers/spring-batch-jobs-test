package com.example.springbatch.myfirstspringbatchexample.partitioner;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import com.example.springbatch.myfirstspringbatchexample.formatter.CsvFormatter;
import com.example.springbatch.myfirstspringbatchexample.formatter.Formatter;
import com.example.springbatch.myfirstspringbatchexample.formatter.XmlFormatter;

public class MyPartitioner implements Partitioner{

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		// TODO Auto-generated method stub
		Map partitionMap = new HashMap<String, Formatter>();
        
         
        //Putting File formate , slaves on the basis of file format pick the correct fileProcessor
        //i.e if file formate xml, xml file processor would be used, using two formatter only for this example
		//ideally on the basis of grid size we create executioncontext for slaves
        ExecutionContext ctxMap = new ExecutionContext();
        ctxMap.put("fileFormater",new XmlFormatter());
        ctxMap.put("name","Thread-1");
        partitionMap.put("partition:-1", ctxMap);
        
        ExecutionContext ctxMap1 = new ExecutionContext();
        ctxMap1.put("fileFormater",new XmlFormatter());
        ctxMap1.put("name","Thread-2");
        partitionMap.put("partition:-2", ctxMap1);
        return partitionMap;
	}

}






