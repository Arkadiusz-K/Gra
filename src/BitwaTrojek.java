import java.util.Scanner;

public class BitwaTrojek extends Walka{
    void bitwa(Postac[] tablicaBohaterow,int punkty){

        Przeciwnik[] tablicaPrzeciwnikow = new Przeciwnik[3];   // tablica trzech przeciwnikow
        losujPrzeciwnikow(tablicaPrzeciwnikow);                 // losowy przydzial wrogow
        Przeciwnik cel = wybierzCel(tablicaPrzeciwnikow);       // wybor przeciwnika do ataku
        System.out.println("cel: "+cel.getimie());

        switch(punkty){
            case 240: {
                // scenariusz ? i elf
                new Elf("Elf Elmir", 1,20, 0, 20, "Elf",false);
                break;
            }
            case 200: {
                // scenariusz ? i ninja
                Ninja nin = new Ninja("Ninja Marcin", 1,20, 0, 20, "Ninja",false);
                break;
            }
            case 184: {
                // scenariusz ? i wrozka
                Wrozka wr = new Wrozka("Wrozka", 1,20, 0, 20, "Wróżka",false);
                break;
            }
            case 181: {
                // scenariusz ? i wojownik
                Wojownik woj = new Wojownik("Wojownik Wojciech",1,20, 0, 20, "Wojownik",false);
                break;
            }
            case 80: {
                // scenariusz elf i ninja
                new Elf("Elf Elmir", 1,20, 0, 20, "Elf",false);
                Ninja nin = new Ninja("Ninja Marcin", 1,20, 0, 20, "Ninja",false);
                break;
            }
            case 64:{
                // scenariusz elf i wrozka
                new Elf("Elf Elmir", 1,20, 0, 20, "Elf",false);
                Wrozka wr = new Wrozka("Wrozka", 1,20, 0, 20, "Wróżka",false);
                break;
            }
            case 61: {
                // scenariusz elf i wojownik
                new Elf("Elf Elmir", 1,20, 0, 20, "Elf",false);
                Wojownik woj = new Wojownik("Wojownik Wojciech",1,20, 0, 20, "Wojownik",false);
                break;
            }
            case 24: {
                // scenariusz ninja i wrozka
                Ninja nin = new Ninja("Ninja Marcin", 1,20, 0, 20, "Ninja",false);
                Wrozka wr = new Wrozka("Wrozka", 1,20, 0, 20, "Wróżka",false);
                break;
            }
            case 21: {
                // scenariusz ninja i wojownik
                Ninja nin = new Ninja("Ninja Marcin", 1,20, 0, 20, "Ninja",false);
                Wojownik woj = new Wojownik("Wojownik Wojciech",1,20, 0, 20, "Wojownik",false);
                break;
            }
            case 5: {
                // scenariusz wrozka i wojownik
                Wojownik woj = new Wojownik("Wojownik Wojciech",1,20, 0, 20, "Wojownik",false);
                Wrozka wr = new Wrozka("Wrozka", 1,20, 0, 20, "Wróżka",false);
                Bron halabarda = new Bron(15, 8, false, "halabarda");
                woj.wezBron(halabarda);
                int tura=0;
                while(cel.gethp()>0) {
                    if(tura%3==0){
                        int losowaniePostaci = (int)(Math.random()*2);
                        if(losowaniePostaci==0){
                            // wybor ataku specjalnego wojownika
                            woj.wyborAtakuSpecjalnego(cel);
                        } else{
                            // wybor ataku specjalnego wrozki

                        }
                    }
                    atak(woj, cel);
                    if (!sprawdzCzyPrzeciwnikZyje(woj, cel)) return;
                    obrona(woj,wr,cel);
                    if (!sprawdzCzyZyje(woj)) return;
                    if (!sprawdzCzyZyje(wr)) return;
                    tura++;
                }
                break;
            }
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
