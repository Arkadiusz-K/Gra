import java.util.Scanner;

public class BitwaTrojek extends Walka{
    void bitwa(Postac[] tablicaBohaterow,int punkty){

            Potwor[] tablicaPrzeciwnikow = new Potwor[3];   // tablica trzech przeciwnikow
            losujPrzeciwnikow(tablicaPrzeciwnikow);                 // losowy przydzial wrogow
            Przeciwnik cel = wybierzCel(tablicaPrzeciwnikow);       // wybor przeciwnika do ataku
            System.out.println("cel: " + cel.getimie());

            int lvlPrzeciwnika = 1;

            switch (punkty) {
                case 80: {
                    // scenariusz elf i ninja
                    Elf elf = new Elf("Elf Elmir", 1, 20, 0, 20, "Elf", false);
                    Ninja nin = new Ninja("Ninja Marcin", 1, 20, 0, 20, "Ninja", false);
                    Postac pom = new Postac("pomocnik", 1, 1, 1, 1, "Nikt", false);

                    boolean czyZyje = true;
                    while(czyZyje) {
                        Potwor rywal = przygodaWyborPrzeciwnika(lvlPrzeciwnika);
                        lvlPrzeciwnika++;
                        int tura = 0;
                        boolean ninjaZyje = true;
                        boolean elfZyje = true;

                        // WALKA
                        while (rywal.gethp() > 0 && czyZyje) {
                            if (tura % 3 == 0) {
                                if (ninjaZyje && elfZyje) {
                                    int losowaniePostaci = (int) (Math.random() * 2);
                                    if (losowaniePostaci == 0) {
                                        // wybor ataku specjalnego wojownika
                                        nin.wyborAtakuSpecjalnego(rywal,elf);
                                    } else {
                                        // wybor ataku specjalnego wrozki
                                        elf.wyborAtakuSpecjalnego(rywal);
                                    }
                                } else if (ninjaZyje) nin.wyborAtakuSpecjalnego(rywal,elf);
                                else elf.wyborAtakuSpecjalnego(rywal);
                            }

                            // Atakowac moze tylko zywy
                            if (ninjaZyje && elfZyje)
                                atak(nin, elf, rywal);
                            else if (ninjaZyje)
                                atak(nin, pom, rywal);
                            else
                                atak(elf, pom, rywal);

                            // Jesli przeciwnik nie zyje nie mozna kontynuowac walki
                            if (sprawdzCzyPrzeciwnikZyje(nin, elf, rywal)) {

                                // Bronic sie moze tylko zywy
                                if (ninjaZyje && elfZyje)
                                    obrona(nin, elf, rywal);
                                else if (ninjaZyje)
                                    obrona(nin, rywal);
                                else
                                    obrona(elf, rywal);

                                if (!sprawdzCzyZyje(nin)) ninjaZyje = false;
                                if (!sprawdzCzyZyje(elf)) elfZyje = false;
                                if (!ninjaZyje && !elfZyje) czyZyje=false;
                            }
                            tura++;
                        }
                    }
                    break;
                }
                case 64: {
                    // scenariusz elf i wrozka
                    Elf elf = new Elf("Elf Elmir", 1, 20, 0, 20, "Elf", false);
                    Wrozka wr = new Wrozka("Wrozka", 1, 20, 0, 20, "Wróżka", false);
                    Postac pom = new Postac("pomocnik", 1, 1, 1, 1, "Nikt", false);

                    boolean czyZyje = true;
                    while(czyZyje) {
                        Potwor rywal = przygodaWyborPrzeciwnika(lvlPrzeciwnika);
                        lvlPrzeciwnika++;
                        int tura = 0;
                        boolean wrozkaZyje = true;
                        boolean elfZyje = true;

                        // WALKA
                        while (rywal.gethp() > 0 && czyZyje) {
                            if (tura % 3 == 0) {
                                if (wrozkaZyje && elfZyje) {
                                    int losowaniePostaci = (int) (Math.random() * 2);
                                    if (losowaniePostaci == 0) {
                                        // wybor ataku specjalnego wojownika
                                        wr.wyborAtakuSpecjalnego(rywal,elf);
                                    } else {
                                        // wybor ataku specjalnego wrozki
                                        elf.wyborAtakuSpecjalnego(rywal);
                                    }
                                } else if (wrozkaZyje) wr.wyborAtakuSpecjalnego(rywal,elf);
                                else elf.wyborAtakuSpecjalnego(rywal);
                            }

                            // Atakowac moze tylko zywy
                            if (wrozkaZyje && elfZyje)
                                atak(wr, elf, rywal);
                            else if (wrozkaZyje)
                                atak(wr, pom, rywal);
                            else
                                atak(elf, pom, rywal);

                            // Jesli przeciwnik nie zyje nie mozna kontynuowac walki
                            if (sprawdzCzyPrzeciwnikZyje(wr, elf, rywal)) {

                                // Bronic sie moze tylko zywy
                                if (wrozkaZyje && elfZyje)
                                    obrona(wr, elf, rywal);
                                else if (wrozkaZyje)
                                    obrona(wr, rywal);
                                else
                                    obrona(elf, rywal);

                                if (!sprawdzCzyZyje(wr)) wrozkaZyje = false;
                                if (!sprawdzCzyZyje(elf)) elfZyje = false;
                                if (!wrozkaZyje && !elfZyje) czyZyje=false;
                            }
                            tura++;
                        }
                    }
                    break;
                }
                case 61: {
                    // scenariusz elf i wojownik
                    Elf elf = new Elf("Elf Elmir", 1, 20, 0, 20, "Elf", false);
                    Wojownik woj = new Wojownik("Wojownik Wojciech", 1, 20, 0, 20, "Wojownik", false);
                    Bron halabarda = new Bron(15, 8, false, "halabarda");
                    woj.wezBron(halabarda);
                    Postac pom = new Postac("pomocnik", 1, 1, 1, 1, "Nikt", false);

                    boolean czyZyje = true;
                    while(czyZyje) {
                        Potwor rywal = przygodaWyborPrzeciwnika(lvlPrzeciwnika);
                        lvlPrzeciwnika++;
                        int tura = 0;
                        boolean wojownikZyje = true;
                        boolean elfZyje = true;

                        // WALKA
                        while (rywal.gethp() > 0 && czyZyje) {
                            if (tura % 3 == 0) {
                                if (wojownikZyje && elfZyje) {
                                    int losowaniePostaci = (int) (Math.random() * 2);
                                    if (losowaniePostaci == 0) {
                                        // wybor ataku specjalnego wojownika
                                        woj.wyborAtakuSpecjalnego(rywal);
                                    } else {
                                        // wybor ataku specjalnego wrozki
                                        elf.wyborAtakuSpecjalnego(rywal);
                                    }
                                } else if (wojownikZyje) woj.wyborAtakuSpecjalnego(rywal);
                                else elf.wyborAtakuSpecjalnego(rywal);
                            }

                            // Atakowac moze tylko zywy
                            if (wojownikZyje && elfZyje)
                                atak(woj, elf, rywal);
                            else if (wojownikZyje)
                                atak(woj, pom, rywal);
                            else
                                atak(elf, pom, rywal);

                            // Jesli przeciwnik nie zyje nie mozna kontynuowac walki
                            if (sprawdzCzyPrzeciwnikZyje(woj, elf, rywal)) {

                                // Bronic sie moze tylko zywy
                                if (wojownikZyje && elfZyje)
                                    obrona(woj, elf, rywal);
                                else if (wojownikZyje)
                                    obrona(woj, rywal);
                                else
                                    obrona(elf, rywal);

                                if (!sprawdzCzyZyje(woj)) wojownikZyje = false;
                                if (!sprawdzCzyZyje(elf)) elfZyje = false;
                                if (!wojownikZyje && !elfZyje) czyZyje=false;
                            }
                            tura++;
                        }
                    }
                    break;
                }
                case 24: {
                    // scenariusz ninja i wrozka
                    Ninja nin = new Ninja("Ninja Marcin", 1, 20, 0, 20, "Ninja", false);
                    Wrozka wr = new Wrozka("Wrozka", 1, 20, 0, 20, "Wróżka", false);
                    Postac pom = new Postac("pomocnik", 1, 1, 1, 1, "Nikt", false);

                    boolean czyZyje = true;
                    while(czyZyje) {
                        Potwor rywal = przygodaWyborPrzeciwnika(lvlPrzeciwnika);
                        lvlPrzeciwnika++;
                        int tura = 0;
                        boolean wrozkaZyje = true;
                        boolean ninjaZyje = true;

                        // WALKA
                        while (rywal.gethp() > 0 && czyZyje) {
                            if (tura % 3 == 0) {
                                if (wrozkaZyje && ninjaZyje) {
                                    int losowaniePostaci = (int) (Math.random() * 2);
                                    if (losowaniePostaci == 0) {
                                        // wybor ataku specjalnego wojownika
                                        wr.wyborAtakuSpecjalnego(rywal,nin);
                                    } else {
                                        // wybor ataku specjalnego wrozki
                                        nin.wyborAtakuSpecjalnego(rywal, nin);
                                    }
                                } else if (wrozkaZyje) wr.wyborAtakuSpecjalnego(rywal,nin);
                                else nin.wyborAtakuSpecjalnego(rywal, wr);
                            }

                            // Atakowac moze tylko zywy
                            if (wrozkaZyje && ninjaZyje)
                                atak(wr, nin, rywal);
                            else if (wrozkaZyje)
                                atak(wr, pom, rywal);
                            else
                                atak(nin, pom, rywal);

                            // Jesli przeciwnik nie zyje nie mozna kontynuowac walki
                            if (sprawdzCzyPrzeciwnikZyje(wr, nin, rywal)) {

                                // Bronic sie moze tylko zywy
                                if (wrozkaZyje && ninjaZyje)
                                    obrona(wr, nin, rywal);
                                else if (wrozkaZyje)
                                    obrona(wr, rywal);
                                else
                                    obrona(nin, rywal);

                                if (!sprawdzCzyZyje(wr)) wrozkaZyje = false;
                                if (!sprawdzCzyZyje(nin)) ninjaZyje = false;
                                if (!wrozkaZyje && !ninjaZyje) czyZyje=false;
                            }
                            tura++;
                        }
                    }
                    break;
                }
                case 21: {
                    // scenariusz ninja i wojownik
                    // PRZYGOTOWANIE
                    Ninja nin = new Ninja("Ninja Marcin", 1, 20, 0, 20, "Ninja", false);
                    Wojownik woj = new Wojownik("Wojownik Wojciech", 1, 20, 0, 20, "Wojownik", false);
                    Bron halabarda = new Bron(15, 8, false, "halabarda");
                    woj.wezBron(halabarda);
                    Postac pom = new Postac("pomocnik", 1, 1, 1, 1, "Nikt", false);

                    boolean czyZyje = true;
                    while(czyZyje) {
                        Potwor rywal = przygodaWyborPrzeciwnika(lvlPrzeciwnika);
                        lvlPrzeciwnika++;
                        int tura = 0;
                        boolean wojownikZyje = true;
                        boolean ninjaZyje = true;

                        // WALKA
                        while (rywal.gethp() > 0 && czyZyje) {
                            if (tura % 3 == 0) {
                                if (wojownikZyje && ninjaZyje) {
                                    int losowaniePostaci = (int) (Math.random() * 2);
                                    if (losowaniePostaci == 0) {
                                        // wybor ataku specjalnego wojownika
                                        woj.wyborAtakuSpecjalnego(rywal);
                                    } else {
                                        // wybor ataku specjalnego wrozki
                                        nin.wyborAtakuSpecjalnego(rywal, woj);
                                    }
                                } else if (wojownikZyje) woj.wyborAtakuSpecjalnego(rywal);
                                else nin.wyborAtakuSpecjalnego(rywal, woj);
                            }

                            // Atakowac moze tylko zywy
                            if (wojownikZyje && ninjaZyje)
                                atak(woj, nin, rywal);
                            else if (wojownikZyje)
                                atak(woj, pom, rywal);
                            else
                                atak(nin, pom, rywal);

                            // Jesli przeciwnik nie zyje nie mozna kontynuowac walki
                            if (sprawdzCzyPrzeciwnikZyje(woj, nin, rywal)) {

                                // Bronic sie moze tylko zywy
                                if (wojownikZyje && ninjaZyje)
                                    obrona(woj, nin, rywal);
                                else if (wojownikZyje)
                                    obrona(woj, rywal);
                                else
                                    obrona(nin, rywal);

                                if (!sprawdzCzyZyje(woj)) wojownikZyje = false;
                                if (!sprawdzCzyZyje(nin)) ninjaZyje = false;
                                if (!wojownikZyje && !ninjaZyje) czyZyje=false;
                            }
                            tura++;
                        }
                    }
                    break;
                }
                case 5: {
                    // SCENARIUSZ WOJOWNIK I WROZKA
                    // PRZYGOTOWANIE
                    Wojownik woj = new Wojownik("Wojownik Wojciech", 1, 20, 0, 20, "Wojownik", false);
                    Wrozka wr = new Wrozka("Wrozka", 1, 20, 0, 20, "Wróżka", false);
                    Bron halabarda = new Bron(15, 8, false, "halabarda");
                    woj.wezBron(halabarda);
                    Postac pom = new Postac("pomocnik", 1, 1, 1, 1, "Nikt", false);
                    boolean czyZyje = true;
                    while(czyZyje) {
                        Potwor rywal = przygodaWyborPrzeciwnika(lvlPrzeciwnika);
                        lvlPrzeciwnika++;
                        int tura = 0;
                        boolean wojownikZyje = true;
                        boolean wrozkaZyje = true;

                        // WALKA
                        while (rywal.gethp() > 0 && czyZyje) {
                            if (tura % 3 == 0) {
                                if (wojownikZyje && wrozkaZyje) {
                                    int losowaniePostaci = (int) (Math.random() * 2);
                                    if (losowaniePostaci == 0) {
                                        // wybor ataku specjalnego wojownika
                                        woj.wyborAtakuSpecjalnego(rywal);
                                    } else {
                                        // wybor ataku specjalnego wrozki
                                        wr.wyborAtakuSpecjalnego(rywal, woj);
                                    }
                                } else if (wojownikZyje) woj.wyborAtakuSpecjalnego(rywal);
                                else wr.wyborAtakuSpecjalnego(rywal, woj);
                            }

                            // Atakowac moze tylko zywy
                            if (wojownikZyje && wrozkaZyje)
                                atak(woj, wr, rywal);
                            else if (wojownikZyje)
                                atak(woj, pom, rywal);
                            else
                                atak(wr, pom, rywal);

                            // Jesli przeciwnik nie zyje nie mozna kontynuowac walki
                            if (sprawdzCzyPrzeciwnikZyje(woj, wr, rywal)) {

                                // Bronic sie moze tylko zywy
                                if (wojownikZyje && wrozkaZyje)
                                    obrona(woj, wr, rywal);
                                else if (wojownikZyje)
                                    obrona(woj, rywal);
                                else
                                    obrona(wr, rywal);

                                if (!sprawdzCzyZyje(woj)) wojownikZyje = false;
                                if (!sprawdzCzyZyje(wr)) wrozkaZyje = false;
                                if (!wojownikZyje && !wrozkaZyje) czyZyje=false;
                            }
                            tura++;
                        }
                    }
                    break;
                }
            }
    }

