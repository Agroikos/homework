package week6;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;


public class MyFileUtils {

    //1. Implement a method to get a list of all file/directory names from the given.

    //first implementation
    public static void getDirectoriesAndFilesInLocation(String directoryPath) {

        try (DirectoryStream<Path> dirStrm = Files.newDirectoryStream(Paths.get(directoryPath))) {
            System.out.println("Location to explore: " + directoryPath);
            for (Path entry : dirStrm) {
                BasicFileAttributes attributes = Files.readAttributes(entry, BasicFileAttributes.class);

                if (attributes.isDirectory()) {
                    System.out.print("DIR: ");
                } else {
                    System.out.print("File: ");
                }
                System.out.println(entry.getFileName());
            }

        } catch (InvalidPathException e) {
            System.out.println("Path error" + e);
        } catch (NotDirectoryException e) {
            System.out.println(directoryPath + "is not a directory" + e);
        } catch (IOException e) {
            System.out.println("Exception caught " + e);
        }

        //second implementation
        /*System.out.println("Second approach: ");
        Stream<Path> pathsUnderHome = Files.walk(Paths.get(directoryPath),1);
        pathsUnderHome.forEach(System.out::println);*/
    }

    //2. Implement a method to get specific files by extensions from a specified folder.
    public static void getFilesByExtension(String directoryPath, String extension) {
        System.out.println("Get files with extension " + extension);
        try (DirectoryStream<Path> dirStrm = Files.newDirectoryStream(Paths.get(directoryPath), "*." + extension)) {
            System.out.println("Location to explore: " + directoryPath);
            for (Path entry : dirStrm) {
                BasicFileAttributes attributes = Files.readAttributes(entry, BasicFileAttributes.class);
                if (!attributes.isDirectory()) {
                    System.out.println(entry.getFileName());
                }
            }
        } catch (InvalidPathException e) {
            System.out.println("Path error" + e);
        } catch (NotDirectoryException e) {
            System.out.println(directoryPath + "is not a directory" + e);
        } catch (IOException e) {
            System.out.println("Exception caught " + e);
        }
    }

    //3. Implement a method to check if a file or directory specified by pathname exists or not.
    public static boolean fileOrFolderExists(String path) {
        return Files.exists(Paths.get(path));
    }

    //4. Implement a method to check if a file or directory has read and write permission.
    public static void hasReadAndWritePermissions(String path) {
        System.out.println("Is readable: " + Files.isReadable(Paths.get(path)));

        System.out.println("Is writable: " + Files.isWritable(Paths.get(path)));

    }

    //5. Implement a method to check if given pathname is a directory or a file.
    public static String isFileOrFolder(String path) {
        if (Files.isDirectory(Paths.get(path))) return "directory";
        else if (Files.isRegularFile(Paths.get(path))) return "file";
        else return "something else";
    }

