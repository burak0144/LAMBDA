package day51_lambda_functional_programming;

import day38_inheritanceDataTypeKullanimi.personel.C;

import java.util.*;
import java.util.stream.Collectors;

public class Fp05 {
    public static void main(String[] args) {
        Courses courseTurkishDay = new Courses("Summer", "Turkish Day", 97, 128);
        Courses courseTurkishNight = new Courses("Winter", "Turkish Night", 98, 154);
        Courses courseEnglishDay = new Courses("Spring", "English Day", 95, 132);
        Courses courseEnglishNight = new Courses("Winter", "English Night", 93, 144);

        List<Courses> coursesList = new ArrayList<>();
        coursesList.add(courseTurkishDay);
        coursesList.add(courseTurkishNight);
        coursesList.add(courseEnglishDay);
        coursesList.add(courseEnglishNight);

        System.out.println(ortalamaPuanlarVerilenSayidanBuyukMu(coursesList,93));
        System.out.println(kelimeVarMi(coursesList, "English Night"));
        ortalamaPuaniEnYuksekKurs(coursesList);
        System.out.println(ortalamaPuanaGoreSiralaVeIlkVerilenleriAtla(coursesList,2));
    }
    //1)Tüm ortalama puanların verilen sayıdan büyük olup olmadığını kontrol etmek için bir method oluşturun.
    public static boolean ortalamaPuanlarVerilenSayidanBuyukMu(List<Courses> list,int x){
       return list.stream().allMatch(t->t.getAverageScore()>x);
    }
    //2)Kurs adlarından en az birinin verilen kelimeyi içerip içermediğini kontrol etmek için bir method oluşturun
    public static boolean kelimeVarMi(List<Courses> list, String str){
        return list.stream().anyMatch(t->t.getCourseName().contains(str));
    }
    //3) Ortalama puanı en yüksek olan kursu yazdırmak için bir yöntem oluşturun
    public static Map<String, Integer> ortalamaPuaniEnYuksekKurs(List<Courses> list){
      String courseName= list.stream().sorted(Comparator.comparing(Courses::getAverageScore).reversed()).findFirst().get().getCourseName();
     Integer score= list.stream().sorted(Comparator.comparing(Courses::getAverageScore).reversed()).findFirst().get().getAverageScore();
   Map<String, Integer> enYuksekScore= new HashMap<>();
   enYuksekScore.put(courseName,score);
        for (Map.Entry<String, Integer> entry : enYuksekScore.entrySet()

             ) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
   return enYuksekScore;
    }
    //4) Liste öğelerini artan düzende ortalama puana göre sıralayın ve ilk verilenleri atlayın
    public static List<Courses> ortalamaPuanaGoreSiralaVeIlkVerilenleriAtla(List<Courses> list,int x){
        return list.stream().sorted(Comparator.comparing(Courses::getAverageScore)).skip(x).collect(Collectors.toList());
    }
}
