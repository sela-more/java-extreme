package strings;
class Ex1
{
	public static void main(String args[])
	{
		String s1 = "Hello Java";
		String s2 = "Hello Java";

		System.out.println("s1 == s2: " + (s1 == s2));
		System.out.println("s1.equals(s2): " + s1.equals(s2));
		System.out.println("compare(s2): " + compare(s2));
	}

	private static boolean compare(String sOther)
	{
		return sOther == "Hello Java";
	}
}