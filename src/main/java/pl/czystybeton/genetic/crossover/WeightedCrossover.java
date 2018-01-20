package pl.czystybeton.genetic.crossover;

import pl.czystybeton.genetic.Genotype;

import java.util.List;

public class WeightedCrossover implements ICrossover {

    private ICrossover crossover;

    private int weight;

    public WeightedCrossover(ICrossover crossover, int weight) {
        this.crossover = crossover;
        this.weight = weight;
    }

    public List<Genotype> offspring(Genotype genotype1, Genotype genotype2) {
        return crossover.offspring(genotype1, genotype2);
    }

    public int getWeight() {
        return weight;
    }

}
