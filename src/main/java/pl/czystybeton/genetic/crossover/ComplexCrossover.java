package pl.czystybeton.genetic.crossover;

import pl.czystybeton.genetic.Genotype;
import pl.czystybeton.genetic.util.RouletteWheel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComplexCrossover implements ICrossover {

    private List<ICrossover> crossoverItems;

    private Function<Void, Integer> spin;

    public ComplexCrossover(ArrayList<ICrossover> crossoverItems) {
        this.crossoverItems = crossoverItems;
        this.spin = RouletteWheel.getSpinner(crossoverItems
                .stream()
                .map(crossoverItem -> crossoverItem instanceof WeightedCrossover
                            ? ((WeightedCrossover) crossoverItem).getWeight()
                            : 1.0)
                .collect(Collectors.toList()));
    }

    public List<Genotype> offspring(Genotype genotype1, Genotype genotype2) {
        return crossoverItems
                .get(spin.apply(null))
                .offspring(genotype1, genotype2);
    }

}
