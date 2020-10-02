package com.tianhongguoji.test.main;

import java.util.Scanner;

/**
 * 名称： Main
 * 作者：
 * 日期： 2020-07-18 12:58
 * 描述： 算法
 **/
public class Main {

//    private static int MONEYS = 0;
//    private static int I = 0;
//    private static final String STRING = "Input #";
//    private static final String sweet = ": Sweet!";
//    private static final String totallySweet = ": Totally Sweet!";
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            I++;
//            int money = Integer.parseInt(sc.nextLine());
//            if (money == 0) {
//                break;
//            }
//            MONEYS =  MONEYS + money;
//            if (MONEYS > 50) {
//                if (MONEYS > 100) {
//                    System.out.println(STRING + I + totallySweet);
//                } else {
//                    System.out.println(STRING + I + sweet);
//                }
//                MONEYS = MONEYS % 50;
//            }
//        }
//    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int numPingZi = 0;
        int num = 0;
        while (true) {
            //讲现在的酒喝掉，计数酒瓶并添加已喝数量
            numPingZi = numPingZi + numBottles;
            num = num + numBottles;
            //对现在的酒瓶数进行兑换并减去酒瓶数
            numBottles = numPingZi / numExchange;
            numPingZi = numPingZi - (numBottles * numExchange);
            if (numBottles == 0) break;
        }
        return num;
    }

//1．某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：
// 每位数字都加上5，然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。

    /**
     * 题目 获取加密数据
     *
     * 题目内容 某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：
     * 每位数字都加上5，然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。
     *
     * @param data 元数据
     * @return int 加密数据
     */
//    public static int getEncryptedData(int data) {
//        String str = data + "";
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 4; i++) {
//            int ii = str.charAt(i);
//            ii = (ii + 5) % 10;
//            sb.append(ii);
//        }
//        StringBuilder newSb = new StringBuilder();
//        for (int i = 3; i >= 0 ; i--) {
//            newSb.append(sb.charAt(i));
//        }
//        return Integer.parseInt(newSb.toString());
//    }

    public static void main(String[] args) {
        //需要加密的数据（四位整数）
        int data = 1234;
        String str = data + "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int ii = str.charAt(i) - 48;
            ii = (ii + 5) % 10;
            sb.append(ii);
        }
        StringBuilder newSb = new StringBuilder();
        for (int i = 3; i >= 0 ; i--) {
            newSb.append(sb.charAt(i));
        }
        //打印加密后的数据
        System.out.println(newSb);
    }

//2．海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子平均分为五份，多了一个，这只猴子把多的一个扔入海中，
// 拿走了一份。第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，
// 拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？

//    public static void main(String[] args) {
//        //初始化桃子数量 取值范围[0,∞）
//        int taoNum = 3121;
//        int status = 0;
//        while (true) {
//            int tn = taoNum;
//            for (int i = 0; i < 5; i++) {
//                if (tn % 5 == 1) {
//                    tn = ((tn - 1) / 5) << 2;
//                } else {
//                    status = 1;
//                    break;
//                }
//            }
//            if (status == 0) {
//                break;
//            } else {
//                ++ taoNum;
//                status = 0;
//            }
//        }
//        //打印桃子数量
//        System.out.println(taoNum);
//    }

}
