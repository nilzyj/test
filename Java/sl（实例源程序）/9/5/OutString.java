public class OutString {
	public static void main(String[] args) {

		final String sourceStr = "����ʡ ���� �Ƽ����޹�˾������� �ʵ䣡";
		IStringDeal s = new IStringDeal() { // ��д�����ڲ���
			@Override
			public String filterBlankChar() {
				// TODO Auto-generated method stub
				String convertStr = sourceStr;
				convertStr = convertStr.replaceAll(" ", ""); // �滻ȫ���ո�
				return convertStr; // ����ת������ַ���
			}
		};
		System.out.println("Դ�ַ�����" + sourceStr);// ���Դ�ַ���
		System.out.println("ת������ַ�����" + s.filterBlankChar());// ���ת������ַ���
	}
}
