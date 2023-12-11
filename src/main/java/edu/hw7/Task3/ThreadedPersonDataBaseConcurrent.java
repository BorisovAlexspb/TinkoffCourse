package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadedPersonDataBaseConcurrent implements PersonDatabase {

    private final Map<Integer, Person> idToPerson = new HashMap<>();
    private final Map<String, List<Person>> phoneNumberToPerson = new HashMap<>();
    private final Map<String, List<Person>> nameToPerson = new HashMap<>();
    private final Map<String, List<Person>> addressToPerson = new HashMap<>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
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
        } finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
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
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            return nameToPerson.get(name);
        } finally {
            lock.readLock().unlock();
        }

    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            return addressToPerson.get(address);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return phoneNumberToPerson.get(phone);
        } finally {
            lock.readLock().unlock();
        }
    }
}
