import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        printOddNumbers(nums);
        System.out.println();
        nums = new ArrayList<>(List.of(1, 8, 2, 4, 10, 4, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        printSortedEvenNumbers(nums);
        System.out.println();
        List<String> words = new ArrayList<>(List.of(" Первое", " Второе", "третье", "Третье", "Третье  ", "Четвертое", "Первое", "Второе", "Пятое"));
        printUniqWords(words);
        System.out.println();
        printDuplicateNumbers(words);
        String text = "а Этот текст проверочный Текст если надо брать не список слов а одну строку слов";
        printDuplicateNumbers(text);
    }

    private static void printDuplicateNumbers(String text) {
    List<String> words = new ArrayList<String>(List.of(text.split(" ")));
    printDuplicateNumbers(words);
    }

    private static void printDuplicateNumbers(List<String> words) {
        HashMap<String, Integer> duplicatesMap = new HashMap<String, Integer>();
        for (String word : words) {
            if (duplicatesMap.containsKey(word.trim().toLowerCase())) {
                duplicatesMap.put(word.trim().toLowerCase(), duplicatesMap.get(word.trim().toLowerCase()) + 1);
            } else {
                duplicatesMap.put(word.trim().toLowerCase(), 1);
            }
        }
        for (String key : duplicatesMap.keySet()) {
            if (duplicatesMap.get(key)>1) {
                System.out.println(key + " - " + duplicatesMap.get(key));
            }
        }
    }

    private static void printUniqWords(List<String> words) {
        List<String> trimWords = new ArrayList<String>();
        for (String word : words) {
            trimWords.add(word.trim().toLowerCase());
        }
        Set<String> setWords = new HashSet<String>(trimWords);
        for (String word : setWords) {
            System.out.print(word + " ");
        }
    }

    private static void printSortedEvenNumbers(List<Integer> nums) {
        Set<Integer> setNums = new HashSet<>(nums);
        nums = new ArrayList<>(setNums);
        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (Integer num : nums) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
    }

    private static void printOddNumbers(List<Integer> nums) {
        for (Integer num : nums) {
            if (num % 2 == 1) {
                System.out.print(num + " ");
            }
        }
    }
}