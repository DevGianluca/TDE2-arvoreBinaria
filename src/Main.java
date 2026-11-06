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

        System.out.println("Digite o codigo em Morse (use '.' e '-' separados por espaco):");
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

        String resultado = tree.decode(input);
        if (resultado.isEmpty()) {
            System.out.println("\nNenhum codigo Morse valido foi reconhecido.");
            System.out.println("Dica: digite pontos '.' e tracos '-' separados por espaco (ex: ... --- ...)");
        } else {
            System.out.println("\nMensagem decodificada: " + resultado);
        }
        scanner.close();
    }
}
