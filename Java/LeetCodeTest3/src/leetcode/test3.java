package leetcode;

public class test3 {

	public static void main(String[] args) 
	{
		String s="abcabcaa";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) 
	{
		int maxlength=0,temp=0;
		for(int i=0;i<s.length()-1;++i)
		{
			if(s.charAt(i+1)!=s.charAt(i))
			{
				temp++;
			}
			else
			{
				for(int j=0;j<temp;++j)
				{
					for(int k=0;k<temp;++k)
					{
						if(s.substring(i-temp, i).charAt(j))
							if(maxlength<temp)
							{
								maxlength=temp;
								temp=0;
							}
					}
				}
			}
		}
		return maxlength;
	}
}

