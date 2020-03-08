import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Arena walka = new Arena();
        Postac wojownik = new Postac(1,20, 0, 20, "Wojownik",false);
        Bron halabarda = new Bron(15, 8, false, "halabarda");
        Bron wloczniaSmoka = new Bron(50, 200, false, "wloczniaSmoka");

        Postac elf = new Postac(1, 15, 0,2, "Elf", false);
        //Potwor dzikiPies = new Potwor(1,1,9,100,"DzikiPies", true);

        wojownik.wezBron(halabarda);

        System.out.println("Wybierz przeciwnika: ");
        System.out.println("1 jeśli Dziki Pies");
        System.out.println("2 jeśli Byk");

        Scanner scanner = new Scanner(System.in);
        int wybor;
        wybor = scanner.nextInt();
        switch(wybor){
            case 1: {
                Potwor dzikiPies = new Potwor(1,1,9,100,"DzikiPies", true);
                walka.bitwa(wojownik,dzikiPies);
            }
            case 2: {
                Potwor byk = new Potwor(100,10, 100, 150, "Byk", true);
                walka.bitwa(wojownik,byk);
            }
        }


    }
}
