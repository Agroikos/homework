package week6;

import java.io.IOException;

import static week6.MyFileUtils.*;

public class WorkingWithFiles {
    public static void main(String... args) {
        String location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java";
       /*
       location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework";

        //1. Implement a method to get a list of all file/directory names from the given.
        getDirectoriesAndFilesInLocation(location);

        //2. Implement a method to get specific files by extensions from a specified folder.
        //put in the extension without '.'
        getFilesByExtension(location, "gradle");

        //3. Implement a method to check if a file or directory specified by pathname exists or not.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week5/streams/FibonacciSeries.jav";
        System.out.println("Location exists: " + fileOrFolderExists(location));

        //4. Implement a method to check if a file or directory has read and write permission.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week5/streams/FibonacciSeries.java";

        hasReadAndWritePermissions(location);

        //5. Implement a method to check if given pathname is a directory or a file.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week5/streams";
        System.out.println("Is location file or directory: " + isFileOrFolder(location));

        //7. Implement a method to get last modified time of a file.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week5/streams/FibonacciSeries.java";

        System.out.println("Last time file was modified: ");
        System.out.println(lastModifiedTime(location));

        //8. Implement method to read input from java console.
        //commented for testing the rest of the code
        try {
            readFromConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //9. Implement a method to get file size in bytes, kb, mb.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week5/streams/FibonacciSeries.java";
        String measurementUnit = "mb";
        System.out.print("Size of target file in " + measurementUnit + " is: ");
        System.out.println(getFileSize(location, measurementUnit));

        //10. Implement a method to read contents from a file into byte array.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week6/testfile.file";
        readFromFileToByte(location);



        //11. Implement a method to read a file content line by line.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week6/testfile.file";
        readFileLineByLine(location);


        //12. Implement a method to read a plain text file.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week6/testfile.file";
        readPlainTextFile(location);



        //13. Implement a method to read a file line by line and store it into a variable.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week6/testfile.file";
        readFileByLineIntoVariable(location);


       //14. Implement a method to store text file content line by line into an array.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week6/testfile.file";
        String[] myFileArray = fileToStringArray(location);
        System.out.println("My array length: " + myFileArray.length);
        System.out.println("And the file is: ");
        for (String s : myFileArray) System.out.print(s + " ");


       //15. Implement a method to write and read a plain text file.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week6/newTestText.txt";
        fileReadAndWrite(location);

        //16. Implement a method to append text to an existing file.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week6/newTestText.txt";
        appendTextToFile(location, "\nBro where's my car?");


        //17. Implement a method to read first 3 lines from a file.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week6/thirdTextFile.txt";
        readThreeLinesFromFile(location);


        //18. Implement a method to find the longest word in a text file.
        location = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week6/testfile.file";
        System.out.println("Longest word: " + longestWordInFile(location));

        */

        //19. Implement a terminal (cmd) in Java using IO operations and new nice :)  features from Java 8.
        //Your app should replicate at least 8 commands and a help command (exclusive) that shows the available commands.
        //Commands are given in the console (including the options for that command) and result of the command should also
        //be displayed in the console or a feedback message.

        //6. Implement a method to compare two files lexicographically.
        String fileA = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week6/FileA.txt";
        String fileB = "/home/vernalissimo/Desktop/Programming/Learning_Projects/Scoala_Informala/newHomeworkWithGradle/homework/src/main/java/week6/FileB.txt";
        int compare = compareFilesLexicographically(fileA,fileB);

        System.out.println("Main method: Compare equals: ----> " + compare);

        if (compare > 0) System.out.println("First file is lexicographically greater.");
        else if (compare < 0) System.out.println("Second file is lexicographically greater.");
        else System.out.println("Files are lexicographically equal.");
    }

}