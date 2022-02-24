package com.company;

public class Address {

    // private static int blocks = 1;
    private final String street;
    private final int houseNumber;

    public Address(String street, int houseNumber){
        if(isValidHouse(houseNumber)){
            this.houseNumber = houseNumber;
        }
        else {
            this.houseNumber = 0;
        }
        if(isValidStreet(street)){
            this.street = street.toUpperCase();
        }
        else{
            this.street = "Void";
        }
    }

    public int getHouseNumber(){
        return this.houseNumber;
    }

    public String getStreet(){
        return this.street;
    }


    private boolean isValidStreet(String street){
        try{
            int streetNum = Integer.parseInt(street);
            return streetNum > 0 && streetNum < 11;
        }
        catch (Exception e){
            char streetLet = street.charAt(0);
            streetLet = Character.toUpperCase(streetLet);
            return streetLet >= 'A' && streetLet <= 'J';
        }
    }
    private boolean isValidHouse(int houseNumber){
        return (houseNumber < 991 && houseNumber > 99 && houseNumber % 2 == 0);
    }
}
