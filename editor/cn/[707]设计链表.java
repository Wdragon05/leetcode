package leetcode.editor.cn;
//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 👍 339 👎 0

import com.sun.glass.ui.Size;2022-01-10 21:00:45

//leetcode submit region begin(Prohibit modification and deletion)
class MyLinkedList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    ListNode head;
    int size;
    public MyLinkedList() {
        size = 0;
        head = null;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode cur = head;
//        for (int i=0; i<index; i++) cur = cur.next;
        while (index > 0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        ListNode tmp = new ListNode(val);
        tmp.next = head;
        head = tmp;
        size++;
    }
    
    public void addAtTail(int val) {
//        ListNode tail = new ListNode(val);
//        tail.next = null;
//        ListNode dummyHead = new ListNode(0);
//        ListNode cur = dummyHead;
//        while (cur.next != null){
//            cur = cur.next;
//        }
//        cur.next = tail;
//        head = dummyHead.next;
        if (size == 0) {
            head = new ListNode(val);
            head.next = null;
        } else {
            ListNode temp = head;
            while (temp.next != null) temp = temp.next;
            ListNode tail = new ListNode(val);
            tail.next = null;
            temp.next = tail;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        ListNode addNode = new ListNode(val);
        ListNode cur = head;
        if (index <= 0)
        {
            addAtHead(val);
            return;
        }
        if (index > size){
            return;
        }
        if (index == size){
            addAtTail(val);
            return;
        }
        while (index > 1){
            cur = cur.next;
            index--;
        }
//        for (int i=0; i<index-1; i++) cur = cur.next;
        addNode.next = cur.next;
        cur.next = addNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
//        ListNode dummyHead =new ListNode(0);
//        ListNode cur = dummyHead;
//        while (index>=0){
//            cur = cur.next;
//        }
//        cur.next = cur.next.next;
//        size--;
        if(index == 0){
            head = head.next;
            size--;
        }else if(index > 0 && index < size){
            ListNode temp = head;
            for(int i = 0; i < index - 1; i++) temp = temp.next;
            temp.next = temp.next.next;
            size--;
        }
//        size--;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

