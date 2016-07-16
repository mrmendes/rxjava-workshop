package org.opensanca.rxworkshop.basics.icmc;

/**
 * Created by ubiratansoares for RxJava Workshop.
 */

public class Teacher {

    String name;
    ICMCDepartment department;
    TeacherStatus status;

    public Teacher(String name, ICMCDepartment department, TeacherStatus status) {
        this.name = name;
        this.department = department;
        this.status = status;
    }

    public static Teacher of(String name, ICMCDepartment department, TeacherStatus status) {
        return new Teacher(name, department, status);
    }

    public String getName() {
        return name;
    }

    public ICMCDepartment getDepartment() {
        return department;
    }

    public TeacherStatus getStatus() {
        return status;
    }

    @Override public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
