import java.lang.reflect.Constructor;

public class AccessConstructor {

	public static void main(String[] args) {

		MoreConstructor example = new MoreConstructor("10", "20", "30");
		Class exampleC = example.getClass();

		Constructor[] declaredConstructors = exampleC.getDeclaredConstructors();
		for (int i = 0; i < declaredConstructors.length; i++) {
			Constructor constructor = declaredConstructors[i];
			System.out.println("查看是否允许带有可变数量的参数：" + constructor.isVarArgs());
			System.out.println("该构造方法的入口参数类型依次为：");
			Class[] parameterTypes = constructor.getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.println(" " + parameterTypes[j]);
			}
			System.out.println("该构造方法可能抛出的异常类型为：");
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
					System.out.println("在创建对象时抛出异常，下面执行setAccessible()方法");
					constructor.setAccessible(true);
				}
			}
			example2.print();
			System.out.println();
		}

	}

}
