package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.Collections;

public class Task5 {

    public ArrayList<Contacts> parseContacts(String[] fullNames, String sortOrder) {
        if (fullNames == null) {
            return new ArrayList<Contacts>();
        }

        ArrayList<Contacts> listOfNames = new ArrayList<>();
        for (String c : fullNames) {
            int valueOfSeparator = c.indexOf(" ");
            if (valueOfSeparator != -1) {
                listOfNames.add(new Contacts(c.substring(0, valueOfSeparator), c.substring(valueOfSeparator + 1)));
            } else {
                listOfNames.add(new Contacts(c, ""));
            }
        }

        if (sortOrder.equals("ASC")) {
            Collections.sort(listOfNames);
        } else {
            Collections.sort(listOfNames, Collections.reverseOrder());
        }

        return listOfNames;
    }
}
