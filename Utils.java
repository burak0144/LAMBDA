package day51_lambda_functional_programming;

public class Utils {
    public static void boslukluYazdirma(Object obj){
        System.out.print(obj +" ");
    }
    public static boolean ciftElemanSec(int x){
        return x%2==0;

    }
    public static boolean tekElemanSec(int x){
        return x%2!=0;
    }
    public static int sayininKaresi(int x){
         return x*x;
    }public static int kupunuAl(int x){

        return x*x*x;
    }
    public static double sayininYarisi(int x){
        return x/2.0;
    }
    public static char sonKarakter(String str){
        return str.charAt(str.length()-1);
    }
    public static char ilkKarakter(String str){
        return str.charAt(0);
    }
    public static int rakamlarToplami(int x){
        int toplam=0;
        while (x>0 ) {
            toplam+=x%10;
            x/=10;

        } return toplam;
    }
}