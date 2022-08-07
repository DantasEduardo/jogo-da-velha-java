import java.util.Scanner;

public class Jogador {

    private int[] tentativa = new int[2];
    private int player;
    public Scanner entrada = new Scanner(System.in);

    public Jogador(int numJogador){
        this.player = numJogador;
    }


    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro){
        if(tabuleiro.getPosicao(tentativa) == 0)
            return true;
        else
            return false;

    }

    public void Play(Tabuleiro tabuleiro){
        do{
            do{
                System.out.print("Linha: ");
                tentativa[0] = entrada.nextInt();

                if( tentativa[0] > 3 ||tentativa[0] < 0)
                    System.out.println("Linha inválida. 0, 1 ou 2");

            }while( tentativa[0] > 3 ||tentativa[0] < 0);

            do{
                System.out.print("Coluna: ");
                tentativa[1] = entrada.nextInt();

                if(tentativa[1] > 3 ||tentativa[1] < 0)
                    System.out.println("Coluna inválida. 0, 1 ou 2");

            }while(tentativa[1] > 3 ||tentativa[1] < 0);

            if(!checaTentativa(tentativa, tabuleiro))
                System.out.println("Esse local já foi marcado. Tente outro.");
        }while( !checaTentativa(tentativa, tabuleiro) );

        tabuleiro.setPosicao(tentativa, this.player);
    }

}