package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ThreadedPersonDataBaseSynchronized implements PersonDatabase {

    private final Map<Integer, Person> idToPerson = new HashMap<>();
    private final Map<String, List<Person>> phoneNumberToPerson = new HashMap<>();
    private final Map<String, List<Person>> nameToPerson = new HashMap<>();
    private final Map<String, List<Person>> addressToPerson = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        synchronized (idToPerson) {
            if (!idToPerson.containsKey(person.id())) {

                //add phone number
                if (phoneNumberToPerson.containsKey(person.phoneNumber())) {
                    phoneNumberToPerson.get(person.phoneNumber()).add(person);
                } else {
                    phoneNumberToPerson.put(person.phoneNumber(), new ArrayList<>(List.of(person)));
                }

                // add name
                if (nameToPerson.containsKey(person.name())) {
                    nameToPerson.get(person.name()).add(person);
                } else {
                    nameToPerson.put(person.name(), new ArrayList<>(List.of(person)));
                }

                // add address
                if (addressToPerson.containsKey(person.address())) {
                    addressToPerson.get(person.address()).add(person);
                } else {
                    addressToPerson.put(person.address(), new ArrayList<>(List.of(person)));
                }

                // add id - person
                idToPerson.put(person.id(), person);
            }
        }
    }

    @Override
    public void delete(int id) {
        //var newId = new AtomicInteger(id);
        synchronized (idToPerson) {
            Person person = idToPerson.get(id);
            if (person != null) {
                // delete phone number
                phoneNumberToPerson.get(person.phoneNumber()).removeIf(v -> v.id() == id);

                // delete name
                nameToPerson.get(person.name()).removeIf(v -> v.id() == id);

                // delete address
                addressToPerson.get(person.address()).removeIf(v -> v.id() == id);

                // delete id and it's value (person)
                idToPerson.remove(id);
            }
        }
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        synchronized (nameToPerson) {
            return nameToPerson.get(name);
        }
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        synchronized (addressToPerson) {
            return addressToPerson.get(address);
        }
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        synchronized (phoneNumberToPerson) {
            return phoneNumberToPerson.get(phone);
        }
    }

}

