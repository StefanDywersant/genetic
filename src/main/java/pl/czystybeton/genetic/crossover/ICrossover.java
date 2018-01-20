package pl.czystybeton.genetic.crossover;

import pl.czystybeton.genetic.Genotype;

import java.util.List;

public interface ICrossover {

    List<Genotype> offspring(Genotype genotype1, Genotype genotype2);

}
