
/**
 * The class INGCollege contains a method courseGui() with JFrames, JPanels, JLabels, JTextFields, JButtons and JComboBox. 
 * It contains accessor methods which return the values entered by the users in JTextFields.
 * It also contains actionPerformed method which executes certain course of actions such as adding, registering or removing a course
 * when particular buttons are clicked.
 *
 * @author (Aashna Shrestha)
 * @version (11.0.2)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class INGCollege implements ActionListener
{
    //---Variable Declaration---//
    
    //JFrame, JPanel and title
    private JFrame frame;
    private JPanel mainPanel, addCoursePanel, registerPanel;
    private JLabel title, academicTitle, nonAcademicTitle, courseOption;
    
    //JButtons
    private JButton academicButton, nonAcademicButton, addAcademicButton, addNonAcademicButton, registerAcademicButton, registerNonAcademicButton, 
    removeButton,displayAcademicButton, displayNonAcademicButton, clearButton;
    
    //JLabels in addCoursePanel 
    private JLabel courseIdLabel, courseNameLabel, durationLabel, levelLabel, creditLabel, 
    assessmentLabel, prerequisiteLabel;
    
    //JTextFields in addCoursePanel
    private JTextField courseIdField, courseNameField, durationField, levelField, creditField, assessmentField, prerequisiteField;
    
    //JLabels in registerPanel
    private JLabel idRegisterLabel, leaderLabel, lecturerLabel, instructorLabel, startDateLabel, completionDateLabel, examDateLabel;
    
    //JTextFields in registerPanel
    private JTextField idRegisterField, leaderField, lecturerField, instructorField;
    
    //JComboBox in registerPanel
    private JComboBox startYear, startMonth, startDay, completionYear, completionMonth, completionDay, examYear, examMonth, examDay;
    
    //Variables to store date
    private String start_year, start_month, start_day, startDate, completion_year, completion_month, completion_day, completionDate, 
    exam_year, exam_month, exam_day, examDate;
    
    //Static variabel for an object of INGCollege
    static INGCollege ing;
    
    //Creates an ArrayList
    private ArrayList <Course> courseList = new ArrayList();
    
    //Variable for objects of AcademicCourse class
    private AcademicCourse academicObject;
    
    //Variable for object of NonAcademicCourse class
    private NonAcademicCourse nonAcademicObject;
    
    /* Method to create a GUI
     * The method contains objects of JFrame, Jpanel, JLabel, JTextField, JComboBox 
     * along with their bounds, font and background/foreground color
       */
    public void courseGui()
    {
        //Creating object for the frame
        frame = new JFrame("Course Registration");
        
        //Creating objects for colors
        Color mainBackground = new Color(27, 38, 66);
        Color innerPanel = new Color(191, 193, 199);
        Color buttonColor = new Color(247, 129, 2);
        
        //Creating object for the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(mainBackground);
        
        //Creating objects for fonts
        Font titleFont = new Font("Serif", Font.BOLD, 25);
        Font mainFont = new Font("Serif", Font.PLAIN, 18);
        Font comboBoxFont = new Font("Serif", Font.PLAIN, 14);
        
        //JLabel for the title of the frame
        title = new JLabel("Course Registration");
        title.setBounds(285, 5, 250, 50);
        title.setFont(titleFont);
        title.setForeground(Color.WHITE);
        mainPanel.add(title);
        
        //JLabel which asks user to choose a course 
        courseOption = new JLabel("Choose your course!");
        courseOption.setFont(mainFont);
        courseOption.setForeground(Color.WHITE);
        courseOption.setBounds(320, 60, 300, 30);
        mainPanel.add(courseOption);
        
        //JButton to choose Academic Course
        academicButton = new JButton("Academic Course");
        academicButton.setBounds(310, 95, 180, 30);
        academicButton.setFont(mainFont);
        academicButton.setForeground(Color.WHITE);
        academicButton.setBackground(buttonColor);
        academicButton.addActionListener(this);
        mainPanel.add(academicButton);
        
        //JButton to choose Non Academic Course
        nonAcademicButton = new JButton("Non Academic Course");
        nonAcademicButton.setBounds(300, 135, 200, 30);
        nonAcademicButton.setFont(mainFont);
        nonAcademicButton.setForeground(Color.WHITE);
        nonAcademicButton.setBackground(buttonColor);
        nonAcademicButton.addActionListener(this);
        mainPanel.add(nonAcademicButton);
        
        //JLabel for the title of Academic Course
        academicTitle = new JLabel("Academic Course");
        academicTitle.setBounds(310, 180, 250, 50);
        academicTitle.setFont(titleFont);
        academicTitle.setForeground(Color.WHITE);
        mainPanel.add(academicTitle);
        
        //JLabel for the title of Non Academic Course
        nonAcademicTitle = new JLabel("Non Academic Course");
        nonAcademicTitle.setBounds(290, 180, 250, 50);
        nonAcademicTitle.setFont(titleFont);
        nonAcademicTitle.setForeground(Color.WHITE);
        mainPanel.add(nonAcademicTitle);
        nonAcademicTitle.setVisible(false);
        
        //JPanel for adding course
        addCoursePanel = new JPanel();
        addCoursePanel.setBackground(innerPanel);
        addCoursePanel.setBounds(20, 240, 355, 380);
        addCoursePanel.setVisible(true);
        addCoursePanel.setLayout(null);
        mainPanel.add(addCoursePanel);
        
        //JPanel for registering course
        registerPanel = new JPanel();
        registerPanel.setBackground(innerPanel);
        registerPanel.setBounds(410, 240, 355, 380);
        registerPanel.setVisible(true);
        registerPanel.setLayout(null);
        mainPanel.add(registerPanel);
        
        //---Components of addCoursePanel---//
        
        //JLabel for course ID in addCoursePanel
        courseIdLabel = new JLabel("Course ID: ");
        courseIdLabel.setBounds(10, 20, 100, 30);
        courseIdLabel.setFont(mainFont);
        addCoursePanel.add(courseIdLabel);
        
        //JTextField for course ID in addCoursePanel
        courseIdField = new JTextField();
        courseIdField.setBounds(170, 20, 160, 30);
        addCoursePanel.add(courseIdField);
        
        //JLabel for course name
        courseNameLabel = new JLabel("Course Name: ");
        courseNameLabel.setBounds(10, 70, 110, 30);
        courseNameLabel.setFont(mainFont);
        addCoursePanel.add(courseNameLabel);
        
        //JTextField for course name
        courseNameField = new JTextField();
        courseNameField.setBounds(170, 70, 160, 30);
        addCoursePanel.add(courseNameField);
        
        //JLabel for duration
        durationLabel = new JLabel("Duration: ");
        durationLabel.setBounds(10, 120, 100, 30);
        durationLabel.setFont(mainFont);
        addCoursePanel.add(durationLabel);
        
        //JTextField for duration
        durationField = new JTextField();
        durationField.setBounds(170, 120, 160, 30);
        addCoursePanel.add(durationField);
        
        //JLabel for level
        levelLabel = new JLabel("Level: ");
        levelLabel.setBounds(10, 170, 100, 30);
        levelLabel.setFont(mainFont);
        addCoursePanel.add(levelLabel);
        
        //JTextField for level
        levelField = new JTextField();
        levelField.setBounds(170, 170, 160, 30);
        addCoursePanel.add(levelField);
        
        //JLabel for credit
        creditLabel = new JLabel("Credit: ");
        creditLabel.setBounds(10, 220, 100, 30);
        creditLabel.setFont(mainFont);
        addCoursePanel.add(creditLabel);
        
        //JTextField for credit
        creditField = new JTextField();
        creditField.setBounds(170, 220, 160, 30);
        addCoursePanel.add(creditField);
        
        //JLabel for number of assessments
        assessmentLabel = new JLabel("No. of Assessments: ");
        assessmentLabel.setBounds(10, 270, 160, 30);
        assessmentLabel.setFont(mainFont);
        addCoursePanel.add(assessmentLabel);
        
        //JTextField for number of assesments
        assessmentField = new JTextField();
        assessmentField.setBounds(170, 270, 160, 30);
        addCoursePanel.add(assessmentField);
        
        //JLabel for prerequisite
        prerequisiteLabel = new JLabel("Prerequisite: ");
        prerequisiteLabel.setBounds(10, 170, 100, 30);
        prerequisiteLabel.setFont(mainFont);
        addCoursePanel.add(prerequisiteLabel);
        prerequisiteLabel.setVisible(false);
        
        //JTextField for prerequisite
        prerequisiteField = new JTextField();
        prerequisiteField.setBounds(170, 170, 160, 70);
        addCoursePanel.add(prerequisiteField);
        prerequisiteField.setVisible(false);
        
        //JButton for adding an academic course
        addAcademicButton = new JButton("Add");
        addAcademicButton.setBounds(140, 340, 80, 30);
        addAcademicButton.setFont(mainFont);
        addAcademicButton.addActionListener(this);
        addCoursePanel.add(addAcademicButton);
        
        //JButton for adding a non academic course
        addNonAcademicButton = new JButton("Add");
        addNonAcademicButton.setBounds(140, 280, 80, 30);
        addNonAcademicButton.setFont(mainFont);
        addNonAcademicButton.addActionListener(this);
        addCoursePanel.add(addNonAcademicButton);
        addNonAcademicButton.setVisible(false);
        
        //JButton to remove non academic course
        removeButton = new JButton("Remove");
        removeButton.setBounds(130, 320, 100, 30);
        removeButton.setFont(mainFont);
        removeButton.addActionListener(this);
        addCoursePanel.add(removeButton);
        removeButton.setVisible(false);
        
        //---Components of registerPanel---//
        
        //JLabel for course Id in registerPanel
        idRegisterLabel = new JLabel("Course ID: ");
        idRegisterLabel.setBounds(10, 20, 100, 30);
        idRegisterLabel.setFont(mainFont);
        registerPanel.add(idRegisterLabel);
        
        //JTextField for course Id in registerPanel
        idRegisterField = new JTextField();
        idRegisterField.setBounds(170, 20, 160, 30);
        registerPanel.add(idRegisterField);
        
        //JLabel for course leader
        leaderLabel = new JLabel("Course Leader: ");
        leaderLabel.setBounds(10, 70, 120, 30);
        leaderLabel.setFont(mainFont);
        registerPanel.add(leaderLabel);
        
        //JTextField for course leader
        leaderField = new JTextField();
        leaderField.setBounds(170, 70, 160, 30);
        registerPanel.add(leaderField);
        
        //JLabel for lecturer
        lecturerLabel = new JLabel("Lecturer: ");
        lecturerLabel.setBounds(10, 120, 100, 30);
        lecturerLabel.setFont(mainFont);
        registerPanel.add(lecturerLabel);
        
        //JTextField for lecturer
        lecturerField = new JTextField();
        lecturerField.setBounds(170, 120, 160, 30);
        registerPanel.add(lecturerField);
        
        //JLabel for lecturer
        instructorLabel = new JLabel("Instructor: ");
        instructorLabel.setBounds(10, 120, 100, 30);
        instructorLabel.setFont(mainFont);
        registerPanel.add(instructorLabel);
        instructorLabel.setVisible(false);
        
        //JTextField for lecturer
        instructorField = new JTextField();
        instructorField.setBounds(170, 120, 160, 30);
        registerPanel.add(instructorField);
        instructorField.setVisible(false);
        
        //JLabel for the date in which a course starts
        startDateLabel = new JLabel("Start Date: ");
        startDateLabel.setBounds(10, 170, 150, 30);
        startDateLabel.setFont(mainFont);
        registerPanel.add(startDateLabel);
        
        //yearList is an array which stores the year
        Integer yearList[] = new Integer[28];
        int year = 2020;
        for (int i = 0; i <= 26; i++){
            yearList[i] = year;
            year++;
        }
        
        //JComboBox for the year in which a course starts
        startYear = new JComboBox(yearList);
        startYear.setBounds(160, 170, 60, 30);
        startYear.setFont(comboBoxFont);
        registerPanel.add(startYear);
        
        //month is an array which stores the month
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        
        //JComboBox for the month in which a course starts
        startMonth = new JComboBox(month);
        startMonth.setBounds(225, 170, 75, 30);
        startMonth.setFont(comboBoxFont);
        registerPanel.add(startMonth);
        
        //dayList is an array which stores the date
        String dayList[] = new String[31];
        int day = 1;
        for (int i = 0; i <= 30; i++){
            if (day < 10){
                dayList[i] = "0" + day;
            }
            else{
                dayList[i] = String.valueOf(day);
            }
            day++;
        }
        
        //JComboBox for the date in which a course starts
        startDay = new JComboBox(dayList);
        startDay.setBounds(305, 170, 40, 30);
        startDay.setFont(comboBoxFont);
        registerPanel.add(startDay);
        
        //JLabel for the date when a course completes
        completionDateLabel = new JLabel("Completion Date: ");
        completionDateLabel.setBounds(10, 220, 140, 30);
        completionDateLabel.setFont(mainFont);
        registerPanel.add(completionDateLabel);
        
        //JComboBox for the year in which a course completes
        completionYear = new JComboBox(yearList);
        completionYear.setBounds(160, 220, 60, 30);
        completionYear.setFont(comboBoxFont);
        registerPanel.add(completionYear);
        
        //JComboBox for the month in which a course completes
        completionMonth = new JComboBox(month);
        completionMonth.setBounds(225, 220, 75, 30);
        completionMonth.setFont(comboBoxFont);
        registerPanel.add(completionMonth);
        
        //JComboBox for the date in which a course completes
        completionDay = new JComboBox(dayList);
        completionDay.setBounds(305, 220, 40, 30);
        completionDay.setFont(comboBoxFont);
        registerPanel.add(completionDay);
        
        //JLabel for the date of exam
        examDateLabel = new JLabel("Exam Date:");
        examDateLabel.setBounds(10, 270, 160, 30);
        examDateLabel.setFont(mainFont);
        registerPanel.add(examDateLabel);
        examDateLabel.setVisible(false);
        
        //JComboBox for the year of exam
        examYear = new JComboBox(yearList);
        examYear.setBounds(160, 270, 60, 30);
        examYear.setFont(comboBoxFont);
        registerPanel.add(examYear);
        examYear.setVisible(false);
        
        //JComboBox for the month of exam
        examMonth = new JComboBox(month);
        examMonth.setBounds(225, 270, 75, 30);
        examMonth.setFont(comboBoxFont);
        registerPanel.add(examMonth);
        examMonth.setVisible(false);
        
        //JComboBox for the day of exam
        examDay = new JComboBox(dayList);
        examDay.setBounds(305, 270, 40, 30);
        examDay.setFont(comboBoxFont);
        registerPanel.add(examDay);
        examDay.setVisible(false);
        
        //JButton to register academic course
        registerAcademicButton = new JButton("Register");
        registerAcademicButton.setBounds(140, 320, 100, 30);
        registerAcademicButton.setFont(mainFont);
        registerAcademicButton.addActionListener(this);
        registerPanel.add(registerAcademicButton);
        
        //JButton to register non academic course
        registerNonAcademicButton = new JButton("Register");
        registerNonAcademicButton.setBounds(140, 340, 100, 30);
        registerNonAcademicButton.setFont(mainFont);
        registerNonAcademicButton.addActionListener(this);
        registerPanel.add(registerNonAcademicButton);
        registerNonAcademicButton.setVisible(false);
        
        //JButton to display information of Academic Course
        displayAcademicButton = new JButton("Display");
        displayAcademicButton.setBounds(285, 640, 100, 30);
        displayAcademicButton.setFont(mainFont);
        displayAcademicButton.setForeground(Color.WHITE);
        displayAcademicButton.setBackground(buttonColor);
        displayAcademicButton.addActionListener(this);
        mainPanel.add(displayAcademicButton);
        
        //JButton to display the information of Non Academic Course
        displayNonAcademicButton = new JButton("Display");
        displayNonAcademicButton.setBounds(285, 640, 100, 30);
        displayNonAcademicButton.setFont(mainFont);
        displayNonAcademicButton.setForeground(Color.WHITE);
        displayNonAcademicButton.setBackground(buttonColor);
        displayNonAcademicButton.addActionListener(this);
        mainPanel.add(displayNonAcademicButton);
        displayNonAcademicButton.setVisible(false);
        
        //JButton to clear all the text fields 
        clearButton = new JButton("Clear");
        clearButton.setBounds(400, 640, 100, 30);
        clearButton.setFont(mainFont);
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(buttonColor);
        clearButton.addActionListener(this);
        mainPanel.add(clearButton);
        
        frame.add(mainPanel);
        frame.setBounds(300, 0, 800, 730);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
    /* Accessor method of courseId.
     * Returns the course ID entered by the user.
     */
    public String getCourseId()
    {
        return this.courseIdField.getText();
    }
    
    /*Accessor method of courseName
     * Returns the course name entered by the user.
     */
    public String getCourseName()
    {
        return this.courseNameField.getText();
    }
    
    /* Accessor method of duration
     * Returns the duration entered by the user.
     */
    public int getDuration()
    {
        return Integer.parseInt(this.durationField.getText());
    }
    
    /* Accessor method of level
     * Returns the level entered by the user.
     */
    public String getLevel()
    {
        return this.levelField.getText();
    }
    
    /* Accessor method of credit
     * Returns the credit entered by the user.
     */
    public String getCredit()
    {
        return this.creditField.getText();
    }
    
    /* Accessor method of noOfAssessments
     * Returns the number of assessments entered by the user.
     */
    public int getNoOfAssessments()
    {
        return Integer.parseInt(this.assessmentField.getText());
    }
    
    /* Accessor method of prerequisite
     * Returns the prerequisite entered by the user.
     */
    public String getPrerequisite()
    {
        return this.prerequisiteField.getText();
    }
    
    /* Accessor method of Id
     * Returns the course ID entered by the user while registering a course.
     */
    public String getRegisterId()
    {
        return this.idRegisterField.getText();
    }
    
    /* Accessor method of course leader
     * Returns the course leader entered by the user.
     */
    public String getCourseLeader()
    {
        return this.leaderField.getText();
    }
    
    /* Accessor method of lecturer
     * Returns the name of the lecturer entered by the user.
     */
    public String getLecturer()
    {
        return this.lecturerField.getText();
    }
    
    /* Accessor method of instructor
     * Returns the name of the instructor entered by the user.
     */
    public String getInstructor()
    {
        return this.instructorField.getText();
    }
    
    /* Accessor method of starting date
     * Concatenates the year, month and date entered by the user.
     * Returns the date on which the course starts.
     */
    public String getStartDate()
    {
        String start_year = (this.startYear.getSelectedItem()).toString();
        String start_month = (this.startMonth.getSelectedItem()).toString();
        String start_day = (this.startDay.getSelectedItem()).toString();
        this.startDate = start_year + " " + start_month + " " + start_day;
        return startDate;
    }
    
    /* Accessor method of completion date
     * Concatenates the year, month and date entered by the user.
     * Returns the date on which the course completes.
     */
    public String getCompletionDate()
    {
        String completion_year = (this.completionYear.getSelectedItem()).toString();
        String completion_month = (this.completionMonth.getSelectedItem()).toString();
        String completion_day = (this.completionDay.getSelectedItem()).toString();
        this.completionDate = completion_year + " " + completion_month + " " + completion_day;
        return completionDate;
    }
    
    /* Accessor method of exam date
     * Concatenates the year, month and date entered by the user.
     * Returns the date of exam.
     */
    public String getExamDate()
    {
        String exam_year = (this.examYear.getSelectedItem()).toString();
        String exam_month = (this.examMonth.getSelectedItem()).toString();
        String exam_day = (this.examDay.getSelectedItem()).toString();
        this.examDate = exam_year + " " + exam_month + " " + exam_day;
        return examDate;
    }

    /* ActionPerformed method checks which button has been clicked by the user
     * Certain course of action will execute according to the required button
     */
    public void actionPerformed(ActionEvent e)
    {
        /*Actions to be performed when nonAcademicButton is clicked
         * Visibility of JLabel, JField, JButton are changed to display the fields needed for Non Academic Course
         */
        if (e.getSource() == nonAcademicButton){
            //Changes to be made in addCoursePanel
            levelLabel.setVisible(false);
            creditLabel.setVisible(false);
            assessmentLabel.setVisible(false);
            levelField.setVisible(false);
            creditField.setVisible(false);
            lecturerLabel.setVisible(false);
            lecturerField.setVisible(false);
            assessmentField.setVisible(false);
            prerequisiteLabel.setVisible(true);
            prerequisiteField.setVisible(true);
            addAcademicButton.setVisible(false);
            addNonAcademicButton.setVisible(true);
            removeButton.setVisible(true);
            
            //Changes to be made in registerPanel
            examDateLabel.setVisible(true);
            examYear.setVisible(true);
            examMonth.setVisible(true);
            examDay.setVisible(true);
            registerNonAcademicButton.setVisible(true);
            registerAcademicButton.setVisible(false);
            instructorLabel.setVisible(true);
            instructorField.setVisible(true);
            
            //Changes to be made in mainPanel
            nonAcademicTitle.setVisible(true);
            academicTitle.setVisible(false);
            displayAcademicButton.setVisible(false);
            displayNonAcademicButton.setVisible(true);
        }
        
        /* Actions to be performed when academicButton is clicked
         * Visibility of JLabel, JField, JButton are changed to display only the required fields
         */
        else if(e.getSource() == academicButton){
            //Changes to be made in addCoursePanel
            levelLabel.setVisible(true);
            creditLabel.setVisible(true);
            assessmentLabel.setVisible(true);
            levelField.setVisible(true);
            creditField.setVisible(true);
            assessmentField.setVisible(true);
            lecturerLabel.setVisible(true);
            lecturerField.setVisible(true);
            prerequisiteLabel.setVisible(false);
            prerequisiteField.setVisible(false);
            addNonAcademicButton.setVisible(false);
            addAcademicButton.setVisible(true);
            registerNonAcademicButton.setVisible(false);
            registerAcademicButton.setVisible(true);
            removeButton.setVisible(false);
            
            //Changes to be made in registerPanel
            examDateLabel.setVisible(false);
            examYear.setVisible(false);
            examMonth.setVisible(false);
            examDay.setVisible(false);
            instructorLabel.setVisible(false);
            instructorField.setVisible(false);
            
            //Changes to be made in mainPanel
            nonAcademicTitle.setVisible(false);
            academicTitle.setVisible(true);
            displayAcademicButton.setVisible(true);
            displayNonAcademicButton.setVisible(false);
        }
        
        /* Actions to be performed when addAcademicButton is clicked.
         * Checks if all the fields have been filled.
         * An object of AcademicCourse class is created.
         * The course is added to the ArrayList: courseList.
         */
        else if(e.getSource() == addAcademicButton){
            boolean courseFound = false;
            for(Course course : courseList)
            {
                if (course.getcourseID().equals(getCourseId()) && course instanceof AcademicCourse)
                {
                    JOptionPane.showMessageDialog(frame, "The course has been added already.", "Duplication Found", JOptionPane.ERROR_MESSAGE);   
                    courseFound = true;
                }
            }
            if (!courseFound || courseList.size() == 0) 
            {
                try{
                    if(getCourseId().isEmpty() || getCourseName().isEmpty() || getLevel().isEmpty() || getCredit().isEmpty())
                    {
                      JOptionPane.showMessageDialog(frame, "Please fill all the fields.", "WARNING", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        {
                        academicObject = new AcademicCourse(getCourseId(), getCourseName(), getDuration(), getLevel(), getCredit(), 
                        getNoOfAssessments());
                        courseList.add(academicObject);
                        JOptionPane.showMessageDialog(frame, "Academic Course has been added successfully with the following details: \n Course ID: " 
                        + getCourseId() +"\n Course Name: " + getCourseName() + "\n Duration: " + getDuration() + "\n Level: " + getLevel() + 
                        "\n Credit: " + getCredit() + "\n Number of Assessments: " + getNoOfAssessments(), "ALERT", JOptionPane.WARNING_MESSAGE);
                        }
                }
                catch(NumberFormatException ae)
                {
                    JOptionPane.showMessageDialog(frame, "Enter a numerical value in duration and number of assessments", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                catch(NullPointerException ex)
                {
                    JOptionPane.showMessageDialog(frame, "Please fill all the fields.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        /* Actions to be performed when registerAcademicButton is clicked.
         * Checks if the entered course ID is present in the ArrayList.
         * If found, it checks if the course has been registered.
         * If the course has not been registered, the register method from the AcademicCourse class will be called.
         */
        
        else if(e.getSource() == registerAcademicButton){
            boolean courseFound = false;
            if(getRegisterId().isEmpty() || getCourseLeader().isEmpty() || getLecturer().isEmpty())
            {
                JOptionPane.showMessageDialog(frame, "Please fill all the fields", "WARNING", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                for (Course course : courseList)
                {
                    if (course.getcourseID().equals(getRegisterId()) && course instanceof AcademicCourse){
                        AcademicCourse academic_obj = (AcademicCourse) course;
                        courseFound = true; 
                        if(academic_obj.getisRegistered() == true){
                            JOptionPane.showMessageDialog(frame, "The course has been registered already", "Duplication Found", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            academic_obj.register(getCourseLeader(), getLecturer(), getStartDate(), getCompletionDate());
                            JOptionPane.showMessageDialog(frame, "The course has been registered successfully with the following details: \n Course ID:" 
                            + getRegisterId() + "\n Course Leader: " + getCourseLeader() + "\n Lecturer: " + getLecturer() + "\n StartDate: " 
                            + getStartDate() + "\n Completion Date: " + getCompletionDate(), "ALERT", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                if(!courseFound || courseList.size() == 0)
                {
                    JOptionPane.showMessageDialog(frame, "The course has not been added yet", "WARNING", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        /* Actions to be performed when displayAcademicButton is clicked.
         * The courseList is searched for the details of all the academic courses.
         * The display method is called from the AcademicCourse class to print the details.
         */
        else if(e.getSource() == displayAcademicButton){
            boolean courseFound = false;
            for (Course course : courseList)
            {
                if(course instanceof AcademicCourse)
                {
                    AcademicCourse academic_obj = (AcademicCourse) course;
                    academic_obj.display();
                    courseFound = true;
                }
            }
            if(!courseFound || courseList.size() == 0)
            {
                JOptionPane.showMessageDialog(frame, "Academic Course has not been added yet.", "WARNING", JOptionPane.ERROR_MESSAGE);                
            }
        }
        
        /* Actions to be performed when addNonAcademicButton is clicked.
         * Checks if all the fields have been filled.
         * An object of NonAcademicCourse class is created.
         * The course is added to the ArrayList: courseList.
         */
        else if(e.getSource() == addNonAcademicButton){
            boolean courseFound = false;
            for(Course course : courseList)
            {
                if (course.getcourseID().equals(getCourseId()) && course instanceof NonAcademicCourse)
                {
                    JOptionPane.showMessageDialog(frame, "The course has been added already.", "Duplication Found", JOptionPane.ERROR_MESSAGE);   
                    courseFound = true;
                }
            }
            if (!courseFound || courseList.size() == 0)
            {
                try
                {
                    if(getCourseId().isEmpty() || getCourseName().isEmpty() || getPrerequisite().isEmpty()){
                        JOptionPane.showMessageDialog(frame, "Please fill all the fields.", "WARNING", JOptionPane.ERROR_MESSAGE);
                    }
                    else 
                    {
                        nonAcademicObject = new NonAcademicCourse(getCourseId(), getCourseName(), getDuration(), getPrerequisite());
                        courseList.add(nonAcademicObject);
                        JOptionPane.showMessageDialog(frame, "Non Academic Course has been added successfully with the following details: \n Course ID: " 
                        + getCourseId() +"\n Course Name: " + getCourseName() + "\n Duration: " + getDuration() + "\n Prerequisite: " 
                        + getPrerequisite(), "ALERT", JOptionPane.WARNING_MESSAGE);
                    }
                }
                catch(NumberFormatException ae)
                {
                    JOptionPane.showMessageDialog(frame, "Please enter a numerical value in duration", "WARNING", JOptionPane.ERROR_MESSAGE);
                }
                catch(NullPointerException ex)
                {
                    JOptionPane.showMessageDialog(frame, "Please fill all the fields.", "WARNING", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        /* Actions to be performed when registerNonAcademicButton is clicked.
         * Checks if the entered course ID is present in the ArrayList.
         * If found, it checks if the course has been registered.
         * If the course has not been registered, the register method from the NonAcademicCourse class will be called.
         */
        else if(e.getSource() == registerNonAcademicButton){
            boolean courseFound = false;
            if(getRegisterId().isEmpty() || getCourseLeader().isEmpty() || getInstructor().isEmpty())
            {
                JOptionPane.showMessageDialog(frame, "Please fill all the fields", "WARNING", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                for(Course course : courseList)
                {
                    if (course.getcourseID().equals(getRegisterId()) && course instanceof NonAcademicCourse){
                        NonAcademicCourse nonAcademic_obj = (NonAcademicCourse) course;
                        courseFound = true;
                        if(nonAcademic_obj.getisRegistered() == true){
                            JOptionPane.showMessageDialog(frame, "The course has been registered already.", "Duplication Found", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            nonAcademic_obj.register(getCourseLeader(), getInstructor(), getStartDate(),getCompletionDate(),getExamDate());
                            JOptionPane.showMessageDialog(frame, "The course has been registered successfully with the following details: \n Course ID:" 
                            + getRegisterId() + "\n Course Leader: " + getCourseLeader() + "\n Lecturer: " + getInstructor() + "\n StartDate: " 
                            + getStartDate() + "\n Completion Date: " + getCompletionDate() + "\n Exam Date: " + getExamDate(), 
                            "ALERT", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                    }
                }
                if (!courseFound || courseList.size() == 0)
                {
                    JOptionPane.showMessageDialog(frame, "The course has not been added yet", "WARNING", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
        
        /* Actions to be performed when displayNonAcademicButton is clicked.
         * The courseList if searched for the details of all the non academic courses.
         * The display method is called from the NonAcademicCourse class to print the details.
         */
        else if(e.getSource() == displayNonAcademicButton)
        {
            boolean courseFound = false;
            for (Course course: courseList)
            {
                if(course instanceof NonAcademicCourse)
                {
                    NonAcademicCourse nonAcademic_obj = (NonAcademicCourse) course;
                    nonAcademic_obj.display();
                    courseFound = true;
                }
            }
            if(!courseFound || courseList.size() == 0)
            {
                JOptionPane.showMessageDialog(frame, "Non Academic Course has not been added yet.", "WARNING", JOptionPane.ERROR_MESSAGE);                
            }
        }
        
        /* Actions to be performed when removeButton is clicked.
         * Checks if the entered course ID is present in the arraylist.
         * If found, the remove method from NonAcademicCourse class is called.
         */
        else if(e.getSource() == removeButton)
        {
            if (getCourseId().isEmpty())
            {
                JOptionPane.showMessageDialog(frame, "Please enter the Course ID", "WARNING", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                boolean courseFound = false;
                for(Course course : courseList)
                {
                    if(course.getcourseID().equals(getCourseId()) && course instanceof NonAcademicCourse)
                    {
                        courseFound = true;
                        NonAcademicCourse nonAcademic_obj = (NonAcademicCourse) course;
                        if (nonAcademic_obj.getisRemoved() == true)
                        {
                            JOptionPane.showMessageDialog(frame, "The course has been removed already.", "Duplication Found", 
                            JOptionPane.ERROR_MESSAGE);
                        }
                        else
                        {
                            nonAcademic_obj.remove();
                            JOptionPane.showMessageDialog(frame, "The course with the course ID " + getCourseId() + " has been removed successfully."
                            , "ALERT", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        
                    }
                }
                if(!courseFound || courseList.size() == 0)
                {
                    JOptionPane.showMessageDialog(frame, "The course has not been added yet", "WARNING", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        /* Actions to be performed when clearButton is clicked
         * The text of all the JTextFields are set to and empty string("") to clear all the fields
         */
        else if(e.getSource() == clearButton){
            courseIdField.setText("");
            courseNameField.setText("");
            durationField.setText("");
            levelField.setText("");
            creditField.setText("");
            assessmentField.setText("");
            prerequisiteField.setText("");
            idRegisterField.setText("");
            leaderField.setText("");
            lecturerField.setText("");
            instructorField.setText("");
        }
    }
    
    /* Main method of the program
     * Calls the courseGui() method.
     */
    public static void main(String[] args){
        ing = new INGCollege();
        ing.courseGui();
    }
}
