package entropy;

import java.util.List;

import static java.lang.Math.log;

public class EntropyCal {
    public double calculateEntropyOf(List<Integer> numbers) {
        double totalProbability = 0;

        for (int i = 0; i < numbers.size(); ) {
            double count = 1;
            while (i < numbers.size() - 1 && numbers.get(i).equals(numbers.get(i + 1))) {
                i++;
                count++;
            }
            i++;
            totalProbability += -(count / numbers.size()) * log(count / numbers.size()) / log(2);
        }

        return totalProbability;
    }
}
