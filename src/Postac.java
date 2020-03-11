public class Postac extends Przeciwnik{

    void wezBron(Bron br){
        if(lvl>br.wymagany_lvl){
            System.out.println(typ+" wzial nowa bron!");
            bron = br;
        } else
            System.out.println(typ+" jeszcze zyje");
    }
}
