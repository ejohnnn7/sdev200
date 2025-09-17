public class GroupSymbols {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java GroupSymbol <source-file>");
            return;
        }

        // check opening symbol
        while ((ch = reader.read()) != -1) {
            char c = (char) ch;

            if (c == '(' || c == '{' || c == '[') {
                stack += c;
            }

            // check closing symbol
            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    System.out.println("Incorrect grouping pairs");
                    reader.close();
                    return;
                }
                char last = stack.charAt(stack.length() - 1);
                if (!((last == '(' && c == ')') ||
                      (last == '{' && c == '}') ||
                      (last == '[' && c == ']'))) {
                    System.out.println("Incorrect grouping pairs");
                    reader.close();
                    return;
                }
            }
        }

        if (stack.isEmpty())
            System.out.println("Correct grouping pairs");
        else
            System.out.println("Incorrect grouping pairs");
    }
}