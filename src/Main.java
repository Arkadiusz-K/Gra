import java.util.*;

public class Main {
    public static void main(String[] args){
        Arena walka = new Arena();
        BitwaTrojek bitwa = new BitwaTrojek();
        Postac wojownik = new Postac(1,20, 0, 20, "Wojownik",false);
        Postac wojownik2 = new Postac(1,20, 0, 20, "Wojownik",false);
        Postac wojownik3 = new Postac(1,20, 0, 20, "Wojownik",false);
        Bron halabarda = new Bron(15, 8, false, "halabarda");

        wojownik.wezBron(halabarda);
        wojownik2.wezBron(halabarda);
        wojownik3.wezBron(halabarda);

        walka.walkaZpotworem(wojownik);
        bitwa.bitwa(wojownik,wojownik2,wojownik3);
    }
}

/*
TODO
1. GUI
2. System walk 3 vs 3
3. Rozdzielenie na klasy
4. W wyborze przeciwnika zmienic tablice na kontener i jesli przeciwnik pokonany to wypada z kontenera
 */