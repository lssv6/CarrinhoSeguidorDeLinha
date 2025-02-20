package br.ufpa.eletro.monitor;

import java.util.Arrays;

public class SData{

    private int size;
    private int[] data;

    private SData(int[] data){this.data = data; size = data.length;}
    
    public static SData fromString(String string){
        String[] numbersAsString = string.split(";");
        int[] numbers = new int[numbersAsString.length];
        for(int i = 0; i < numbersAsString.length; i++){
            try{
                numbers[i] = Integer.parseInt(numbersAsString[i]);
            }catch(NumberFormatException nu){
                numbers[i] = -99;
            }
        }
        System.out.println(Arrays.toString(numbersAsString));
        return new SData(numbers);
    }

    public int getSize(){return size;}
    
    public int[] getData(){return data;}
    
    public String toString(){return "SData[data=" + Arrays.toString(data)+", size=" + size+"]";}
}
