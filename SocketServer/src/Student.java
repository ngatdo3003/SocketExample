import java.util.Objects;

public class Student
{
    private String mssv;
    private String name;
    private String classID;
    private String phone;
    private String email;
    private String address;

    public Student(String mssv, String name, String classID, String phone, String email, String address)
    {
        this.mssv = mssv;
        this.name = name;
        this.classID = classID;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Student(String mssv)
    {
        this.mssv = mssv;
    }

    public String getMssv()
    {
        return mssv;
    }

    public void setMssv(String mssv)
    {
        this.mssv = mssv;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getClassID()
    {
        return classID;
    }

    public void setClassID(String classID)
    {
        this.classID = classID;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getMssv(), student.getMssv());
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "mssv='" + mssv + '\'' +
                ", name='" + name + '\'' +
                ", classID='" + classID + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
