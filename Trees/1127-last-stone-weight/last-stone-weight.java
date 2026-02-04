class MaxHeaps
{
    ArrayList<Integer> arr = new ArrayList<>();

    public int parent(int index) {
        return (index-1)/2;
    }
    public void swap(int index, int parentIndex) {
        Integer temp = arr.get(index);
        arr.set(index, arr.get(parentIndex));
        arr.set(parentIndex, temp);
    }
    public void insert(int x) {
        arr.add(x);
        int index = arr.size() - 1;
        upheap(index);
    }

    public void upheap(int index) {
        if(index == 0)
            return;
        int parentIndex = parent(index);
        if(arr.get(index).compareTo(arr.get(parentIndex)) > 0) 
        {
            swap(index, parentIndex);
            upheap(parentIndex);
        }
    }
    public Integer remove() throws Exception {
        if(arr.isEmpty()) 
            throw new IllegalStateException("heap is empty");
        Integer temp = arr.get(0);
        Integer last = arr.remove(arr.size() - 1);
        if(!arr.isEmpty()) {
            arr.set(0, last);
            downheap(0);
        }
        return temp;
    }
    public void downheap(int index) 
    {
        int small = index;
        int leftIndex = left(index);
        int rightIndex = right(index);
        if(leftIndex < arr.size() &&
            arr.get(leftIndex).compareTo(arr.get(small)) > 0) {
                small = leftIndex;
            }
        if(rightIndex < arr.size() &&
            arr.get(rightIndex).compareTo(arr.get(small)) > 0) {
                small = rightIndex;
            }
        if(small != index)
        {
            swap(small, index);
            downheap(small);
        }
    }
    public int left(int index) {
        return 2*index + 1;
    }
    public int right(int index) {
        return 2 * index + 2;
    }
    public void elements() {
        while(!arr.isEmpty()) {
            try {
                Integer x = remove();
                System.out.print(x + " ");
            } catch(Exception e) {

            }
        }
    }
    public int lastStone() {
        while(arr.size() > 1) {
            int first=0;
            int second=0;
            try {
                first = remove();
                second = remove();
            } catch(Exception e) {}
            if(first == second)
                continue;
            else
                insert(Math.abs(first - second));
        }
        return arr.isEmpty() ? 0 : arr.get(arr.size() - 1);
    }
}
class Solution {
    public int lastStoneWeight(int[] stones) {
        MaxHeaps heap = new MaxHeaps();
        for(int i=0;i<stones.length;i++)
            heap.insert(stones[i]);
        //o(nlogn)
        return heap.lastStone();
        
    }
}