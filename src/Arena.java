import java.util.Scanner;

public class Arena extends Walka{

    void walkaZpotworem(Przeciwnik hero){
            Potwor cel = wybierzPotwora();
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
}
