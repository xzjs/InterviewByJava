import java.util.Arrays;

/**
 * topic1_2为c++问题,后期会在c++相应的代码库中上传
 * 给定两个字符串,请编写程序,确定其中一个字符串的字符重新排列后,能否变成两一个字符串
 * 要点:1.变位词是否区分大小写;2.是否考虑空白;3.字符串问题一定得询问编码
 */
public class topic1_3 {
    String str1="abcdeedcba",str2="edcbaabcde";

    topic1_3(){
        long time0=System.nanoTime();
        method1();
        long time1=System.nanoTime();
        System.out.println(time1-time0);
        time1=System.nanoTime();
        method2();
        long time2=System.nanoTime();
        System.out.println(time2-time1);
    }

    private String sort(String s){
        char[] content=s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    /**
     * 自己想到的算法,将两个字符串排序,若两个字符串相等,即返回true
     * @return
     * time:274635
     */
    public boolean method1(){
        if(str1.length()!=str2.length()){
            return false;
        }
        return  sort(str1).equals(sort(str2));
    }

    /**
     * 假设字符编码为ASII编码,设置一个256大小的数组用来存储每个字符的个数,然后判断两个字符串字符个数的多少
     * @return
     * time:9931
     */
    public boolean method2(){
        if(str1.length()!=str2.length()){
            return false;
        }
        int[] letters=new int[256];
        char[] s_array=str1.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            int c=(int)str2.charAt(i);
            if(--letters[c]<0){
                return false;
            }
        }
        return true;
    }
}
