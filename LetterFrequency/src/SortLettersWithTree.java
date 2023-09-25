public class SortLettersWithTree {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        java.util.TreeMap<Character, Integer> mA = new java.util.TreeMap<>();
        java.util.TreeMap<Character, Integer> mB = new java.util.TreeMap<>();
        for (int i = 0; i < a.length(); i++) {
            char cA = Character.toLowerCase(a.charAt(i));
            if (mA.containsKey(cA)) mA.put(cA, mA.get(cA) + 1);
            else mA.put(cA, 1);

            char cB = Character.toLowerCase(b.charAt(i));
            if (mB.containsKey(cB)) mB.put(cB, mB.get(cB) + 1);
            else mB.put(cB, 1);
        }
        System.out.println(mA);
        System.out.println(mB);

        return mA.equals(mB);
    }

    public static void main(String[] args) {

        String a = "anagramm";
        String b = "marganaa";
        if (isAnagram(a, b)) System.out.println("Anagrams");
        else System.out.println("Not Anagrams");

        a = "anagram";
        b = "margana";
        if (isAnagram(a, b)) System.out.println("Anagrams");
        else System.out.println("Not Anagrams");

    }
}