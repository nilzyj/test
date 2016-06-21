import java.lang.reflect.Method;

public class AccessMethod {

	public static void main(String[] args) {
		MoreMethod example = new MoreMethod();
		Class exampleC = example.getClass();

		Method[] declaredMethods = exampleC.getDeclaredMethods();
		for (int i = 0; i < declaredMethods.length; i++) {
			Method method = declaredMethods[i];
			System.out.println("����Ϊ��" + method.getName());
			System.out.println("�Ƿ�������пɱ������Ĳ�����" + method.isVarArgs());
			System.out.println("��ڲ�����������Ϊ��");
			Class[] parameterTypes = method.getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.println(" " + parameterTypes[j]);
			}
			System.out.println("����ֵ����Ϊ��" + method.getReturnType());
			System.out.println("�����׳����쳣�����У�");
			Class[] exceptionTypes = method.getExceptionTypes();
			for (int j = 0; j < exceptionTypes.length; j++) {
				System.out.println(" " + exceptionTypes[j]);
			}
			boolean isTurn = true;
			while (isTurn) {
				try {
					isTurn = false;
					if (i == 0)
						method.invoke(example); // ִ��û����ڲ����ķ�
					else if (i == 1)
						System.out.println("����ֵΪ��"
								+ method.invoke(example, 168));
					else if (i == 2)
						System.out.println("����ֵΪ��"
								+ method.invoke(example, "7", 5)); // ִ�з���
					else {
						Object[] parameters = new Object[] { new String[] {
								"��", "��", "��","��" } };
						System.out.println("����ֵΪ��"
								+ method.invoke(example, parameters)); // ִ�з���
					}
				} catch (Exception e) {
					System.out.println("��ִ�з���ʱ�׳��쳣������ִ��setAccessible()������");
					method.setAccessible(true);
					isTurn = true;
				}
			}
			System.out.println();
		}

	}

}
