//package com.tianhongguoji.test.controller.demo;
//
//import java.math.BigDecimal;
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//public class Main {
////    1.
////    正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
////
////    输入描述:输入两个正整数A和B。
////
////    输出描述:输出A和B的最小公倍数。
////    示例1
////    输入
////    5 7
////    输出
////    35
//
//    public static int ti1(int a,int b) {
//        if (a == b) {
//            return a;
//        }
//        int x;
//        if (a > b) {
//            x = a;
//        } else {
//            x = b;
//        }
//        while (true) {
//            x ++;
//            if (x % a == 0 && x % b == 0) {
//                return x;
//            }
//        }
//    }
//
////    public static void main1(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        String str = sc.nextLine();
////        String [] strings = str.split(" ");
////        int a = Integer.parseInt(strings [0]);
////        int b = Integer.parseInt(strings [1]);
////        System.out.println(ti1(a,b));
////    }
//
////    将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。 如：输入“I am a student”，输出“tneduts a ma I”。
////
////    输入参数：
////
////    inputString：输入的字符串
////
////    返回值：
////
////    输出转换好的逆序字符串
////
////    输入描述:
////    输入一个字符串，可以有空格
////
////    输出描述:
////    输出逆序的字符串
////
////            示例1
////    输入
////    I am a student
////    输出
////    tneduts a ma I
//
//    public static void ti2(String [] ss) {
//        for (int i = 0; i < ss.length; i++) {
//            System.out.print(ss[ss.length - i - 1]);
//        }
//    }
//
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        String str = sc.nextLine();
////        String [] ss = str.split("");
////        ti2(ss);
////    }
//
////    功能:等差数列 2，5，8，11，14。。。。
////
////    输入:正整数N >0
////
////    输出:求等差数列前N项和
////
////    返回:转换成功返回 0 ,非法输入与异常返回-1
////
////    本题为多组输入，请使用while(cin>>)等形式读取数据
////
////    输入描述:
////    输入一个正整数。
////
////    输出描述:
////    输出一个相加后的整数。
////
////    示例1
////    输入
////    2
////    输出
////    7
//
//    public static void ti3(int a) {
//        int x = 2,y = 3, z = 0, sum = 0;
//        for (int i = 0; i < a; i++) {
//            if (i == 0) {
//                z = x;
//            } else {
//                z += 3;
//            }
//            sum += z;
//        }
//        System.out.println(sum);
//    }
//
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        while (sc.hasNextInt()) {
////            int a = sc.nextInt();
////            ti3(a);
////        }
////    }
//
////•计算一个数字的立方根，不使用库函数
////
////    详细描述：
////
////            •接口说明
////
////    原型：
////
////    public static double getCubeRoot(double input)
////
////    输入:double 待求解参数
////
////    返回值:double  输入参数的立方根，保留一位小数
////
////    输入描述:
////    待求解参数 double类型
////
////    输出描述:
////    输入参数的立方根 也是double类型
////
////    示例1
////    输入
////    216
////    输出
////    6.0
//
//    public static double getCubeRoot(double input) {
//        int zf = 1;
//        if (input < 0) {
//            zf = 0;
//            input = -input;
//        }
//        double five = 125.0;
//        double ten = 1000.0;
//        if (five == input) {
//            return 5.0;
//        }
//        if (ten == input) {
//            return 10.0;
//        }
//        int multiple = 0;
//        int multipleDouble = 1;
//        double i;
//        while (true) {
//            for (int j = 0; j < multiple; j++) {
//                multipleDouble = multipleDouble * 1000;
//            }
//            i = five * multipleDouble;
//            if (input < i) {
//                break;
//            }
//            multiple ++;
//        }
//        double maxDouble = 0.0;
//        if (multiple == 0) {
//            for (int j = 1; j < 5; j++) {
//                int jjj = j * j * j;
//                if (jjj > input) {
//                    maxDouble = j;
//                    break;
//                }
//            }
//        } else {
//            int ii = 10;
//            for (int j = 1; j < multiple; j++) {
//                ii = ii * 10;
//            }
//            for (int j = (5 * ii)/10; j < (5 * ii); j++) {
//                int jjj = j * j * j;
//                if (jjj > input) {
//                    maxDouble = j;
//                    break;
//                }
//            }
//        }
//        int sta = 0;
//        double endDouble = 0.0;
//        for (double j = maxDouble - 1; j < maxDouble; j = j + 0.1) {
//            double jjj = j * j * j;
//            if (jjj == input) {
//                endDouble = j;
//                sta = 1;
//                break;
//            }
//            if (jjj > input) {
//                endDouble = j;
//                break;
//            }
//        }
//        double endEndDouble = 0.0;
//        if (sta == 0) {
//            for (double j = endDouble - 0.1; j < endDouble; j = j + 0.01) {
//                double jjj = j * j * j;
//                if (jjj == input) {
//                    endEndDouble = j;
//                    break;
//                }
//                if (jjj > input) {
//                    endEndDouble = j;
//                    break;
//                }
//            }
//        } else {
//            endEndDouble = endDouble;
//        }
//        BigDecimal b = new BigDecimal(endEndDouble);
//        double f1 = b.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();
//        return f1;
//    }
//
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        double a = sc.nextDouble();
////        System.out.println(getCubeRoot(a));
////    }
//
////    Redraiment是走梅花桩的高手。Redraiment总是起点不限，从前到后，往高的桩子走，但走的步数最多，不知道为什么？你能替Redraiment研究他最多走的步数吗？
////
////    样例输入
////
////    6
////
////        2 5 1 5 4 5
////
////    样例输出
////
////    3
////
////    提示
////
////    Example:
////    6个点的高度各为 2 5 1 5 4 5
////    如从第1格开始走,最多为3步, 2 4 5
////    从第2格开始走,最多只有1步,5
////    而从第3格开始走最多有3步,1 4 5
////    从第5格开始走最多有2步,4 5
////
////    所以这个结果是3。
////
////    接口说明
////
////    方法原型：
////
////    int GetResult(int num, int[] pInput, List  pResult);
////
////    输入参数：
////    int num：整数，表示数组元素的个数（保证有效）。
////    int[] pInput: 数组，存放输入的数字。
////
////    输出参数：
////    List pResult: 保证传入一个空的List，要求把结果放入第一个位置。
////    返回值：
////    正确返回1，错误返回0
////
////    输入描述:
////    输入多行，先输入数组的个数，再输入相应个数的整数
////
////    输出描述:
////    输出结果
////
////            示例1
////    输入
////        6
////        2
////        5
////        1
////        5
////        4
////        5
////    输出
////        3
//    //9:35
////    用例:
////            30
////            186 13 322 264 328 110 120 73 20 35 240 97 150 221 284 324 46 219 239 284 128 251 298 319 304 36 144 236 163 122
////
////    对应输出应该为:
////
////            10
//    public static int GetResult(int num, int[] pInput) {
//        int n = 0,size;
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < num; i++) {
//            for (int j = i; j < num; j++) {
//                list.add(pInput[j]);
//            }
//            size = list.size();
//            int s = 0;
//            for (int j = 0; j < size - 1; j++) {
//                int nn = 0;
//                int nnn = -1;
//                for (int k = 0; k < size; k++) {
//                    if (k == 0 || k > j) {
//                        int jj = list.get(k);
//                        if (nnn < jj) {
//                            nnn = jj;
//                            nn++;
//                        }
//                    }
//                }
//                if (nn > n) {
//                    n = nn;
//                }
//                s++;
//            }
//            list.clear();
//        }
//        return n;
//    }
//
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        int num = sc.nextInt();
////        int [] pInput = new int[num];
////        for (int i = 0; i < num; i++) {
////            pInput[i] = sc.nextInt();
////        }
////        System.out.println(GetResult(num,pInput));
////    }
//
////    P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），
////    则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
////    如下图：实心点为满足条件的点的集合。请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。
//    public static void tt1(int num , int [] [] nums){
//        TreeMap<Integer,String> map = new TreeMap<>();
//        for (int i = 0; i < num; i++) {
//            int s = 0;
//            int x = nums[i][0];
//            int y = nums[i][1];
//            for (int j = 0; j < num; j++) {
//                if (x < nums[j][0] && y < nums[j][1]) {
//                    s = 1;
//                    break;
//                }
//            }
//            if (s == 0) {
//                map.put(x,x + " " + y);
//            }
//            System.gc();
//        }
//        for (Map.Entry entry : map.entrySet()) {
//            System.out.println(entry.getValue());
//        }
//    }
//
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        while (sc.hasNext()) {
////            String n = sc.nextLine();
////            int intn = Integer.parseInt(n);
////            int [] [] nums = new int[intn][2];
////            for (int i = 0; i < nums.length; i++) {
////                String [] strings = sc.nextLine().split(" ");
////                int num1 = Integer.parseInt(strings[0]);
////                int num2 = Integer.parseInt(strings[1]);
////                nums [i] [0] = num1;
////                nums [i] [1] = num2;
////            }
////            tt1(intn,nums);
////        }
////    }
//
////    蒜头又要改变世界了。这次他将为一些恶劣地形环境设计太阳能取电方案。
////    在最新的设计中，太阳能板被设置在一些太阳能塔上，与塔同高。
////    这一次，将有 n 座太阳能塔被设置，这些塔已经被提前制作完成，其中 i 号塔高为 hi，现在工程师需要确定将塔安置在哪些位置，以获得最大的总能量。
////    太阳能塔被安置的地形环境由 m 个点的多边形来表示。多边形的每个点将会给出对应的坐标（xi, yi），xi < xi+1。
////    经过测量可知，太阳在此地的照射角度恒为 α 度。太阳的阳光洒满在最左上角到最右下角的区域。获取的太阳能的多少取决于被太阳光照射的塔的长度。
////    当两座塔被安置的较近时，左边的塔的影子会落在右边的塔上，这样右边的塔产生的能量就会有一定程度的减少。同理，周围起伏的地形也会对太阳能塔有一些遮挡，从而使获取的能量有所减少。
////    你的任务是设计太阳能塔的安置位置方案，使得所有太阳能塔获得尽可能多的能量。
////    输入
////    输入文件的第一行包含三个整数 n, m, α（1 ≤ n ≤ 104, 2 ≤ m ≤ 104, 1 ≤ α < 90)。
////    第二行包含 n 个整数 hi, 为塔的高度（1 ≤ hi ≤ 103)。
////    接下来的 m 行为 xi,yi 对，为地形的顶点坐标（|xi| ≤ 105, xi < xi+1, |yi| ≤ 103）。
////    输出
////    输出文件的第一行为最大的可能获得的太阳能量值，绝对误差不超过 10-6。
////    接下来的 n 行输出太阳能塔安置位置的 x 点坐标，绝对误差不超过 10-9。
////    太阳能塔的坐标的输出顺序请与输入顺序保持一致。
////    如果有多种使得总能量值最大的方案，输出任意一种即可。
//
//
////    我叫王大锤，是一名特工。我刚刚接到任务：在字节跳动大街进行埋伏，抓捕恐怖分子孔连顺。和我一起行动的还有另外两名特工，我提议
////
////    1. 我们在字节跳动大街的N个建筑中选定3个埋伏地点。
////    2. 为了相互照应，我们决定相距最远的两名特工间的距离不超过D。
////
////    我特喵是个天才! 经过精密的计算，我们从X种可行的埋伏方案中选择了一种。这个方案万无一失，颤抖吧，孔连顺！
////            ……
////    万万没想到，计划还是失败了，孔连顺化妆成小龙女，混在cosplay的队伍中逃出了字节跳动大街。只怪他的伪装太成功了，就是杨过本人来了也发现不了的！
////
////    请听题：给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
////    注意：
////            1. 两个特工不能埋伏在同一地点
////            2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用
////
////
////    输入描述:
////    第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)
////
////    第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，从小到大排列（将字节跳动大街看做一条数轴）
////
////    输出描述:
////    一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模
////
////    输入例子1:
////            4 3
////            1 2 3 4
////
////    输出例子1:
////            4
////
////    例子说明1:
////    可选方案 (1, 2, 3), (1, 2, 4), (1, 3, 4), (2, 3, 4)
////
////    输入例子2:
////            5 19
////            1 10 20 30 50
////
////    输出例子2:
////            1
////
////    例子说明2:
////    可选方案 (1, 10, 20)
//
////    小包最近迷上了一款叫做雀魂的麻将游戏，但是这个游戏规则太复杂，小包玩了几个月了还是输多赢少。
////    于是生气的小包根据游戏简化了一下规则发明了一种新的麻将，只留下一种花色，并且去除了一些特殊和牌方式（例如七对子等），具体的规则如下：
////
////    总共有36张牌，每张牌是1~9。每个数字4张牌。
////    你手里有其中的14张牌，如果这14张牌满足如下条件，即算作和牌
////    14张牌中有2张相同数字的牌，称为雀头。
////    除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）
////
////    例如：
////            1 1 1 2 2 2 6 6 6 7 7 7 9 9 可以组成1,2,6,7的4个刻子和9的雀头，可以和牌
////            1 1 1 1 2 2 3 3 5 6 7 7 8 9 用1做雀头，组123,123,567,789的四个顺子，可以和牌
////            1 1 1 2 2 2 3 3 3 5 6 7 7 9 无论用1 2 3 7哪个做雀头，都无法组成和牌的条件。
////
////    现在，小包从36张牌中抽取了13张牌，他想知道在剩下的23张牌中，再取一张牌，取到哪几种数字牌可以和牌。
////
////    输入描述:
////    输入只有一行，包含13个数字，用空格分隔，每个数字在1~9之间，数据保证同种数字最多出现4次。
////
////    输出描述:
////    输出同样是一行，包含1个或以上的数字。代表他再取到哪些牌可以和牌。若满足条件的有多种牌，请按从小到大的顺序输出。若没有满足条件的牌，请输出一个数字0
////
////    输入例子1:
////            1 1 1 2 2 2 5 5 5 6 6 6 9
////
////    输出例子1:
////            9
////
////    例子说明1:
////    可以组成1,2,6,7的4个刻子和9的雀头
////
////    输入例子2:
////            1 1 1 1 2 2 3 3 5 6 7 8 9
////
////    输出例子2:
////            4 7
////
////    例子说明2:
////    用1做雀头，组123,123,567或456,789的四个顺子
////
////    输入例子3:
////            1 1 1 2 2 2 3 3 3 5 7 7 9
////
////    输出例子3:
////            0
////
////    例子说明3:
////    来任何牌都无法和牌
//
//    /**
//     * AAABBBCCCDDDEE
//     * AAABBBCCCABCEE
//     * AAABBBABCABCEE
//     * AAAABCABCABCEE
//     * ABCABCABCABCEE
//     * @param nums
//     */
//    public static void tt2(int [] nums){
//        Arrays.sort(nums);
//        int n = 0;
//        int num = 0;
//        TreeSet treeSet = new TreeSet();
//        for (int i = 1; i < 10; i++) {
//            for (int j = 0; j < 5; j++) {
//                int sta = 0, stan = 1;
//                int[] newNums = Arrays.copyOf(nums, 13);
//                List<Integer> list = new ArrayList<>();
//                for (int k = 0; k < 13; k++) {
//                    int nn = newNums[k];
//                    if (nn == sta) {
//                        sta = nn;
//                        stan++;
//                    }
//                    if (stan == 3) {
//                        list.add(k - 2);
//                        list.add(k - 1);
//                        list.add(k);
//                    }
//                }
//
//            }
//        }
//
//        if (n == 0) {
//            System.out.println(n);
//        } else {
//
//        }
//    }
//
////    public static void main(String[] args) {
////        List<Integer> list = new ArrayList<>();
////        list.add(1);
////        list.add(2);
////        list.add(3);
////        System.out.println(list.contains(1));
////        int [] a = new int[13];
////        Arrays.fill(a, 2);
//////        System.out.println(Arrays.toString(a));int[] newNums = new int[14];
////        int[] newNums = Arrays.copyOf(a, 14);
////        newNums[13] = 14;
////        System.out.println(Arrays.toString(newNums));
////        Scanner sc = new Scanner(System.in);
////        String[] s = sc.nextLine().split(" ");
////        int [] nums = new int[13];
////        for (int i = 0; i < s.length; i++) {
////            nums[i] = Integer.parseInt(s[i]);
////        }
////        tt2(nums);
////    }
//
////    小明是一名算法工程师，同时也是一名铲屎官。某天，他突发奇想，想从猫咪的视频里挖掘一些猫咪的运动信息。为了提取运动信息，
////    他需要从视频的每一帧提取“猫咪特征”。一个猫咪特征是一个两维的vector<x, y>。如果x_1=x_2 and y_1=y_2，那么这俩是同一个特征。
////    因此，如果喵咪特征连续一致，可以认为喵咪在运动。也就是说，如果特征<a, b>在持续帧里出现，那么它将构成特征运动。比如，
////    特征<a, b>在第2/3/4/7/8帧出现，那么该特征将形成两个特征运动2-3-4 和7-8。
////    现在，给定每一帧的特征，特征的数量可能不一样。小明期望能找到最长的特征运动。
////
////    输入描述:
////    第一行包含一个正整数N，代表测试用例的个数。
////
////    每个测试用例的第一行包含一个正整数M，代表视频的帧数。
////
////    接下来的M行，每行代表一帧。其中，第一个数字是该帧的特征个数，接下来的数字是在特征的取值；比如样例输入第三行里，2代表该帧有两个猫咪特征，<1，1>和<2，2>
////    所有用例的输入特征总数和<100000
////
////    N满足1≤N≤100000，M满足1≤M≤10000，一帧的特征个数满足 ≤ 10000。
////    特征取值均为非负整数。
////
////    输出描述:
////    对每一个测试用例，输出特征运动的长度作为一行
////
////    输入例子1:
////            1
////            8
////            2 1 1 2 2
////            2 1 1 1 4
////            2 1 1 2 2
////            2 2 2 1 4
////            0
////            0
////            1 1 1
////            1 1 1
////
////    输出例子1:
////            3
////
////    例子说明1:
////    特征<1,1>在连续的帧中连续出现3次，相比其他特征连续出现的次数大，所以输出3
//
//
//
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        int n = Integer.parseInt(sc.nextLine());
////        Map<String,Integer> map1 = new HashMap<>();
////        Map<String,Integer> map2 = new HashMap<>();
////        //上一级的特征
////        List<String> list = new ArrayList<>();
////        for (int i = 0; i < n; i++) {
////            //获取帧数
////            int n1 = Integer.parseInt(sc.nextLine());
////            //循环获取帧数
////            for (int j = 0; j < n1; j++) {
////                //用于存储当前帧的特征
////                Set<String> set = new HashSet<>();
////                //获取去数据
////                String[] strings = sc.nextLine().split(" ");
////                //特征个数
////                int nn = Integer.parseInt(strings[0]);
////                //循环获取每一个特征并去重
////                for (int k = 0; k < nn; k++) {
////                    String ss = strings[((k << 1) + 1)] + " " + strings[(k << 1) + 2];
////                    set.add(ss);
////                }
////                //对特征计数
////                for (String x : set) {
////                    if (list.contains(x)) {
////                        map2.put(x,map2.get(x) + 1);
////                    } else {
////                        if (map2.get(x) == null) {
////                            map2.put(x,1);
////                        } else {
////                            if (map1.get(x) == null) {
////                                map1.put(x,map2.get(x));
////                            } else {
////                                if (map1.get(x) < map2.get(x)) {
////                                    map1.put(x,map2.get(x));
////                                }
////                            }
////                            map2.put(x,1);
////                        }
////                    }
////                }
////                list = new ArrayList(set);
////            }
////            int max1 = 0,max2 = 0;
////            if (!map1.isEmpty()) {
////                Collection<Integer> c1 = map1.values();
////                Object[] obj1 = c1.toArray();
////                Arrays.sort(obj1);
////                max1 = (int) obj1[obj1.length - 1];
////            }
////            if (!map2.isEmpty()) {
////                Collection<Integer> c2 = map2.values();
////                Object[] obj2 = c2.toArray();
////                Arrays.sort(obj2);
////                max2 = (int) obj2[obj2.length - 1];
////            }
////            System.out.println(Math.max(max1, max2));
////        }
////    }
//
////    小明目前在做一份毕业旅行的规划。打算从北京出发，分别去若干个城市，然后再回到北京，每个城市之间均乘坐高铁，
////    且每个城市只去一次。由于经费有限，希望能够通过合理的路线安排尽可能的省一些路上的花销。给定一组城市和每对城市之间的火车票的价钱，
////    找到每个城市只访问一次并返回起点的最小车费花销。
////
////    输入描述:
////    城市个数n（1<n≤20，包括北京）
////
////    城市间的车票价钱 n行n列的矩阵 m[n][n]
////
////    输出描述:
////    最小车费花销 s
////
////    输入例子1:
////            4
////            0 2 6 5
////            2 0 4 4
////            6 4 0 2
////            5 4 2 0
////
////    输出例子1:
////            13
////
////    例子说明1:
////    共 4 个城市，城市 1 和城市 1 的车费为0，城市 1 和城市 2 之间的车费为 2，城市 1 和城市 3 之间的车费为 6，
////    城市 1 和城市 4 之间的车费为 5，依次类推。假设任意两个城市之间均有单程票可购买，且票价在1000元以内，无需考虑极端情况。
//
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        int n = Integer.parseInt(sc.nextLine());
////        int[][] nums = new int[n][n];
////        for (int i = 0; i < n; i++) {
////            String [] strings = sc.nextLine().split(" ");
////            for (int j = 0; j < n; j++) {
////                nums[i][j] = Integer.parseInt(strings[j]);
////            }
////        }
////        int[] num = new int[n];
////        for (int i = 0; i < n; i++) {
////            num[i] = i;
////        }
////        List<int[]> list = new ArrayList<>();
////        list = permutation(num,n,0,list);
////        int min = 10000;
////        for (int[] ns : list) {
////            int v = 0;
////            for (int i = 0; i < (n - 1); i++) {
////                int a = ns[i];
////                int b = ns[i + 1];
////                v = v + nums[a][b];
////            }
////            v = v + nums[ns[0]][ns[n - 1]];
////            if (v < min) {
////                min = v;
////            }
////        }
////        System.out.println(min);
////    }
////
////    public static List<int[]> permutation(int[] a, int length, int index, List<int[]> list) {
////        if (index == length) {
////            int [] nums = new int[length];
////            for (int i = 0; i < length; i++) {
////                nums[i] = a[i];
////            }
////            list.add(nums);
////        } else {
////            for (int i = index; i < length; i++) {
////                if (isSwap(a, length, i)) {
////                    swap(a, index, i);
////                    permutation(a, length, index + 1, list);
////                    swap(a, index, i);
////                }
////            }
////        }
////        return list;
////    }
////
////    private static boolean isSwap(int[] a, int length, int index) {
////        for (int i = index + 1; i < length; i++) {
////            if (a[index] == a[i]) {
////                return false;
////            }
////        }
////        return true;
////    }
////
////    private static void swap(int[] a, int index, int i) {
////        int temp = a[index];
////        a[index] = a[i];
////        a[i] = temp;
////    }
//
////    Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。现在小Y使用1024元的纸币购买了一件价值为的商品，请问最少他会收到多少硬币？
////
////    输入描述:
////    一行，包含一个数N。
////
////    输出描述:
////    一行，包含一个数，表示最少收到的硬币数。
////
////    输入例子1:
////            200
////
////    输出例子1:
////            17
////
////    例子说明1:
////    花200，需要找零824块，找12个64元硬币，3个16元硬币，2个4元硬币即可。
//
////    private static final int[] N = {64, 16, 4, 1};
////
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        int num = sc.nextInt();
////        int newNum = 1024 - num;
////        int number = 0;
////        int status = 0;
////        for (int i = 0; i < 4; i++) {
////            int n = N [i];
////            while (true) {
////                if (newNum - n < 0)
////                    break;
////                newNum = newNum - n;
////                number++;
////                if (newNum == 0) {
////                    status = 1;
////                    break;
////                }
////                if (newNum < n)
////                    break;
////            }
////            if (status == 1)
////                break;
////        }
////        System.out.println(number);
////    }
//
////    机器人正在玩一个古老的基于DOS的游戏。游戏中有N+1座建筑——从0到N编号，从左到右排列。编号为0的建筑高度为0个单位，编号为i的建筑的高度为H(i)个单位。
////    起初， 机器人在编号为0的建筑处。每一步，它跳到下一个（右边）建筑。假设机器人在第k个建筑，且它现在的能量值是E, 下一步它将跳到第个k+1建筑。
////    它将会得到或者失去正比于与H(k+1)与E之差的能量。如果 H(k+1) > E 那么机器人就失去 H(k+1) - E 的能量值，否则它将得到 E - H(k+1) 的能量值。
////    游戏目标是到达第个N建筑，在这个过程中，能量值不能为负数个单位。现在的问题是机器人以多少能量值开始游戏，才可以保证成功完成游戏？
////
////    输入描述:
////    第一行输入，表示一共有 N 组数据.
////    第二个是 N 个空格分隔的整数，H1, H2, H3, ..., Hn 代表建筑物的高度
////
////    输出描述:
////    输出一个单独的数表示完成游戏所需的最少单位的初始能量
////
////    输入例子1:
////            5
////            3 4 3 2 4
////    输出例子1:
////            4
////
////    输入例子2:
////            3
////            4 4 4
////    输出例子2:
////            4
////
////    输入例子3:
////            3
////            1 6 4
////    输出例子3:
////            3
//
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        int num = Integer.parseInt(sc.nextLine());
////        String [] strings = sc.nextLine().split(" ");
////        int [] nums = new int[num];
////        for (int i = 0; i < num; i++) {
////            nums[i] = Integer.parseInt(strings[i]);
////        }
////        int NN = IntStream.of(nums).sum() / num;
////        while (true) {
////            int sta = 0;
////            int N = NN;
////            for (int i = 0; i < num; i++) {
////                if (num < nums[i]) {
////                    N = N - (nums[i] - N);
////                } else {
////                    N = N + (N - nums[i]);
////                }
////                if (N < 0) {
////                    sta = 1;
////                    break;
////                }
////            }
////            if (sta == 0)
////                break;
////            NN++;
////        }
////        System.out.println(NN);
////    }
//
////    给你一个数字数组 arr 。
////    如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
////    如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
////    示例 1：
////
////    输入：arr = [3,5,1]
////    输出：true
////    解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
////    示例 2：
////
////    输入：arr = [1,2,4]
////    输出：false
////    解释：无法通过重新排序得到等差数列。
//
////    提示：
////
////            2 <= arr.length <= 1000
////            -10^6 <= arr[i] <= 10^6
//
//    public boolean canMakeArithmeticProgression(int[] arr) {
//        Arrays.sort(arr);
//        int sum1 = IntStream.of(arr).sum();
//        int sum2 = ((arr[0] + arr[arr.length - 1]) * arr.length) >> 1;
//        if (sum2 != sum1)
//            return false;
//        int N = arr[1] - arr[0];
//        int sta = 0;
//        for (int i = 2; i < arr.length; i++) {
//            if ((arr[i] - arr[i - 1]) != N) {
//                sta = 1;
//                break;
//            }
//        }
//        if (sta == 0)
//            return true;
//        return false;
//    }
//
////    public static void main(String[] args) {
////        int [] arr = {1,2,4};
////        System.out.println(new Main().canMakeArithmeticProgression(arr));;
////    }
//
////    有一块木板，长度为 n 个 单位 。一些蚂蚁在木板上移动，每只蚂蚁都以 每秒一个单位 的速度移动。其中，一部分蚂蚁向 左 移动，其他蚂蚁向 右 移动。
////
////    当两只向 不同 方向移动的蚂蚁在某个点相遇时，它们会同时改变移动方向并继续移动。假设更改方向不会花费任何额外时间。
////
////    而当蚂蚁在某一时刻 t 到达木板的一端时，它立即从木板上掉下来。
////
////    给你一个整数 n 和两个整数数组 left 以及 right 。两个数组分别标识向左或者向右移动的蚂蚁在 t = 0 时的位置。请你返回最后一只蚂蚁从木板上掉下来的时刻。
//
////    public int getLastMoment(int n, int[] left, int[] right) {
////        //翻倍
////        for (int i = 0; i < left.length; i++) {
////            left[i] = left[i] << 1;
////        }
////        for (int i = 0; i < right.length; i++) {
////            right[i] = right[i] << 1;
////        }
////        IntStream.of(left).max();
////        int t = 0;
////        while (true) {
////            t++;
////
////        }
////        return 0;
////    }
//
//    public int getLastMoment(int n, int[] left, int[] right) {
//        if (right.length == 0) {
//            int max = IntStream.of(left).max().orElse(0);
//            return max;
//        }
//        if (left.length == 0) {
//            int min = IntStream.of(right).min().orElse(0);
//            return n - min;
//        }
//        int max = IntStream.of(left).max().orElse(0);
//        int min = IntStream.of(right).min().orElse(0);
//        return (n - max) < min ? max : n - min;
//    }
//
////    public static void main(String[] args) {
////        int n = 1000;
////        int[] left = {0};
////        int[] right = {};
////        System.out.println(new Main().getLastMoment(n,left,right));
////    }
//
////    给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
//
////    示例 1：
////
////    输入：mat = [[1,0,1],[1,1,0],[1,1,0]]
////    输出：13
////    解释：
////    有 6 个 1x1 的矩形。
////    有 2 个 1x2 的矩形。
////    有 3 个 2x1 的矩形。
////    有 1 个 2x2 的矩形。
////    有 1 个 3x1 的矩形。
////    矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
//
//    public int numSubmat(int[][] mat) {
//        int x = 0,y = 0;
//        for (int i = 0; i < 1; i++) {
//
//        }
//        return 0;
//    }
//
////    public static void main(String[] args) {
////        int[][] mat = {{1,0,1},{1,1,0},{1,1,0}};
////        System.out.println(new Main().numSubmat(mat));
////    }
//
////    给你一个字符串 num 和一个整数 k 。其中，num 表示一个很大的整数，字符串中的每个字符依次对应整数上的各个 数位 。
////
////    你可以交换这个整数相邻数位的数字 最多 k 次。
////
////    请你返回你能得到的最小整数，并以字符串形式返回。
//
////    示例 1：
////
////    输入：num = "4321", k = 4
////    输出："1342"
////    解释：4321 通过 4 次交换相邻数位得到最小整数的步骤如上图所示。
//
//    public String minInteger(String num, int k) {
//        if (k == 0)
//            return num;
//        //判断现在是不是已经是最小的
//        char[] numc = num.toCharArray();
//        Arrays.sort(numc);
//        if (Arrays.equals(numc,num.toCharArray())) {
//            return num;
//        }
//        //获取可操作的字符串区间
//        int n = num.length();
//        String s;
//        int i = 1;
//        if (n > k) {
//            s = num.substring(0, k + i);
//            while (true) {
//                if (ifStr(s)) {
//                    s = num.substring(0, k + i);
//                } else {
//                    break;
//                }
//            }
//        } else {
//            s = num;
//        }
//        //对字符串区间
//        char[] cs = s.toCharArray();
//        Arrays.sort(cs);
//        int in = 0;
////        while (true) {
////            char c = cs[in];
////            in++;
////        }
//        return "";
//    }
//
//    public String minInteger(String num, int k) {
//        if (k == 0)return num;
//        for (char c = '0' ; c <= '9' ; c++){
//            int i = num.indexOf(c);
//            if (i >= 0){
//                if ( i <= k){
//                    return c + minInteger(num.substring(0,i)+ num.substring(i+1),k - i);
//                }
//            }
//        }
//        return num;
//    }
//
//    public String minInteger(String num, int k) {
//        if (k == 0)return num;
//        StringBuffer sb = new StringBuffer(num);
//        for (char c = '0' ; c <= '9' ; c++){
//            int i = num.indexOf(c);
//            if (i >= 0){
//                int n = 0;
//                while (true) {
//                    int i = num.indexOf(c);
//                    if (i <= k) {
//                        k = k - i;
//                        sb.append(c);
//                    }
//                }
//            }
//        }
//        return num;
//    }
//
//    private boolean ifStr(String s) {
//        char cc = s.charAt(0);
//        int sta = 0;
//        for (int i = 1; i < s.length(); i++) {
//            if (cc != s.charAt(i) && (int)cc > (int)s.charAt(i)) {
//                sta = 1;
//                break;
//            }
//        }
//        if (sta == 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        String num = "4321";
//        System.out.println(num.substring(2));
////        int k = 4;
////        System.out.println(new Main().minInteger(num,k));
//    }
//}
