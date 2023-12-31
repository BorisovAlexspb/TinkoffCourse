package edu.hw4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public final class Tasks {
    private Tasks() {
    }

    public static List<Animal> task1(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    public static List<Animal> task2(List<Animal> animals, int count) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(count)
            .toList();
    }

    public static Map<Animal.Type, Integer> task3(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(a -> 1)));
    }

    public static Animal.Type task4(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length())).get().type();
    }

    public static Animal.Sex task5(List<Animal> animals) {
        Map<Animal.Sex, Integer> animalsAmountBySex = animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.summingInt(a -> 1)));

        Set<Integer> animalsAmount = new HashSet<>(animalsAmountBySex.values());
        if (animalsAmount.isEmpty()) {
            throw new NoSuchElementException();
        }

        return animalsAmountBySex.entrySet().stream()
            .max(Map.Entry.comparingByValue()).orElseThrow().getKey();
    }

    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(Animal::type, animal -> animal,
                (animal1, animal2) -> animal1.weight() > animal2.weight() ? animal1 : animal2
            ));
    }

    public static Animal task7(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .toList().get(k - 1);
    }

    public static Optional<Animal> task8(List<Animal> animals, int k) {
        return animals.stream()
            .filter(a -> a.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Integer task9(List<Animal> animals) {
        return animals.stream()
            .map(Animal::paws)
            .reduce(Integer::sum)
            .orElse(0);
    }

    public static List<Animal> task10(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.paws() != a.age())
            .toList();
    }

    @SuppressWarnings("MagicNumber")
    public static List<Animal> task11(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.bites() && a.height() > 100)
            .toList();
    }

    public static Integer task12(List<Animal> animals) {
        return (int) animals.stream()
            .filter(a -> a.weight() > a.height())
            .count();
    }

    public static List<Animal> task13(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.name().split(" ").length > 2)
            .toList();
    }

    public static boolean task14(List<Animal> animals, int k) {
        return animals.stream()
            .noneMatch(a -> a.type() == Animal.Type.DOG && a.height() > k);
    }

    public static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(a -> a.weight() >= k && a.weight() <= l)
            .collect(
                Collectors.groupingBy(
                    Animal::type,
                    () -> new EnumMap<>(Animal.Type.class),
                    Collectors.summingInt(Animal::weight)
                )
            );
    }

    public static List<Animal> task16(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator
                .comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }

    public static Boolean task17(List<Animal> animals) {
        var bitesSpiders = animals.stream()
            .filter(a -> a.type() == Animal.Type.SPIDER && a.bites())
            .count();
        var spidersCount = animals.stream()
            .filter(a -> a.type() == Animal.Type.SPIDER)
            .count();
        var bitesDogs = animals.stream()
            .filter(a -> a.type() == Animal.Type.DOG && a.bites())
            .count();
        var dogsCount = animals.stream()
            .filter(a -> a.type() == Animal.Type.DOG)
            .count();
        return spidersCount != 0 && dogsCount != 0
            && (double) bitesSpiders / spidersCount > (double) bitesDogs / dogsCount;
    }

    @SafeVarargs
    public static Animal task18(List<Animal>... animals) {
        return Arrays.stream(animals)
            .flatMap(Collection::stream)
            .filter(animal -> animal.type().equals(Animal.Type.FISH))
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    public static Map<String, Set<ValidationError>> task19(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(Animal::name, a -> {
                Set<ValidationError> errors = new HashSet<>();
                Collections.addAll(
                    errors,
                    ValidationError.invalidName(a),
                    ValidationError.invalidAge(a),
                    ValidationError.invalidHeight(a),
                    ValidationError.invalidWeight(a)
                );
                return errors.stream().filter(Objects::nonNull).collect(Collectors.toSet());
            })).entrySet().stream().filter(s -> !s.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, String> task20(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(Animal::name, a -> {
                StringBuilder sb = new StringBuilder();
                if (ValidationError.invalidName(a) != null) {
                    sb.append("name, ");
                }
                if (ValidationError.invalidAge(a) != null) {
                    sb.append("age, ");
                }
                if (ValidationError.invalidHeight(a) != null) {
                    sb.append("height, ");
                }
                if (ValidationError.invalidWeight(a) != null) {
                    sb.append("weight, ");
                }
                if (!sb.isEmpty()) {
                    sb.delete(sb.length() - 2, sb.length());
                }
                return sb.toString();
            })).entrySet().stream().filter(s -> !s.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
