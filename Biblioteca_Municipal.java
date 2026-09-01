/*
 * Este programa implementa um sistema simples de gestão
 * de uma Biblioteca Municipal.
 */

package com.dausse.biblioteca_municipal;

// Importa a classe Scanner para permitir a entrada de dados pelo teclado
import java.util.Scanner;

public class Biblioteca_Municipal {

    /*
     * ARRAYS
     * 
     * Os arrays servem para armazenar os dados dos livros.
     * Cada posição do array representa um livro.
     *
     * Exemplo:
     * posição 0 = primeiro livro
     * posição 1 = segundo livro
     * posição 2 = terceiro livro
     */

    // Array que armazena o ID dos livros
    static String[] ids = new String[100];

    // Array que armazena o título dos livros
    static String[] titulos = new String[100];

    // Array que armazena o nome dos autores
    static String[] autores = new String[100];

    // Array que armazena o ano de publicação
    static int[] anos = new int[100];

    // Array que armazena a quantidade disponível de cada livro
    static int[] quantidades = new int[100];


    /*
     * Variável que controla a quantidade de livros registados.
     *
     * Inicialmente não existe nenhum livro:
     * totalLivros = 0
     */
    static int totalLivros = 0;


    /*
     * ARRAY BIDIMENSIONAL DE EMPRÉSTIMOS
     *
     * A primeira dimensão representa o número do empréstimo.
     *
     * A segunda dimensão possui 2 posições:
     *
     * [0] = ID do livro
     * [1] = Nome do utilizador
     *
     * Exemplo:
     * emprestimos[0][0] = "L001"
     * emprestimos[0][1] = "Eduardo"
     */
    static String[][] emprestimos = new String[100][2];


    // Controla o número total de empréstimos realizados
    static int totalEmprestimos = 0;


    /*
     * OBJETO SCANNER
     *
     * Permite receber informações introduzidas
     * pelo utilizador através do teclado.
     */
    static Scanner sc = new Scanner(System.in);


    /*
     * =====================================================
     * MÉTODO PRINCIPAL - main()
     * =====================================================
     *
     * O método main() é o ponto de entrada do programa.
     *
     * É a partir deste método que o programa começa a executar.
     */
    public static void main(String[] args) {

        // Variável que irá armazenar a opção escolhida no menu
        int opcao;


        /*
         * =================================================
         * CICLO DO-WHILE
         * =================================================
         *
         * O menu será apresentado pelo menos uma vez.
         *
         * O programa continuará a executar enquanto
         * a opção escolhida for diferente de 8.
         */
        do {

            // Apresenta o título do sistema
            System.out.println("\n===== BIBLIOTECA MUNICIPAL =====");

            // Apresenta as opções disponíveis
            System.out.println("1. Registar Livro");
            System.out.println("2. Consultar Catalogo");
            System.out.println("3. Pesquisar por Titulo");
            System.out.println("4. Pesquisar por Autor");
            System.out.println("5. Efectuar Emprestimo");
            System.out.println("6. Efectuar Devolucao");
            System.out.println("7. Estatisticas");
            System.out.println("8. Sair");


            // Solicita ao utilizador que escolha uma opção
            System.out.print("Opcao: ");

            // Lê um número inteiro introduzido pelo utilizador
            opcao = sc.nextInt();

            /*
             * Limpa o ENTER que ficou no buffer depois
             * de utilizar nextInt().
             *
             * Isto permite utilizar posteriormente nextLine().
             */
            sc.nextLine();


            /*
             * =================================================
             * SWITCH
             * =================================================
             *
             * O switch verifica qual opção foi escolhida
             * e executa o método correspondente.
             */
            switch(opcao) {

                // Se escolher 1, chama o método registarLivro()
                case 1:
                    registarLivro();
                    break;


                // Se escolher 2, chama o método listarLivros()
                case 2:
                    listarLivros();
                    break;


                // Se escolher 3, chama o método pesquisarTitulo()
                case 3:
                    pesquisarTitulo();
                    break;


                // Se escolher 4, chama o método pesquisarAutor()
                case 4:
                    pesquisarAutor();
                    break;


                // Se escolher 5, chama o método emprestarLivro()
                case 5:
                    emprestarLivro();
                    break;


                // Se escolher 6, chama o método devolverLivro()
                case 6:
                    devolverLivro();
                    break;


                // Se escolher 7, chama o método estatisticas()
                case 7:
                    estatisticas();
                    break;


                // Se escolher 8, encerra o programa
                case 8:
                    System.out.println("Programa encerrado.");
                    break;


                // Caso o utilizador introduza uma opção inexistente
                default:
                    System.out.println("Opcao inválida!");
            }

        /*
         * O ciclo continua enquanto a opção não for 8.
         */
        } while(opcao != 8);

    }


