package day51_lambda_functional_programming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fp01 {
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
        ciftSayiElemanlari(liste);
        System.out.println();
        tekSayiElemanlarininKaresi(liste);
        System.out.println();
        tekSayilarinKupleriniTekrarsizYazdirma(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareleriToplami(liste);
        tekrarsizCiftElemanlarinKupununCarpimi(liste);
        maxValue(liste);
        maxValue2(liste);
        minValue(liste);
        minValueEvenAfterYedi(liste);
        tekrarsizBestenBuyukElemanlarinYarisiniTerstenYazdir(liste);

    }//stream() =>lambda methodlarini getirir
    //1) Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Structured)
    public static void listElemanlari(List<Integer>list){
        list.stream().forEach(t-> System.out.print(t+" ")); //t-> lambda ifadesidir yazdirma da forEach ile yapilir
    }
    //2)Çift sayı olan list elemanlarını aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.
    public static void ciftSayiElemanlari(List<Integer>list){
        list.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" ")); //filter listeyi filtrelemek icin kullanilir
    }
    //3) Ardışık tek list elemanlarının karelerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.
    public static void tekSayiElemanlarininKaresi(List<Integer>list){
        list.stream().filter(t->t%2!=0).map(t->t*t).forEach(t-> System.out.print(t+" ")); //map listede islem yapacagimizda kullaniriz
    }
    //4) Ardışık tek list elementlerinin küplerini tekrarsız olarak aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.
    public static void tekSayilarinKupleriniTekrarsizYazdirma(List<Integer>list){
        list.stream().filter(t->t%2!=0).distinct().map(t->t*t*t).forEach(t-> System.out.print(t+" ")); //distinct tekrarsiz yapmak icin kullanilir

    }
    //5) Tekrarsız çift elemanların karelerinin toplamını hesaplayan bir method oluşturun.
    public static void tekrarsizCiftElemanlarinKareleriToplami(List<Integer>list){
        Integer toplam=list.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0,(t,u)->t+u);  //reduce, islemi teke indirgemede kullanilir
        System.out.println(toplam);
    }
    //6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.
    public static void tekrarsizCiftElemanlarinKupununCarpimi(List<Integer>list){
        Integer carpim=list.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1,(t,u)->t*u);  //reduce, islemi teke indirgemede kullanilir
        System.out.println(carpim);
}
    //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.
    public static void maxValue(List<Integer>list){
        Integer maxValue=list.stream().sorted().reduce(Integer.MIN_VALUE,(t,u)->u);  //sort kucukten buyuge yazar ve son eleman en buyuk olur
        System.out.println(maxValue);
    }
    //2.cozum yolu
    public static void maxValue2(List<Integer>list){
        Integer maxValue=list.stream().reduce(Integer.MIN_VALUE, (t,u)->t>u?t:u);
        System.out.println(maxValue);
    }
    //8)List elemanları arasından en küçük değeri bulan bir method oluşturun.(1 Yol ile)

    public static void minValue(List<Integer>list){
        Integer minValue=list.stream().sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE,(t, u)->u);
        System.out.println(minValue);
        Integer minValue2=list.stream().sorted().findFirst().get();//find first get ilk elemani getirir
        System.out.println(minValue2);
    }
    //9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.
    public static void minValueEvenAfterYedi(List<Integer>list){
        Integer minValue=list.stream().sorted().filter(t->t%2==0 && t>7).findFirst().get();
        System.out.println(minValue);
    }
    //10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı değerlerini(elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.
    public static void tekrarsizBestenBuyukElemanlarinYarisiniTerstenYazdir(List<Integer>list){
       List<Double> sonuc=list.stream().distinct().filter(t-> t>5).sorted(Comparator.reverseOrder()).map(t->t/2.0).collect(Collectors.toList());
        System.out.println(sonuc);  //yeni bir liste olusturdugu icin collect methodunu kullandik
    }

}