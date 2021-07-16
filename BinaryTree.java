public class BinaryTree {
    public static void main(String[] args) {
        int[] array =  { 27,15,19,18,28,34,65,49,25,37 };
        HeapDemo heapDemo = new HeapDemo();
        heapDemo.crateBigHeap(array);
        heapDemo.push(100);
        for (int i = 0; i < heapDemo.usedSize; i++) {
            System.out.print(heapDemo.elem[i] + " ");
        }


    }

}
class BTNode{
    public int vaL;
    public BTNode left;
    public BTNode right;

    public BTNode(int var) {
        this.vaL = vaL;
    }
}