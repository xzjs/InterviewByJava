/**
 * 编写一个算法,将字符串中的空格全部替换为"%20"
 */
public class topic1_4 {
    private char[] str=new char[20];

    topic1_4(){
        char[] temp="Mr John Smith".toCharArray();
        for (int i = 0; i < temp.length; i++) {
            str[i]=temp[i];
        }
        method1(13);
    }

    /**
     * 处理字符串操作问题时,常见的做法是从字符串尾部开始编辑
     * @param length
     */
    public void method1(int length){
        int space_num=0,new_length;
        for (char aStr : str) {
            if (aStr == ' ') {
                space_num++;
            }
        }
        new_length=length+space_num*2;
        str[new_length]='\0';
        for (int i = length-1; i >=0; i--) {
            if(str[i]==' '){
                str[new_length-1]='0';
                str[new_length-2]='2';
                str[new_length-3]='%';
                new_length-=3;
            }else{
                str[new_length-1]=str[i];
                new_length--;
            }
        }
        System.out.println(str);
    }
}
