import java.util.Arrays;

class MyArrayList {
    public int usedSize;
    public int[] elem={1,2,3,4,5};

    public final int CAPACITY = 10;

    public MyArrayList() {
        this.usedSize = 0;
        this.elem = new int[CAPACITY];
    }

   // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //1、pos是否合法
        //2、挪数据
        //3、插入数据
        //4、usedSize++
        if(pos<0||pos>this.usedSize){
            System.out.println("pos位置不合法");
            return;
        }else if(pos-1!=0&&pos>=0&&pos<=usedSize-1){
            for (int i = usedSize-1; i >=pos ; i--) {
                this.elem[i+1]=this.elem[i];
            }
            this.elem[pos]=data;
            this.usedSize++;
        }
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i <usedSize ; i++) {
            if(elem[i]==toFind){
                return true;
            }

        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i <usedSize ; i++) {
            if(elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        return -1;
    }
    // 给 pos 位置的元素设为 value
    // public void setPos(int pos, int value) { }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if(usedSize!=0){
            for (int i = 0; i <usedSize ; i++) {
                if(this.elem[i]==toRemove){
                    for (int j = i; j <=usedSize-1; j++) {
                        this.elem[j]=this.elem[j+1];
                    }
                    this.usedSize--;
                }
            }
        }
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize=0;
    }
    // 打印顺序表
    public void display() { }
}


