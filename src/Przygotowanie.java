import java.util.Scanner;

public class Przygotowanie {
    void wyborBohaterow(Postac[] tablicaBohaterow){
        System.out.println("Wybierz 3 bohaterow! (Moga sie powtarzac). Kazdy z nich posiada inne umiejetnosci oraz statystyki");
        System.out.println("-----------------------------------------------------------------");
        opisBohaterow();
        System.out.println("Wcisnij 1 jesli wybierasz Wojownika, 2 jesli Wrozke");
        for(int i=0;i<tablicaBohaterow.length;i++){
            System.out.println("Wybierz bohatera nr "+i);
            Scanner scanner = new Scanner(System.in);
            int wybor = scanner.nextInt();
            switch(wybor){
                case 1:{
                    tablicaBohaterow[i] = new Wojownik("Wojownik Wojciech",1,20, 0, 20, "Wojownik",false);
                    break;
                }
                case 2:{
                    tablicaBohaterow[i] = new Wrozka("Wrozka", 1,20, 0, 20, "Wróżka",false);
                    break;
                }
            }
            }
        System.out.println("Twoja druzyna sklada sie z: ");
        for(int j=0;j<tablicaBohaterow.length;j++){
            System.out.println(tablicaBohaterow[j].gettyp()+" o imieniu: "+tablicaBohaterow[j].getimie());
        }
    }

    //  Lepiej wczytac z pliku
    void opisBohaterow(){
        System.out.println("Wojownik - duza sila ataku i bazowanie na swojej fizycznosci, brak umiejetnosci magicznych");
        System.out.println("Umiejetnosci: ");
        System.out.println("1. Punchdown - 30% szans na uderzenie krytyczne tj. 3*silniejsze");
        System.out.println("2. Furia - Zyskuje 40% sily ataku, ale traci 30% zycia");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Wrozka - wsparcie dla druzyny dzieki uzytej magii");
        System.out.println("Umiejetnosci: ");
        System.out.println("1. Losowe Wsparcie - zostaje wylosowane jakie wsparcie zostanie wykonane na innym czlonku druzyny. Moze to byc wzmocnienie ataku o 10% albo 20% albo zwiekszenie sily o 10%");
        System.out.println("2. Pocalunek Smierci - 10% szans na odebranie przeciwnikowi 90% punktow zycia");

    }
}
