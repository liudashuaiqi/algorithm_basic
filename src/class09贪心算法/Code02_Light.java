package class09贪心算法;

import java.util.Arrays;
import java.util.Comparator;

//已经测试，正确
public class Code02_Light {
    public static int minLight2(String road){
        char[] str = road.toCharArray();
        int index = 0;
        int light = 0;
        while(index < str.length){
            if(str[index] == 'X'){
                index++;
            }else {
                light++;
                if(index+1==str.length){
                    break;
                }else{
                    if(str[index+1]=='X'){
                        index+=2;
                    }else{
                        index+=3;
                    }
                }
            }
        }
        return light;
    }

}
