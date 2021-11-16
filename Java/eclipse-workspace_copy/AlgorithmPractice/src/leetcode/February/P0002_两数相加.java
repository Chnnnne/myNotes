package leetcode.February;


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class P0002_两数相加 {
	
	
	//只要出现节点相加，就一定要有伴随的动作:加上last，重置last
	//两个节点链都要遍历一遍到头
	//和节点储存相加的每一位，并创建下一个，最高位next=null
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode head = new ListNode();//两数之和节点链的头 (也即和的个位对应的节点)
    	ListNode i1 = l1,i2 = l2,h = head; // i1指向l1节点链  ,i2指向l2节点链  ,h指向两数之和节点链
    	int v1=0,v2=0,v;//设置变量方便操作
    	int last=0;//记住进位
    	while(true) {
			v1 = i1==null?  0 : i1.val;
			v2 = i2==null?  0 : i2.val;
			v=v1+v2+last;
			last=v/10;
    		
			i1= i1==null? null:i1.next;
			i2= i2==null? null:i2.next;
			
    		h.val=v%10;
    		if(i1==null&&i2==null&&last==0) {
    			h.next=null;
    			break;
    		}
    		h.next=new ListNode();
    		h=h.next;
    	}
    	return head;
    }
}
