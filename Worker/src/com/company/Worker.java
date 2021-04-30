package com.company;
import java.lang.Object;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.math.BigDecimal;

public class Worker {
    //уникальный модификатор доступа
    private int Id;
    private static int GlobalID;
    //поле фамилиии
    private final String Firstname;
    Gender gender;
    //поле имени
    private final String Name;
    //поле отчества
    private final String FatherName;
    //дата рождения
    private final LocalDate birthday;
    //дата поступления на работу
    private final LocalDate dateOfStart;
    private int age;
    private String post;
    //поле способностей рабочего
    private Set <String> skills;
    //поле зарплаты
    private BigDecimal salary;
    //уволен не уволен
    private boolean fired;

    public Worker (String FirstName,String Name,
                  String FatherName,LocalDate birthday,
                  LocalDate dateOfStart,Gender gender,String post,
                  Set <String> skills, BigDecimal salary) {
        this.Id = this.GlobalID;
        this.GlobalID++;
        this.Firstname = FirstName;
        this.Name = Name;
        this.gender = gender;
        this.FatherName = FatherName;
        this.birthday = birthday;
        this.dateOfStart = dateOfStart;
        this.age = calculateAge(birthday);
        this.gender = gender;
        this.skills = skills;
        this.post = post;
        this.salary = salary;


    }

    public enum Gender{
        MALE,
        FEMALE,
        UNDEFINED
    }

    @Override
    public boolean equals (Object others){
        return false;
    }


    @Override
    public int hashCode(){
        return 0;
    }

    public int calculateAge(LocalDate birthday){
        LocalDate now =LocalDate.now();
        if(now.getMonthValue()<birthday.getMonthValue() ||(now.getMonthValue()<birthday.getMonthValue() || now.getDayOfMonth()<birthday.getDayOfMonth())){
            return now.compareTo(birthday)-1;
        }
        else {
            return now.compareTo(birthday);
        }
    }

    @Override
    public String toString(){
        String result = "ID: "+Id+"\nName: "+Firstname+" " +Name+" "+FatherName+"\nSex: "+gender+"\nPost: "+post+"\nSkills: ";
        if (skills != null){
            int i = 1;
            result += "\n";
            for (String skills : skills){
                result += " "+i+"."+skills+"\n";
                i++;
            }
        }
        else{
            result += "nothing\n";
        }
        result += "\nBirthday: "+birthday+"\nDate of Start: "+dateOfStart+"\n";
        return result;
    }

    public void setSalary(BigDecimal salary) {this.salary = salary;}

    public BigDecimal getSalary() {return salary;}
    public String getFirstname () {return this.Firstname; }
    public Gender getGender() { return gender; }
    public int  getAge(){ return age; }
    public Set<String> getSkills(){ return skills; }
    public String getFirstName(){ return Firstname; }
    public int getGlobalID(){return GlobalID;}
    public LocalDate getBirthday(){return birthday;}
    public String getPost(){return post;}
    public LocalDate getDateOfStart(){ return  dateOfStart;}
    public int getId(){return Id;}

    public void addSkill (String skill){ skills.add(skill);}
    public void removeSkill (String skill){skills.remove(skill);}
}
