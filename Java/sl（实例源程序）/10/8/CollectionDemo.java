import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class CollectionDemo {
    public static void main(String[] args) {
        Set<People> hashSet = new HashSet<People>();			// ����Set���϶���
        hashSet.add(new People("��ͬѧ", 201101));				// �򼯺�����Ӷ���
        hashSet.add(new People("��ͬѧ", 201102));
        hashSet.add(new People("��ͬѧ", 201103));
        Iterator<People> it = hashSet.iterator();						// �������ϵ�����
        System.out.println("�����е�Ԫ���ǣ�");
        while (it.hasNext()) {									// ѭ������������
            People person = it.next();
            System.out.println(person.getName() + "  " + person.getId_card());
        }
    }
}
