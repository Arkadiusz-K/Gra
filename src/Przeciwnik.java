public class Przeciwnik {
    protected int moc;
    protected int lvl;
    protected double exp;
    protected int hp;
    protected String typ;
    protected boolean czyPotwor;
    protected Bron bron;



    int getmoc(){
        return moc;
    }

    int getlvl(){
        return lvl;
    }

    double getexp(){
        return exp;
    }

    void setexp(double exp){
        this.exp = exp;
    }

    int gethp(){
        return hp;
    }

    void sethp(int hp){
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
}
