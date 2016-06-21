public class OutString {
	public static void main(String[] args) {

		final String sourceStr = "吉林省 明日 科技有限公司——编程 词典！";
		IStringDeal s = new IStringDeal() { // 编写匿名内部类
			@Override
			public String filterBlankChar() {
				// TODO Auto-generated method stub
				String convertStr = sourceStr;
				convertStr = convertStr.replaceAll(" ", ""); // 替换全部空格
				return convertStr; // 返回转换后的字符串
			}
		};
		System.out.println("源字符串：" + sourceStr);// 输出源字符串
		System.out.println("转换后的字符串：" + s.filterBlankChar());// 输出转换后的字符串
	}
}
