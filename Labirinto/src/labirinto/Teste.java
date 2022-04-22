
package labirinto;

import java.util.Scanner;


 *
 * @author lua
 */
public class Teste {
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