    Potwor przygodaWyborPrzeciwnika(int lvlPrzeciwnika) {
        switch (lvlPrzeciwnika) {
            case 1: return new Potwor("Dziki Pies", 10, 1, 2, 5, "DzikiPies", true);
            case 2: return new Potwor("Zablakany pies", 12000, 2, 10, 5000, "Zablakany pies", true);
            case 3: return new Potwor("Dziki Wilk",5,3,11,30,"Dziki Wilk", true);

        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("GRATULACJE !!!!!!!!!!!!!!!!!!!!!!!!! Przeszedles caly tryb przygody !!!!!!!1");
        System.exit(0);
        return new Potwor("Dziki Pies", 10, 1, 2, 30, "DzikiPies", true);
    }


    void losujPrzeciwnikow(Potwor[] tablicaPrzeciwnikow){

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
                    Potwor dzikiPies = new Potwor("Dziki Pies",10,1,2,30,"DzikiPies", true);
                    tablicaPrzeciwnikow[i] = dzikiPies;
                    i++;
                     break;
                }
                case 1: {
                    Potwor zablakanyPies = new Potwor("Zablakany pies",12000,2,5,5000,"Zablakany pies", true);
                    tablicaPrzeciwnikow[i] = zablakanyPies;
                    i++;
                    break;
                }
                case 2: {
                    Potwor dzikiWilk = new Potwor("Dziki Wilk",5,3,11,30,"Dziki Wilk", true);
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
            System.out.println("Przeciwnik nr: "+j+" to: "+i.gettyp()+" ,lvl: "+i.getlvl());
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

    boolean sprawdzCzyPrzeciwnikZyje(Postac hero1,Postac hero2,Przeciwnik pr){
        if(pr.gethp()<=0) {
            System.out.println("-------------------------------------");
            System.out.println(pr.gettyp() + " UMIERA !!!");
            System.out.println("WYGRALES !!!!!!!!!!!");
            System.out.println("-------------------------------------");
            wait(1000);
            hero1.setexp(hero1.getexp() + pr.getexp());
            hero2.setexp(hero2.getexp() + pr.getexp());
            sprawdzLvl(hero1);
            sprawdzLvl(hero2);
            return false;
        } else return true;
    }

    void sprawdzLvl(Przeciwnik hero){
        if((hero.getexp()-hero.getWymaganeDoLvl())>=0) {
            hero.setlvl(hero.getlvl() + 1);
            double doNastepnegoLvl = hero.getexp()-hero.getWymaganeDoLvl();
            System.out.println(hero.gettyp()+" zdobywa lvl !!!");
            System.out.println("Teraz jego lvl to: "+hero.getlvl());
            System.out.println(hero.gettyp() +" zwieksza swoja moc i ilosc HP!");
            wait(1000);
            hero.setexp(doNastepnegoLvl);
            hero.sethp(hero.gethp()+2);
            hero.setmoc(hero.getmoc()+1);
            System.out.println("ilosc exp: "+hero.getexp());
            hero.setWymaganeDoLvl(hero.getWymaganeDoLvl()*3);
            if(doNastepnegoLvl>=hero.getWymaganeDoLvl()) sprawdzLvl(hero);
        }
    }
}
