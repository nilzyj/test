import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        // 创建一个ArrayList，其中能够保存的数据类型是Integer
        ArrayList<Integer> array = new ArrayList<Integer>();
        // 使用Collections类中的工具方法addAll()向集合中增加元素
        Collections.addAll(array, 1, 2, 3, 4, 5, 6);
        System.out.println("集合中的元素：" + array);
        // 使用无参数的方法获得ListIterator对象
        ListIterator<Integer> iterator = array.listIterator();
        // 对于初始位置，判断是否具有下一个元素
        boolean hasNext = iterator.hasNext();
        System.out.println("集合是否具有下一个元素：" + hasNext);
        // 对于初始位置，判断是否具有前一个元素
        boolean hasPrevious = iterator.hasPrevious();
        System.out.println("集合是否具有前一个元素：" + hasPrevious);
        int next = iterator.next();// 获得下一个元素
        System.out.println("获得集合的下一个元素：" + next);
        int nextIndex = iterator.nextIndex();// 获得下一个元素的索引
        System.out.println("获得集合的下一个元素的索引：" + nextIndex);
        int previous = iterator.previous();// 获得前一个元素
        System.out.println("获得集合的前一个元素：" + previous);
        int previousIndex = iterator.previousIndex();// 获得前一个元素的索引
        System.out.println("获得集合的前一个元素的索引：" + previousIndex);
        iterator.add(7);// 向列表中增加元素7
        System.out.println("向集合中增加元素7后的集合：" + array);
        iterator.next();// 获得下一个元素
        iterator.set(12);// 将获得的元素设置成12
        System.out.println("将获得的下一个元素修改成12后的集合：" + array);
        iterator.remove();
        System.out.println("将获得的下一个元素删除后的集合：" + array);
    }
}
