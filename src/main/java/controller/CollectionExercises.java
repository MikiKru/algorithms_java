package controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CollectionExercises {
    public int dziuraBinarana(String binarka) {
        char[] tab = binarka.toCharArray();
//        System.out.println(tab.length);
        int count = 0;
        int dziura = 0;
        for (int i = 0; i < tab.length; i++) {
            // System.out.println(tab[i]);
            if (tab[i] == '0') {
                count += 1;
            } else if (tab[i] == '1' && count > 0) {
                dziura++;
                count = 0;
            }
//            System.out.println("[" + tab[i] + "] " + count);
        }
        if (tab[0] == '0' && dziura > 0) {
            dziura -= 1;
        }
        return dziura;
    }

    public int findBinaryGaps(String signal){
        boolean isOne = false;
        boolean isZero = false;
        int countedBinaryGaps = 0;
        int i = 0;
        for (String element : signal.split("")) {
            if(element.equals("1") && isOne && isZero && signal.charAt(i-1) != '1'){
                countedBinaryGaps++;
                isZero = false;
            } else if(element.equals("0")){
                isZero = true;
            } else if(element.equals("1") ) {
                isOne = true;
            }
            i++;
        }
        return countedBinaryGaps;
    }

    public static void main(String[] args) {
        System.out.println(
                new CollectionExercises().dziuraBinarana("0000011001010000"));
        System.out.println(
                new CollectionExercises().dziuraBinarana("1001111001100001"));

        // wypisz elementy występujące w obu tablicach bez duplikatów [3,4,6]
        int [] tab1 = {1,2,3,4,4,5,6};
        int [] tab2 = {3,3,4,6,7};

        // wpisyje elementy list do zbiorów
        Set<Integer> s1 = new HashSet<>();
        for (int elem : tab1) {
            s1.add(elem);
        }
        Set<Integer> s2 = new HashSet<>();
        for (int elem : tab2) {
            s2.add(elem);
        }
        Set<Integer> sResult = new HashSet<>();
        sResult.addAll(s1);
        sResult.retainAll(s2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(sResult);
        s1.addAll(s2);
        s1.removeAll(sResult);
        System.out.println(s1);



    }
}
