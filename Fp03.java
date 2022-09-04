package day51_lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fp03 {
    public static void main(String[] args) {
        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Amanda");
        liste.add("Christopher");
        liste.add("Jackson");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Benjamin");
        System.out.println(liste);
        tumElemanlariBuyukYazdir(liste);
        uzunluklarinaGoreYazdir(liste);
        System.out.println();
        uzunluklarininTersiniSirala(liste);
        System.out.println();
        sonKaraktereGoreSiralayipTekrarsizYazdir(liste);
        System.out.println();
        elemanlariOnceUzunlukSonraIlkKaraktereGoreSirala(liste);
        System.out.println();
        //bestenBuyukElemanlariSil(liste);
       // AIleBaslayanVeyaNileBitenElemanlariSil(liste);
        //uzunlugu8Ile10ArasiYadaoIleBiten(liste);
        System.out.println(uzunlugu12denAzMi(liste));
        System.out.println(hicBiriXileBaslamiyorMu(liste));
        System.out.println(herhangiBirElemanrIleBitiyorMu(liste));


    }//1.yol
    //1) Tüm elemanları büyük harf ile yazdıran bir method oluşturun.
    public static void tumElemanlariBuyukYazdir(List<String> list){
        list.stream().map(String::toUpperCase).forEach(Utils::boslukluYazdirma);
        System.out.println();
        //2.yol
       /* list.replaceAll(String::toUpperCase);
        System.out.println("2.yol"+list);*/

    }//2) Elemanları uzunluklarına göre sıralayıp yazdıran bir method oluşturun.
    public static void uzunluklarinaGoreYazdir(List<String>list){
        list.stream().sorted(Comparator.comparing(String::length)).forEach(Utils::boslukluYazdirma);
    }
    //3) Elemanları uzunluklarına göre ters sıralayıp yazdıran bir method oluşturun.
    public static void uzunluklarininTersiniSirala(List<String>list){
        list.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Utils::boslukluYazdirma);
    }
    //4) Elemanları son karakterlerine göre sıralayıp tekrarsız yazdıran bir method oluşturun.
    public static void sonKaraktereGoreSiralayipTekrarsizYazdir(List<String>list){
        list.stream().distinct().sorted(Comparator.comparing(Utils::sonKarakter))
                .forEach(Utils::boslukluYazdirma);
    }
    //5) Elemanların önce uzunluklarına göre ve sonra ilk karakterine göre sıralayıp yazdıran bir method oluşturun.
    public static void elemanlariOnceUzunlukSonraIlkKaraktereGoreSirala(List<String>list){
        list.stream().sorted(Comparator.comparing(String::length).thenComparing(Utils::ilkKarakter))
                .forEach(Utils::boslukluYazdirma);
    }
    //6) Uzunluğu 5'ten büyük olan elemanları silen bir method oluşturun.
    /*public static void bestenBuyukElemanlariSil(List<String>list){
        list.removeIf(t->t.length()>5);
        System.out.println(list);
          ==> list, mutable olduğu için elemanları işlem sonrası kalıcı değiştiğinden comment-out yapıyorum.
    }*/
    //7) ‘A’, ‘a’ ile başlayan yada ‘N’, ‘n’ ile biten elemanları silen bir method oluşturun.
    /*public static void AIleBaslayanVeyaNileBitenElemanlariSil(List<String >list){
        list.removeIf(t->t.startsWith("A")||t.charAt(0)=='a'||t.endsWith("N")||t.charAt(t.length()-1)=='n');
        System.out.println(list);
    }*/
    //8) Uzunluğu 8 ile 10 arası olan yada 'o' ile biten elemanları silen bir method oluşturun.
    /*public static void uzunlugu8Ile10ArasiYadaoIleBiten(List<String>list){
        list.removeIf(t->t.length()>=8&&t.length()<=10||t.charAt(t.length()-1)=='o');
        System.out.println(list);
    }*/
    //9) Tüm elemanların uzunluklarının 12'den az olup olmadığını kontrol eden bir method oluşturun.
   public static boolean uzunlugu12denAzMi(List<String>list){
     return list.stream().allMatch(t->t.length()<12);
   }
    //10) Hiçbir elemanın 'X' ile başlamadığını kontrol eden bir method oluşturun.
    public static boolean hicBiriXileBaslamiyorMu(List<String>list){
       return list.stream().noneMatch(t->t.startsWith("X"));
    }
    //11) Herhangi bir elemanın 'r' ile bitip bitmediğini kontrol eden bir method oluşturun.
    public static boolean herhangiBirElemanrIleBitiyorMu(List<String>list){
       return list.stream().anyMatch(t->t.endsWith("r"));
    }
}
