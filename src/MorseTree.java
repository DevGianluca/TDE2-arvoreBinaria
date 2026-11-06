public class MorseTree {
    private Node root;

    public MorseTree() {
        // A raiz é o ponto de partida (vazia/asterisco)
        root = new Node('*');
    }

    public void insert(String morseCode, char letter) {
        if (morseCode == null || morseCode.isEmpty()) {
            return;
        }

        Node current = root;

        for (int i = 0; i < morseCode.length(); i++) {
            if (morseCode.charAt(i) == '-') {
                if (current.right == null) {
                    current.right = new Node('*');
                }
                current = current.right;
            } else if (morseCode.charAt(i) == '.') {
                if (current.left == null) {
                    current.left = new Node('*');
                }
                current = current.left;
            }
        }
        current.value = letter;
    }

    public String decode(String morseMessage) {
        if (morseMessage == null || morseMessage.trim().isEmpty()) {
            return "";
        }

        StringBuilder decodedMessage = new StringBuilder();
        // Garante que o separador de palavras (/) seja tratado como token isolado
        String[] novoTexto = morseMessage.replace("/", " / ").trim().split("\\s+");

        for (String morseAtual : novoTexto) {
            if (morseAtual.isEmpty()) continue;

            if (morseAtual.equals("/")) {
                decodedMessage.append(' ');
                continue;
            }

            Node current = root;
            for (char ch : morseAtual.toCharArray()) {
                if (current == null) {
                    break;
                }
                if (ch == '-') {
                    current = current.right;
                } else if (ch == '.') {
                    current = current.left;
                } else {
                    current = null;
                    break;
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