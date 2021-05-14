package com.intercom.filesort.service;

import com.intercom.filesort.entities.response.PQCustomer;
import com.intercom.filesort.mapper.CustomerMapper;
import com.intercom.filesort.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

import static com.intercom.filesort.constants.AppConstant.*;


@Component
public class FileMerge {
    @Autowired
    Util util;
    @Autowired
    CustomerMapper customerMapper;
    public  void merge(){
        // Now open each file and merge them, then write back to disk

        try {
            long INPUT_FILE_SIZE = util.getFileSize();
            int partitions = (int) Math.ceil((double) INPUT_FILE_SIZE / TEMP_FILE_SIZE);

            PriorityQueue<PQCustomer> customerPriorityQueue= new PriorityQueue<PQCustomer>(partitions);
            ArrayList<BufferedReader> brs = new ArrayList<BufferedReader>(partitions);

            int i = 0 , j=0;

            for (i = 0; i < partitions; i++) {
                brs.add(i,new BufferedReader(new FileReader(TEMP_FILE + Integer.toString(i) + ".txt")));
                String line = brs.get(i).readLine();
                if (line != null){
                    PQCustomer temp = customerMapper.mapResponse(line);
                    if(temp != null) {
                        temp.setIndex(i);
                        customerPriorityQueue.add(temp);
                    }
                }
            }

            FileWriter fw = new FileWriter(OUTPUT_FILE_NAME);
            PrintWriter pw = new PrintWriter(fw);

            for (i = 0; i < INPUT_FILE_SIZE; i++) {

                PQCustomer closetCustomer = customerPriorityQueue.peek();
                if(closetCustomer == null){
                    break;
                }
                customerPriorityQueue.poll();

                pw.println(closetCustomer.getCustomer());


                int closetFileIndex = closetCustomer.getIndex();
                String line = brs.get(closetFileIndex).readLine();

                if (line != null){
                    PQCustomer temp = customerMapper.mapResponse(line);
                    if(temp != null) {
                        temp.setIndex(closetFileIndex);
                        customerPriorityQueue.add(temp);
                    }
                }
            }

            for (i = 0; i < partitions; i++)
                brs.get(0).close();

            pw.close();
            fw.close();
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
