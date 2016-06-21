import java.lang.reflect.Field;

public class AccessFields {

	public static void main(String[] args) {

		MoreFields example = new MoreFields();
		Class exampleC = example.getClass();

		Field[] declaredFields = exampleC.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			Field field = declaredFields[i];
			System.out.println("����Ϊ��" + field.getName());
			Class fieldType = field.getType();
			System.out.println("����Ϊ��" + fieldType);
			boolean isTurn = true;
			while (isTurn) {
				try {
					isTurn = false;
					System.out.println("�޸�ǰ��ֵΪ��" + field.get(example));
					if (fieldType.equals(int.class)) {
						System.out.println("���÷���setInt()�޸ĳ�Ա������ֵ");
						field.setInt(example, 168);
					} else if (fieldType.equals(float.class)) {
						System.out.println("���÷���setFloat()�޸ĳ�Ա������ֵ");
						field.setFloat(example, 99.9F);
					} else if (fieldType.equals(boolean.class)) {
						System.out.println("���÷���setBoolean()�޸ĳ�Ա������ֵ");
						field.setBoolean(example, true);
					} else {
						System.out.println("���÷���set()�޸ĳ�Ա������ֵ");
						field.set(example, "MWQ");
					}
					System.out.println("�޸ĺ��ֵΪ��" + field.get(example));
				} catch (Exception e) {
					System.out.println("�����ó�Ա����ֵʱ�׳��쳣������ִ��setAccessible()������");
					field.setAccessible(true);
					isTurn = true;
				}
			}
			System.out.println();
		}

	}
}
