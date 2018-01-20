package pl.czystybeton.genetic.mutation;

import pl.czystybeton.genetic.Genotype;

public interface IDegreeMutator extends IMutator {

    Genotype mutate(Genotype genotype, double degree);

}
