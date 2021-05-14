package com.intercom.filesort;

import com.intercom.filesort.service.FileSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.intercom.filesort.*"})
public class FilesortApplication implements CommandLineRunner {

	@Autowired
	FileSortService fileSortService;

	public static void main(String[] args) {

		SpringApplication.run(FilesortApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileSortService.run();
	}
}
