public class Walka {

    void atak(Przeciwnik hero, Przeciwnik cel){
        System.out.println("ilosc hp przeciwnika: "+cel.gethp());
        cel.sethp((cel.gethp()-(hero.getbron().getobrazenia()+(int)(Math.random()*5))*hero.getmoc()));
        System.out.println("hp przeciwnika po ataku mieczem: "+cel.gethp());
        // Obsluga furii, ale hero jest typu przeciwnik
        System.out.printf("Hp hero: "+hero.gethp());
    }

    void obrona(Przeciwnik hero1, Przeciwnik hero2, Przeciwnik pr){
        int szansaObrony = (int)(Math.random()*100);
        System.out.println("Szansa obrony: "+szansaObrony);
        if(szansaObrony>50) return;
        System.out.println("Nie udalo obronic sie przed atakiem :(");
        if(Math.random()*2==0){
            hero1.sethp(hero1.gethp()-pr.getmoc());
            System.out.println(hero1.gettyp()+" traci: "+pr.getmoc()+" i obecnie ma: "+hero1.gethp()+" hp!");
        } else{
            hero1.sethp(hero2.gethp()-pr.getmoc());
            System.out.println(hero2.gettyp()+" traci: "+pr.getmoc()+" i obecnie ma: "+hero2.gethp()+" hp!");
        }
    }

    boolean sprawdzCzyZyje(Przeciwnik hero){
        if(hero.gethp()<0){
            System.out.println(hero.gettyp()+" przegral, tracisz zycie");
            hero.setIloscZyc(hero.getilosczyc()-1);
            return false;
        } else
            return true;
    }

    boolean sprawdzCzyPrzeciwnikZyje(Przeciwnik hero,Przeciwnik pr){
        if(pr.gethp()<0) {
            System.out.println(pr.gettyp() + " przegrywa!");
            hero.setexp(hero.getexp() + pr.getexp());
            sprawdzLvl(hero);
            return false;
        } else return true;
    }

    void sprawdzLvl(Przeciwnik hero){
        if((hero.getexp()-hero.getWymaganeDoLvl())>=0) {
            hero.setlvl(hero.getlvl() + 1);
            double doNastepnegoLvl = hero.getexp()-hero.getWymaganeDoLvl();
            System.out.println(hero.gettyp()+" zdobywa lvl!");
            System.out.println("Teraz jego lvl to: "+hero.getlvl());
            hero.setexp(doNastepnegoLvl);
            hero.sethp(hero.gethp()+2);
            hero.setmoc(hero.getmoc()+1);
            System.out.println("ilosc exp: "+hero.getexp());
            if(doNastepnegoLvl>=hero.getWymaganeDoLvl()) sprawdzLvl(hero);
        }
    }

    void wyswietlStatystyki(Przeciwnik hero){
        System.out.println("----------------------------STATYSTYKI POSTACI ------------"+hero.gettyp());
        System.out.println("typ: "+hero.gettyp());
        System.out.println("lvl: "+hero.getlvl());
        System.out.println("exp: "+hero.getexp());
        System.out.println("wymagany exp: "+hero.getWymaganeDoLvl());
        System.out.println("Bron: "+hero.getbron().getNazwa_broni());
        System.out.println("---------statystyki do walki----------");
        System.out.println("moc: "+hero.getmoc());
        System.out.println("hp: "+hero.gethp());
    }
}
