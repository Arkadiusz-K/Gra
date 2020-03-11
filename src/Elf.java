import java.util.Scanner;

public class Elf extends Postac{
    Elf(String im,double m,int l, double e, double hp,String t,boolean czypo){
        super(im,m,l,e,hp,t,czypo);
    }

    void wyborAtakuSpecjalnego(Przeciwnik cel) {
        System.out.println("Ktory atak specjalny wybierasz?");
        System.out.println("1. Koronawirus - po zarazeniu istnieje 80% szans na odebranie 5% zycia przeciwnika w kazdej turze");
        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();
        switch(wybor) {
            case 1: {
                zaraza(cel);
                break;
            }
        }
    }

    void zaraza(Przeciwnik cel){
        cel.zostalZarazonyPrzezElfa();
    }
}
