package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WriterApp {
	@Autowired
	@Qualifier("decoratedWriter")
	Writer writer;

	public WriterApp(Writer writer) {
		super();
		this.writer = writer;
	}

	public WriterApp() {
		super();
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public void print(String message) {
		writer.write(message);
	}
}
