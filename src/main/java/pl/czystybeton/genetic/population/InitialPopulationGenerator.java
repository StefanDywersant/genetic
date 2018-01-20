package pl.czystybeton.genetic.population;

import pl.czystybeton.genetic.Genotype;
import pl.czystybeton.genetic.Population;
import pl.czystybeton.genetic.fitness.IFitnessEvaluator;
import pl.czystybeton.genetic.mutation.IMutator;
import pl.czystybeton.genetic.util.MathTool;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InitialPopulationGenerator {

    private IFitnessEvaluator fitnessEvaluator;

    private IMutator mutator;

    public InitialPopulationGenerator(IFitnessEvaluator fitnessEvaluator, IMutator mutator) {
        this.fitnessEvaluator = fitnessEvaluator;
        this.mutator = mutator;
    }

    public Population generateOne(int size, int maxGenotypeLength) {
        Population population = new Population();

        for (int i = 0; i < size; i++) {
            Genotype genotype = new Genotype();
            int length = MathTool.random(maxGenotypeLength);

            for (int j = 0; j < length; j++) {
                mutator.mutate(genotype);
            }

            population.add(fitnessEvaluator.evaluate(genotype));
        }

        System.out.println(population);

        population.sort();

        return population;

    }

    public List<Population> generateMany(int populationCount, int populationSize, int maxGenotypeLength) {
        return IntStream
                .range(0, populationCount)
                .mapToObj(i -> generateOne(populationSize, maxGenotypeLength))
                .collect(Collectors.toList());

    }

}
