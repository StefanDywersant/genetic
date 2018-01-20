package pl.czystybeton.genetic.mutation;

import pl.czystybeton.genetic.Genotype;
import pl.czystybeton.genetic.util.MathTool;

public class DeletionMutator implements IMutator {

    public Genotype mutate(Genotype genotype) {
        if (genotype.size() == 0) {
            return genotype;
        }

        genotype.remove(MathTool.random(genotype.size()));

        return genotype;
    }

}
