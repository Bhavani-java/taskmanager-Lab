
public class TaskUtil1 {
	
	public static boolean validateName(String str)
	{
		if(str == null)
			return false;
		if(str.trim().equals(""))
			return false;
		
		if(!Character.isLetter(str.charAt(0)))
			return false;
		 
		if(str.split(" ").length>1)
			return false;
		
		for(int i=1; i<str.length(); i++)
		{
			char c =str.charAt(i);
			if(!(Character.isDigit(c) || Character.isLetter(c)))
				return false;
		}
			return true;
	}

	public static boolean isValidWord(String taskName) {
		System.out.println("in task name validation "+taskName);
		// TODO Auto-generated method stub
		return true;
	}

	
}
