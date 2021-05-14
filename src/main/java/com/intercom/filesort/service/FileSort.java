package com.intercom.filesort.service;


import com.intercom.filesort.entities.response.Customer;
import com.intercom.filesort.mapper.CustomerMapper;
import com.intercom.filesort.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import static com.intercom.filesort.constants.AppConstant.*;

@Component
public class FileSort
{
    @Autowired
    Util util;
    @Autowired
    CustomerMapper customerMapper;

    public void sort ()throws Exception
    {
       readFileAndStoreSortedPartitions();
    }

    public void sort(String file) throws Exception
    {
        INPUT_FILE_NAME = file;
        File inputFile = new File(INPUT_FILE_NAME);

        if (!(inputFile.exists())) {
            throw new FileNotFoundException("The file " + file + " does not exist.");
        }

        if (!(inputFile.canRead())) {
            throw new FileNotFoundException("The file " + file + " is not readable.");
        }
        if(inputFile.length()<=0){
            throw new IllegalArgumentException("Input file has no data");
        }
        readFileAndStoreSortedPartitions();
    }

    private  void readFileAndStoreSortedPartitions() throws Exception{
        try
        {
            FileReader fr = new FileReader(INPUT_FILE_NAME);

            BufferedReader br = new BufferedReader(fr);
            long INPUT_FILE_SIZE = util.getFileSize();
            int partitions = (int) Math.ceil((double) INPUT_FILE_SIZE / TEMP_FILE_SIZE);

            int i, j;
            i = j = 0;
            // Iterate through the input  file
            for (i = 0; i < partitions; i++)
            {
                ArrayList<Customer> customers = new ArrayList<>();
                // Read TEMP_FILE_SIZE chunks at a time from the file
                for (j = 0; j < (TEMP_FILE_SIZE < INPUT_FILE_SIZE ? TEMP_FILE_SIZE : INPUT_FILE_SIZE); j++)
                {
                    String line = br.readLine();
                    if (line != null) {
                        Customer temp = customerMapper.mapRequest(line);
                        if(temp !=null){
                            //Filtering customers based on proximity
                            if(temp.getDistance() < DISTANCE_LIMIT)
                                customers.add(temp);
                        }
                    }
                    else
                        break;
                }
                // Sort Chunk size Customer based on userid
                Collections.sort(customers);

                // Write the sorted Customer Chunk to temp file
                FileWriter fw = new FileWriter(TEMP_FILE + Integer.toString(i) + ".txt");
                PrintWriter pw = new PrintWriter(fw);

                for (Customer temp :customers) {
                    pw.println(temp);
                }

                pw.close();
                fw.close();
            }

            br.close();
            fr.close();


        }
        catch (FileNotFoundException e)
        {
            throw e;
        } catch (IOException e) {
            throw e;
        }catch (Exception e){
            throw e;
        }
    }


}