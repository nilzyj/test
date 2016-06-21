import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class CollectionDemo {
    public static void main(String[] args) {
        Set<People> hashSet = new HashSet<People>();			// 创建Set集合对象
        hashSet.add(new People("陈同学", 201101));				// 向集合中添加对象
        hashSet.add(new People("王同学", 201102));
        hashSet.add(new People("李同学", 201103));
        Iterator<People> it = hashSet.iterator();						// 创建集合迭代器
        System.out.println("集合中的元素是：");
        while (it.hasNext()) {									// 循环遍历迭代器
            People person = it.next();
            System.out.println(person.getName() + "  " + person.getId_card());
        }
    }
}
