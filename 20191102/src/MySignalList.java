
class ListNode{
    public int data;
    public ListNode next;
    public ListNode random;

    public ListNode(int data,ListNode next,ListNode random){
        this.data=data;
        this.next=null;
    }
}//节点类
public  class MySignalList{
    public ListNode head;

    public MySignalList(){
        this.head=null;
    }
/*
    //头插法
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
        }else{
            node.next=this.head;
            this.head=node;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        ListNode cur=this.head;
        if(this.head==null){
            this.head=node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }*/
/*
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //得到单链表的长度
    public int getLenth(){
        int count=0;
        ListNode cur=this.head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    //找到index-1的位置
    private ListNode  searchIndex(int index){
        ListNode cur=this.head;
        int count=0;
        while (count<index-1){
            count++;
            cur=cur.next;
        }
        return cur;
    }
    //任意位置插入，第一个数据节点为0号下标
    public boolean addTndex(int index,int data){
        //判断index是否合法
        if(index<0||index>getLenth()){
            System.out.println("index不合法");
            return false;
        }
        //如果index=0，则使用头插法即可
        if(index==0){
            addFirst(data);
            return true;
        }
        //找到index-1的位置
        ListNode cur=searchIndex(index);
        ListNode node=new ListNode(data);
        node.next=cur.next;
        cur.next=node;
        return true;
    }
    private ListNode searchPrev(int key) {
        ListNode prev=this.head;
        while(prev.next!=null) {
            if(prev.next.data==key) {
                return prev;
            }
            prev=prev.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //判断单链表是否为空
        if(this.head == null) {
            System.out.println("单链表为空");
            return;
        }
        //0、删除的节点是否是头结点
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //1、找到key的前驱  如果返回空
        ListNode prev = searchPrev(key);
        if(prev==null) {
            return;
        }
        //2、删除节点
        ListNode del=prev.next;
        prev.next=del.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while (cur != null) {
            if(prev.next.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key) {
            this.head = this.head.next;
        }
    }
 */   //反转单链表
    public ListNode reverseList() {
        ListNode prev = null;
        ListNode newHead = null;
        ListNode cur = this.head;
        while (cur != null) {
            ListNode curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public void display(){
        ListNode cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    public void display2(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //单链表的中间节点
    public ListNode middleNode() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //输出该链表中倒数第k个节点
    public ListNode findKthToTail(int k){
        // k > getLength()
        if(k <= 0) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (k-1 > 0) {
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else {
                System.out.println("没有这个节点");
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
    public ListNode partition(int x) {
        ListNode cur = this.head;
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;
        while (cur != null) {
            ListNode curNext=cur.next;
            cur.next=null;
            if (cur.data < x) {
                //第一次插入
                if (beforeStart == null) {
                    beforeStart=cur;
                    beforeEnd=cur;
                } else {
                    beforeEnd.next=cur;
                    beforeEnd=beforeEnd.next;
                }

            } else {
                //第一次插入
                if (afterStart == null) {
                    afterStart=cur;
                    afterEnd=cur;
                } else {
                    afterEnd.next=cur;
                    afterEnd=afterEnd.next;
                }
            }
           cur=curNext;
        }
        if(beforeStart==null){
            return  afterStart;
        }
        beforeEnd.next=afterStart;
        return  beforeStart;
    }
  /*  public ListNode deleteDuplication(){
        ListNode node=new ListNode(-1);
        ListNode cur=this.head;
        ListNode tmp=node;
        while(cur!=null){
            if(cur.next!=null&&cur.data==cur.next.data){
                //1、循环
                while(cur.next!=null&&cur.data==cur.next.data){
                    cur=cur.next;
                }
                //2、退出循环 cur要多走一步
                cur=cur.next;
            }else{
                //当前节点不等于下一个节点的时候
                tmp.next=cur;
                cur=cur.next;
                tmp=tmp.next;
            }
        }
        tmp.next=null;
        return  node.next;
    }*/

    //回文结构
    public boolean chkPalindrome() {
        if(head==null){
            return false;
        }
        //只有一个节点
        if(head.next==null){
            return true;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;

        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转
        ListNode p = slow.next;
        while (p != null) {
            ListNode pNext = p.next;
            //反转
            p.next=slow;
            slow=p;
            p=pNext;
        }
        while(slow!=this.head){

            if(slow.data!=this.head.data){
                return false;
            }
            //偶数
            if(this.head.next==slow){
                return true;
            }
            this.head=this.head.next;
            slow=slow.next;
        }
        return true;
    }
    //创建一个环   oj不用创建，底层会创建好
    // 在 idea运行时，需要创建环
    public void createLoop(){
        ListNode cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=this.head.next;
    }
    //判断是否有环
    public boolean hasCycle(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return true;
                /*break;*/
            }
        }
        /*if(fast==null||fast.next==null){
            return false;
        }
        return true;*/
        return false;
    }

    public ListNode detectCycle(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=this.head;

        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;//或者slow都可以
    }

    public int linkLen(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return -1;
        }
        int count=1;
        slow=slow.next;//先让slow先走一步
        while(slow!=fast){
            slow=slow.next;
            count++;
        }
        return count;

    }
    public ListNode copyRandonList(ListNode head){
        if(head==null){
            return null;
        }
        //1、将老新节点串成一个链表
        ListNode cur=this.head;
        while (cur!=null){
            ListNode node=new ListNode(cur.data,cur.next,null);
            ListNode tmp=cur.next;
            cur.next=node;
            cur=tmp;
        }
        //2、开始解决random指针
        cur=this.head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }else{
                cur.next.random=null;
            }
            cur=cur.next.next;
        }
        //3、拆分链表   cur->需要拆分的节点
        cur=head;
        ListNode newHead=cur.next;
        while(cur.next!=null){
            ListNode tmp=cur.next;
            cur.next=tmp.next;
            cur=tmp;
        }
        return newHead;
    }
    public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode node = new ListNode(-1,null,null);
        ListNode tmp = node;

        while (headA != null && headB != null) {
            if(headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headA != null) {
            tmp.next = headA;
        }
        if(headB != null) {
            tmp.next = headB;
        }
        return node.next;
    }

}
/*
删除重复的节点
public ListNode deleteDuplication() {
        ListNode node = new ListNode(-1);
        ListNode cur = this.head;
        ListNode tmp = node;
        while (cur != null) {
        if(cur.next != null && cur.data == cur.next.data) {
        //1、循环
        cur=cur.next;
        }else {
        //2、退出循环 cur要多走一步
        //
        //当前节点 不等于下一个节点的时候
        tmp.next = cur;
        cur = cur.next;
        tmp = tmp.next;
        }
        }

        }


*/




























