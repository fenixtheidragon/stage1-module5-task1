package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> x.stream().filter(a -> a.matches("[A-Z].*")).count() == x.size();
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) {
                ArrayList<Integer> arrayList = integers.stream().filter(a -> a % 2 == 0).collect(Collectors.toCollection(ArrayList::new));
                integers.addAll(arrayList);
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return new Supplier<List<String>>() {
            @Override
            public List<String> get() {
                return values.stream().filter(a->a.matches("[A-Z](\\s?)(.*\\s){3,}.*\\.")).collect(Collectors.toList());
            }
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return new Function<List<String>, Map<String, Integer>>() {
            @Override
            public Map<String, Integer> apply(List<String> strings) {
                HashMap<String,Integer> hashMap = new HashMap<>();
                strings.stream().forEach(a->hashMap.put(a, a.length()));
                return hashMap;
            }
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
            @Override
            public List<Integer> apply(List<Integer> integers, List<Integer> integers2) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.addAll(integers);
                arrayList.addAll(integers2);
                return arrayList;
            }
        };
    }
}
