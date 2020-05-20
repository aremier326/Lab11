package com.task.employee;

import com.task.manager.Manager;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {

    /**
     * Contains ID of the employee.
     */
    private int ID;

    /**
     * Contains name of the employee.
     */
    private String name;

    /**
     * Contains surname of the employee.
     */
    private String surname;

    /**
     * Contains salary of the employee.
     */
    private double salary;

    /**
     * Contains manager of the employee.
     */
    private Manager manager;

    /**
     * Default constructor.
     */
    public Employee() {
        setSalary(1000);
    }

    /**
     * Custom constructor.
     *
     * @param ID      ID.
     * @param name    name.
     * @param surname surname.
     */
    public Employee(int ID, String name, String surname) {
        this();
        setID(ID);
        setName(name);
        setSurname(surname);
    }

    /**
     * Custom constructor.
     *
     * @param ID      ID.
     * @param name    name.
     * @param surname surname.
     * @param salary  salary.
     */
    public Employee(int ID, String name, String surname, double salary) {
        this(ID, name, surname);
        setSalary(salary);
    }

    /**
     * Custom constructor.
     *
     * @param ID      ID.
     * @param name    name.
     * @param surname surname.
     * @param salary  salary.
     * @param manager manager.
     */
    public Employee(int ID, String name, String surname, double salary, Manager manager) {
        this(ID, name, surname, salary);
        setManager(manager);
    }

    /**
     * ID getter.
     *
     * @return ID.
     */
    public final int getID() {
        return this.ID;
    }

    /**
     * Name getter.
     *
     * @return name.
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Surname getter.
     *
     * @return name.
     */
    public final String getSurname() {
        return this.surname;
    }

    /**
     * Salary getter.
     *
     * @return salary.
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * Manager getter.
     *
     * @return manager.
     */
    public final Manager getManager() {
        return this.manager;
    }

    /**
     * ID setter.
     *
     * @param ID
     */
    public final void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Name setter.
     *
     * @param name
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * surname setter.
     *
     * @param surname
     */
    public final void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * salary setter.
     *
     * @param salary
     */
    public void setSalary(double salary) throws IllegalArgumentException {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary can't be lower 0");
        } else {
            this.salary = salary;
        }
    }

    /**
     * Manager setter.
     *
     * @param manager
     */
    public final void setManager(Manager manager) {
        this.manager = manager;
    }

    /**
     * Method for raising of salary.
     *
     * @param p percents.
     */
    public final void raiseSalary(double p) throws IllegalArgumentException {
        if (p < 0) {
            throw new IllegalArgumentException("You can't raise salary!");
        } else {
            setSalary((getSalary() * p / 100) + getSalary());
        }
    }

    /**
     * Gets manager name.
     *
     * @return if manager is not null, returns string with
     * his name and surname.
     */
    public final String getManagerName() {
        if (getManager() != null) {
            return getManager().getName() + " " + getManager().getSurname();
        } else {
            return "Nomanager";
        }
    }

    /**
     * Method for getting top manager of current hierarchy.
     *
     * @return employee object.
     */
    public final Employee getTopManager() {
        if (getManager() != null) {
            return getManager().getTopManager();
        } else {
            return this;
        }
    }

    /**
     * toString overriding.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Employee ID: " + getID() + "\n" +
                "Name: " + getName() + "\n" +
                "Surname: " + getSurname() + "\n" +
                "Salary: " + getSalary() + "\n" +
                "Manager: " + getManagerName() + "\n";
    }
}
