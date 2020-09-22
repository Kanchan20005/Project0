/*
Name- Kanchan Bhattarai
Linear Data Structure with JAVA
Professor Dr. Gerald R. Heuring

This is the first project of Linear Data Stucture. This Program sorts the mailing address on the basis of zipcode in the ascending order.
 */




package com.company;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the file path: ");
        String fileName = input.nextLine();


        File myFile = new File(fileName);                                                    //Input File
        MailAddressInterface[] address = new mailList[10000];                                //Creating array of Object
        helper project0 = new helper();
        try {
            Scanner myReader = new Scanner(myFile);                                          //Scanning the file to read the file
            //This for loop reads the name, address1, address2, city, state, and zip of the mailing address and stores in the specific object
            for (int i = 0; i < 10000; i++) {
                String name = myReader.nextLine();
                String address1 = myReader.nextLine();
                String address2 = myReader.nextLine();
                String city = myReader.nextLine();
                String state = myReader.nextLine();
                int zip = myReader.nextInt();
                String x = myReader.nextLine();
                address[i] = new mailList(name, address1, address2, city, state, zip);       //Instantiating the object to store mailing address
            }

        } catch (FileNotFoundException e) {                                                  // Checks the File not found exception
            e.printStackTrace();
        } catch (NoSuchElementException e) { }                                               // Checks the no such element exception

        helper.checkStartingOrder(address);                                                 //Calls the method checkStartingOrder from helper class and converts array of object into list.
        address = helper.sorting_mail(address);                                             //Sorting the array with Radix sort
        helper.checkFinalOrder(address);                                                    //Checking the final Radix sort by comparing with list sort

        FileWriter newfile = null;                                                          //Writing the sorted mailing address in new file
        try {
            newfile = new FileWriter("Output.txt");
            //Writing the sorted mailing address in output file
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
        input.close();
    }
}

