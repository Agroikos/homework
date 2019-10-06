package quizztwoassignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LogisticsTool {
    public static void main(String[] args) {

        List<Package> delivs = new ArrayList<>();
        String pathToFile = "/Users/danolaru/Desktop/Programming/Scoala Informala/homework/src/main/java/quizztwoassignment/inputData.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathToFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.length() > 1) delivs.add(new Package(line));
            }

        } catch (IOException e) {
            System.out.println("Oops, this happened: " + e.getMessage());
        }


        /*
        delivs.stream()
                .filter(distinctByLocation(Package::getLocation))
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.toList())
                .forEach(t -> new LocationAggregator(t));
         */

        Collection<List<Package>> listOfLists = delivs.stream()
                .collect(Collectors.groupingBy(Package::getLocation)).values();

        listOfLists.stream().forEach(t -> {
            Thread runnie = new LocationAggregator(t);
            runnie.start();
        });
    }

}
