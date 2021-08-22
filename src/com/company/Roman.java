package com.company;

import java.util.HashMap;
import java.util.Map;

/**Класс для работы с римскими числами.
 * В классе реализовано:
 *      формирование римского числа с учётом правил вычитания;
 *      перевод значения правильно сформированного римского числа в арабский вид;
 *      проверка правильности переданного римского числа.
 */
public abstract class Roman {
    private static final Map<String, Integer> romDigits = new HashMap<>();
    static {
        romDigits.put("I",1);
        romDigits.put("V",5);
        romDigits.put("X",10);
        romDigits.put("L",50);
        romDigits.put("C",100);
        romDigits.put("D",500);
        romDigits.put("M",1000);
    }

    public static boolean isRoman(String s){
        // проверка состава числа на предмет неправильных символов
        String[] chars = s.split("");
        for (String ch: chars) {
            if (!romDigits.containsKey(ch)){
                return false;
            }
        }
        // проверка правильности формирования числа:
        //      1. вычисление значения переданного числа
        //      2. перевод значения к правильному римскому виду
        //      3. сравнение переданного числа с правильным видом
        int r2a = Roman.romanToArabic(s);
        String r2a2r = Roman.arabicToRoman(r2a);
        return s.equals(r2a2r);
    }

    /** Принимает в качестве аргумента римское число, возвращает равное ему арабское.
     * Число на входе должно соответствовать правилам записи римских чисел, иначе возвращается -1.
     */
    public static int romanToArabic(String romanNumber) {
        int result = 0;
        String[] chars = romanNumber.split("");
        for (int i = 0; i < chars.length; ++i) {
            if (i + 1 < chars.length && romDigits.get(chars[i]) < romDigits.get(chars[i + 1])) {
                result -= romDigits.get(chars[i]);
                continue;
            }
            result += romDigits.get(chars[i]);
        }
        if (Roman.arabicToRoman(result).equals(romanNumber))
            return result;
        else return -1;
    }

    public static String arabicToRoman(int arabicNumber) {
        StringBuilder builder = new StringBuilder();
        while (arabicNumber >= 1000) {
            builder.append("M");
            arabicNumber -= 1000;
        }
        if (arabicNumber >= 900) {
            builder.append("CM");
            arabicNumber -= 900;
        } else if (arabicNumber >= 500) {
            builder.append("D");
            arabicNumber -= 500;
        } else if (arabicNumber >= 400) {
            builder.append("CD");
            arabicNumber -= 400;
        }

        while (arabicNumber >= 100) {
            builder.append("C");
            arabicNumber -= 100;
        }
        if (arabicNumber >= 90) {
            builder.append("XC");
            arabicNumber -= 90;
        } else if (arabicNumber >= 50) {
            builder.append("L");
            arabicNumber -= 50;
        } else {
            if (arabicNumber >= 40) {
                builder.append("XL");
                arabicNumber -= 40;
            }
        }

        while (arabicNumber >= 10) {
            builder.append("X");
            arabicNumber -= 10;
        }
        if (arabicNumber >= 9) {
            builder.append("IX");
            arabicNumber -= 9;
        } else if (arabicNumber >= 5) {
            builder.append("V");
            arabicNumber -= 5;
        } else {
            if (arabicNumber % 5 >= 4) {
                builder.append("IV");
                arabicNumber -= 4;
            }
        }

        while (arabicNumber > 0) {
            builder.append("I");
            arabicNumber -= 1;
        }
        return builder.toString();
    }


}
