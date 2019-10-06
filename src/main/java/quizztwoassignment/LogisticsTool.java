package quizztwoassignment;

import lombok.Getter;
import lombok.Setter;

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
                delivs.add(new Package(line));
            }

        } catch (IOException e) {
            System.out.println("Oops, this happened: " + e.getMessage());
            System.out.println(e);
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

        listOfLists.stream().forEach(t -> new LocationAggregator(t));
    }

    public static <T> Predicate<T> distinctByLocation(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }


}
