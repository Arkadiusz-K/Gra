import java.util.*;

public class Main{
    public static void main(String[] args){
        Arena walka = new Arena();
        BitwaTrojek bitwa = new BitwaTrojek();

        Przygotowanie przygotowanie = new Przygotowanie();
        Postac[] tablicaBohaterow = new Postac[3];
        przygotowanie.wyborBohaterow(tablicaBohaterow);

        Bron halabarda = new Bron(15, 8, false, "halabarda");

        tablicaBohaterow[0].wezBron(halabarda);
        tablicaBohaterow[0].wezBron(halabarda);



        //walka.walkaZpotworem(wojownik);
        bitwa.bitwa(tablicaBohaterow);
    }

}

/*
TODO
1. GUI
2. System walk 3 vs 3
3. Rozdzielenie na klasy
4. W wyborze przeciwnika zmienic tablice na kontener i jesli przeciwnik pokonany to wypada z kontenera
 */