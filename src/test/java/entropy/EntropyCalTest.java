package entropy;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EntropyCalTest {
    @Test
    public void shouldCalculateCorrectProbabilityFromAnArray() {
        List<Integer> numbers = Lists.newArrayList(1, 2, 1, 3, 4, 5, 1, 7, 8, 9, 6);
        Collections.sort(numbers);

        EntropyCal entropy = new EntropyCal();
        double probability = entropy.calculateEntropyOf(numbers);

        double finalProbability = roundToFinal(probability);

        assertThat(finalProbability, is(3.03));
    }

    private double roundToFinal(double probability) {
        BigDecimal bigDecimal = new BigDecimal(probability);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }
}
