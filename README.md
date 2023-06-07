# TicTacToe








public class TicTacToe {
    public static void main(String[] args) {
        int wymiar =3;
        char[][] plansza = //new char[wymiar][wymiar];
                            {{'O', 'X', 'O'},
                            {'O', 'X', ' '},
                            {' ', 'O', 'X'}};

        //nagłówki kolumn
        //System.out.println("\t0\t1\t2");
        System.out.print("\t");
        //pętla drukująca nagłówki kolumn
            for (int i = 0; i < wymiar; i++){
                System.out.print(i + "\t");
            }
        System.out.println();

            //pętla drukowanie wierszy
        for (int wiersz = 0; wiersz < wymiar; wiersz++){
            System.out.print(wiersz + ":\t");
            for (int kolumna = 0; kolumna < wymiar; kolumna++){

                System.out.print(plansza[wiersz][kolumna] + " \t");
            }
            System.out.println("");
        }
    }
}
