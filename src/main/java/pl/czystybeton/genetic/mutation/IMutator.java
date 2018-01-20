package pl.czystybeton.genetic.mutation;

import pl.czystybeton.genetic.Genotype;

public interface IMutator {

    Genotype mutate(Genotype genotype);

}
