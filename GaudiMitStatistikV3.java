import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class GaudiMitStatistikV3 {
    public static void main(String[] args) {
        Random r = new Random(4);
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100);
        }
        System.out.println("Urliste:");
        System.out.print(Arrays.toString(a));
        System.out.println();

        int b = 0;
        while (b < a.length - 1) {
            int save = 0;
            if (a[b] > a[b + 1]) {
                save = a[b];
                a[b] = a[b+1];
                a[b+1] = save;
                b=0;
            }
            else b++;
        }
        System.out.println("Aufsteigend sortiert: ");
        System.out.println(Arrays.toString(a));
        System.out.print("Arithmetisches Mittel: ");
        double arithmeticMean=0;
        double save=0;
        for (int i = 0; i < a.length-1; i++) {
            if(i==0){
                arithmeticMean= a[i] + a[i+1];
                save=arithmeticMean+save;
            } else {
                arithmeticMean = save + a[i + 1];
                save=arithmeticMean;
            }
        }
        arithmeticMean= arithmeticMean/a.length;
        System.out.print(String.format("%.1f",arithmeticMean));
        System.out.println();
        System.out.print("Spannweite: ");
        System.out.println(String.format("%d", a[a.length-1]-a[0]));
        System.out.print("Median: ");
        if (a.length % 2.0==0){
            System.out.println(String.format("%.1f ",(a[a.length/2] + a[(a.length/2)-1])/2.0));
        } else System.out.println(String.format("%d", a[a.length/2]));
        System.out.print("Modalwert: ");
        int mode=1;
        int temp=0;
        ArrayList <Integer> modeList=new ArrayList<Integer>();
        int totalCount=0;
        int maxValue=0;
        int counter=1;

        for (int i = 0; i < a.length-1; i++) {
            if (a[i]==a[i+1]){
                counter++;
            } else if (a[i] != a[i+1] && counter!=1 && counter>totalCount) {
                totalCount=counter;
                maxValue=a[i];
            }
        }
//        for (int i = 0; i <a.length-1 ; i++) {
//            if (mode==1){
//                counter++;
//            } else {
//                modeList.add(a[counter]);
//                modeList.add(mode);
//                counter++;
//                mode=1;
//            }
//            for (int j = 0; j <a.length-1 ; j++) {
//                if (a[counter]==a[j+1]){
//                    mode++;
//                }
//
//            }
//        }
        if (maxValue!=0) {
            System.out.println(String.format("%d mit %d", maxValue, totalCount));
        } else {
            System.out.println("Kein Modalwert vorhanden.");
        }
        System.out.print("Mittlere absolute Abweichung: ");

        //meanAD = meanAbsoluteDeviation

        double meanAD=0;
        double tempTwo=0;
        for (int i = 0; i < a.length; i++) {
            tempTwo= a[i]-arithmeticMean;
            if (tempTwo<0){
                tempTwo=-(tempTwo);
            }
            meanAD=tempTwo+meanAD;
        }
        System.out.println(String.format("%.1f",((1.0/a.length)*meanAD)));



    }
}