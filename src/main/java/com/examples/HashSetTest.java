package com.examples;

import java.util.HashSet;
import java.util.Set;

class Employee{
    private String ename;
    private String sal;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(ename, employee.ename)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(ename)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ename='" + ename + '\'' +
                ", sal='" + sal + '\'' +
                '}';
    }
}
public class HashSetTest {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setEname("venky");
        e1.setSal("100");
        Employee e2 = new Employee();
        e2.setEname("venky");
        e2.setSal("100");
        Set<Employee> set = new HashSet();
        set.add(e1);
        set.add(e2);
        System.out.println(set);
    }
}
