package class09贪心算法;

import java.util.Arrays;
import java.util.Comparator;

//已经测试，正确
public class Code04_BestArrange {
    public static class Program{
        public int start;
        public int end;
        public Program(int s,int e){
            start = s;
            end = e;
        }
    }
    public static class Mycomparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end-o2.end;
        }
    }
    public static int bestArrange2(Program[] program){
        Arrays.sort(program,new Mycomparator());
        int result = 0;
        int timeLine = 0;
        for(int i = 0;i < program.length;i++){
            if(timeLine<=program[i].start){
                result++;
                timeLine = program[i].end;
            }
        }
        return result;
    }
}
