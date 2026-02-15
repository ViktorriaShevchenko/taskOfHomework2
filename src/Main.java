import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Alice");
        names.add("Bob");
        names.add("A");
        names.add("");
        names.add(null);
        names.add("Tom");
        names.add("Кириллица");
        names.add("X");

        System.out.println("Исходный список: " + names);
        System.out.println();

        // Stream API
        NameProcessorStream streamProcessor = new NameProcessorStream();
        List<String> streamResult = streamProcessor.processNames(names);
        System.out.println("Stream API результат: " + streamResult);

        // Итеративный подход
        NameProcessorIterative iterativeProcessor = new NameProcessorIterative();
        List<String> iterativeResult = iterativeProcessor.processNames(names);
        System.out.println("Итеративный результат: " + iterativeResult);

        System.out.println("Исходный список (не изменился): " + names);

        // Тест с null
        System.out.println("\n--- Тест с null ---");
        System.out.println("Stream API: " + streamProcessor.processNames(null));
        System.out.println("Итеративный: " + iterativeProcessor.processNames(null));
    }
}

class NameProcessorStream {
    public List<String> processNames(List<String> names) {
        if (names == null) return Collections.emptyList();

        return names.stream()
                .filter(name -> name != null && name.length() > 1)
                .map(name -> name.substring(1))
                .sorted()
                .collect(Collectors.toList());
    }
}

class NameProcessorIterative {
    public List<String> processNames(List<String> names) {
        if (names == null) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (name != null && name.length() > 1) {
                result.add(name.substring(1));
            }
        }
        Collections.sort(result);
        return result;
    }
}