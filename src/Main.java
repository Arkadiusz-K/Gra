import java.util.*;

public class Main{
    public static void main(String[] args){
        Arena walka = new Arena();
        BitwaTrojek bitwa = new BitwaTrojek();

        Przygotowanie przygotowanie = new Przygotowanie();
        Postac[] tablicaBohaterow = new Postac[2];
        int punkty = przygotowanie.wyborBohaterow(tablicaBohaterow);

        //walka.walkaZpotworem(wojownik);
        bitwa.bitwa(tablicaBohaterow,punkty);
    }
}

/*
TODO
1. GUI
2. Rozbudowa klas
3. Zbalansowanie postaci
 */