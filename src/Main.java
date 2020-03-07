import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args){
        Arena walka = new Arena();
        Postac wojownik = new Postac(1,20, 0, 20, "Wojownik",false);
        Bron halabarda = new Bron(15, 8, false, "halabarda");
        Bron wloczniaSmoka = new Bron(50, 200, false, "wloczniaSmoka");

        Postac elf = new Postac(1, 15, 0,2, "Elf", false);
        Potwor dzikiPies = new Potwor(1,1,0.5,1,"DzikiPies", true);

        wojownik.wezBron(halabarda);
        walka.atakBronia(wojownik,dzikiPies);
    }
}
