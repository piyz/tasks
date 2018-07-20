package by.matrosov.tasks.vigenerecipher;

import java.util.Optional;
import java.util.stream.Stream;

public class Task {
    public static void main(String[] args) {
        int[] arr2 = {3, 2, 5, 1, 0, 4};
        int[] arr1 = {40, 20, 5, 26, 25, 28};

        Optional<String> sequence = Stream.iterate(0, i -> arr2[i])
                .map(res -> arr1[res])
                .skip(1)
                .limit(arr2.length)
                .map(Object::toString)
                .reduce((a, b) -> a + ", " + b);

        if (sequence.isPresent()){
            sequence.map(s -> new StringBuilder(s).reverse().toString());
        }

        System.out.println(String.format("%s-%s-%s-%s-%s-%s", sequence.get().split(",")));
    }
}