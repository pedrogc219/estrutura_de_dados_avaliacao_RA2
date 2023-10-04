import java.util.Scanner;
import java.util.Random;

/*
Pedro Gonçalves Classen BCC4A

Somativa RA 2

 */

public class ArvoreBinariaAVL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        ArvoreBinaria arvore = new ArvoreBinaria();

        long tempoInicial;
        long tempoFinal;

        int acao;
        int valor;
        int quantidade;
        while (true) {
            System.out.println("\n----- ACOES -----");
            System.out.println("1 - Inserir um elemento");
            System.out.println("2 - Inserir valores aleatorios");
            System.out.println("3 - Remover um elemento");
            System.out.println("4 - Buscar um elemento");
            System.out.println("5 - Imprimir arvore");

            acao = scanner.nextInt();
            switch (acao) {
                case 1:
                    System.out.print("numero: ");
                    valor = scanner.nextInt();

                    tempoInicial = System.currentTimeMillis();
                    arvore.inserir(valor);
                    arvore.rebalancear();
                    tempoFinal = (System.currentTimeMillis() - tempoInicial);

                    System.out.println("Tempo de execucao em milisegundos: "+tempoFinal);
                    break;


                case 2:
                    System.out.println("Quantidade: ");
                    quantidade = scanner.nextInt();

                    tempoInicial = System.currentTimeMillis();
                    for (int i = 0; i < quantidade; i++) {
                        arvore.inserir(rand.nextInt(1000));
                        arvore.rebalancear();
                    }
                    tempoFinal = (System.currentTimeMillis() - tempoInicial);

                    System.out.println("Tempo de execucao em milisegundos: "+tempoFinal);
                    break;


                case 3:
                    System.out.print("Valor a retirar: ");
                    valor = scanner.nextInt();

                    tempoInicial = System.currentTimeMillis();
                    arvore.remover(valor);
                    arvore.rebalancear();
                    tempoFinal = (System.currentTimeMillis() - tempoInicial);

                    System.out.println("Tempo de execucao em milisegundos: "+tempoFinal);
                    break;


                case 4:
                    System.out.println("Numero a buscar: ");
                    valor = scanner.nextInt();

                    tempoInicial = System.currentTimeMillis();
                    if (arvore.buscar(valor) != null) {
                        System.out.println("valor existe");
                    } else {
                        System.out.println("Valor nao existe");
                    }
                    tempoFinal = (System.currentTimeMillis() - tempoInicial);

                    System.out.println("Tempo de execucao em milisegundos: "+tempoFinal);
                    break;

                case 5:
                    if (!arvore.vazia()) {
                        arvore.imprimir(0, null);
                    }
                    break;
            }
        }
    }
}
