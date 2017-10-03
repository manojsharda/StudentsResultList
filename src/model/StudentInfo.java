package model;

/**
 * StudentInfo class hold student id, first name and GPA record
 */
public class StudentInfo {
    private int id;
    private String firstName;
    private float gpa;

    public StudentInfo (int id, String firstName, float gpa){
        this.id = id;
        this.firstName = firstName;
        this.gpa = gpa;
    }
    public int getID()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public float getGpa()
    {
        return gpa;
    }

}

