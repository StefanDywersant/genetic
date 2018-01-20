package pl.czystybeton.genetic.recipe;

import pl.czystybeton.genetic.Genotype;
import pl.czystybeton.genetic.Individual;
import pl.czystybeton.genetic.Population;
import pl.czystybeton.genetic.crossover.ComplexCrossover;
import pl.czystybeton.genetic.fitness.IFitnessEvaluator;
import pl.czystybeton.genetic.selection.ISelection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SinglePopulationIngredient implements IIngredient {

    private int amount;

    private ISelection selection;

    private ComplexCrossover crossover;

    private IFitnessEvaluator fitnessEvaluator;

    public SinglePopulationIngredient(int amount, ISelection selection, ComplexCrossover crossover, IFitnessEvaluator fitnessEvaluator) {
        this.amount = amount;
        this.selection = selection;
        this.crossover = crossover;
        this.fitnessEvaluator = fitnessEvaluator;
    }

    public Population offspring(Population population, int count, List<Population> populations) {
        List<Individual> parents = selection.select(population, count);
        List<Genotype> genotypes = new ArrayList<>();

        int loops = count / 2 - ((count / 2) % 2);

        for (int i = 0; i < loops; i++) {
            genotypes.addAll(
                crossover.offspring(
                        parents.get(i * 2).getGenotype(),
                        parents.get(i * 2 + 1).getGenotype()
                )
            );
        }

        return genotypes
                .stream()
                .map(fitnessEvaluator::evaluate)
                .sorted((i1, i2) -> Double.compare(i2.getFitness(), i1.getFitness()))
                .collect(Collectors.toCollection(Population::new));
    }

    public int getAmount() {
        return amount;
    }

}
