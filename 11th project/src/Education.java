
public class Education {
	//private String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
	private String[] arr = new String [10];
	

	
	public void setEducation(String[] schools)
	{
		for(int i=0; i<10; i++)
		{
			arr[i] = schools[i];
		}
	}
	
	public String[] getEducation()
	{
		return arr;
	}
	
	@Override
    public String toString()
    {
		
        return "School names are:      " + arr[0] + " " + arr[2]
        		+ " " + arr[3] + " " + arr[4] + " " + arr[5] + " " + arr[6]
        		+ " " + arr[7] + " " + arr[8] + " " + arr[9]
        		+ " " + arr[10] + "\n";		
    }
	
}	
