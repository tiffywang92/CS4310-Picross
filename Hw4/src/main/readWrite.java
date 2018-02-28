package main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;



public class readWrite {
    public static String readFile(String fileName) {

        String outPutLine = "";
        String line = null;

        try {
           
            FileReader fileReader = new FileReader(fileName);

            
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	outPutLine += line + "\n";
                System.out.println(line);
            }   

            
            bufferedReader.close();    
            return outPutLine;
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            
            
        }
        return null;
    }
    
    public static void createFile(String fileName, String content) throws FileNotFoundException, UnsupportedEncodingException{
        
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        writer.println(content);
        writer.close();
    }
}