package bytetest;


import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        int[] ints = {0, 1, 3};
        int[] more = {3, 5, 7};

        printIntValuesInBinary(ints);
        printIntValuesInBinary(more);

        printBinaryOperations();
    }

    public static void printIntValuesInBinary(int... values) {
        Arrays.stream(values)
                .forEach(value -> {
                    System.out.println("(decimal) " + value + " = (binary) 0b" + Integer.toBinaryString(value));
                });
    }

    private static void printBinaryOperations() {

        int[] ints1 = {0, 1, 3};
        int[] ints2 = {3, 5, 7};

        System.out.println("/**************OR***************/");
        System.out.println("/*            0|0=0            */");
        System.out.println("/*            1|0=1            */");
        System.out.println("/*            1|1=1            */");
        System.out.println("/*******************************/");
        printBinaryOrTable(ints1, ints2);

        System.out.println("/**************AND**************/");
        System.out.println("/*            0&0=0            */");
        System.out.println("/*            1&0=0            */");
        System.out.println("/*            1&1=1            */");
        System.out.println("/*******************************/");
        printBinaryAndTable(ints1, ints2);

        System.out.println("/**************XOR**************/");
        System.out.println("/*            0^0=1            */");
        System.out.println("/*            1^0=1            */");
        System.out.println("/*            1^1=0            */");
        System.out.println("/*******************************/");
        printBinaryXORTable(ints1, ints2);

        System.out.println("/***********Compliment**********/");
        System.out.println("/*             ~0=1            */");
        System.out.println("/*             ~1=0            */");
        System.out.println("/*         ~0b101=0b010        */");
        System.out.println("/*******************************/");
        printBinaryComplementTable(ints1, ints2);

        int[] shift1 = {32, 64, 114};
        int[] shift2 = {0, 1, 4};

        System.out.println("/*******Signed Left Shift*******/");
        System.out.println("/* Equal multiplication by 2^n */");
        System.out.println("/*   0<<2 = 0*pow(2, 2) = 0    */");
        System.out.println("/*   1<<3 = 1*pow(2, 3) = 8    */");
        System.out.println("/*   3<<5 = 3*pow(2, 5) = 96   */");
        System.out.println("/*******************************/");
        printBinaryLeftShiftTable(shift1, shift2);

        System.out.println("/******Signed Right Shift*******/");
        System.out.println("/*    Equal division by 2^n    */");
        System.out.println("/*   0>>2 = 0/pow(2, 2) = 0    */");
        System.out.println("/*   4>>1 = 4/pow(2, 1) = 2    */");
        System.out.println("/*  64>>4 = 64/pow(2, 5) = 4   */");
        System.out.println("/*******************************/");
        printBinaryRightShiftTable(shift1, shift2);

        System.out.println("/***********Unsigned Right Shift***********/");
        System.out.println("/*        Equal abs division by 2^n       */");
        System.out.println("/*        0>>>2 = 0/pow(2, 2) = 0         */");
        System.out.println("/*   -4>>>1 = -4/pow(2, 1) = 2147483646   */");
        System.out.println("/*  -64>>>4 = 64/pow(2, 5) = 268435452    */");
        System.out.println("/******************************************/");
        printBinaryUnsignedRightShiftTable(shift1, shift2);
    }

    private static int findZerosBeforeFirstBinaryValue(int firstVal, int secondVal) {
        int zeros = 0;
        firstVal = firstVal == Integer.MIN_VALUE ? firstVal-1 : firstVal;
        if (Math.abs(firstVal) < Math.abs(secondVal))
            zeros = Math.abs(Integer.toBinaryString(secondVal).length()) - Math.abs(Integer.toBinaryString(firstVal).length());
        return zeros;
    }

    private static void printBinaryOrTable(int[] ints1, int[] ints2) {
        System.out.printf("|%38s|\n", "-".repeat(38));
        System.out.printf("| %-7s | %8s | %14s |\n", "int|int", "result", "binary|binary");
        for (int val1 : ints1) {
            for (int val2 : ints2) {
                String zeros1 = "0".repeat(findZerosBeforeFirstBinaryValue(val1, val2));
                String zeros2 = "0".repeat(findZerosBeforeFirstBinaryValue(val2, val1));
                System.out.printf("* %-7s * %8s * %7s|%-7s *\n",
                        String.format("%3d&%-3d", val1, val2),
                        String.format("0b%s", Integer.toBinaryString(val1 | val2)),
                        String.format("0b%s%s", zeros1, Integer.toBinaryString(val1)),
                        String.format("0b%s%s", zeros2, Integer.toBinaryString(val2))
                );
            }
        }
        System.out.printf("|%38s|\n", "-".repeat(38));
    }

    private static void printBinaryAndTable(int[] ints1, int[] ints2) {
        System.out.printf("|%40s|\n", "-".repeat(40));
        System.out.printf("| %-7s | %8s | %17s |\n", "int&int", "result", "binary & binary");
        for (int val1 : ints1) {
            for (int val2 : ints2) {
                String zeros1 = "0".repeat(findZerosBeforeFirstBinaryValue(val1, val2));
                String zeros2 = "0".repeat(findZerosBeforeFirstBinaryValue(val2, val1));
                System.out.printf("* %-7s * %8s * %7s & %-7s *\n",
                        String.format("%3d&%-3d", val1, val2),
                        String.format("0b%s%s",
                                "0".repeat(findZerosBeforeFirstBinaryValue(val1 & val2, Math.max(val1, val2))),
                                Integer.toBinaryString(val1 & val2)
                        ),
                        String.format("0b%s%s", zeros1, Integer.toBinaryString(val1)),
                        String.format("0b%s%s", zeros2, Integer.toBinaryString(val2))
                );
            }
        }
        System.out.printf("|%40s|\n", "-".repeat(40));
    }

    private static void printBinaryXORTable(int[] ints1, int[] ints2) {
        System.out.printf("|%40s|\n", "-".repeat(40));
        System.out.printf("| %-7s | %8s | %17s |\n", "int^int", "result", "binary ^ binary");
        for (int val1 : ints1) {
            for (int val2 : ints2) {
                String zeros1 = "0".repeat(findZerosBeforeFirstBinaryValue(val1, val2));
                String zeros2 = "0".repeat(findZerosBeforeFirstBinaryValue(val2, val1));
                System.out.printf("* %-7s * %8s * %7s ^ %-7s *\n",
                        String.format("%3d^%-3d", val1, val2),
                        String.format("0b%s%s",
                                "0".repeat(findZerosBeforeFirstBinaryValue(val1 ^ val2, Math.max(val1, val2))),
                                Integer.toBinaryString(val1 ^ val2)
                        ),
                        String.format("0b%s%s", zeros1, Integer.toBinaryString(val1)),
                        String.format("0b%s%s", zeros2, Integer.toBinaryString(val2))
                );
            }
        }
        System.out.printf("|%40s|\n", "-".repeat(40));
    }

    private static void printBinaryComplementTable(int[] ints1, int[] ints2) {
        System.out.printf("|%50s|\n", "-".repeat(50));
        System.out.printf("| %-10s | %15s | %17s |\n", "int | int", "binary | binary", "~binary | ~binary");
        for (int val1 : ints1) {
            for (int val2 : ints2) {
                int length1 = Integer.toBinaryString(val1).length();
                int length2 = Integer.toBinaryString(val2).length();
                System.out.printf("* %-10s * %6.5s * %-6.5s * %7.5s * %7.5s *\n",
                        String.format("%3d * %-3d", val1, val2),
                        String.format("0b%s%s", "0".repeat(3 - length1), Integer.toBinaryString(val1)),
                        String.format("0b%s%s", "0".repeat(3 - length2), Integer.toBinaryString(val2)),
                        String.format("0b%s", Integer.toBinaryString(~val1).substring(Integer.toBinaryString(~val1).length() - 3)),
                        String.format("0b%s", Integer.toBinaryString(~val2).substring(Integer.toBinaryString(~val1).length() - 3))

                );
            }
        }
        System.out.printf("|%50s|\n", "-".repeat(50));
    }

    private static void printBinaryLeftShiftTable(int[] ints1, int[] ints2) {
        System.out.printf("|%58s|\n", "-".repeat(58));
        System.out.printf("| %-8s | %3s | %20s | %-13s |\n", "int<<int", "res", "binary << binary", "result");
        for (int val1 : ints1) {
            for (int val2 : ints2) {
                String zeros1 = "0".repeat(findZerosBeforeFirstBinaryValue(val1, val2));
                String zeros2 = "0".repeat(findZerosBeforeFirstBinaryValue(val2, val1));
                System.out.printf("* %-7s * %3s * %7s << %-7s * %-13s *\n",
                        String.format("%3d<<%-3d", val1, val2),
                        String.format("%-3d", val1 << val2),
                        String.format("0b%s%s", zeros1, Integer.toBinaryString(val1)),
                        String.format("0b%s%s", zeros2, Integer.toBinaryString(val2)),
                        String.format("0b%s%s",
                                "0".repeat(findZerosBeforeFirstBinaryValue(val1 << val2, Math.max(val1, val2))),
                                Integer.toBinaryString(val1 << val2)
                        )
                );
            }
        }
        System.out.printf("|%58s|\n", "-".repeat(58));
    }

    private static void printBinaryRightShiftTable(int[] ints1, int[] ints2) {
        System.out.printf("|%55s|\n", "-".repeat(55));
        System.out.printf("| %-8s | %3s | %22s | %-11s |\n", "int>>int", "res", "binary >> binary", "result");
        for (int val1 : ints1) {
            for (int val2 : ints2) {
                String zeros1 = "0".repeat(findZerosBeforeFirstBinaryValue(val1, val2));
                String zeros2 = "0".repeat(findZerosBeforeFirstBinaryValue(val2, val1));
                System.out.printf("* %-7s * %3s * %9s >> %-9s * %-11s *\n",
                        String.format("%3d>>%-3d", val1, val2),
                        String.format("%-3d", val1 >> val2),
                        String.format("0b%s%s", zeros1, Integer.toBinaryString(val1)),
                        String.format("0b%s%s", zeros2, Integer.toBinaryString(val2)),
                        String.format("0b%s%s",
                                "0".repeat(findZerosBeforeFirstBinaryValue(val1 >> val2, Math.max(val1, val2))),
                                Integer.toBinaryString(val1 >> val2)
                        )
                );
            }
        }
        System.out.printf("|%55s|\n", "-".repeat(55));
    }

    private static void printBinaryUnsignedRightShiftTable(int[] ints1, int[] ints2) {
        System.out.printf("|%57s|\n", "-".repeat(57));
        System.out.printf("| %-8s | %3s | %23s | %-11s |\n", "int>>>int", "res", "binary >>> binary", "result");
        for (int val1 : ints1) {
            for (int val2 : ints2) {
                String zeros1 = "0".repeat(findZerosBeforeFirstBinaryValue(val1, val2));
                String zeros2 = "0".repeat(findZerosBeforeFirstBinaryValue(val2, val1));
                System.out.printf("* %-7s * %3s * %9s >>> %-9s * %-11s *\n",
                        String.format("%3d>>>%-3d", val1, val2),
                        String.format("%-3d", val1 >>> val2),
                        String.format("0b%s%s", zeros1, Integer.toBinaryString(val1)),
                        String.format("0b%s%s", zeros2, Integer.toBinaryString(val2)),
                        String.format("0b%s%s",
                                "0".repeat(findZerosBeforeFirstBinaryValue(val1 >>> val2, Math.max(val1, val2))),
                                Integer.toBinaryString(val1 >>> val2)
                        )
                );
            }
        }
        System.out.printf("|%57s|\n", "-".repeat(57));
    }
}
