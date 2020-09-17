package com.company;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File myFile = new File("src/com/company/eecs2500Project0Dataset1.txt");
        System.out.println("File excessed");
        MailAddressInterface[] address = new mailList[10000];
        helper project0 = new helper();
        try {
            Scanner myReader = new Scanner(myFile);


            for (int i = 0; i < 10000; i++) {
                String name = myReader.nextLine();

                String address1 = myReader.nextLine();
                String address2 = myReader.nextLine();
                String city = myReader.nextLine();
                String state = myReader.nextLine();
                int zip = myReader.nextInt();
                String x = myReader.nextLine();
                address[i] = new mailList(name, address1, address2, city, state, zip);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {

        }
        helper.checkStartingOrder(address);
        address = helper.sorting_mail(address);
        helper.checkFinalOrder(address);

        System.out.println(address.length);
        FileWriter newfile = null;
        try {
            newfile = new FileWriter("Output.txt");
            for (int i = 0; i < 10000; i++) {
                newfile.write(address[i].getName()+"\n");
                newfile.write(address[i].getAddressLine1()+"\n");
                newfile.write(address[i].getAddressLine2()+"\n");
                newfile.write(address[i].getCity()+"\n");
                newfile.write(address[i].getState()+"\n");
                newfile.write(address[i].getZipCode()+"\n");
            }
        } catch (NullPointerException e) {
            newfile.close();
        } catch (IOException e) {
            newfile.close();
        }
    }
}

