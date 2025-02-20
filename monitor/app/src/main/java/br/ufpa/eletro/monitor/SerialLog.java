package br.ufpa.eletro.monitor;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import com.fazecast.jSerialComm.SerialPort;

public class SerialLog implements Iterable<String>{
    private InputStreamReader reader;
    private char[] chars = new char[20];
    public SerialLog(SerialPort serialPort){
        try{
            reader = new InputStreamReader(serialPort.getInputStream(), "US-ASCII");
        }catch(UnsupportedEncodingException unsupportedEncodingException){
            //
        }
    }

    public Iterator<String> iterator(){
        return new Iterator<String>(){
            public String next(){
                
                try{
                    reader.read(chars);
                    return new String(chars);
                }catch(IOException ioException){
                }
                return "";
                
            }
            public boolean hasNext(){
                return true;
            }
        };
    }
}
