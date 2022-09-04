package day51_lambda_functional_programming;

import java.util.stream.IntStream;

public class Fp04 {
    public static void main(String[] args) {
        System.out.println(get7den100eKadarToplam());
        System.out.println(get2den11eCarpim());
        System.out.println(get5Faktoryel(5));
        System.out.println(verilenIkiSayiArasindakiCiftSayilarinToplami(9, 5));
        System.out.println(ikiSayiArasindakiTumSayilarinRakamlariToplami(32, 23));

    }
    //1) 7'den 100'e kadar integer değerlerinin toplamını bulan bir method oluşturun.
    public static int get7den100eKadarToplam(){
      // return IntStream.rangeClosed(7,100).sum(); //closed sinirlar dahil,close olmazsa ikinci sinir dahil degil
        // return IntStream.range(7,101).reduce(Math::addExact).getAsInt();
        return IntStream.rangeClosed(7,100).reduce(Math::addExact).getAsInt(); //get kullanarak 1 elemana dusurdugumuzu getirir
    }
    //2) 2'den 11'e kadar integer değerlerinin çarpımını bulan bir method oluşturun.
    public static int get2den11eCarpim(){
        return IntStream.rangeClosed(2,11).reduce(Math::multiplyExact).getAsInt();
    }
    //3) Verilen bir sayının faktoriyelini hesaplayan bir method oluşturun. (5 factorial = 1*2*3*4*5  ==> 5! = 1*2*3*4*5)
    public static int get5Faktoryel(int x){
        return IntStream.rangeClosed(1,x).reduce(Math::multiplyExact).getAsInt();
    }
    //4) Verilen iki sayı arasındaki çift sayıların toplamını bulan bir method oluşturun.
    public static int verilenIkiSayiArasindakiCiftSayilarinToplami(int x,int y){
       if(x>y){
           int z=x;
           x=y;
           y=z;
       }
        return IntStream.rangeClosed(x,y).filter(Utils::ciftElemanSec).sum();
    }
    ///5) Verilen iki sayı arasındaki tüm sayıların rakamlarının toplamını hesaplayan bir method oluşturun.
    public static int ikiSayiArasindakiTumSayilarinRakamlariToplami(int x, int y){
        if(x>y){
            int z=x;
            x=y;
            y=z;
        }
        return IntStream.rangeClosed(x,y).map(Utils::rakamlarToplami).sum();
    }
}
