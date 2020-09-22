/*
Name- Kanchan Bhattarai
 */

package com.company;

public class mailList implements MailAddressInterface {
    //Creating instances
    String name;
    String address1;
    String address2;
    String city;
    String state;
    int zip;

    public mailList(String name,String address1,String address2,String city,String state,int zip) {
        //Constructing object
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;

    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public String getAddressLine1() {
        return address1;
    }

    @Override
    public String getAddressLine2() {
        return address2;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public int getZipCode() {
        return zip;
    }

    @Override
    public int getZipCodeDigit(int digit) {
        switch (digit) {
            case 1:
                int a = getZipCode() % 10;
                return a;
            case 2:
                int b = (getZipCode()/10)%10;
                return b;
            case 3:
                int c = (getZipCode()/100)%10;
                return c;
            case 4:
                int d = (getZipCode()/1000)%10;
                return d;
            case 5:
                int e = (getZipCode()/10000)%10;
                return e;
            default:
                System.out.println("Invalid digit");
                return 0;
        }
    }
}
