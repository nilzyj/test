import java.lang.reflect.Method;

public class AccessMethod {

	public static void main(String[] args) {
		MoreMethod example = new MoreMethod();
		Class exampleC = example.getClass();

		Method[] declaredMethods = exampleC.getDeclaredMethods();
		for (int i = 0; i < declaredMethods.length; i++) {
			Method method = declaredMethods[i];
			System.out.println("名称为：" + method.getName());
			System.out.println("是否允许带有可变数量的参数：" + method.isVarArgs());
			System.out.println("入口参数类型依次为：");
			Class[] parameterTypes = method.getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.println(" " + parameterTypes[j]);
			}
			System.out.println("返回值类型为：" + method.getReturnType());
			System.out.println("可能抛出的异常类型有：");
			Class[] exceptionTypes = method.getExceptionTypes();
			for (int j = 0; j < exceptionTypes.length; j++) {
				System.out.println(" " + exceptionTypes[j]);
			}
			boolean isTurn = true;
			while (isTurn) {
				try {
					isTurn = false;
					if (i == 0)
						method.invoke(example); // 执行没有入口参数的发
					else if (i == 1)
						System.out.println("返回值为："
								+ method.invoke(example, 168));
					else if (i == 2)
						System.out.println("返回值为："
								+ method.invoke(example, "7", 5)); // 执行方法
					else {
						Object[] parameters = new Object[] { new String[] {
								"明", "日", "科","技" } };
						System.out.println("返回值为："
								+ method.invoke(example, parameters)); // 执行方法
					}
				} catch (Exception e) {
					System.out.println("在执行方法时抛出异常，下面执行setAccessible()方法！");
					method.setAccessible(true);
					isTurn = true;
				}
			}
			System.out.println();
		}

	}

}
