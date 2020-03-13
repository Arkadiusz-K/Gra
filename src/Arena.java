import java.util.Scanner;

public class Arena extends Walka{

    void walkaZpotworem(Przeciwnik hero){
            Potwor cel = wybierzPotwora();
             System.out.println("cel: "+cel.gettyp());
            while(true) {
                obrona(hero, cel);
                if (!sprawdzCzyZyje(hero)) return;
                atak(hero, cel);
                if (!sprawdzCzyPrzeciwnikZyje(hero, cel)) return;
            }
    }

    // redundancja?
    Potwor wybierzPotwora(){
        System.out.println("Wybierz przeciwnika: ");
        System.out.println("1 jeśli Dziki Pies");
        System.out.println("2 jeśli Byk");
        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();
        switch(wybor){
            case 1: {
                Potwor dzikiPies = new Potwor("Dziki Pies",1,1,9,100,"DzikiPies", true);
                return dzikiPies;
            }
            case 2: {
                Potwor byk = new Potwor("Byk", 100,10, 100, 150, "Byk", true);
                return byk;
            }
            default: {
                Potwor dzikiPies1 = new Potwor("Dziki Pies Dubler",1,1,9,100,"DzikiPies", true);
                return dzikiPies1;
            }
        }
    }

    void atak(Przeciwnik hero,Przeciwnik cel){
        cel.sethp((cel.gethp()-(hero.getbron().getobrazenia()+(int)(Math.random()*5))*hero.getmoc()));
        System.out.println("hp przeciwnika po ataku mieczem: "+cel.gethp());
    }

    void obrona(Przeciwnik hero,Przeciwnik pr){
        int szansaObrony = (int)(Math.random()*100);
        System.out.println("Szansa obrony: "+szansaObrony);
        if(szansaObrony>50) return;
        System.out.println("Nie udalo obronic sie przed atakiem :(");
        hero.sethp(hero.gethp()-pr.getmoc());
        System.out.println(hero.gettyp()+" traci: "+pr.getmoc()+" i obecnie ma: "+hero.gethp()+" hp!");
    }
}
