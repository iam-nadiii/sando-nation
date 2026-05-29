package com.sando_nation.data;

import com.sando_nation.model.Receipt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ReceiptFileHandler {


    public static boolean generateReceipt(Receipt receipt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        DateTimeFormatter timeStampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd\nHH:mm:ss");
        String fileName = receipt.getTime().format(formatter) + ".txt";
        String timeStamp = receipt.getTime().format(timeStampFormatter);

        try {
            FileWriter fileWriter = new FileWriter("./Receipts/" + fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(receipt.getOrder().toString());
            bufferedWriter.write(timeStamp);

            bufferedWriter.close();
            return true;

        } catch (IOException e){
            System.out.println("ERROR! Could not generate receipt: " + e.getMessage());
            return false;
        }

    }
}
