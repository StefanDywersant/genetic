package pl.czystybeton.genetic.fitness;

import pl.czystybeton.genetic.Genotype;
import pl.czystybeton.genetic.Individual;

public class GenotypeLengthEvaluator implements IFitnessEvaluator {

    public Individual evaluate(Genotype genotype) {
        return new Individual(
                genotype,
                -0.5 * genotype.size()
        );
    }

}
