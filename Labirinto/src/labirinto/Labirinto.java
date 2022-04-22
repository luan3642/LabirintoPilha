/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labirinto;

import java.util.Scanner;

public class Labirinto {

    Scanner scan = new Scanner(System.in);
    int linhaCoordenada = 0;
    int colunaCoordenada = 0;
    int linhaAtual = 0;
    int colunaAtual = 0;
    String[][] labirinto;
    int[][] empilhaPosicao;

 

    int linhaInicial = 0;
    int colunaInicial = 0;

    String sair = "";

    int quantidadeMaximaAndar = 0;
    int tamanho;

    public Labirinto() {
        labirinto = new String[6][8];
        empilhaPosicao = new int[20][20];
        this.linhaInicial = 1;
        this.colunaInicial = 1;
    }

    public void constroiLabirinto() {
        labirinto[0][0] = "#";
        labirinto[0][1] = "#";
        labirinto[0][2] = "#";
        labirinto[0][3] = "#";
        labirinto[0][4] = "#";
        labirinto[0][5] = "#";
        labirinto[0][6] = "#";
        labirinto[0][7] = "#";

        labirinto[1][0] = "#";
        labirinto[1][1] = "-";
        labirinto[1][2] = "#";
        labirinto[1][3] = " ";
        labirinto[1][4] = " ";
        labirinto[1][5] = " ";
        labirinto[1][6] = " ";
        labirinto[0][7] = "#";

        labirinto[2][0] = "#";
        labirinto[2][1] = " ";
        labirinto[2][2] = " ";
        labirinto[2][3] = "#";
        labirinto[2][4] = " ";
        labirinto[2][5] = "#";
        labirinto[2][6] = " ";
        labirinto[2][7] = "#";

        labirinto[3][0] = "#";
        labirinto[3][1] = " ";
        labirinto[3][2] = "#";
        labirinto[3][3] = " ";
        labirinto[3][4] = " ";
        labirinto[3][5] = "#";
        labirinto[3][6] = " ";
        labirinto[3][7] = "#";

        labirinto[4][0] = "#";
        labirinto[4][1] = " ";
        labirinto[4][2] = "#";
        labirinto[4][3] = "#";
        labirinto[4][4] = " ";
        labirinto[4][5] = "#";
        labirinto[4][6] = " ";
        labirinto[4][7] = "#";

        labirinto[5][0] = "#";
        labirinto[5][1] = " ";
        labirinto[5][2] = " ";
        labirinto[5][3] = " ";
        labirinto[5][4] = " ";
        labirinto[5][5] = " ";
        labirinto[5][6] = "S";
        labirinto[5][7] = "#";

    }

    public void mostraCoordenadaAtual() {
        System.out.println("Linha atual: " + linhaCoordenada);
        System.out.println("Coluna atual: " + colunaCoordenada);
        System.out.println("");
    }

