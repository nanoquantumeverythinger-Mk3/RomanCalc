package com.company;

public class Calculator {
    // поля для определения наибольшего и наименьшего чисел, с которыми может работать калькулятор.
    private static final int topNumber = 10;
    private static final int lowNumber = 1;

    public static void calculate(String s) throws Exception {
        String[] data = s.split(" ");
        if (Roman.isRoman(data[0]) && Roman.isRoman(data[2])){
            int a = Roman.romanToArabic(data[0]);
            int b = Roman.romanToArabic(data[2]);
            if (a > topNumber || a < lowNumber || b > topNumber || b < lowNumber) throw new Exception();
            switch (data[1]){
                case "+":
                    System.out.println(Roman.arabicToRoman(a + b));
                    break;
                case "-":
                    if (a - b > 0) {
                        System.out.println(Roman.arabicToRoman(a - b));
                        break;
                    } else throw new Exception();
                case "/":
                    if (a / b > 0) {
                        System.out.println(Roman.arabicToRoman(a / b));
                        break;
                    } else throw new Exception();
                case "*":
                    System.out.println(Roman.arabicToRoman(a * b));
                    break;
                default: throw new Exception();
            }
        }
        else try{
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[2]);
            if (a > topNumber || a < lowNumber || b > topNumber || b < lowNumber) throw new Exception();
            switch (data[1]){
                case "+":
                    System.out.println(a + b);
                    break;
                case "-":
                    System.out.println(a - b);
                    break;
                case "/":
                    System.out.println(a / b);
                    break;
                case "*":
                    System.out.println(a * b);
                    break;
                default: throw new Exception();
            }
        } catch (NumberFormatException e){
            throw e;
        }

    }
}
