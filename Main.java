
//Atividade - 1
/* public class Main {
    // Método para encontrar e imprimir o maior entre dois números inteiros
    public static void encontrarMaior(int num1, int num2) {
        if (num1 > num2) {
            System.out.println("O maior número é: " + num1);
        } else if (num2 > num1) {
            System.out.println("O maior número é: " + num2);
        } else {
            System.out.println("Os números são iguais: " + num1);
        }
    }
  
    // Método main para teste
    public static void main(String[] args) {
        // Teste do método encontrarMaior
        int numero1 = 10;
        int numero2 = 20;
        encontrarMaior(numero1, numero2);
        
        // Teste com números iguais
        int numero3 = 30;
        int numero4 = 30;
        encontrarMaior(numero3, numero4);
    }
  }
   */


//////////////////////////////////////////////////////////////////////////


   //Atividade -2 
 /*  public class Main {
    // Método para imprimir um número inteiro em ordem decrescente até 0
    public static void imprimirDecrescente(int numero) {
        // Verifica se o número é positivo
        if (numero >= 0) {
            for (int i = numero; i >= 0; i--) {
                System.out.println(i);
            }
        } else {
            System.out.println("O número deve ser positivo.");
        }
    }
  
    // Método main para teste
    public static void main(String[] args) {
        // Teste do método imprimirDecrescente
        int numero = 10;
        System.out.println("Imprimindo em ordem decrescente até 0:");
        imprimirDecrescente(numero);
    }
  } */
  
////////////////////////////////////////////////////////////////////////

    // Atividade - 3
/*public class Main {
    // Método para calcular a soma dos números ímpares entre 0 e 30
    public static int somaImpares() {
        int soma = 0;
        for (int i = 1; i <= 30; i += 2) {
            soma += i;
        }
        return soma;
    }

    // Método para calcular a multiplicação dos números pares entre 0 e 30
    public static long multiplicacaoPares() {
        long multiplicacao = 1;
        for (int i = 2; i <= 30; i += 2) {
            multiplicacao *= i;
        }
        return multiplicacao;
    }

    // Método main para imprimir os resultados
    public static void main(String[] args) {
        // Calcula a soma dos números ímpares e imprime
        int soma = somaImpares();
        System.out.println("A soma dos números ímpares entre 0 e 30 é: " + soma);

        // Calcula a multiplicação dos números pares e imprime
        long multiplicacao = multiplicacaoPares();
        System.out.println("A multiplicação dos números pares entre 0 e 30 é: " + multiplicacao);
    }
}  */

////////////////////////////////////////////////////////////////////////////////////////////

//Atividade - 3 

/*public class Main {
    // Método para comparar dois números e mostrar se são iguais ou diferentes,
    // e mostrar o maior e o menor número
    public static void compararNumeros(int num1, int num2) {
        if (num1 == num2) {
            System.out.println("Os números são iguais.");
            System.out.println("Maior número: " + num1);
            System.out.println("Menor número: " + num2);
        } else {
            System.out.println("Os números são diferentes.");
            System.out.println("Maior número: " + Math.max(num1, num2));
            System.out.println("Menor número: " + Math.min(num1, num2));
        }
    }

    // Método main para teste
    public static void main(String[] args) {
        // Teste do método compararNumeros
        int numero1 = 10;
        int numero2 = 20;
        compararNumeros(numero1, numero2);
    }
} */

//////////////////////////////////////////////////////////////////////////////
// Atividade - 5
import java.util.Scanner;

public class Main {
    private static char[][] tabuleiro = new char[3][3];
    private static char jogadorAtual = 'X';
    private static boolean jogoEmAndamento = true;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarTabuleiro();
        while (jogoEmAndamento) {
            exibirTabuleiro();
            fazerJogada();
            verificarFimDeJogo();
            trocarJogador();
        }
        exibirTabuleiro();
        scanner.close();
    }

    private static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    private static void exibirTabuleiro() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fazerJogada() {
        int linha, coluna;
        do {
            System.out.println("Jogador " + jogadorAtual + ", informe a linha e a coluna da sua jogada (ex: 0 0):");
            linha = scanner.nextInt();
            coluna = scanner.nextInt();
        } while (!jogadaValida(linha, coluna));
        tabuleiro[linha][coluna] = jogadorAtual;
    }

    private static boolean jogadaValida(int linha, int coluna) {
        if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3 || tabuleiro[linha][coluna] != '-') {
            System.out.println("Jogada inválida. Tente novamente.");
            return false;
        }
        return true;
    }

    private static void verificarFimDeJogo() {
        if (verificarVitoria()) {
            System.out.println("Jogador " + jogadorAtual + " venceu!");
            jogoEmAndamento = false;
        } else if (verificarEmpate()) {
            System.out.println("O jogo empatou!");
            jogoEmAndamento = false;
        }
    }

    private static boolean verificarVitoria() {
        return (verificarLinhas() || verificarColunas() || verificarDiagonais());
    }

    private static boolean verificarLinhas() {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                return true;
            }
        }
        return false;
    }

    private static boolean verificarColunas() {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) {
                return true;
            }
        }
        return false;
    }

    private static boolean verificarDiagonais() {
        return ((tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) ||
                (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual));
    }

    private static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }
}


