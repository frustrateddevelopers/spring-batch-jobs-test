package com.example.springbatch.myfirstspringbatchexample.listeners;

import org.springframework.batch.core.ItemReadListener;

import com.example.springbatch.myfirstspringbatchexample.model.Domain;

public class ItemReaderListener implements ItemReadListener<Domain> {

	@Override
	public void beforeRead() {
		System.out.println("ItemReadListener - beforeRead");
	}

	@Override
	public void afterRead(Domain item) {
		System.out.println("ItemReadListener - afterRead > "+item);
	}

	@Override
	public void onReadError(Exception ex) {
		System.out.println("ItemReadListener - onReadError");
	}

}
