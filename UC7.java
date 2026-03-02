public class UC7 {

    /**
     * Static Inner Class to encapsulate
     * a character and its banner pattern.
     */
    public static class CharacterPatternMap {

        private final char character;
        private final String[] pattern;

        /**
         * Constructor
         * @param character Character represented
         * @param pattern   7-line banner pattern
         */
        public CharacterPatternMap(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        /**
         * Getter for character
         * @return character
         */
        public char getCharacter() {
            return character;
        }

        /**
         * Getter for pattern
         * @return 7-line banner pattern
         */
        public String[] getPattern() {
            return pattern;
        }
    }

    /**
     * Retrieves character pattern from storage
     * @param ch character to search
     * @param patterns array of CharacterPatternMap
     * @return matching pattern or null
     */
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] patterns) {
        for (CharacterPatternMap cp : patterns) {
            if (cp.getCharacter() == ch) {
                return cp.getPattern();
            }
        }
        return null;
    }

    /**
     * Prints banner for given word
     * @param word word to print
     * @param patterns character storage
     */
    public static void printBanner(String word, CharacterPatternMap[] patterns) {

        for (int row = 0; row < 7; row++) {

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                String[] pattern = getCharacterPattern(word.charAt(i), patterns);

                if (pattern != null) {
                    builder.append(pattern[row]).append("  ");
                }
            }

            System.out.println(builder);
        }
    }

    /**
     * Main Method
     */
    public static void main(String[] args) {

        CharacterPatternMap patternO = new CharacterPatternMap('O', new String[]{
                " ***** ",
                "*     *",
                "*     *",
                "*     *",
                "*     *",
                "*     *",
                " ***** "
        });

        CharacterPatternMap patternP = new CharacterPatternMap('P', new String[]{
                " ***** ",
                "*     *",
                "*     *",
                " ***** ",
                "*      ",
                "*      ",
                "*      "
        });

        CharacterPatternMap patternS = new CharacterPatternMap('S', new String[]{
                " ***** ",
                "*      ",
                "*      ",
                " ***** ",
                "      *",
                "      *",
                " ***** "
        });

        CharacterPatternMap[] patterns = { patternO, patternP, patternS };

        printBanner("OOPS", patterns);
    }
}
