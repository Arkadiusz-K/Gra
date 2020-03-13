import java.util.Scanner;

public class Ninja extends Postac{
    Ninja(String im,double m,int l, double e, double hp,String t,boolean czypo){
        super(im,m,l,e,hp,t,czypo);
    }

    private int zmianaSkilliObronnych = 10;

    void wyborAtakuSpecjalnego(Przeciwnik cel,Postac hero) {
        System.out.println("Ktory atak specjalny wybierasz?");
        System.out.println("1. Siekanie Ogorkow - zadaje losowa ilosc ciosow (z pewnego przedzialu) odbierajacych po 1 HP");
        System.out.println("2. Zwinnosc - zwieksza szanse uniknieca ataku o 10% przy pierwszym uzyciu i o 5% przy drugim uzyciu");
        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();
        switch(wybor) {
            case 1: {
                siekanieOgorkow(cel);
                break;
            }
            case 2: {
                zwinnosc(cel);
                break;
            }
        }
    }

    void siekanieOgorkow(Przeciwnik cel){
        int ileSiekniec = (int)(Math.random()*getmoc()*10+1);
        System.out.println("ilosc siekniec: "+ileSiekniec);
        System.out.println("!!!!!! Zycie przed atakiem: "+cel.gethp());
        cel.sethp(cel.gethp()-ileSiekniec);
        System.out.println("!!!!!! Zycie po ataku: "+cel.gethp());
        for(int i=0;i<ileSiekniec;i++) System.out.println("Ciach! ");
    }

    void zwinnosc(Przeciwnik cel){
        if(zmianaSkilliObronnych>0) {
            setSkilleObronne(getSkilleObronne() + zmianaSkilliObronnych);
            zmianaSkilliObronnych -= 5;
        } else{
            System.out.println("Juz nie mozna zwieksza obrony!");
            System.out.println("Zamiast tego ninja uzyje ataku Siekanie Ogorkow!");
            siekanieOgorkow(cel);
        }
    }
}
