package list_related;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.Stack;

/**
 * 单向链表的实现
 */
public class MakeSingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
//        StandardNode node = new StandardNode(1, "john", "天才");
//        StandardNode node1 = new StandardNode(2, "mike", "傻子");
//        StandardNode node2 = new StandardNode(3, "marry", "一般");
//        list.addNode(node);
//        list.addNode(node1);
//        list.addNode(node2);
//        list.showList();

//      按顺序添加
        StandardNode node = new StandardNode(1, "john", "天才");
        StandardNode node1 = new StandardNode(3, "mike", "傻子");
        StandardNode node2 = new StandardNode(2, "marry", "一般");
        list.addNodeByOrder(node);
        list.addNodeByOrder(node1);
        list.addNodeByOrder(node2);
        list.showList();

        System.out.printf("------------------\n");
        StandardNode node4 = new StandardNode(2, "marry1", "一般1");
        list.update(node4);
        list.showList();

        System.out.printf("------------------\n");
        StandardNode node5 = new StandardNode(2);
        list.delete(node5);
        list.showList();

        System.out.printf("------------------\n");
        int length = list.getLength();
        System.out.printf("the length of the list is " + length+"\n");

        //  反转
//        System.out.printf("------------------\n");
//        StandardNode head = list.getHead();
//        list.reverseList(head);
//        list.showList();

        // 逆序遍历
        list.reverseShowList();


    }
}


class SingleLinkedList{
    private StandardNode head = new StandardNode(0,"","");

    public StandardNode getHead() {
        return head;
    }

    // 添加数据
    public void addNode(StandardNode node){
        // 找到链表中最后一个元素
        StandardNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;

    }
    // 展示链表
    public void showList(){
        if (head.next == null){
            System.out.println("该链表无元素");
        }
        StandardNode temp = head.next;
        while (true){
            System.out.println(temp);
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
    }


    // 根据 addr顺序添加数据, 并且 如果addr相同，不添加
    public void addNodeByOrder(StandardNode node){
        // 找到链表中元素添加地方的前一个元素
        StandardNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.getAddr() == node.addr){
                flag = true;
                break;
            }
            if (node.getAddr() < temp.next.getAddr()) {
                break;
            }
            temp = temp.next;
        }
        // 在temp后添加
        if (flag){
            System.out.printf("what you want to add has already in the list\n");
        }else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    // 根据addr更新name和nickname
    public void update(StandardNode node){
        // 先判断list是否为空
        if (head.next == null){
            System.out.printf("the list is empty");
            return;
        }
        // 找到addr，更新 数据
         StandardNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.getAddr() == node.getAddr()){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.next.setName(node.getName());
            temp.next.setNickname(node.getNickname());
        }else {
            System.out.printf("there is no addr found\n");
        }
    }

    public void delete(StandardNode node){
        // 先判断list是否为空
        if (head.next == null){
            System.out.printf("the list is empty");
            return;
        }
        // 找到addr，删除
        StandardNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.getAddr() == node.getAddr()){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.next = temp.next.next;

        }else {
            System.out.printf("there is no addr found\n");
        }

    }

    // 有效 节点的个数
    public int getLength(){
        if (head.next == null){
            return 0;
        }

        int length = 0;
        StandardNode temp = head.next;
        while (true){
            length++;
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        return length;
    }

    // 反转单链表，用一个临时的头指针 作为辅助
    public void reverseList(StandardNode head){
        // 如果 head引导的链表为空 或 节点数量为1，则直接返回
        if (head.next == null || head.next.next == null){
            return;
        }

        StandardNode newHead = new StandardNode(0);
        // 遍历 head 引导的链表，利用头插法插入newHead引导的链表
        // 定义两个辅助变量,temp 指向 要被插入的节点，next 指向 下一个被插入的节点
        StandardNode cur = head.next;
        StandardNode next;
        while (cur != null){
            next =cur.next;
            // 头插法
            cur.next = newHead.next;
            newHead.next = cur;

            cur = next;
        }
        head.next = newHead.next;

    }

    // 逆序遍历
    public void reverseShowList(){
        // 使用 栈 做辅助
        if (head.next == null){
            System.out.println("the list is null");
            return;
        }
        Stack<StandardNode> stack = new Stack<>();
        StandardNode temp = head.next;
        while (temp != null){
            stack.add(temp);
            temp = temp.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }


    }



}

class StandardNode{
    public int addr;

    public String name;
    public String nickname;
    public StandardNode next;

    public StandardNode(int addr) {
        this.addr = addr;
    }

    public StandardNode(int addr, String name, String nickname) {
        this.addr = addr;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "StandardNode{" +
                "addr=" + addr +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public int getAddr() {
        return addr;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}