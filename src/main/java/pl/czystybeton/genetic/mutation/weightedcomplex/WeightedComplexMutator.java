package pl.czystybeton.genetic.mutation.weightedcomplex;

import pl.czystybeton.genetic.Genotype;
import pl.czystybeton.genetic.mutation.IDegreeMutator;
import pl.czystybeton.genetic.mutation.IMutator;
import pl.czystybeton.genetic.util.RouletteWheel;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WeightedComplexMutator implements IDegreeMutator {

    private List<WeightedMutatorItem> mutators;

    private Function<Void, Integer> spin;

    public WeightedComplexMutator(List<WeightedMutatorItem> mutators) {
        this.mutators = mutators;
        this.spin = RouletteWheel.getSpinner(mutators
                .stream()
                .map(weightedMutatorItem -> (double) weightedMutatorItem.getWeight())
                .collect(Collectors.toList()));
    }

    public Genotype mutate(Genotype genotype) {
        return mutate(genotype, 1.0);
    }

    public Genotype mutate(Genotype genotype, double degree) {
        if (mutators.size() == 0) {
            return genotype;
        }

        IMutator mutator = mutators
                .get(spin.apply(null))
                .getMutator();

        if (mutator instanceof IDegreeMutator) {
            return ((IDegreeMutator) mutator).mutate(genotype, degree);
        }

        return mutator.mutate(genotype);
    }

}
