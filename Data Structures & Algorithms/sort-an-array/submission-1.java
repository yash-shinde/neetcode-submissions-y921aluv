class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    static void mergeSort(int[] arr,int l,int r){
        if(l<r){
            int m = l+(r-l)/2;

            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);

            merge(arr,l,m,r);
        }
    }

    static void merge(int[] arr,int l,int m,int r){
        //calculate sizes of both arrs
        int n1 = m-l+1;
        int n2 = r-m;

        //copy both arrays
        int[] first = new int[n1];
        for(int i=0;i<n1;i++){
            first[i] = arr[l+i];
        }

        int[] second = new int[n2];
        for(int i=0;i<n2;i++){
            second[i] = arr[m+1+i];
        }

        //for both unmerged parts
        int i=0;int j=0;
        //for merge array
        int k=l;

        while(i<n1 && j<n2){
            if(first[i] < second[j]){
                arr[k] = first[i];
                i++;
            }else{
                arr[k] = second[j];
                j++;
            }
            k++;
        }

        //if anything is remaining
        while(i<n1){
            arr[k] = first[i];
            i++;k++;
        }

        while(j<n2){
            arr[k] = second[j];
            j++;k++;
        }

    }
}


