package com.company;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class helper
{
    protected static ArrayList<Integer> zipList;
    static long startTime;
    static long endTime;


    public helper() {
        zipList = new ArrayList<Integer> (100);
        startTime = 0;
        endTime = 0;
;
    }

    public static void checkStartingOrder(MailAddressInterface mailingList[]) {
    for (int i = 0; i < mailingList.length; i++) {
        if (mailingList[i] != null) {
            zipList.add(mailingList[i].getZipCode());
        }
    }
    startTime = System.currentTimeMillis();
    System.out.println(zipList.size());
    }


    public static void checkFinalOrder(MailAddressInterface mailingList[]) {
        int finalListSize = mailingList.length;

        endTime = System.currentTimeMillis();
        for (int i = 0; i < mailingList.length; i++) {
            if (mailingList[i] == null) {
                finalListSize = i;
                break;
            }
        }

        if (zipList.size() != finalListSize) {
            System.out.println("Final list size does not match initial list size!");
            System.out.println("Initial List Size = " + zipList.size());
            System.out.println("Final List Size = " + finalListSize);
        } else {
            System.out.println("Initial and Final list sizes match.");
        }
        int outOfOrder = 0;

        for (int i = 1; i < finalListSize; i++) {

            if (mailingList[i - 1].getZipCode() > mailingList[i].getZipCode()) {
                System.out.println("Zip Code Out of Order");
                System.out.println("Address " + (i - 1));
                System.out.println(mailingList[i - 1]);
                System.out.println("Address " + (i));
                System.out.println(mailingList[i]);
                outOfOrder++;
            }
        }
        int missingZip = 0;
        zipList.sort(null);
        for (int i = 0; i < finalListSize; i++) {

            if (mailingList[i].getZipCode() != zipList.get(i).intValue()) {
                System.out.println("Expecting to see zip code " + zipList.get(i).intValue());
                System.out.println("Found: ");
                System.out.println(mailingList[i]);
                missingZip++;
            }
        }
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println("Time Taken = "+(endTime - startTime)+" msec");
    }
    public static MailAddressInterface[] sorting_mail(MailAddressInterface[] mail)
    {
            for(int a = 1;a<=5;a++)
            {
                Object[][] radix = new Object[10][10000];
                try {
                    for (int i = 0; i < 10000; i++)
                    {
                        int digit = mail[i].getZipCodeDigit(a);
                        int j = 0;
                        while (true)
                        {
                            if (radix[digit][j] == null)
                            {
                                radix[digit][j] = mail[i];
                                break;
                            }
                            else
                                {
                                    ++j;
                                }
                        }
                    }
                }
                catch (NoSuchElementException e) { }
                catch (NullPointerException e) { }
                int c = 0;
                for(int b = 0;b<10;b++)
                {
                    for(int i=0;i<10000;i++)
                    {
                        if (radix[b][i]==null)
                        {
                            break;
                        }
                        else
                        {
                            mail[c] = (MailAddressInterface) radix[b][i];
                            c++;
                        }
                    }
                }
            }
            return mail;
    }
}
