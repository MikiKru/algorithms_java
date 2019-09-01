package controller;

public class CollectionExercises {
    public int findBinaryGaps(String signal){
        boolean isOne = false;
        boolean isZero = false;
        int countedBinaryGaps = 0;
        int i = 0;
        for (String element : signal.split("")) {
//            System.out.println("elem:" + element);
//            System.out.println("isZero: " + isZero);
//            System.out.println("isOne: " + isOne);
            if(element.equals("1") && isOne && isZero && signal.charAt(i-1) != '1'){
                countedBinaryGaps++;
                isZero = false;
            } else if(element.equals("0")){
                isZero = true;
            } else if(element.equals("1") ) {
                isOne = true;
            }
            i++;

//            System.out.println("gaps:" + countedBinaryGaps);
        }
        return countedBinaryGaps;
    }

    public static void main(String[] args) {
        System.out.println(
                new CollectionExercises().findBinaryGaps("0011001010000"));
        System.out.println(
                new CollectionExercises().findBinaryGaps("1001111001100001"));
    }
}
