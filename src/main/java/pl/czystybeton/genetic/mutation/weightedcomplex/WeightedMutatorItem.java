package pl.czystybeton.genetic.mutation.weightedcomplex;

import pl.czystybeton.genetic.mutation.IMutator;

public class WeightedMutatorItem {

    private IMutator mutator;

    private int weight;

    public WeightedMutatorItem(IMutator mutator, int weight) {
        this.mutator = mutator;
        this.weight = weight;
    }

    IMutator getMutator() {
        return mutator;
    }

    int getWeight() {
        return weight;
    }

}
