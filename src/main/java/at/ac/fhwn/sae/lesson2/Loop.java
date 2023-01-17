package at.ac.fhwn.sae.lesson2;

public class Loop {
    public static void main(String [] args) {
        int month = 13;
        String monthString = switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            case 13 -> "Des is ka monat du foitrottl!";
            default -> "InvalidMonth";
        };
        System.out.println(monthString);

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int i = 0;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
        do {
            System.out.println(i);
            i--;
        } while (i >= 1);

        System.out.println(add("12", 4, 100));


        int[] intArr = new int[10];
        System.out.println(intArr[3]);
        intArr[0] = 42;
        intArr[9] = 3;

        for (int value : intArr){
            System.out.println(value);
        }
        System.out.println(getMaxOfBitsRecursive(2));


    }
    public static long getMaxOfBitsRecursive(int numberOfBits){
        return getMaxOfBitsRecursive(1,numberOfBits);
    }
    private static long getMaxOfBitsRecursive(long number, int numberOfBitsLeft){
        if(numberOfBitsLeft > 0){
            return getMaxOfBitsRecursive(number*2,--numberOfBitsLeft);
        }
        return number;
    }

    /**
     * Gets the maximum value of a datatype with a given number of Bits
     *
     * @param numberOfBits the number of Bits
     * @return
     */

    public static long getMaxofBits(int numberOfBits){
        long result = 1;
        while(numberOfBits > 0){
            numberOfBits--;
            result*=2;
        }
        return result;
    }







    public static int add(int number1, int number2){
        return number1 + number2;

    }
    public static int  add(int number1, int number2, int number3){
        return add(add(number1,number2),number3);
    }
    public static int  add(String number1, int number2, int number3){
        return add(add(Integer.parseInt(number1),number2),number3);
    }
}