    //6. Implement a method to compare two files lexicographically.
    public static int compareFilesLexicographically(String fileOne, String fileTwo) {
        try (BufferedReader readerOne = new BufferedReader(new FileReader(fileOne));
             BufferedReader readerTwo = new BufferedReader(new FileReader(fileTwo))) {
            String lineOne = "", lineTwo = "";

            //implement two queues to keep the words to compare in
            Queue<String> wordsOne = new LinkedList<>();
            Queue<String> wordsTwo = new LinkedList<>();

            while ((((lineOne = readerOne.readLine()) != null) ||
                    (!wordsOne.isEmpty()) ) &&
            ((lineTwo = readerTwo.readLine()) != null) ||
                    (!wordsTwo.isEmpty())) {

                if (lineOne != null) wordsOne.addAll(Arrays.asList(lineOne.split("[^a-zA-Z]")));
                if (lineTwo != null) wordsTwo.addAll(Arrays.asList(lineTwo.split("[^a-zA-Z]")));

                System.out.println("WordsOne: " + wordsOne);
                System.out.println("WordsTwo: " + wordsTwo);

                while (!wordsOne.isEmpty() && !wordsTwo.isEmpty()) {
                    String wordA = wordsOne.peek();
                    String wordB = wordsTwo.peek();

                    System.out.print("A: " + wordA + " || B: " + wordB);

                    //int comparison = wordsOne.poll().compareTo(wordsTwo.poll());
                    if (isNotEmpty(wordA) && isNotEmpty(wordB)) {
                        int comparison = wordA.compareTo(wordB);

                        wordA = wordsOne.poll();
                        wordB = wordsTwo.poll();

                        System.out.println(" || comparison: " + comparison);
                        if (comparison != 0) return comparison;
                    } else {
                        System.out.println();
                        if (isEmpty(wordA)) wordsOne.poll();
                        if (isEmpty(wordB)) wordsTwo.poll();
                    }
                }
            }

            //decide which file ended first
            if ((wordsOne.size() == 0) && (wordsTwo.size() != 0)) return 1;
            if ((wordsOne.size() != 0) && (wordsTwo.size() == 0)) return -1;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    //7. Implement a method to get last modified time of a file.
    public static String lastModifiedTime(String path) {
        try {
            return Files.getLastModifiedTime(Paths.get(path)).toString();
        } catch (IOException e) {
            //e.printStackTrace();
            return e.toString();
        } catch (Exception e) {
            //e.printStackTrace();
            return e.toString();
        }
        //return "Exception occurred";
    }

    //8. Implement method to read input from java console.
    public static void readFromConsole() throws IOException {

        //console implementation doesn't work in intellij
    /*  Console console = System.console();
        String consoleFeed = "";
        if (console == null) throw new IOException("Couldn't get console");
        else {
            while (true) {
                consoleFeed = console.readLine("Enter a line");
                if (!consoleFeed.equals("quit")) System.out.println("Read from console: " + consoleFeed);
                else {
                    System.out.println("You decided to quit.");
                    return;
                }
            }
        }*/

        //use Scanner
        Scanner scanner = new Scanner(System.in);
        String scanIn = "";
        System.out.println("Input text here:");
        scanIn = scanner.next();
        System.out.println("You entered: " + scanIn);
    }

    //9. Implement a method to get file size in bytes, kb, mb.
    public static String getFileSize(String path, String resultFormat) {

        Path pth = Paths.get(path);
        try {
            double sizeInBytes = Files.size(pth);
            if (resultFormat.equals("bytes")) return String.valueOf(sizeInBytes);
            else if (resultFormat.equals("kb")) return String.valueOf(sizeInBytes / 1024);
            else if (resultFormat.equals("mb")) return String.valueOf(sizeInBytes / (1024 * 1024));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Oops, something went wrong.";
    }

    //10. Implement a method to read contents from a file into byte array.
    public static void readFromFileToByte(String path) {

        File file = new File(path);
        int arrayLength = 0;
        byte val;
        byte[] myFileArray = new byte[10000];

        try {
            FileInputStream in = new FileInputStream(file);
            while ((val = (byte) in.read()) != -1) {
                myFileArray[arrayLength++] = val;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Results read: ");
        System.out.println("Length of array: " + arrayLength);
        System.out.println("The contents of the array; ");
        for (byte b : myFileArray) System.out.print(b + " ");
    }

    //11. Implement a method to read a file content line by line.
    public static void readFileLineByLine(String path) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(path));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //12. Implement a method to read a plain text file.
    public static void readPlainTextFile(String path) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            int val;
            char character;

            while ((val = fileInputStream.read()) != -1) {
                character = (char) val;
                System.out.print(" " + character);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //13. Implement a method to read a file line by line and store it into a variable.
    //TODO: make it with threads
    public static void readFileByLineIntoVariable(String location) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(location))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //14. Implement a method to store text file content line by line into an array.
    public static String[] fileToStringArray(String location) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(location))) {
            String line;

            while ((line = reader.readLine()) != null) {
                //System.out.println("Line: " + line);
                result.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //check
        result.stream().forEach(t -> System.out.println("Line : " + t));
        String[] myResult = new String[result.size()];
        return result.toArray(myResult);
    }

    //15. Implement a method to write and read a plain text file.
    public static void fileReadAndWrite(String location) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input choice: ");
        System.out.println("1 for write \n2 for append\n0 for read \n-1 for end");
        int choice = scanner.nextInt();
        String input = "";

        while (true) {
            switch (choice) {
                //TODO: why does it keep adding a new line character at the beginning of the file???
                case 1:
                    System.out.println("You've chosen to write to fresh file:");
                    System.out.println("Write what you want to input to file: (-1 to quit writing / go up one level in menu)");
                    try (FileWriter writer = new FileWriter(location)) {
                        while (!((input = scanner.nextLine()).equals("-1"))) {
                            if (!input.equals("\n")) writer.write(input.trim() + "\n");
                            //writer.append(input + "\n" );
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Input next choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                //break;
                case 2:
                    System.out.println("You've chosen to append to file:");
                    System.out.println("Write what you want to append to file: (-1 to quit writing / go up one level in menu)");
                    try (PrintWriter writer = new PrintWriter(new FileWriter(location, true))) {
                        while (!((input = scanner.nextLine()).equals("-1"))) {
                            if (!input.equals("\n")) writer.println(input.trim());
                            //writer.append(input + "\n" );
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Input next choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                //break;
                case 0:
                    System.out.println("You've chosen to read from file:");
                    try (BufferedReader reader = Files.newBufferedReader(Paths.get(location))) {
                        String line = "";
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Input next choice: ");
                    //while (!(input = scanner.nextLine()).isEmpty()) choice = Integer.parseInt(input);
                    if (scanner.hasNext()) choice = scanner.nextInt();

                    break;
                //break;
                case -1:
                    System.out.println("You've chosen to end program.");
                    return;
                default:
                    System.out.println("Invalid choice. Choose again: ");
                    if (scanner.hasNext()) choice = scanner.nextInt();
                    break;
            }
        }

    }

    //16. Implement a method to append text to an existing file.
    public static void appendTextToFile(String location, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(location, true))) {
            //writer.append(text);
            //writer.println(text);
            writer.newLine();
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //17. Implement a method to read first 3 lines from a file.
    public static void readThreeLinesFromFile(String location) {
        try (BufferedReader reader = new BufferedReader(new FileReader(location))) {
            String line = reader.readLine();
            System.out.println(line);

            line = reader.readLine();
            System.out.println(line);

            line = reader.readLine();
            System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //18. Implement a method to find the longest word in a text file.
    public static String longestWordInFile(String location) {
        String longestWord = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(location))) {
            String line = "";
            int maxLen = 0;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[^a-zA-Z]");
                for (String t : words)
                    if (t.length() > maxLen) {
                        maxLen = t.length();
                        longestWord = t;
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return longestWord;
    }

    //19. Implement a terminal (cmd) in Java using IO operations and new nice :)  features from Java 8.
    //Your app should replicate at least 8 commands and a help command (exclusive) that shows the available commands.
    //Commands are given in the console (including the options for that command) and result of the command should also
    //be displayed in the console or a feedback message.

    public static void terminalUtility(Class callingClass) {
        String currentDir = new java.io.File(".").toURI().toString();
        String pathToClass = callingClass.getResource("URI").toString();
        //String pathToClass = callingClass.getClass().getResource("WorkingWithFiles.class").toString();
        //System.out.println(pathToClass.substring(currentDir.length() - 2)); // -2 to get rid of the /./ at the end of the current dir

        System.out.println("testing: ");
        System.out.println("current dir: " + currentDir);
        System.out.println("pathToClass: " + pathToClass);
        System.out.println();
        /*
        System.out.println("Type command:");
        Scanner scanner = new Scanner(System.in);
        String command = "";
        command = scanner.nextLine();

        while (true) {
            String[] commands = command.split(" .");

            switch (commands[0]) {
                case "mkdir":
                    System.out.println("Make directory with name : " + commands[1]);

                    break;
                case "rmdir":
                    System.out.println("Remove");
                    break;
                case "help":
                    System.out.println("You are getting helped:");
                    break;
                case "ls":
                    System.out.println("Showing current directory contents: ");
                    break;
                case "cd":
                    System.out.println("Stepping down one level in directory tree");
                    break;
                case "quit":
                    System.out.println("You selected quit. Quitting...");
                    break;
                case "delete":
                    System.out.println("Deleting specified file.");
                    break;
                case "copy":
                    System.out.println("Copying specified object to location");
                    break;


            }
        }*/

    }
}
