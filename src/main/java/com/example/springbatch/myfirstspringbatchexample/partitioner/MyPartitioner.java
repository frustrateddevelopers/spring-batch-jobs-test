package com.example.springbatch.myfirstspringbatchexample.partitioner;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

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
        partitionMap.put("Thread:-1", ctxMap);
        ExecutionContext ctxMap1 = new ExecutionContext();
        ctxMap1.put("fileFormater",new CsvFormatter());
        partitionMap.put("Thread:-2", ctxMap);
        return partitionMap;
	}

}

abstract class Formatter{
	abstract void format();
}

class XmlFormatter extends Formatter{

	@Override
	void format() {
		// TODO Auto-generated method stub
		System.out.println("processing xml files");
	}
	
}

class CsvFormatter extends Formatter{

	@Override
	void format() {
		// TODO Auto-generated method stub
		System.out.println("processing csv files");
	}
	
}
