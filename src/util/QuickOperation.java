package util;

import java.util.ArrayList;

public class QuickOperation {

    public static double calculateMean(ArrayList<Long> numbers){

        return numbers.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0);

    }

}
