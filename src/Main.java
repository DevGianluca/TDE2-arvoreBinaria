import java.util.Scanner;


public static void main(String[] args) {
    MorseTree tree = new MorseTree();

    // Arrays auxiliares para popular a árvore
    String[] codes = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."
    };
    char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    for (int i = 0; i < codes.length; i++) {
        tree.insert(codes[i], letters[i]);
    }
    tree.printTree();
    IO.println("Digite a sua palavra em morse para ser traduzida: ");
    Scanner scanner = new Scanner(System.in);
    String input =  scanner.nextLine();
    for (char ch : input.toCharArray()) {
        if (ch == '.') {
            Buzzer.playBeep(150); // Beep curto
            try { Thread.sleep(5); } catch (Exception e) {} // Pausa entre os bipes
        }
        else if (ch == '-') {
            Buzzer.playBeep(450); // Beep longo
            try { Thread.sleep(5); } catch (Exception e) {} // Pausa entre os bipes
        }
        else if (ch == ' ' || ch == '/') {
            try { Thread.sleep(30); } catch (Exception e) {} // Pausa maior nos espaços/separadores
        }
    }
    IO.println(tree.decode(input));
}
