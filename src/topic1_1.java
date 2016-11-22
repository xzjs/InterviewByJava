import java.util.Arrays;

/**
 * 实现一个算法,确定一个字符串中的所有字符是否全都不同。假设不允许势使用额外的数据结构
 * 此处有一个非常巧妙的思路,先询问字符串的编码是什么,如果是ASII码的话,只有256个,若字符串长度超过256则必定有重复字符
 */
public class topic1_1 {
    private String str="abcdefghijklmnopqrstuvwxyza";

    topic1_1(){
        long time0=System.nanoTime();
        method1();
        long time1=System.nanoTime();
        System.out.println(time1-time0);
        time1=System.nanoTime();
        method2();
        long time2=System.nanoTime();
        System.out.println(time2-time1);
        time2=System.nanoTime();
        method3();
        long time3=System.nanoTime();
        System.out.println(time3-time2);
        time3=System.nanoTime();
        method4();
        long time4=System.nanoTime();
        System.out.println(time4-time3);
    }

    /**
     * 自己想出的算法,最笨的两层循环查找
     * time:11914
     */
    public void method1(){
        for (int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)){
                    return;
                }
            }
        }
    }

    /**
     * 对字符串进行排序,但由于对Java的不熟悉,字符串和字符数组之间转换花费了很多时间
     * time:261106
     */
    public void method2(){
        char[] cs=str.toCharArray();
        Arrays.sort(cs);
        str=new String(cs);
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                return;
            }
        }
    }

    /**
     * 用一个存储bool变量的数组来存储状态
     * time:7276
     */
    public void method3(){
        boolean[] char_set=new boolean[256];
        for(int i=0;i<str.length();i++){
            int val=str.charAt(i);
            if(char_set[val]){
                return;
            }
            char_set[val]=true;
        }
    }

    /**
     * 如何也不会想到的位运算
     * time:3657
     */
    public void method4(){
        int checker=0;
        for(int i=0;i<str.length();i++){
            int val=str.charAt(i)-'a';
            if((checker&(1<<val))>0){
                return;
            }
            checker|=(1<<val);
        }
    }
}
