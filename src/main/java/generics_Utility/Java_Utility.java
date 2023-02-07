package generics_Utility;

import java.util.Random;

public class Java_Utility 
{
	/**
	 * This method is used to Avoid Duplicates Names we use for textfields
	 * @return
	 * @author Abinash
	 */
	public int getRandomNumber()
	{
		Random ran = new  Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
}
