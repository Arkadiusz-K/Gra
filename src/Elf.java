import java.util.Scanner;

public class Elf extends Postac{
    Elf(String im,double m,int l, double e, double hp,String t,boolean czypo){
        super(im,m,l,e,hp,t,czypo);
    }

    void wyborAtakuSpecjalnego(Przeciwnik cel) {
        System.out.println("Ktory atak specjalny wybierasz?");
        System.out.println("1. Koronawirus - po zarazeniu istnieje 80% szans na odebranie 5% zycia przeciwnika w kazdej turze");
        System.out.println("2. Art of Destruction - 50% szans na zabranie przeciwnikowi losowej wartosci hp z pewnego przedzialu (zaleznej od mocy elfa)");
        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();
        switch(wybor) {
            case 1: {
                zaraza(cel);
                break;
            }
            case 2: {
                artOfDestruction(cel);
                break;
            }
        }
    }

    void zaraza(Przeciwnik cel){
        cel.zostalZarazonyPrzezElfa();
    }

    void artOfDestruction(Przeciwnik cel){
        int szansaArtOfDestruction = (int)(Math.random()*100);
        if(szansaArtOfDestruction>50){
            double wylosowanaWartosc = getmoc()*(int)(Math.random()*10)+1;
            System.out.println("Elf odbierze w tej kolejce przeciwnikowi ...");
            wait(500);
            System.out.println(wylosowanaWartosc+" hp!");
            cel.sethp(cel.gethp()-wylosowanaWartosc);
        } else{
            System.out.println("Elfowi nie udalo sie wykonac Art of Destruction :(");
        }
    }
}
