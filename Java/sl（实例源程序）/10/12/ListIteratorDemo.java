import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        // ����һ��ArrayList�������ܹ����������������Integer
        ArrayList<Integer> array = new ArrayList<Integer>();
        // ʹ��Collections���еĹ��߷���addAll()�򼯺�������Ԫ��
        Collections.addAll(array, 1, 2, 3, 4, 5, 6);
        System.out.println("�����е�Ԫ�أ�" + array);
        // ʹ���޲����ķ������ListIterator����
        ListIterator<Integer> iterator = array.listIterator();
        // ���ڳ�ʼλ�ã��ж��Ƿ������һ��Ԫ��
        boolean hasNext = iterator.hasNext();
        System.out.println("�����Ƿ������һ��Ԫ�أ�" + hasNext);
        // ���ڳ�ʼλ�ã��ж��Ƿ����ǰһ��Ԫ��
        boolean hasPrevious = iterator.hasPrevious();
        System.out.println("�����Ƿ����ǰһ��Ԫ�أ�" + hasPrevious);
        int next = iterator.next();// �����һ��Ԫ��
        System.out.println("��ü��ϵ���һ��Ԫ�أ�" + next);
        int nextIndex = iterator.nextIndex();// �����һ��Ԫ�ص�����
        System.out.println("��ü��ϵ���һ��Ԫ�ص�������" + nextIndex);
        int previous = iterator.previous();// ���ǰһ��Ԫ��
        System.out.println("��ü��ϵ�ǰһ��Ԫ�أ�" + previous);
        int previousIndex = iterator.previousIndex();// ���ǰһ��Ԫ�ص�����
        System.out.println("��ü��ϵ�ǰһ��Ԫ�ص�������" + previousIndex);
        iterator.add(7);// ���б�������Ԫ��7
        System.out.println("�򼯺�������Ԫ��7��ļ��ϣ�" + array);
        iterator.next();// �����һ��Ԫ��
        iterator.set(12);// ����õ�Ԫ�����ó�12
        System.out.println("����õ���һ��Ԫ���޸ĳ�12��ļ��ϣ�" + array);
        iterator.remove();
        System.out.println("����õ���һ��Ԫ��ɾ����ļ��ϣ�" + array);
    }
}
