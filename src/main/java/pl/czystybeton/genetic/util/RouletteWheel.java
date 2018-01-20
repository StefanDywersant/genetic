package pl.czystybeton.genetic.util;

import java.util.List;
import java.util.function.Function;

public class RouletteWheel {

    public static Function<Void, Integer> getSpinner(List<Double> weights) {
        double sum = weights
                .stream()
                .mapToDouble(a -> a)
                .sum();

        return (x) -> {
            double value = MathTool.random(sum);

            for (int i = 0; i < weights.size(); i++) {
                value -= weights.get(i);

                if (value < 0) {
                    return i;
                }
            }

            return weights.size() - 1;
        };
    }

}
