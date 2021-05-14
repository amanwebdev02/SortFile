package com.intercom.filesort;

import com.google.gson.JsonParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.intercom.filesort.service.FileSort;

import java.io.FileNotFoundException;

import static com.intercom.filesort.constants.AppConstant.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class FilesortApplicationTests {
	@Autowired
	FileSort fileSort;

	@Test
	void contextLoads() {
	}

	@Test()
	public void testForEmptyFile() {
		assertThrows(IllegalArgumentException.class, () -> fileSort.sort(TEST_INPUT_FILE_EMPTY));
	}

	@Test
	public void testForFileDoesNotExists() {
		assertThrows(FileNotFoundException.class, () -> fileSort.sort(TEST_INPUT_FILE_DOES_NOT_EXISTS));
	}

	@Test
    public void testForInvalidJsonData() {
        assertThrows(JsonParseException.class, () -> fileSort.sort(TEST_INPUT_FILE_INVALID));
    }

}
