public class Postac extends Przeciwnik{

    Postac(int m,int l, double e, int hp,String t,boolean czypo){
        moc = m;
        lvl = l;
        exp = e;
        this.hp = hp;
        typ = t;
        czyPotwor = czypo;
    }

    void wezBron(Bron br){
        if(lvl>br.wymagany_lvl){
            System.out.println(typ+" wzial nowa bron!");
            bron = br;
        } else
            System.out.println(typ+" nie moze wziac tej broni, za niski lvl!");
    }
}
