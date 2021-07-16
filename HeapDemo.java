import java.util.Arrays;

/**
 * 将数组变为大堆
 */
public class HeapDemo {
    public int[] elem;
    public int usedSize;

    public HeapDemo() {
        this.elem = new int[10];
    }

    public void adjustDown(int parent,int length){
        int child = (2*parent) + 1;
        while (child < length){
            if(child+1 < length && this.elem[child] < this.elem[child +1]){
                child++;
            }
            if(this.elem[parent] < this.elem[child]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = (2*parent) + 1;
            }else {
                break;
            }

        }
    }
    public void adjustUp(int child){
        int parent = (child -1)/2;
        while(child > 0){
            if(this.elem[child] > this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                child = parent;
                parent = (child -1)/2;
            }else{
                break;
            }
        }
    }

    public void push(int val){
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[this.usedSize] = val;
        this.usedSize++;

        adjustUp(this.usedSize-1);
    }

    public boolean isFull(){
        if(this.usedSize == this.elem.length){
            return true;
        }
        return false;
    }

    public void crateBigHeap(int[] array){
        for (int i = 0; i < array.length ; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        for (int i = (this.usedSize-1-1)/2; i >= 0 ; i--) {
            adjustDown(i,this.usedSize);
        }
    }
    //删除堆
    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int ret = this.elem[0];
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize -1] = tmp;
        this.usedSize--;
        adjustDown(0,this.usedSize);
        return ret;
    }

    public boolean isEmpty(){
        return this.usedSize == 0;
    }
}
