package zyj;

public class ComparableSort implements Comparable<ComparableSort
> {
	private int id;
	private String name;
	private int age;
	public ComparableSort(int id,String name,int age)
	{
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public int compareTo(ComparableSort o) 
	{
		if(id > o.id)
		{
			return 1;
		}
		else if(id < o.id)
		{
			return -1;
		}
		return 0;
	};
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id"+id+" ");
		sb.append("name"+name+" ");
		sb.append("age"+age+" ");
		return sb.toString();
	}
}