    /*
     * =====================================================
     * MÉTODO: registarLivro()
     * =====================================================
     *
     * OBJETIVO:
     * Registar um novo livro no sistema.
     *
     * Este método:
     * 1. Solicita o ID
     * 2. Solicita o título
     * 3. Solicita o autor
     * 4. Solicita o ano
     * 5. Solicita a quantidade
     * 6. Incrementa o número total de livros
     */
    static void registarLivro() {

        // Solicita o ID do livro
        System.out.print("ID: ");

        // Guarda o ID na posição correspondente ao livro atual
        ids[totalLivros] = sc.nextLine();


        // Solicita o título
        System.out.print("Titulo: ");

        // Guarda o título na mesma posição do ID
        titulos[totalLivros] = sc.nextLine();


        // Solicita o autor
        System.out.print("Autor: ");

        // Guarda o autor
        autores[totalLivros] = sc.nextLine();


        // Solicita o ano de publicação
        System.out.print("Ano: ");

        // Lê e guarda o ano
        anos[totalLivros] = sc.nextInt();


        // Solicita a quantidade de exemplares
        System.out.print("Quantidade: ");

        // Lê e guarda a quantidade
        quantidades[totalLivros] = sc.nextInt();


        /*
         * Incrementa o número de livros.
         *
         * Exemplo:
         * 0 livros -> 1 livro
         * 1 livro  -> 2 livros
         * 2 livros -> 3 livros
         */
        totalLivros++;


        // Informa ao utilizador que o cadastro foi concluído
        System.out.println("Livro registado com sucesso!");
    }


    /*
     * =====================================================
     * MÉTODO: listarLivros()
     * =====================================================
     *
     * OBJETIVO:
     * Apresentar todos os livros registados na biblioteca.
     */
    static void listarLivros() {

        // Apresenta o título da lista
        System.out.println("\n===== CATALOGO =====");


        /*
         * FOR
         *
         * Percorre todos os livros registados.
         *
         * A variável i representa a posição do livro.
         */
        for(int i = 0; i < totalLivros; i++) {

            // Apresenta o ID
            System.out.println("ID: " + ids[i]);

            // Apresenta o título
            System.out.println("Titulo: " + titulos[i]);

            // Apresenta o autor
            System.out.println("Autor: " + autores[i]);

            // Apresenta o ano
            System.out.println("Ano: " + anos[i]);

            // Apresenta a quantidade disponível
            System.out.println("Quantidade: " + quantidades[i]);

            // Linha de separação entre livros
            System.out.println("-----------------------");
        }
    }


    /*
     * =====================================================
     * MÉTODO: pesquisarTitulo()
     * =====================================================
     *
     * OBJETIVO:
     * Procurar um livro pelo seu título.
     */
    static void pesquisarTitulo() {

        // Solicita o título que o utilizador deseja pesquisar
        System.out.print("Digite o titulo: ");

        // Lê o título introduzido
        String titulo = sc.nextLine();


        /*
         * Percorre todos os livros registados
         * procurando o título informado.
         */
        for(int i = 0; i < totalLivros; i++) {


            /*
             * equalsIgnoreCase()
             *
             * Compara dois textos ignorando maiúsculas
             * e minúsculas.
             *
             * Exemplo:
             * "Java" = "java"
             */
            if(titulos[i].equalsIgnoreCase(titulo)) {

                // Informa que o livro foi encontrado
                System.out.println("Livro encontrado:");

                // Apresenta o título e o autor
                System.out.println(titulos[i] + " - " + autores[i]);


                /*
                 * return
                 *
                 * Termina o método imediatamente porque
                 * o livro já foi encontrado.
                 */
                return;
            }
        }


        // Se terminar o FOR sem encontrar o livro
        System.out.println("Livro nao encontrado.");
    }


    /*
     * =====================================================
     * MÉTODO: pesquisarAutor()
     * =====================================================
     *
     * OBJETIVO:
     * Procurar todos os livros de determinado autor.
     */
    static void pesquisarAutor() {

        // Solicita o nome do autor
        System.out.print("Digite o autor: ");

        // Lê o nome do autor
        String autor = sc.nextLine();


        /*
         * Percorre todos os livros registados.
         */
        for(int i = 0; i < totalLivros; i++) {


            // Verifica se o autor do livro corresponde ao pesquisado
            if(autores[i].equalsIgnoreCase(autor)) {

                // Apresenta o título do livro encontrado
                System.out.println(titulos[i]);
            }
        }
    }


