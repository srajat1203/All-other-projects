public class Person {
    //composition has-a relationship
    private Education edu;
    private Job job;
    
    public Person(){
    	String[] schools = new String[10];
    	for(int i =0; i<10; i++)
    	{
    		schools[i] = "mySchool";
    	}
        this.edu=new Education();
        edu.setEducation(schools);
        
        this.job=new Job();
        job.setSalary(1000L);
    }
    
    public String[] getEducation() {
        return edu.getEducation();
    }
    
    public long getSalary() {
        return job.getSalary();
    }
    
    @Override
    public String toString()
    {
        return "Jobs details are " + job.toString() + "\n" + 
        		"Education details are " + edu.toString() + "\n";
    }
}