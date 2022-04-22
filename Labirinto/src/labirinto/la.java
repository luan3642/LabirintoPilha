/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirinto;

import java.util.Scanner;

/**
 *
 * @author luan
 */
public class la {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Labirinto labirinto = new Labirinto();

        labirinto.constroiLabirinto();
        System.out.println("0 - SUBIR");
        System.out.println("3 - ESQUERDA");
        System.out.println("2 - DESCER");
        System.out.println("1 - DIREITA");

            
            labirinto.jogada();
            labirinto.mostraPilha();
        }
        
    }


