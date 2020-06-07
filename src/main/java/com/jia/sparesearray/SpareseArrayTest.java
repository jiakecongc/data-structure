package com.jia.sparesearray;

public class SpareseArrayTest {

    public static void main(String[] args) {
        fromMemory();

    }

    public static void fromMemory() {

        int[][] originArray = new int[11][11];
        originArray[2][3] = 1;
        originArray[2][5] = 2;
        originArray[4][4] = 2;

        System.out.println("原始的数组");
        for(int[] row: originArray) {
            for(int num: row) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }

        int countValue = 0;
        for (int[] row: originArray) {
            for (int num: row) {
                if (num != 0) {
                    countValue++;
                }
            }
        }



        int[][] newArray = new int[countValue+1][3];
        newArray[0][0] = 11;
        newArray[0][1] = 11;
        newArray[0][2] = countValue;
        int rowCount = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (originArray[i][j] != 0) {
                    rowCount++;
                    newArray[rowCount][0] = i;
                    newArray[rowCount][1] = j;
                    newArray[rowCount][2] = originArray[i][j];
                }
            }
        }


        System.out.println("得到的稀疏数组：");
        for(int[] row: newArray) {
            for(int num: row) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }


        int[][] transArray = new int[newArray[0][0]][newArray[0][1]];
        for(int[] row : newArray) {
            if (row[0] == 11 && row[1] ==11) {
                continue;
            }
            transArray[row[0]][row[1]] = row[2];
        }

        System.out.println("由稀疏数组转换：");
        for(int[] row: transArray) {
            for(int num: row) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }

    }

}
