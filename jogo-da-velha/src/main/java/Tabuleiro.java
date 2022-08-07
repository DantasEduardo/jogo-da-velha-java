public class Tabuleiro {
    private int[][] tabuleiro= new int[3][3];

    public Tabuleiro(){
        for(int row=0 ; row<3 ; row++)
            for(int column=0 ; column<3 ; column++)
                tabuleiro[row][column]=0;
    }



    public void show(){
        System.out.println();
        for(int row=0 ; row<3 ; row++){
            for(int column=0 ; column<3 ; column++){
                if(tabuleiro[row][column]==1){
                    System.out.print(" X ");
                }
                if(tabuleiro[row][column]==-1){
                    System.out.print(" O ");
                }
                if(tabuleiro[row][column]==0){
                    System.out.print("   ");
                }

                if(column==0 || column==1)
                    System.out.print("|");
            }
            System.out.println();
        }
    }

    public int getPosicao(int[] tentativa){
        return tabuleiro[tentativa[0]][tentativa[1]];
    }

    public void setPosicao(int[] tentativa, int jogador){
        if(jogador == 1)
            tabuleiro[tentativa[0]][tentativa[1]] = 1;//X
        else
            tabuleiro[tentativa[0]][tentativa[1]] = -1;//0
        show();
    }

    public int checaRows(){
        for(int row=0 ; row<3 ; row++){
            if( (tabuleiro[row][0] + tabuleiro[row][1] + tabuleiro[row][2]) == 3)
                return 1;
            if( (tabuleiro[row][0] + tabuleiro[row][1] + tabuleiro[row][2]) == -3)
                return -1;
        }
        return 0;
    }

    public int checaColumns(){
        for(int column=0 ; column<3 ; column++){
            if( (tabuleiro[0][column] + tabuleiro[1][column] + tabuleiro[2][column]) == 3)
                return 1;
            if( (tabuleiro[0][column] + tabuleiro[1][column] + tabuleiro[2][column]) == -3)
                return -1;
        }
        return 0;

    }

    public int checaDiagonais(){
        if( (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
            return 1;
        if( (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
            return -1;
        if( (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
            return 1;
        if( (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
            return -1;
        return 0;
    }

    public boolean tabuleiroCompleto(){
        for(int row=0 ; row<3 ; row++)
            for(int column=0 ; column<3 ; column++)
                if( tabuleiro[row][column]==0 )
                    return false;
        return true;
    }
}
