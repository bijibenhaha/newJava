import java.util.ArrayList;
import java.util.Iterator;

public class LianX1 {
    public static void main(String[] args) {
        // List 遍历、CRUD
        // 遍历（4种方式）
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        // 方式一：迭代器
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        
        // 方式二：索引
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        
        // 方式三：增强for
        for (Integer i : arrayList) {
            System.out.println(i);
        }

        // 方式四：stream
        arrayList.forEach((value) -> {
            System.out.println(value);
        });


    }
}
