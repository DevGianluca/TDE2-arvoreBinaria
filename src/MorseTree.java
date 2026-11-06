public class MorseTree {
    private Node root;

    public MorseTree() {
        // A raiz é o ponto de partida (vazia/asterisco)
        root = new Node('*');
    }

    public void insert(String morseCode, char letter) {
        Node current = root;

        for(int i = 0 ; i < morseCode.length(); i++) {

            if(morseCode.charAt(i) == '-') {
                if(current.right == null) {
                    current.right = new Node('*');
                }
                current = current.right;
            }
            else if(morseCode.charAt(i) == '.') {
                if(current.left == null) {
                    current.left = new Node('*');
                }
                current = current.left;
            }
        }
        current.value = letter;
    }

    public String decode(String morseMessage) {
        StringBuilder decodedMessage = new StringBuilder();
        String[] novoTexto = morseMessage.split(" ");
        for(int i = 0; i < novoTexto.length; i++) {
            Node current = root;
            String morseAtual = novoTexto[i];
            if (morseAtual.isEmpty()) continue;
            for (char ch : morseAtual.toCharArray()) {
                if(ch == '-') {
                    current = current.right;
                }
                else if(ch == '.') {
                    current = current.left;
                }
            }
            if (current != null && current.value != '*') {
                decodedMessage.append(current.value);
            }
        }
        return decodedMessage.toString();
    }

    public void printTree() {
        System.out.println("Árvore de Código Morse:" +
                "\n");
        printTreeHelper(root, "", true);
    }

    private void printTreeHelper(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value);
            printTreeHelper(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTreeHelper(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}