    /*
     * =====================================================
     * MÉTODO: emprestarLivro()
     * =====================================================
     *
     * OBJETIVO:
     * Registar o empréstimo de um livro.
     *
     * O método:
     * 1. Recebe o ID do livro
     * 2. Procura o livro
     * 3. Verifica se existe quantidade disponível
     * 4. Solicita o nome do utilizador
     * 5. Diminui a quantidade disponível
     * 6. Regista o empréstimo
     */
    static void emprestarLivro() {

        // Solicita o ID do livro
        System.out.print("ID do Livro: ");

        // Guarda o ID informado
        String id = sc.nextLine();


        /*
         * Percorre todos os livros procurando
         * o ID informado.
         */
        for(int i = 0; i < totalLivros; i++) {


            // Verifica se encontrou o livro
            if(ids[i].equals(id)) {


                /*
                 * Verifica se existe pelo menos um
                 * exemplar disponível.
                 */
                if(quantidades[i] > 0) {


                    // Solicita o nome do utilizador
                    System.out.print("Nome do utilizador: ");

                    // Guarda o nome
                    String utilizador = sc.nextLine();


                    /*
                     * Diminui a quantidade disponível em 1.
                     *
                     * Exemplo:
                     * 10 livros disponíveis
                     * depois do empréstimo = 9
                     */
                    quantidades[i]--;


                    /*
                     * Guarda o empréstimo no array.
                     *
                     * [0] = ID do livro
                     * [1] = Nome do utilizador
                     */
                    emprestimos[totalEmprestimos][0] = id;
                    emprestimos[totalEmprestimos][1] = utilizador;


                    // Incrementa o número total de empréstimos
                    totalEmprestimos++;


                    // Informa que o empréstimo foi realizado
                    System.out.println("Emprestimo registado.");

                } else {

                    /*
                     * Se a quantidade for 0,
                     * o livro não está disponível.
                     */
                    System.out.println("Livro indisponivel.");
                }


                /*
                 * O livro já foi encontrado.
                 * Portanto, termina o método.
                 */
                return;
            }
        }


        /*
         * Se o FOR terminar sem encontrar o ID,
         * significa que o livro não existe.
         */
        System.out.println("Livro nao encontrado.");
    }


    /*
     * =====================================================
     * MÉTODO: devolverLivro()
     * =====================================================
     *
     * OBJETIVO:
     * Registar a devolução de um livro.
     *
     * Quando um livro é devolvido,
     * a quantidade disponível aumenta em 1.
     */
    static void devolverLivro() {

        // Solicita o ID do livro
        System.out.print("ID do Livro: ");

        // Lê o ID
        String id = sc.nextLine();


        /*
         * Percorre todos os livros procurando
         * o ID informado.
         */
        for(int i = 0; i < totalLivros; i++) {


            // Verifica se encontrou o livro
            if(ids[i].equals(id)) {


                /*
                 * Aumenta a quantidade disponível.
                 *
                 * Exemplo:
                 * 9 livros disponíveis
                 * após devolução = 10
                 */
                quantidades[i]++;


                // Informa que a devolução foi registada
                System.out.println("Devolucao registada.");


                // Termina o método
                return;
            }
        }


        // Caso o livro não seja encontrado
        System.out.println("Livro nao encontrado.");
    }


    /*
     * =====================================================
     * MÉTODO: estatisticas()
     * =====================================================
     *
     * OBJETIVO:
     * Apresentar informações estatísticas da biblioteca.
     *
     * Atualmente apresenta:
     * - Total de empréstimos
     * - Livro mais emprestado
     */
    static void estatisticas() {


        // Apresenta o número total de empréstimos
        System.out.println(
            "Total de emprestimos: " + totalEmprestimos
        );


        /*
         * Variável que irá guardar o maior número
         * de empréstimos encontrado.
         *
         * Começa com -1 para garantir que o primeiro
         * livro possa ser considerado.
         */
        int max = -1;


        // Variável que irá guardar o título do livro mais emprestado
        String livroMaisEmprestado = "";


        /*
         * PRIMEIRO FOR
         *
         * Percorre todos os livros.
         */
        for(int i = 0; i < totalLivros; i++) {


            /*
             * Contador de empréstimos do livro atual.
             *
             * Para cada livro começamos a contagem em zero.
             */
            int contador = 0;


            /*
             * SEGUNDO FOR
             *
             * Percorre todos os empréstimos realizados.
             *
             * Este FOR está dentro do primeiro FOR.
             */
            for(int j = 0; j < totalEmprestimos; j++) {


                /*
                 * Verifica se o ID do livro atual
                 * é igual ao ID armazenado no empréstimo.
                 */
                if(ids[i].equals(emprestimos[j][0])) {

                    /*
                     * Se forem iguais,
                     * aumenta o contador.
                     */
                    contador++;
                }
            }


            /*
             * Verifica se o número de empréstimos
             * deste livro é maior que o máximo
             * encontrado anteriormente.
             */
            if(contador > max) {

                // Atualiza o maior número de empréstimos
                max = contador;

                // Guarda o título do livro
                livroMaisEmprestado = titulos[i];
            }
        }


        /*
         * Verifica se existe pelo menos um empréstimo.
         */
        if(max > 0) {


            // Apresenta o livro mais emprestado
            System.out.println(
                "Livro mais emprestado: "
                + livroMaisEmprestado
                + " (" + max + " emprestimos)"
            );
        }

    }
}