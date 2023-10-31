package edu.hw3.Task5;

import java.util.Comparator;

public class FullNameComparator implements Comparator<Contacts> {
    private int sortOrder;  // 1(ACS) or -1(DESC)

    FullNameComparator(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Contacts o1, Contacts o2) {
        if (o1.getLastName().isEmpty() || o2.getLastName().isEmpty()) {
            return o1.getFirstName().compareTo(o2.getFirstName()) * sortOrder;
        }
        return o1.getLastName().compareTo(o2.getLastName()) * sortOrder;

    }
}
