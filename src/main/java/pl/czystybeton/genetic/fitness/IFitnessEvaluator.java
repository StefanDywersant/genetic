package pl.czystybeton.genetic.fitness;

import pl.czystybeton.genetic.Genotype;
import pl.czystybeton.genetic.Individual;

public interface IFitnessEvaluator {

    Individual evaluate(Genotype genotype);

}
