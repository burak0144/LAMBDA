package day51_lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp02 {

    /*
1)  t-> "Logic" , (t, u)-> "Logic"
    Bu yapıya "Lambda Expession"
2) Functional Programming kapsamında "Lambda Expession" kullanılabilir ama önerilmez.
   "Lambda Expession" yerine "Method Reference" tercih edilir.
3) "Method Reference" kullanımı "Class Name :: Method Name"

   Aynı zamanda kendi class'larınızı da kullanabilirsiniz.
   Örneğin bir Animal class'ınız var ve bu class "eat()" methoduna sahip ==> "Animal :: eat"
 */
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();
        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(8);
        System.out.println(liste);
        listElemanlari(liste);
        System.out.println();
        ciftElemanlariYazdir(liste);
        System.out.println();
        tekSayiElemanlarininKaresi(liste);
        System.out.println();
        tekElemanlarinKupleriniTekrarsizYazdirma(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareleriToplami(liste);
        tekrarsizCiftElemanlarinKupununCarpmi(liste);
        maxValue(liste);
        minValue(liste);
        yedidenBuyukEnKucukCiftSayi(liste);
        tekrarsizBestenBuyukElemanlarinYarisiniTerstenYazdir(liste);
    }
    //1) Ardışık list elemanlarını aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional ve method reference)
      public static void listElemanlari(List<Integer> list){
        list.stream().forEach(Utils::boslukluYazdirma);
      }
    //2)Ardışık çift list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
    public static void ciftElemanlariYazdir(List<Integer> list){
    list.stream().filter(Utils::ciftElemanSec).forEach(Utils::boslukluYazdirma);
    }
    //3) Ardışık tek list elemanlarının karelerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
    public static void tekSayiElemanlarininKaresi(List<Integer>list){
        list.stream().filter(Utils::tekElemanSec).map(Utils::sayininKaresi).forEach(Utils::boslukluYazdirma);
    }
    //4) Ardışık tek list elemanlarının küplerini tekrarsız olarak aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.
    public static void tekElemanlarinKupleriniTekrarsizYazdirma(List<Integer> list) {
        list.stream().distinct().filter(Utils::tekElemanSec).map(Utils::kupunuAl).forEach(Utils::boslukluYazdirma);
    }
    //5) Tekrarsız çift elemanların karelerinin toplamını hesaplayan bir method oluşturun.
    public static void tekrarsizCiftElemanlarinKareleriToplami(List<Integer>list){
        Integer toplam=list.stream().distinct().filter(Utils::ciftElemanSec).map(Utils::sayininKaresi).reduce(Math::addExact).get();
        System.out.println(toplam);
        //Integer toplam=list.stream().distinct().filter(Utils::ciftElemanSec).map(Utils::sayininKaresi).reduce(0,Math::addExact);
       // Integer toplam=list.stream().distinct().filter(Utils::ciftElemanSec).map(Utils::sayininKaresi).reduce(Integer::sum).get();

    }
    //6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.
    public static void tekrarsizCiftElemanlarinKupununCarpmi(List<Integer>list){
        Integer carpim=list.stream().distinct().filter(Utils::ciftElemanSec).map(Utils::kupunuAl).reduce(Math::multiplyExact).get();
        System.out.println(carpim);
    }
    //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.
     public static void maxValue(List<Integer>list){
        Integer maxValue=list.stream().reduce(Math::max).get();
         System.out.println(maxValue);
     }
    //Ödev
    //8)List elemanları arasından en küçük değeri bulan bir method oluşturun.(Method Reference)
    public static void minValue(List<Integer>list){
        Integer minValue=list.stream().reduce(Math::min).get();
        System.out.println(minValue);
    }
    //9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.
    public static void yedidenBuyukEnKucukCiftSayi(List<Integer>list){
        Integer sonuc=list.stream().filter(Utils::ciftElemanSec).filter(t->t>7).reduce(Math::min).get();
        System.out.println(sonuc);
    }
    //10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı değerlerini(elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.
    public static void tekrarsizBestenBuyukElemanlarinYarisiniTerstenYazdir(List<Integer>list){
        List<Double>sonuc=list.stream().distinct().filter(t->t>5).map(Utils::sayininYarisi).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sonuc);
    }
}