    public void jogada() {

        linhaCoordenada = 1;
        colunaCoordenada = 1;
        empilhaPosicao[linhaInicial][colunaInicial] = 2;
        System.out.println("");
        while (!(labirinto[linhaCoordenada][colunaCoordenada].equals("S") || sair.equalsIgnoreCase("SIM"))) {
            System.out.println("");
            System.out.println("Informe a direcao");
            int direcao = scan.nextInt();
            System.out.println("");
            switch (direcao) {
                case 0:
                    try {
                    System.out.println("SUBIR");
                    linhaCoordenada -= 1;
                    linhaAtual = linhaCoordenada + 1;
                    if (labirinto[linhaCoordenada][colunaCoordenada].equals("#") || labirinto[linhaCoordenada][colunaCoordenada].equals("-")) {
                        linhaCoordenada = linhaAtual;
                        System.out.println("Direcao bloquada, ou ja preenchida");
                        mostraCoordenadaAtual();

                        
                        quantidadeMaximaAndar++;

                        // desimpilhar
                        if (quantidadeMaximaAndar == 4) {
                            System.out.println("Você tentou se movimentar para todos os lados, DESIMPILHANDO");
                            this.linhaAtual++;
                            this.labirinto[linhaCoordenada][colunaCoordenada] = " ";

                        }

                        break;
                    } else if (labirinto[linhaCoordenada][colunaCoordenada].equals("S")) {
                        System.out.println("Jogo ganho");
                        labirinto[linhaCoordenada][colunaCoordenada] = "S";
                        mostraCoordenadaAtual();
                    } else {
                        System.out.println("Direcao valida, jogada realizada");
                        labirinto[linhaCoordenada][colunaCoordenada] = "-";
                        mostraCoordenadaAtual();
                        
                        empilhaPosicao[linhaCoordenada][colunaCoordenada] = direcao;
                        tamanho++;
                    }
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Limite atingido");
                }

                case 1:
                    try {
                    System.out.println("DIREITA");
                    colunaCoordenada += 1;
                    colunaAtual = colunaCoordenada - 1;
                    if (labirinto[linhaCoordenada][colunaCoordenada].equals("#") || labirinto[linhaCoordenada][colunaCoordenada].equals("-")) {
                        colunaCoordenada = colunaAtual;
                        System.out.println("Direcao bloquada, ou ja preenchida");
                        mostraCoordenadaAtual();
                        quantidadeMaximaAndar++;
                        // DESIMPILHAR
                        if (quantidadeMaximaAndar == 4) {
                            System.out.println("Você tentou se movimentar para todos os lados, DESIMPILHANDO");
                            this.colunaCoordenada--;
                            this.labirinto[linhaCoordenada][colunaCoordenada] = " ";
                            mostraCoordenadaAtual();

                        }

                    } else if (labirinto[linhaCoordenada][colunaCoordenada].equals("S")) {
                        System.out.println("Jogo ganho");
                        labirinto[linhaCoordenada][colunaCoordenada] = "S";
                        mostraCoordenadaAtual();
                    } else {
                        System.out.println("Direcao valida, jogada realizada");
                        labirinto[linhaCoordenada][colunaCoordenada] = "-";
                        mostraCoordenadaAtual();
                        empilhaPosicao[linhaCoordenada][colunaCoordenada] = direcao;
                        tamanho++;

                    }
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Limite atingido");
                }

                case 2:
                    try {
                    System.out.println("DESCER");
                    linhaCoordenada += 1;
                    linhaAtual = linhaCoordenada - 1;
                    if (labirinto[linhaCoordenada][colunaCoordenada].equals("#") || labirinto[linhaCoordenada][colunaCoordenada].equals("-")) {
                        linhaCoordenada = linhaAtual;
                        System.out.println("Direcao bloquada, ou ja preenchida");
                        mostraCoordenadaAtual();
                        quantidadeMaximaAndar++;

                        if (quantidadeMaximaAndar == 4) {
                            System.out.println("Você tentou se movimentar para todos os lados, DESIMPILHANDO");
                            this.linhaAtual--;
                            this.labirinto[linhaCoordenada][colunaCoordenada] = " ";

                        }

                    } else if (labirinto[linhaCoordenada][colunaCoordenada].equals("S")) {
                        System.out.println("Jogo ganho");
                        labirinto[linhaCoordenada][colunaCoordenada] = "S";
                        mostraCoordenadaAtual();
                    } else {
                        System.out.println("Direcao valida, jogada realizada");
                        labirinto[linhaCoordenada][colunaCoordenada] = "-";
                        mostraCoordenadaAtual();
                        //movimento de empilhar
                        empilhaPosicao[linhaCoordenada][colunaCoordenada] = direcao;
                        tamanho++;
                    }
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Limite atingido: " + e);
                }
                case 3:
                  try {
                    System.out.println("ESQUERDA");
                    colunaCoordenada -= 1;
                    colunaAtual = colunaCoordenada + 1;
                    if (labirinto[linhaCoordenada][colunaCoordenada].equals("#") || labirinto[linhaCoordenada][colunaCoordenada].equals("-")) {
                        colunaCoordenada = colunaAtual;
                        System.out.println("Direcao bloquada, ou ja preenchida");
                        mostraCoordenadaAtual();
                        quantidadeMaximaAndar++;

                        if (quantidadeMaximaAndar == 4) {
                            System.out.println("Você tentou se movimentar para todos os lados, DESIMPILHANDO");
                            this.linhaAtual++;
                            this.labirinto[linhaCoordenada][colunaCoordenada] = " ";

                        }

                    } else if (labirinto[linhaCoordenada][colunaCoordenada].equals("S")) {
                        System.out.println("Jogo ganho");
                        labirinto[linhaCoordenada][colunaCoordenada] = "S";
                        mostraCoordenadaAtual();
                    } else {
                        System.out.println("Direção valida, jogada realizada");
                        labirinto[linhaCoordenada][colunaCoordenada] = "-";
                        mostraCoordenadaAtual();
                        empilhaPosicao[linhaCoordenada][colunaCoordenada] = direcao;
                        tamanho++;
                    }
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Limite atingido");
                }

                default:
                    System.out.println("Posição errada");
                    break;
            }

        }
        System.out.println("");
        System.out.println("Voce chegou ao fim do JOGO....");
   
    }

    public void mostraPilha() {
        for (int i = linhaInicial; i <= (tamanho+1) ; i++) {
            for (int j = colunaInicial; j <= tamanho; j++) {
                System.out.println("(" + j + "," + i + ")" + "-" + " " + empilhaPosicao[i][j]);
            }
        }
    }
    
    

}
