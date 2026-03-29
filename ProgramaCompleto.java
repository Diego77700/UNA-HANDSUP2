import java.util.Scanner;

public class ProgramaCompleto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Mostrar desenho ASCII");
            System.out.println("2 - Calcular distância entre dois pontos");
            System.out.println("3 - Contar caracteres de uma string");
            System.out.println("4 - Questão de múltipla escolha");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    mostrarDesenho();
                    break;

                case 2:
                    calcularDistancia();
                    break;

                case 3:
                    contarCaracteres(sc);
                    break;

                case 4:
                    questaoMultiplaEscolha(sc);
                    break;

                case 0:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    
    public static void mostrarDesenho() {
        System.out.println(" +\"\"\"\"\"+");
        System.out.println("[| o o |]");
        System.out.println(" |  ^  |");
        System.out.println(" | '-' |");
        System.out.println(" +-----+");
    }

    
    public static void calcularDistancia() {
        double x1 = Math.toRadians(25);
        double y1 = Math.toRadians(35);
        double x2 = Math.toRadians(35.5);
        double y2 = Math.toRadians(25.5);

        double raio = 6371.01;

        double distancia = raio * Math.acos(
                Math.sin(x1) * Math.sin(x2) +
                Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2)
        );

        System.out.println("A distância entre esses pontos é: " + distancia + " km");
    }

    
    public static void contarCaracteres(Scanner sc) {
        System.out.print("Digite uma string: ");
        String texto = sc.nextLine();

        int letras = 0, espacos = 0, numeros = 0, outros = 0;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (Character.isLetter(c)) {
                letras++;
            } else if (Character.isDigit(c)) {
                numeros++;
            } else if (Character.isWhitespace(c)) {
                espacos++;
            } else {
                outros++;
            }
        }

        System.out.println("Letras: " + letras);
        System.out.println("Espaços: " + espacos);
        System.out.println("Números: " + numeros);
        System.out.println("Outros: " + outros);
    }

    
    public static void questaoMultiplaEscolha(Scanner sc) {
        int tentativa = 0;
        char resposta;

        do {
            tentativa++;

            System.out.println("\nQual é o resultado de 2 + 2?");
            System.out.println("(a) 3");
            System.out.println("(b) 4");
            System.out.println("(c) 5");
            System.out.println("(d) 6");
            System.out.println("(e) 7");

            System.out.print("Resposta: ");
            resposta = sc.next().charAt(0);

            switch (resposta) {
                case 'b':
                case 'B':
                    System.out.println("Resposta correta na tentativa " + tentativa);
                    return;

                case 'a': case 'A':
                case 'c': case 'C':
                case 'd': case 'D':
                case 'e': case 'E':
                    System.out.println("Resposta incorreta");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        } while (tentativa < 3);

        System.out.println("Resposta incorreta nas 3 tentativas");
    }
}