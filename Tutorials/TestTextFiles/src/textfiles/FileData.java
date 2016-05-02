/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfiles;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Boutsman
 */
public class FileData {

    public static void main(String[] args) throws IOException {
        getDirData("C:/Users/Boutsman/Desktop/TestBlueJ");
        System.out.println("");
        getJavaFiles("C:/Users/Boutsman/Desktop/TestBlueJ");
        System.out.println("");
        geefText("C:/Users/Boutsman/Desktop/TestBlueJ/package.bluej");
    }

    public static void getDirData(String direc) {
        Path dir = Paths.get(direc);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
    }
    
    public static void getJavaFiles(String direc) {
        Path dir = Paths.get(direc);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{java,txt}")) {
            for (Path file : stream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {
            System.err.println(x);
        }
    }

    public static void geefText(String dir) {
        // Give the path to the file
        String file_name = dir;

        // Try to read the file
        try {
            ReadFile file = new ReadFile(file_name);
            // Record each line of text into an array of strings
            String[] aryLines = file.OpenFile();

            if (!aryLines[0].equals("#BlueJ package file")) {
                System.out.println("Bestand is geen correct package.bluej bestand");
            } else {
                for (int i = 1; i < aryLines.length; i++) {
                    // Put a line into a string
                    // The line has the format what.doWhat.param=val
                    String str = aryLines[i];
                    String[] temp = str.split("=");
                    String temp2 = temp[0];
                    String[] temp3 = temp2.split("\\.");

                    System.out.print(temp3[0]);
                    System.out.print(" - ");
                    if (temp3.length == 2) {
                        System.out.println(temp3[temp3.length - 1]);
                    } else if (temp3.length == 3) {
                        System.out.print(temp3[temp3.length - 2]);
                        System.out.print(" - ");
                        System.out.println(temp3[temp3.length - 1]);
                    } else {
                        System.out.println("Fout");
                    }

                    //System.out.println(temp3.length + " - ");
                    //System.out.println(temp[temp.length - 1]);
                    //System.out.println(temp3[temp3.length-1]);
                    //String str = aryLines[i];
                    //String[] temp = str.split("=");
                    //String temp2 = temp[0];
                    //String[] temp3 = temp2.split(".");
                    //String id = temp3[0];
                    //String cmd = temp3[temp3.length-1];
                    //String val = temp[temp.length-1];
                    //System.out.print(temp[0] + " - ");
                    //System.out.println(id + " - " + cmd + " - " + val);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
