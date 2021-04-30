package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


public class EmployeeRepository {

    private final List<Worker> employees;

    public EmployeeRepository(List<Worker> employees) {
        this.employees = employees;
    }

    /**
     * Найти всех сотрудников с заданной фамилией
     */
    public List<Worker> getByLastName(String lastName) {
        LinkedList<Worker> result = new LinkedList<>();
        for (var w:employees){
            if (w.getFirstname().equals(lastName)){
                result.add(w);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников старше заданного возраста
     */
    public List<Worker> getOlderThan(int age) {
        LinkedList<Worker> result = new LinkedList<>();
        for (var w:employees){
            if (w.getAge() > age){
                result.add(w);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников заданного пола.
     * Вместо Object используйте ваш класс для пола
     */
    public List<Worker> getByGender(Worker.Gender gender) {
        LinkedList<Worker> result = new LinkedList<>();
        for (var w:employees){
            if (w.getGender() == gender){
                result.add(w);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников с указанными должностями
     */
    public List<Worker> getByStates(String... states) {
        List<Worker> result = new LinkedList<>();
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < employees.size(); j++) {
                if (states[i].equals(employees.get(j).getPost())) {
                    result.add(employees.get(j));
                }
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников с зарплатой меньше заднной в рублях
     */
    public List<Worker> getBySalaryLessThan(int salaryInRubbles) {
        LinkedList<Worker> result = new LinkedList<>();
        for (var w:employees){
            BigDecimal salary = w.getSalary();
            int salary1 = salary.intValue();
            if(salary1 < salaryInRubbles){
                result.add(w);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников, обладающих заданным навыком
     */
    public List<Worker> getBySkill(String skill) {
        LinkedList<Worker> result = new LinkedList<>();
        for (var w: employees){
            if (w.getSkills().contains(skill)){
                result.add(w);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников, работающих в компании больше заданного числа лет
     */
     public List<Worker> getWorkMoreThan(int years) {
        List<Worker> result = new LinkedList<>();
        for (var current : employees) {
            if (LocalDate.now().compareTo(current.getDateOfStart()) > years) {
                result.add(current);
            }
        }
        return result;
     }

    /**
     * Найти всех сотрудников, у которых День рождения в указанную дату
     */
    public List<Worker> getBirthDayMates(LocalDate date) {
        LinkedList<Worker> result = new LinkedList<>();
        for (var w:employees){
            LocalDate current = w.getBirthday();
            if (current.getYear() == date.getYear() && current.getMonthValue() == date.getMonthValue() && current.getDayOfMonth() == date.getDayOfMonth()){
                result.add(w);
            }
        }
        return result;
    }

    /**
     * Получить сколько всего сотрудников работает в компании
     */
    public int amount() {
        int i = 0;
        for (var w:employees) {
            i++;
        }
        return i;
    }

    /**
     * Получить сколько всего денег тратит компания на зарплаты в год.
     * Вместо Object используйте подходящий тип данных
     */
    public BigDecimal totalSalary() {
        List<BigDecimal> result = new LinkedList<>();
        for (int i = 0; i < employees.size(); i++) {
            result.add(employees.get(i).getSalary());
        }
        return result.stream().reduce(BigDecimal.ZERO, BigDecimal::add).multiply(new BigDecimal(12));
    }

    /**
     * Получить отображение идентификатора работника на сущность работника для удобства дальнейшего поиска по id
     */
    public Map<Integer, Worker> mapIdToEmployee() {
        Map<Integer, Worker> result = new HashMap<Integer, Worker>();
        for (var current : employees) {
            result.put(current.getId(), current);
        }
        return result;
    }
}
