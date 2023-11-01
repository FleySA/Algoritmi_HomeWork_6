import java.util.HashMap;
import java.util.Map;

public class RussianLetterFrequency {
    public static void main(String[] args) {
        String text = "Далеко-далеко за словесными горами в стране гласных и согласных...";
        text = text.toLowerCase(); // Приводим текст к нижнему регистру, чтобы учесть регистронезависимость.

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c) && c >= 'а' && c <= 'я') {
                if (frequencyMap.containsKey(c)) {
                    frequencyMap.put(c, frequencyMap.get(c) + 1);
                } else {
                    frequencyMap.put(c, 1);
                }
            }
        }

        for (char letter = 'а'; letter <= 'я'; letter++) {
            int frequency = frequencyMap.getOrDefault(letter, 0);
            System.out.println(letter + ": " + frequency);
        }
    }
}