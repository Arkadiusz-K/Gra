import java.util.Scanner;

public class Wrozka extends Postac {
    Wrozka(String im,double m,int l, double e, double hp,String t,boolean czypo){
        super(im,m,l,e,hp,t,czypo);
    }

    void wyborAtakuSpecjalnego(Przeciwnik cel,Postac hero) {
        System.out.println("Ktory atak specjalny wybierasz?");
        System.out.println("1. Losowe Wsparcie - zostaje wylosowane jakie wsparcie zostanie wykonane na innym czlonku druzyny. Moze to byc wzmocnienie ataku o 10% albo 20% albo zwiekszenie sily o 10%");
        System.out.println("2. Pocalunek Smierci - 10% szans na odebranie przeciwnikowi 90% punktow zycia");
        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();
        switch (wybor) {
            case 1: {
                wspierajLosowo(hero);
            }
            case 2: {
                pocalunekSmierci(cel);
            }
        }
    }

    void wspierajLosowo(Przeciwnik hero){
        int losoweWsparcie = (int)(Math.random()*3);
        switch(losoweWsparcie){
            case 0: {
                System.out.println("Podniesienie mocy o 10% dla: "+hero.gettyp());
                hero.setmoc(hero.getmoc()*1.1);
                break;
            }
            case 1: {
                System.out.println("Podniesienie mocy o 20% dla: "+hero.gettyp());
                hero.setmoc(hero.getmoc()*1.2);
                break;
            }
            case 2: {
                System.out.println("Uzdrowienie o 10% dla: "+hero.gettyp());
                hero.sethp(hero.gethp()*1.1);
                break;
            }
        }

    }

    // 10% szans na zabranie przeciwnikowi 90% zycia
    void pocalunekSmierci(Przeciwnik cel){
        int szansaPocalunkuSmierci = (int)(Math.random()*100);
        System.out.println(gettyp()+" przygotowuje sie do proby wykonania pocalunku smierci ...");
        wait(1000);
        if(szansaPocalunkuSmierci>90){
            System.out.println(gettyp()+" wykonuje POCALUNEK SMIERCI !!");
            cel.sethp(cel.gethp()*0.1);
        } else{
            System.out.println(gettyp()+" nie udalo sie wykonac pocalunku smierci");
        }
        wait(1000);
    }





}
