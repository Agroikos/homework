package quizztwoassignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class LogisticsTool {

    public static String pathToFile;

    public LogisticsTool(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public static void main(String[] args) {

        List<Package> delivs;
        pathToFile = "/Users/danolaru/Desktop/Programming/Scoala Informala/homework/src/main/java/quizztwoassignment/inputData.txt";

        delivs = readFile(pathToFile);

        delegateToThreads(delivs);
    }

    public static List<Package> readFile(String path) {
        List<Package> delivs = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.length() > 1) delivs.add(new Package(line));
            }
            return delivs;

        } catch (IOException e) {
            System.out.println("Oops, this happened: " + e.getMessage());
        }
        return null;
    }

    public static Collection<List<Package>> groupDelivsByLocation(List<Package> delivs) {

        return delivs.stream().collect(Collectors.groupingBy(Package::getLocation)).values();
    }

    public static int delegateToThreads (List<Package> delivs) {
        //for testing purposes: returns number of distinct locations, which should be the same as the number of streams;

        Collection<List<Package>> listOfLists = groupDelivsByLocation(delivs);

        listOfLists.stream().forEach(t -> {
            Thread runnie = new LocationThread(t);
            runnie.start();
        });

        return listOfLists.size();
    }

}
