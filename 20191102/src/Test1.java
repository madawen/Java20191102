/*public class Test1 {
   public static ListNode  getIntersectionNode
           (ListNode headA,ListNode headB){
       if(headA == null || headB == null) {
           return null;
       }
       //永远指向最长的单链表
       ListNode pL = headA;
       //永远指向最短的单链表
       ListNode pS = headB;
       int lenA = 0;
       int lenB = 0;
       //分别求长度
       while (pL != null) {
           lenA++;
           pL = pL.next;
       }
       while (pS != null) {
           lenB++;
           pS = pS.next;
       }
       pL = headA;
       pS = headB;
       //求长度的差值
       int len = lenA-lenB;
       //如果是负数-》pL = headB;  pS = headA
       if(len < 0) {
           pL = headB;
           pS = headA;
           len = lenB-lenA;
       }
       //只需要让pL走len步就好了
       while (len > 0) {
           pL = pL.next;
           len--;
       }
       //走完len步之后  两个同时开始走
       //一直走 走到next值相同时 就是交点
       while (pL != pS && pL != null) {
           pL = pL.next;
           pS = pS.next;
       }
       //万一没有相交 并且两个单链表长度一样
       // 防止最后一个节点
       if(pL == pS && pS != null) {
           return pL;//或者ps
       }
       return null;
   }
   public static void createCut(ListNode headA,ListNode headB){
       headA.next.next=headB.next.next.next;
   }
   public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
       ListNode node = new ListNode(-1);
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


    public static void main(String[] args) {
    MySignalList mySignalList=new MySignalList();
    mySignalList.addLast(1);
    mySignalList.addLast(2);
    mySignalList.addLast(3);
    mySignalList.addLast(4);
    mySignalList.addLast(5);
    mySignalList.display();
    MySignalList mySignalList2=new MySignalList();
    mySignalList2.addLast(3);
    mySignalList2.addLast(4);
    mySignalList2.addLast(13);
    mySignalList2.addLast(14);
    mySignalList2.addLast(54);
    mySignalList2.display();
    ListNode node= mergeTwoLists(mySignalList.head,mySignalList2.head);
    mySignalList2.display2(node);
   }
}
createCut(mySignalList.head,mySignalList2.head);
    ListNode node=getIntersectionNode(mySignalList.head,mySignalList2.head);
    System.out.println(node.data);
    mySignalList.createLoop();
    boolean flg=mySignalList.hasCycle();
    System.out.println(flg);
    ListNode node=mySignalList.detectCycle();
       System.out.println(node.data);

       int len=mySignalList.linkLen();
       System.out.println(len);*/



//mySignalList.display2(node);
    /* boolean flg=mySignalList.chkPalindrome();
        System.out.println(flg);*/
//ListNode node=mySignalList.deleteDuplication();
//mySignalList.display2(node);