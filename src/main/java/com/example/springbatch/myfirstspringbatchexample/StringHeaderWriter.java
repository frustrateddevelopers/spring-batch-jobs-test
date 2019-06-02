package com.example.springbatch.myfirstspringbatchexample;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

class StringHeaderWriter implements FlatFileHeaderCallback {
	 
    private String header;
 
    @Override
    public void writeHeader(Writer writer) throws IOException {
        writer.write(header);
    }

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
}
