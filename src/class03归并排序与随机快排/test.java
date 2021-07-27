package class03归并排序与随机快排;
public class test {
    public static void main(String[] args) {
        int[] arr={10,29,78,37,89,49};
        MergeSort(arr,0,5);
    }
    public static void MergeSort(int[] arr, int start, int end)
    {
        int[] temp = new int[0];
        if(start>=end)
        {
            return;
        }
        int mid=(start+end)/2;
        MergeSort(arr,start,mid);
        MergeSort(arr,mid+1,end);
        int length=0;
        int i_start=start;
        int i_end=mid;
        int j_start=mid+1;
        int j_end=end;
        while(i_start<=i_end&&j_start<=j_end)
        {
            if(arr[i_start]<arr[j_start])
            {
                temp[length]=arr[i_start];
                length++;
                i_start++;
            }
            else{
                temp[length]=arr[j_start];
                length++;
                j_start++;
            }
        }
        while(i_start<=i_end)
        {
            temp[length]=arr[i_start];
            i_start++;
            length++;
        }
        while(j_start<=j_end)
        {
            temp[length]=arr[j_start];
            length++;
            j_start++;
        }
        for (int i = 0; i < length; i++) {
            arr[start+i]=temp[i];
        }
    }
}
