package GeneralTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Anargams {

        public static void main(String[] args) throws IOException {
            File dictionary = new File("C:\\Users\\rgouda\\Desktop\\Books\\Dictionary.txt");
            int minGroupSize = Integer.parseInt("1");
            Map<String, Set<String>> groups = new HashMap<>();

            ///

            try (Stream<String> words = (Stream<String>) Files.lines(Paths.get(dictionary.toURI()))) {
                words.collect(
                        groupingBy(word -> word.chars().sorted()
                                .collect(StringBuilder::new,
                                        (sb, c) -> sb.append((char) c),
                                        StringBuilder::append).toString()))
                        .values().stream()
                        .filter(group -> group.size() >= minGroupSize)
                        .map(group -> group.size() + ": " + group)
                        .forEach(System.out::println);
            }

            ////
            try (Scanner s = new Scanner(dictionary)) {
                while (s.hasNext()) {
                    String word = s.next();
                    groups.computeIfAbsent(alphabetize(word),
                            (unused) -> new TreeSet<>()).add(word);
                }}
            for (Set<String> group : groups.values())
                if (group.size() >= minGroupSize)
                    System.out.println(group.size() + ": " + group);
        }
        private static String alphabetize(String s) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            return new String(a);
        }
}
