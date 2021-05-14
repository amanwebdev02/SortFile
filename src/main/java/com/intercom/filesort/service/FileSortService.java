package com.intercom.filesort.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileSortService {
    @Autowired
    FileSort fileSort;
    @Autowired
    FileMerge fileMerge;
    public  void run()
    {
        try {
            fileSort.sort();
            fileMerge.merge();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
