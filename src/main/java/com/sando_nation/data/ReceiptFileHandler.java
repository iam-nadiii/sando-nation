package com.sando_nation.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ReceiptFileHandler {


    public boolean generateReceipt(Receipt receipt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = receipt.getTime().format(formatter) + ".txt";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(String.valueOf(receipt.getOrder()));

            bufferedWriter.close();
            return true;

        } catch (IOException e){
            System.out.println("ERROR! Could not generate receipt: " + e.getMessage());
            return false;
        }

    }
}
