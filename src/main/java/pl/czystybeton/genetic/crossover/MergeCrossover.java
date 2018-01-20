package pl.czystybeton.genetic.crossover;

import pl.czystybeton.genetic.Genotype;

import java.util.Arrays;
import java.util.List;

public class MergeCrossover implements ICrossover {

    public List<Genotype> offspring(Genotype genotype1, Genotype genotype2) {
        Genotype g1r = new Genotype();
        Genotype g2r = new Genotype();

        for (int i = 0; i < Math.min(genotype1.size(), genotype2.size()); i++) {
            g1r.add(i % 2 == 1 ? genotype1.get(i) : genotype2.get(i));
            g2r.add(i % 2 == 1 ? genotype2.get(i) : genotype1.get(i));
        }

        return Arrays.asList(g1r, g2r);
    }

}
