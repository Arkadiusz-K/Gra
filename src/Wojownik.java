public class Wojownik extends Postac{

    Wojownik(double m,int l, double e, double hp,String t,boolean czypo){
        moc = m;
        lvl = l;
        exp = e;
        this.hp = hp;
        typ = t;
        czyPotwor = czypo;
        wymaganeDoLvl = 5;
        iloscZyc = 3;
    }

    void furia(){
        sethp(Math.round(gethp()*0.7));
        setmoc(Math.round(getmoc()*1.4));
    }

    void punchdown(Przeciwnik cel){
        // 30% szans na uderzenie krytyczne tj. 3*silniejsze
        int szansaNaPunchdown = (int)(Math.random()*100);
        System.out.println("Pomocnicze: szansa na punchdown: "+szansaNaPunchdown);
        if(szansaNaPunchdown>70){
            System.out.println("Udalo sie! PUNCHDOWN!!!");
            cel.sethp((cel.gethp()-3*((getbron().getobrazenia()+(int)(Math.random()*5))*getmoc())));
        } else
            System.out.println("Punchdown sie nie powiodl :(");
    }
}
