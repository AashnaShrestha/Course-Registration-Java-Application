
/**
 * The AcademicCourse class consists of six attributes i.e., 
 * lecturerName, level, credit, startingDate, completionDate, noOfAssessments and isRegistered
 * The class inherits Course class.
 * The class contains a constructor where the variables are initialized, accessor and mutator methods, a method to register the course
 * and a method to output the details of a course.
 * 
 * @author (Aashna Shrestha)
 * @version (11.0.2)
 */
public class AcademicCourse extends Course
{
    //Declares the instance variables
    private String lecturerName;
    private String level;
    private String credit;
    private String startingDate;
    private String completionDate;
    private int noOfAssessments;
    private boolean isRegistered;
    
    /* Constructor with six parameters:
     * courseID, courseName, duration, level, credit, noOfAssessments
     */
    AcademicCourse(String courseID, String courseName,int duration,String level, String credit, int noOfAssessments)
    {
        // Calls the super class, Course
        super(courseID, courseName, duration);
        
        //Initialize the instance variables
        this.lecturerName ="";
        this.startingDate = "";
        this.completionDate = "";
        this.isRegistered = false;
    }
    //Accessor method of lecturerName
    public String getlecturerName()
    {
        return this.lecturerName;
    }
    //Accessor method of level
    public String getlevel()
    {
        return this.level;
    }
    //Accessor method of credit
    public String getcredit()
    {
        return this.credit;
    }
    //Accessor method of startingDate
    public String getstartingDate()
    {
        return this.startingDate;
    }
    //Accessor method of completionDate
    public String getcompletionDate()
    {
        return this.completionDate;
    }
    //Accessor method of noOfAssessments
    public int getnoOfAssessments()
    {
        return this.noOfAssessments;
    }
    //Accessor method of isRegistered
    public boolean getisRegistered()
    {
        return this.isRegistered;
    }
    //Mutator method of lecturerName
    public void setlecturerName(String lecturer_name)
    {
        this.lecturerName = lecturer_name;
    }
    //Mutator method of noOfAssessments
    public void setnoOfAssessments(int noOfAssessments)
    {
        this.noOfAssessments = noOfAssessments;
    }
    /* Checks if an Academic Course has been registered
     * If the course has not been registered, initializes the attributes and registers the course 
     */
    public void register(String course_leader,String lecturer_name,String starting_date, String completion_date)
    {
        if (isRegistered == true){
            System.out.println("You have registered for the course."); 
            System.out.println("Instructor's Name: " + getlecturerName());
            System.out.println("Starting Date: " + getstartingDate()); 
            System.out.println("Completion Date: " + getcompletionDate());
        }
        else{
            //Calls the method setcourseLeader() from the super class with its parameter
            super.setcourseLeader(course_leader);
            
            this.lecturerName = lecturer_name;
            this.startingDate = starting_date;
            this.completionDate = completion_date;
            this.isRegistered = true;
        
            System.out.println("You have registered for the course."); 
            System.out.println("Lecturer: " + getlecturerName());
            System.out.println("Starting Date: " + getstartingDate()); 
            System.out.println("Completion Date: " + getcompletionDate());
        }
    }
    //Displays the course details
    public void display()
    {
        //Calls the display() method from the super class
        super.display();
        if (isRegistered == true)
        {
        System.out.println("Lecturer: " + getlecturerName());
        System.out.println("level:" + getlevel()); 
        System.out.println("credit: " + getcredit()); 
        System.out.println("Starting Date: " + getstartingDate());
        System.out.println("Completion Date: " + getcompletionDate());
        System.out.println("Number of Assessments: " + getnoOfAssessments());
        }
    }
}
