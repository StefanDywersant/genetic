package pl.czystybeton.genetic.crossover;

import pl.czystybeton.genetic.Genotype;

import java.util.Collections;
import java.util.List;

public class AddCrossover implements ICrossover {

    public List<Genotype> offspring(Genotype genotype1, Genotype genotype2) {
        Genotype genotype = new Genotype();

        genotype.addAll(genotype1.clone());
        genotype.addAll(genotype2.clone());

        return Collections.singletonList(genotype);
    }

}
