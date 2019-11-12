public class Test {
    class ListNode{
        ListNode next=null;
    }
    public static ListNode  getIntersectionNode (ListNode headA,ListNode headB){
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

        //求长度的差值
        int len = lenA-lenB;

        //如果是负数-》pL = headB;  pS = headA

        //只需要让pL走len步就好了

        //走完len步之后  两个同时开始走
        //一直走 走到next值相同时 就是交点

        return null;
    }

    public static ListNode mergeTwoLists(ListNode headA,ListNode headB) {
        while (headA.next != null && headB.next != null) {

        }
        return null;
    }
    public static void main(String[] args) {


    }

}




















