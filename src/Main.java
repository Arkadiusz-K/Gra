public class Main{
    public static void main(String[] args){
        //Arena walka = new Arena();
        BitwaTrojek bitwa = new BitwaTrojek();

        Przygotowanie przygotowanie = new Przygotowanie();
        Postac[] tablicaBohaterow = new Postac[2];
        int punkty = przygotowanie.wyborBohaterow(tablicaBohaterow);

        /*Wojownik woj = new Wojownik("Wojownik Wojciech",1,20, 0, 20, "Wojownik",false);
        Bron halabarda = new Bron(15, 8, false, "halabarda");
        woj.wezBron(halabarda);
        walka.walkaZpotworem(woj);*/
        bitwa.bitwa(tablicaBohaterow,punkty);
    }
}

/*
TODO
1. GUI
2. Rozbudowa klas o jeszcze 1 atak specjalny (poprawa koronawirusa bo drugi raz nic nie daje)
3. Zbalansowanie postaci
4. Ulepszony sposob zdobywania lvl (jakis wybor jak ulepszac postac)
 */