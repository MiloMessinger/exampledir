
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {
    
    
    private static void printFileSize (String filePath){
        File file = new File(filePath);
        System.out.println(file.length());
    }

    public static void printTotalFileSize (String... files){
        long totalSize = 0;
        for(String fileName : files){
            File file = new File(fileName);
            if(file.exists()){
                totalSize += file.length();
            }
        }
        System.out.println ("Total Size of all files: " + totalSize + " Bytes");
    }

    public static void main(String[] args) {
        //printFileSize("MyFileWriter.java");
        
        String secretPassword = "secretpassword";
        String secretData = "sean ozalpasan (idk what else to put here)";
        //Create a secretpassword txt file in the root directory
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(".hiddenkey.txt"))){
            outputStream.write(secretPassword.getBytes());
            outputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("/home/milomessinger/exampledir/.secret/secret.dat")))){
        writer.write (secretData);
        writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        printTotalFileSize(".hiddenkey.txt", ".gitignore", "/home/milomessinger/exampledir/.secret/secret.dat");
    }
}