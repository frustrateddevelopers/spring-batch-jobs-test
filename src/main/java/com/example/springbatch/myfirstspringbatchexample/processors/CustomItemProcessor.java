package com.example.springbatch.myfirstspringbatchexample.processors;

import org.springframework.batch.item.ItemProcessor;

import com.example.springbatch.myfirstspringbatchexample.model.Domain;

public class CustomItemProcessor implements ItemProcessor<Domain, Domain> {

	@Override
	public Domain process(Domain item) throws Exception {

		System.out.println("Processing..." + item);
		return item;
	}

}
