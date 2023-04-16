import java.util.*;

public class Main {
    static String[] wordsArray = new String[]{"test", "lama mala", "naan", "abba"};
    public static void main(String[] args) {
        Set<Character> result = solverTask(wordsArray);
        System.out.println(result);
    }
    private static Set<Character> solverTask(String[] wordsArray) {
        List<Set<Character>> helpList = new ArrayList<>();

        for (String word : wordsArray) {
            char[] chars = word.toCharArray();
            HashMap<Character, Integer> helpMap = new HashMap<>();

            for (Character character : chars) {
                if (character == ' ') {
                    continue;
                }
                if (helpMap.containsKey(character)) {
                    Integer value = helpMap.get(character) + 1;
                    helpMap.put(character, value);
                } else {
                    helpMap.put(character, 1);
                }
            }
            boolean isRightWord = true;
            for (Character key : helpMap.keySet()) {
                if (helpMap.get(key) % 2 != 0) {
                    isRightWord = false;
                }
            }
            if (isRightWord) {
                helpList.add(helpMap.keySet());
                if (helpList.size() == 2) break;
            }
        }
        Set<Character> result = new HashSet<>();
        for (Set<Character> stringCharSet : helpList) {
            result.addAll(stringCharSet);
        }
        return result;
    }
}
