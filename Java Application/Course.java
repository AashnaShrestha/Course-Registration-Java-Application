
/**
 * The Course class consists of four attributes i.e., courseID, courseName, courseLeader and duration. 
 * The class contains a constructor where the variables are initialized, accessor and mutator methods,
 * and a display method to output the details of a course.
 * 
 * @author (Aashna Shrestha)
 * @version (11.0.2)
 */
public class Course
{
    //Declares the instance variables
    private String courseID;
    private String courseName;
    private String courseLeader;
    private int duration;
    
    /* Constructor with 3 parameters: courseID, courseName, duration
     * Initialize the attributes */
    Course(String courseID, String courseName, int duration)
    {
        this.courseID = courseID;
        this.courseName = courseName;
        this.duration = duration;
        this.courseLeader = "";
    }
    //Accessor method for courseID
    public String getcourseID()
    {
        return this.courseID;
    }
    //Accessor method for courseName
    public String getcourseName()
    {
        return this.courseName;
    }
    //Accessor method for duration
    public int getduration()
    {
        return this.duration;
    }
    //Accessor method for courseLeader
    public String getcourseLeader()
    {
        return this.courseLeader;
    }
    //Mutator method for courseLeader
    public void setcourseLeader(String course_leader)
    {
        this.courseLeader = course_leader;
    }
    //Displays the course details and name of the course leader if the leader has been assigned
    public void display()
    {
        System.out.println("Course ID: " + getcourseID()); 
        System.out.println("Course Name: " + getcourseName());
        System.out.println("Duration: " + getduration());
        if (courseLeader != "")
        {
        System.out.println("Course Leader: " + getcourseLeader());
        }
    }
}
