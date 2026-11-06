import java.util.Scanner;

public class Main {
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

        System.out.println("Digite a sua palavra em morse para ser traduzida: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        for (char ch : input.toCharArray()) {
            if (ch == '.') {
                Buzzer.playBeep(150); // Beep curto
                try { Thread.sleep(50); } catch (Exception e) {} // Pausa entre os bipes
            }
            else if (ch == '-') {
                Buzzer.playBeep(450); // Beep longo
                try { Thread.sleep(50); } catch (Exception e) {} // Pausa entre os bipes
            }
            else if (ch == ' ' || ch == '/') {
                try { Thread.sleep(150); } catch (Exception e) {} // Pausa maior nos espaços/separadores
            }
        }

        System.out.println(tree.decode(input));
        scanner.close();
    }
}
