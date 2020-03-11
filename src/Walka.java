public class Walka {

    void atak(Przeciwnik hero1, Przeciwnik hero2,Przeciwnik cel){
        System.out.println("ilosc hp przeciwnika: "+cel.gethp());
        if(hero1.gettyp().equals("Wojownik") || hero2.gettyp().equals("Wojownik")){
            System.out.println("Wojownik atakuje");
            cel.sethp((cel.gethp()-(hero1.getbron().getobrazenia()+(int)(Math.random()*5))*hero1.getmoc()));
        } else if (hero1.gettyp().equals("Ninja") || hero2.gettyp().equals("Ninja")){
            System.out.println("Ninja atakuje");
            cel.sethp(cel.gethp()-3);
        } else if (hero1.gettyp().equals("Elf") || hero2.gettyp().equals("Elf") ){
            System.out.println("Elf atakuje");
            cel.sethp(cel.gethp()-2);
        } else if (hero1.gettyp().equals("Wrozka") || hero2.gettyp().equals("Wrozka") ){
            System.out.println("Wrozka atakuje");
            cel.sethp(cel.gethp()-2);
        }
        System.out.println("hp przeciwnika po ataku mieczem: "+cel.gethp());
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
            System.out.println(hero.gettyp()+" NIE ZYJE !!!!!!!!!!!!!!!!");
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
