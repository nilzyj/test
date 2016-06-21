import java.lang.reflect.Constructor;

public class AccessConstructor {

	public static void main(String[] args) {

		MoreConstructor example = new MoreConstructor("10", "20", "30");
		Class exampleC = example.getClass();

		Constructor[] declaredConstructors = exampleC.getDeclaredConstructors();
		for (int i = 0; i < declaredConstructors.length; i++) {
			Constructor constructor = declaredConstructors[i];
			System.out.println("�鿴�Ƿ�������пɱ������Ĳ�����" + constructor.isVarArgs());
			System.out.println("�ù��췽������ڲ�����������Ϊ��");
			Class[] parameterTypes = constructor.getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.println(" " + parameterTypes[j]);
			}
			System.out.println("�ù��췽�������׳����쳣����Ϊ��");
			Class[] exceptionTypes = constructor.getExceptionTypes();
			for (int j = 0; j < exceptionTypes.length; j++) {
				System.out.println(" " + exceptionTypes[j]);
			}
			MoreConstructor example2 = null;
			while (example2 == null) {
				try {
					if (i == 0)
						example2 = (MoreConstructor) constructor.newInstance();
					else if (i == 1)
						example2 = (MoreConstructor) constructor.newInstance("7", 5);
					else {
						Object[] parameters = new Object[] { new String[] {
								"100", "200", "300" } };
						example2 = (MoreConstructor) constructor
								.newInstance(parameters);
					}
				} catch (Exception e) {
					System.out.println("�ڴ�������ʱ�׳��쳣������ִ��setAccessible()����");
					constructor.setAccessible(true);
				}
			}
			example2.print();
			System.out.println();
		}

	}

}
