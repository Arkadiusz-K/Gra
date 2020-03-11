abstract public class Przeciwnik {
    protected double moc;
    protected int lvl;
    protected double exp;
    protected double hp;
    protected String typ;
    protected boolean czyPotwor;
    protected Bron bron;
    protected double wymaganeDoLvl;
    protected int iloscZyc;

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
}
