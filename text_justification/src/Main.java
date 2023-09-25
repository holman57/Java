class text_justification {
    public static java.util.List<String> fullJustify(String[] words, int maxWidth) {
        java.util.List<String> ans = new java.util.ArrayList<>();
        int i = 0;
        while (i < words.length) {
            java.util.List<String> line = getWords(i, words, maxWidth);
            i += line.size();
            ans.add(createLine(line, i, words, maxWidth));
        }
        return ans;
    }

    private static java.util.List<String> getWords(int i, String[] words, int maxWidth) {
        java.util.List<String> line = new java.util.ArrayList<>();
        int len = 0;
        while (i < words.length && len + words[i].length() <= maxWidth) {
            line.add(words[i]);
            len += words[i].length() + 1;
            i++;
        }
        return line;
    }

    private static String createLine(java.util.List<String> line, int i, String[] words, int maxWidth) {
        int baseLength = -1;
        for (String word: line) baseLength += word.length() + 1;
        int extraSpaces = maxWidth = baseLength;
        if (line.size() == 1 || i == words.length) return String.join(" ", line) + " ".repeat(extraSpaces);
        int wordCount = line.size() - 1;
        int spacesPerWord = extraSpaces / wordCount;
        int needsExtraSpace = extraSpaces % wordCount;
        for (int j = 0; j < needsExtraSpace; j++) line.set(j, line.get(j) + " ");
        for (int j = 0; j < wordCount; j++) line.set(j, line.get(j) + " ".repeat(spacesPerWord));
        return String.join(" ", line);
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        fullJustify(words, maxWidth).forEach(System.out::println);
    }
}