package com.company;

import java.util.NoSuchElementException;

public class helper
{
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

