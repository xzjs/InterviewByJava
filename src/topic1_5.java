/**
 * 利用字符重复出现的次数,编写一个方法,实现基本的字符串压缩功能
 */
public class topic1_5 {
    private String str="aabcccccaaa";
    topic1_5(){
        long time1=System.nanoTime();
        System.out.println(method1());
        long time2=System.nanoTime();
        System.out.println(time2-time1);
        time1=System.nanoTime();
        System.out.println(method2());
        time2=System.nanoTime();
        System.out.println(time2-time1);
    }

    /**
     * 自己想到的办法,数一遍,使用SringBuffer拼接
     * time:433666
     * @return
     */
    public String method1(){
        StringBuffer sb=new StringBuffer();
        char last=str.charAt(0);
        int count=1;
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i)==last){
                count++;
            }else{
                sb.append(last+""+count);
                last=str.charAt(i);
                count=1;
            }
        }
        sb.append(last+""+count);
        return sb.length()==str.length()?str:sb.toString();
    }

    /**
     * 书上的解法,虽然将时间复杂度降低为线性,但我认为没有任何可取之处,结构复杂,代码多处冗余
     * time:84002
     * @return
     */
    public String method2(){
        int size=11;
        char[] array=new char[11];
        int index=0;
        char last=str.charAt(0);
        int count=1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==last){
                count++;
            }else{
                index=setChar(array,last,index,count);
                last=str.charAt(i);
                count=1;
            }
        }
        index=setChar(array,last,index,count);
        String s=String.valueOf(array);
        return s.length()==str.length()?str:s;
    }

    private int setChar(char[] array,char c,int index,int count){
        array[index]=c;
        index++;
        char[] cnt=String.valueOf(count).toCharArray();
        for (char x :
                cnt) {
            array[index] = x;
            index++;
        }
        return index;
    }
}
