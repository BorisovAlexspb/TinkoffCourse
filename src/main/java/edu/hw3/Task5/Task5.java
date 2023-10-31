package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task5 {

    public List<Contacts> parseContacts(String[] fullNames, String sortOrder) {
        if (fullNames == null) {
            return new ArrayList<Contacts>();
        }

        List<Contacts> listOfNames = new ArrayList<>();
        for (String c : fullNames) {
            String[] words = c.split(" ");
            if (words.length > 1) {
                listOfNames.add(new Contacts(words[0], words[1]));
            } else {
                listOfNames.add(new Contacts(words[0], ""));
            }
        }

        if (sortOrder.equals("ASC")) {
            Collections.sort(listOfNames, new FullNameComparator(1));
        } else {
            Collections.sort(listOfNames, new FullNameComparator(-1));
        }

        return listOfNames;
    }
}
