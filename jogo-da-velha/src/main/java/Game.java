import java.util.Scanner;

public class Game {
    private Tabuleiro tabuleiro;
    private int turn;

    private Jogador player1;
    private Jogador player2;


    public Game(){
        this.tabuleiro = new Tabuleiro();
        this.turn = 1;
        this.player1 = new Jogador(1);
        this.player2 = new Jogador(2);
    }

    public void Start(){
        while(Play());
    }

    public boolean Play(){
        tabuleiro.show();
        if(Win() == 0){
            System.out.println("----------------------");
            System.out.println("É a vez do jogador " + turn);

            if(turn==1){
                this.player1.Play(tabuleiro);
                turn++;
            }
            else {
                this.player2.Play(tabuleiro);
                turn--;
            }
            if(tabuleiro.tabuleiroCompleto()){
                System.out.println("EMPATE");
                return false;
            }
        }
        else {
            if (Win() == 1) {
                System.out.println("JOGADOR 1 GANHOU!");
                return false;
            } else {
                System.out.println("JOGADOR 2 GANHOU!");
                return false;
            }
        }
        return true;
    }

    public int Win(){
        if(tabuleiro.checaRows() == 1 ||
           tabuleiro.checaColumns() == 1 ||
           tabuleiro.checaDiagonais() == 1){
            return 1;
        }
        if(tabuleiro.checaRows() == -1 ||
           tabuleiro.checaColumns() == -1 ||
           tabuleiro.checaDiagonais() == -1){
            return 2;
        }
        return 0;
    }
}
