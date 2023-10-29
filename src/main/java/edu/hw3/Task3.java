package edu.hw3;

import java.util.HashMap;

public class Task3 {

    public <T> HashMap<T, Integer> freqDict(T[] inputList) {
        if (inputList == null) {
            throw new NullPointerException("Null argument");
        }
        HashMap<T, Integer> answer = new HashMap<>();
        for (int i = 0; i < inputList.length; i++) {
            if (answer.containsKey(inputList[i])) {
                answer.put(inputList[i], answer.get(inputList[i]) + 1);
            } else {
                answer.put(inputList[i], 1);
            }
        }
        return answer;
    }
}
