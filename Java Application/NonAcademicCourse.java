
/**
 * The NonAcademicCourse class has eight attributes i.e., instructorName, startDate, completionDate, examDate, prerequisite,
 * duration, isRegistered, isRemoved.
 * The class inherits Course class.
 * The class contains a constructor, accessor and mutator methods, methods to register course, remove course,
 * and display the course details.
 * 
 * @author (Aashna Shrestha)
 * @version (11.0.2)
 */
public class NonAcademicCourse extends Course
{
    //Declares the instance variables
    private String instructorName;
    private String startDate;
    private String completionDate;
    private String examDate;
    private String prerequisite;
    private int duration;
    private boolean isRegistered;
    private boolean isRemoved;
    
    /* Constructor with four parameters i.e.,
     * courseID, courseName, duration, prerequisite
       */
    NonAcademicCourse(String courseID, String courseName, int duration, String prerequisite)
    {    
        super(courseID, courseName, duration);
        this.prerequisite = prerequisite;
        this.startDate = "";
        this.completionDate = "";
        this.examDate = "";
        this.isRegistered = false;
        this.isRemoved = false;
    }
    //Accessor method of instructor method
    public String getinstructorName()
    {
        return this.instructorName;
    }
    //Accessor method of duration
    public int getduration()
    {
        return this.duration;
    }
    //Accessor method of startDate
    public String getstartDate()
    {
        return this.startDate;
    }
    //Accessor method of completionDate
    public String getcompletionDate()
    {
        return this.completionDate;
    }
    //Accessor method of examDate
    public String getexamDate()
    {
        return this.examDate;
    }
    //Accessor method of prerequisite
    public String getprerequisite()
    {
        return this.prerequisite;
    }
    //Accessor method of isRegistered
    public boolean getisRegistered()
    {
        return this.isRegistered;
    }
    //Accessor method of isRemoved
    public boolean getisRemoved()
    {
        return this.isRemoved;
    }
    /*Mutator method of instructorName
     *Initializes the instructorName if the course has not been registered
     */
    public void setinstructorName(String instructor_name)
    {
        if (isRegistered == false){
            this.instructorName = instructor_name;
        }
        else{
            System.out.println("Update failed. Changing the instructor name is not possible.");
        }
    }
    /* Checks if the course has been registered
     * If the course has not been registered, initializes the instructorName and registers the course
       */
    public void register(String courseLeader, String instructor_name, String startDate,String completionDate,String examDate)
    {
        if (isRegistered == false){
            // Calls the method setinstructorName with its parameter. 
            setinstructorName(instructor_name);
            this.isRegistered = true;
        }
        else{
            System.out.println("The course has already been registered. Instructor name can not be changed.");
        }
    }
    //Removes the course
    public void remove()
    {
        if(isRemoved == true){
            System.out.println("The course has been removed.");
        }
        else{
            //Calls the setcourseLeader() method from the super class with its parameter
            super.setcourseLeader("");
            
            //Initailize the instance variables to remove the course
            this.instructorName = "";
            this.startDate = "";
            this.completionDate = "";
            this.examDate = "";
            this.isRegistered = false;
            this.isRemoved = true;
        }
    }
    //Displays the details of the course
    public void display()
    {
        //Calls the display() method from the super class.
        super.display();
        if (isRegistered == true){
            System.out.println("Instructor Name: " + getinstructorName());
            System.out.println("Start Date: " + getstartDate()); 
            System.out.println("Completion Date: " + getcompletionDate());
            System.out.println("Exam Date: " + getexamDate());
        }
        else{
            System.out.println("The course has not been registered.");
        }
    }
}
