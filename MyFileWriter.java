
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {
    public static void main(String[] args) {
        String secretPassword = "insert bank password";
        String secretData = "sean ozalpasan (idk what else to put here)";
        //Create a secretpassword txt file in the root directory
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(".hiddenkey.txt"))){
            outputStream.write(secretPassword.getBytes());
            outputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("/home/milomessinger/exampledir/.secret/secret.txt")))){
        writer.write (secretData);
        writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}