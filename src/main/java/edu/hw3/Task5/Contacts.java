package edu.hw3.Task5;

import org.jetbrains.annotations.NotNull;

public class Contacts implements Comparable<Contacts> {
    private String firstName;
    private String lastName;

    Contacts(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public int compareTo(@NotNull Contacts o) {
        return this.getLastName().compareTo(o.lastName);
    }

    @Override
    public String toString() {
        return "{"
            + "firstname='" + firstName + '\''
            + ", lastname=" + lastName
            + '}';
    }
}
