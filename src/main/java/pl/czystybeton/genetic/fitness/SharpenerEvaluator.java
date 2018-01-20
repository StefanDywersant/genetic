package pl.czystybeton.genetic.fitness;

import pl.czystybeton.genetic.Genotype;
import pl.czystybeton.genetic.Individual;
import pl.czystybeton.genetic.mutation.IDegreeMutator;

public class SharpenerEvaluator implements IFitnessEvaluator {

    private int steps;

    private IFitnessEvaluator fitnessEvaluator;

    private IDegreeMutator mutator;

    private double degree;

    public SharpenerEvaluator(int steps, double degree, IFitnessEvaluator fitnessEvaluator, IDegreeMutator mutator) {
        this.steps = steps;
        this.fitnessEvaluator = fitnessEvaluator;
        this.mutator = mutator;
        this.degree = degree;
    }

    public Individual evaluate(Genotype genotype) {
        Individual best = fitnessEvaluator.evaluate(genotype);

        for (int i = 0; i < steps; i++) {
            Genotype gt = best.getGenotype().clone();

            mutator.mutate(gt, degree);

            Individual candidate = fitnessEvaluator.evaluate(gt);

            if (candidate.getFitness() > best.getFitness()) {
                best = candidate;
            }
        }

        return best;
    }

    public Individual sharpen(Individual individual) {
        return evaluate(individual.getGenotype());
    }

}
