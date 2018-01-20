package pl.czystybeton.genetic.fitness;

import pl.czystybeton.genetic.Genotype;
import pl.czystybeton.genetic.Individual;

import java.util.List;

public class ComplexEvaluator implements IFitnessEvaluator {

    private List<IFitnessEvaluator> fitnessEvaluators;

    public ComplexEvaluator(List<IFitnessEvaluator> fitnessEvaluators) {
        this.fitnessEvaluators = fitnessEvaluators;
    }

    public Individual evaluate(Genotype genotype) {
        double fitness = fitnessEvaluators
                .stream()
                .mapToDouble(fe -> fe.evaluate(genotype).getFitness())
                .sum();

        return new Individual(genotype, fitness);
    }

}
