package pl.czystybeton.genetic.selection;

import pl.czystybeton.genetic.Individual;
import pl.czystybeton.genetic.Population;
import pl.czystybeton.genetic.util.RouletteWheel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RouletteWheelSelection implements ISelection {

    public Individual select(Population population) {
        return select(population, 1).get(0);
    }

    public List<Individual> select(Population population, int count) {
        double min = population.stream().min(Comparator.comparingDouble(Individual::getFitness))
                .orElse(null).getFitness();

        List<Individual> individuals = new ArrayList<>();

        List<Double> weights = population
                .stream()
                .map(individual -> individual.getFitness() - min)
                .collect(Collectors.toList());

        Function<Void, Integer> spin = RouletteWheel.getSpinner(weights);

        for (int i = 0; i < count; i++) {
            individuals.add(
                    population.get(spin.apply(null))
            );
        }

        return individuals;
    }

}
