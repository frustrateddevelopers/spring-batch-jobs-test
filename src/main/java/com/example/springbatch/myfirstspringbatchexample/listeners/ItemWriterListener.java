package com.example.springbatch.myfirstspringbatchexample.listeners;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

import com.example.springbatch.myfirstspringbatchexample.model.Domain;

public class ItemWriterListener implements ItemWriteListener<Domain> {

	@Override
	public void beforeWrite(List<? extends Domain> items) {
		System.out.println("ItemWriteListener - beforeWrite > "+items);
	}

	@Override
	public void afterWrite(List<? extends Domain> items) {
		System.out.println("ItemWriteListener - afterWrite > "+items);
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Domain> items) {
		System.out.println("ItemWriteListener - onWriteError");
	}

}
