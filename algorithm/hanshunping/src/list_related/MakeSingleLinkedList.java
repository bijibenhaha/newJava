package list_related;

/**
 * 单向链表的实现
 */
public class MakeSingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        StandardNode node = new StandardNode(1, "john", "天才");
        StandardNode node1 = new StandardNode(2, "mike", "傻子");
        StandardNode node2 = new StandardNode(3, "marry", "一般");
        list.addNode(node);
        list.addNode(node1);
        list.addNode(node2);
        list.showList();

    }
}


class SingleLinkedList{
    private StandardNode head = new StandardNode(0,"","");

    // 添加数据
    public void addNode(StandardNode node){
        StandardNode newNode = new StandardNode(node.getAddr(),node.getName(),node.getNickname());
        // 找到链表中最后一个元素
        StandardNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = newNode;

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
        StandardNode newNode = new StandardNode(node.getAddr(),node.getName(),node.getNickname());
        // 找到链表中最后一个元素
        StandardNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        // 在最后一个元素后添加
        temp.next = newNode;
    }




}

class StandardNode{
    public int addr;

    public String name;
    public String nickname;
    public StandardNode next;

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
}