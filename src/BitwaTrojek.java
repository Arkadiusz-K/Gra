import java.util.Scanner;

public class BitwaTrojek extends Walka{
    void bitwa(Postac[] tablicaBohaterow){
        Postac hero1 = tablicaBohaterow[0];
        Postac hero2 = tablicaBohaterow[1];
        Postac hero3 = tablicaBohaterow[2];

        Przeciwnik[] tablicaPrzeciwnikow = new Przeciwnik[3];   // tablica trzech przeciwnikow
        losujPrzeciwnikow(tablicaPrzeciwnikow);                 // losowy przydzial wrogow
        Przeciwnik cel = wybierzCel(tablicaPrzeciwnikow);       // wybor przeciwnika do ataku
        System.out.println("cel: "+cel.getimie());

        Wojownik woj = (Wojownik)hero1;
        Wrozka wr = (Wrozka)hero3;

        while(cel.gethp()>0) {
            atak(hero1, cel);
            if (!sprawdzCzyPrzeciwnikZyje(hero1, cel)) return;
            obrona(hero1,cel);
            if (!sprawdzCzyZyje(hero1)) return;
        }
    }

    void losujPrzeciwnikow(Przeciwnik[] tablicaPrzeciwnikow){

        int[] tabelaLosujaca = new int[3];
        for(int i=0;i<3;i++){
            tabelaLosujaca[i] = (int)(Math.random()*5);
            System.out.println("wylosowane: "+tabelaLosujaca[i]);
        }
        int i=0;
        for(int j=0;j<tabelaLosujaca.length; j++){
            System.out.println("j: "+j);
            switch(tabelaLosujaca[j]){
                case 0: {
                    Potwor dzikiPies = new Potwor("Dziki Pies",1,1,2,3,"DzikiPies", true);
                    tablicaPrzeciwnikow[i] = dzikiPies;
                    i++;
                     break;
                }
                case 1: {
                    Potwor zablakanyPies = new Potwor("Zablakany pies",2,2,5,7,"Zablakany pies", true);
                    tablicaPrzeciwnikow[i] = zablakanyPies;
                    i++;
                    break;
                }
                case 2: {
                    Potwor dzikiWilk = new Potwor("Dziki Wilk",3,3,11,10,"Dziki Wilk", true);
                    tablicaPrzeciwnikow[i] = dzikiWilk;
                    i++;
                    break;
                }
                case 3: {
                    Potwor niedzwiedz = new Potwor("Niedzwiedz",2,5,20,40,"Niedzwiedz", true);
                    tablicaPrzeciwnikow[i] = niedzwiedz;
                    i++;
                    break;
                }
                case 4: {
                    Potwor boss = new Potwor("Boss",5,5,80,100,"boss", true);
                    tablicaPrzeciwnikow[i] = boss;
                    i++;
                    break;
                }
            }
        }
    }

    Przeciwnik wybierzCel(Przeciwnik[] tablicaPrzeciwnikow){
        int j=1;
        for(Przeciwnik i : tablicaPrzeciwnikow){
            System.out.println("Przeciwnik nr: "+j+" to: "+i.gettyp());
            j++;
        }
        System.out.println("Wybierz cel (zakres <1;3>): 1 jesli przeciwnik nr 1 itd");
        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();

        switch(wybor){
            case 1: {
                return tablicaPrzeciwnikow[0];
            }
            case 2: {
                return tablicaPrzeciwnikow[1];
            }
            case 3: {
                return tablicaPrzeciwnikow[2];
            }
            default: {
                System.out.println("Wybrano bledny numer przeciwnika!");
                return tablicaPrzeciwnikow[0];
            }
        }
    }
}
