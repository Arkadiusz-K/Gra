abstract public class Przeciwnik {
    protected String imie;
    protected double moc;
    protected int lvl;
    protected double exp;
    protected double hp;
    protected String typ;
    protected boolean czyPotwor;
    protected Bron bron;
    protected double wymaganeDoLvl;
    protected int iloscZyc;
    protected int skilleObronne =0;

    String getimie(){
        return imie;
    }

    double getmoc(){
        return moc;
    }

    void setmoc(double m){
        moc = m;
    }

    int getlvl(){
        return lvl;
    }

    void setlvl(int level) {
        lvl = level;
    }

    double getexp(){
        return exp;
    }

    void setexp(double exp){
        this.exp = exp;
    }

    double gethp(){
        return hp;
    }

    void sethp(double hp){
        this.hp = hp;
    }

    String gettyp(){
        return typ;
    }

    boolean getczypotwor(){
        return czyPotwor;
    }

    Bron getbron(){
        return bron;
    }

    double getWymaganeDoLvl(){
        return wymaganeDoLvl;
    }

    void setWymaganeDoLvl(double wymagane){
        wymaganeDoLvl = wymagane;
    }

    int getilosczyc(){
        return iloscZyc;
    }

    void setIloscZyc(int ilZyc){
        iloscZyc = ilZyc;
    }

    int getSkilleObronne(){
        return skilleObronne;
    }

    void setSkilleObronne(int iloscObrony){
        skilleObronne = iloscObrony;
    }

    boolean czyZarazony = false;
    void zostalZarazonyPrzezElfa(){
        czyZarazony = true;
    }

    void sprawdzCzyZarazony(){
        if(czyZarazony) {
            int czyZarazenieOdbieraZycie = (int)(Math.random()*100);
            if(czyZarazenieOdbieraZycie>80) {
                sethp(gethp() * 0.95);
                System.out.println("W tej turze zarazenie odbiera 5% zycia przeciwnika!");
            } else
                System.out.println("W tej turze zarazenie nie odbiera zycia");
        }
    }

    public static void wait(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

}
