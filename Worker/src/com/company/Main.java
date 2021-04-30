package com.company;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LocalDate l1 = LocalDate.of (2008 , 5 , 10);
        LocalDate l11= LocalDate.of (2021 , 4 , 20);

        LocalDate l2 = LocalDate.of (2003 , 5 , 10);
        LocalDate l22= LocalDate.of (2021 , 4 , 20);

        LocalDate l3 = LocalDate.of (1991 , 5 , 10);
        LocalDate l33= LocalDate.of (2021 , 4 , 20);

        BigDecimal salary1 = new BigDecimal("9134.41");
        BigDecimal salary2 = new BigDecimal("12034.41");
        BigDecimal salary3 = new BigDecimal("227034.41");

        HashSet<String> skills1 =new HashSet<>();
        skills1.add("Full Master");
        skills1.add("Penis");

        HashSet<String> skills2 =new HashSet<>();
        skills2.add("Fighter");
        skills2.add("Dirty");

        HashSet<String> skills3 =new HashSet<>();
        skills3.add("Sniper");
        skills3.add("Alcoholic");

        Worker w1 = new Worker("Zdenko", "Mihail", "Petrovich",l1,l11,
                Worker.Gender.UNDEFINED,"Mafiosi",skills1,salary1);
        Worker w2 = new Worker("Trad", "Nikita", "Mikolov",l2,l22,
                Worker.Gender.MALE,"Strong",skills2,salary2);
        Worker w3 = new Worker("Trad", "Garish", "Andreevich",l3,l33,
                Worker.Gender.MALE,"Vodka",skills3,salary3);
        int age1 = w1.getAge();
        int age2 = w2.getAge();
        int age3 = w3.getAge();
        LinkedList <Worker> workers =new LinkedList<>(){};
        workers.add(w1);
        workers.add(w2);
        workers.add(w3);

//      System.out.println(w1);
//      System.out.println("Age:"+age1);
//      System.out.println(w2);
//      System.out.println("Age:"+age2);
//      System.out.println(w3);
//      System.out.println("Age:"+age3);

        //передача списка работников в EmployeeRepository
        EmployeeRepository workers1 = new EmployeeRepository(workers);

//      System.out.println(workers1.getOlderThan(16));
//      System.out.println(workers1.getBySalaryLessThan(12035));
//      System.out.println(workers1.getByGender(Worker.Gender.UNDEFINED));
//      System.out.println(workers1.getBirthDayMates(LocalDate.of(2008 , 5 , 10)));
//      System.out.println("Всего работников: "+workers1.amount());
//        System.out.println(workers1.totalSalary());
        System.out.println(workers1.getBySkill("Fighter"));
    }
}

