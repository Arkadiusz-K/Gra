public class Arena {
    void atakBronia(Przeciwnik hero, Przeciwnik pr){
        System.out.println("works");
        System.out.println("ilosc hp przeciwnika: "+pr.gethp());
        pr.sethp(pr.gethp()-(hero.getbron().getobrazenia()*hero.getmoc()));
        System.out.println("hp przeciwnika po ataku mieczem: "+pr.gethp());
        if(pr.gethp()<=0){
            System.out.println(pr.gettyp()+ "przegrywa!");
            if(pr.czyPotwor == true){
                hero.setexp(hero.getexp()+pr.getexp());
                System.out.println("Ilosc exp "+hero.gettyp()+ " to: "+hero.getexp());;
            } else{
                // TODO Walka z przeciwnikiem
            }
        }
        System.out.println("Czy potwor?: "+pr.getczypotwor());
    }
}
