package app.ejemplo.juegotablas;

import java.util.Random;

public class AppProcesses {
    public  int nonRepeatingRandomNumberInt(String num){
        int numberRandom=0;
        int foundNumber=0;
        Random random= new Random();
        while (foundNumber!=-1){
            numberRandom=(int)(random.nextDouble()*10);
            String numberRandomString=String.valueOf(numberRandom);
            foundNumber=num.indexOf(numberRandomString);
        }
        return numberRandom;
    }
    public int randomIntNumber(int rank){
        int numberRandom;
        Random random= new Random();
        numberRandom=(int)(random.nextDouble()*rank);
        return numberRandom;
    }
    public int randomIntNumberTwo(int rank,int num){
        int numberRandom;
        Random random= new Random();
        numberRandom=(int)(random.nextDouble()*(rank*num));
        return numberRandom;
    }
    public  String randomStringNumber(int rank){
        int numberRandom;
        String numberRandomString;
        Random random= new Random();
        numberRandom=(int)(random.nextDouble()*rank);
        numberRandomString=String.valueOf(numberRandom);
        return  numberRandomString;
    }
    public int multiplicationPlusOne(int numOne,int numTwo){
        int resulting=numOne*(numTwo+1);
        return resulting;
    }
    public int multiplicationMinusOne(int numOne,int numTwo){
        int resulting=numOne*(numTwo-1);
        return resulting;
    }
    public int multiplication(int numOne,int numTwo){
        int resulting=numOne*numTwo;
        return resulting;
    }
}
