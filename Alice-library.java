public static void main(String[] args) throws IOException {
    FastScanner fs = new FastScanner();
    String s = fs.next();
    Stack<Character> S = new Stack<>();
    for (int i=0;i<s.length();++i) {
        char currentCharacter = s.charAt(i);
        if (S.empty()) {
            S.push(currentCharacter);
        } else {
            //char topCharacter = S.peek();
            if (s.charAt(i) == '\\'){
                Queue<Character> Q = new LinkedList<>();
                while (!S.empty() && S.peek()!='/'){
                    Q.add(S.peek());
                    S.pop();
                }
                if (!S.empty() && S.peek()=='/') {
                    S.pop();
                }
                while (!Q.isEmpty()){
                    S.push(Q.peek());
                    Q.poll();
                }
            } else {
                S.push(currentCharacter);
            }
        }
    }
    for (Character c:S) {
        System.out.print(c);
    }
}
