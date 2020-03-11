public class Bron {
    int wymagany_lvl;
    int obrazenia;
    boolean czyZasiegowo;
    String nazwa_broni;
    Bron(int wym, int obr, boolean czyZas, String naz){
        wymagany_lvl = wym;
        obrazenia = obr;
        czyZasiegowo = czyZas;
        nazwa_broni = naz;
    }


    String getNazwa_broni(){
        return nazwa_broni;
    }

    int getobrazenia(){
        return obrazenia;
    }
}
