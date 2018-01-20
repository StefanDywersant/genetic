package pl.czystybeton.genetic.crossover;

import pl.czystybeton.genetic.Genotype;

import java.util.Arrays;
import java.util.List;

public class HalfsCrossover implements ICrossover {

    public List<Genotype> offspring(Genotype genotype1, Genotype genotype2) {
        int genotype1s = (int)Math.floor(genotype1.size() / 2);
        int genotype2s = (int)Math.ceil(genotype2.size() / 2);

        Genotype genotype1r = new Genotype();
        if (genotype2.size() > 0) {
            genotype1r.addAll(genotype1.subList(0, genotype1s));
            genotype1r.addAll(genotype2.subList(genotype2s, genotype2.size() - 1));
        } else {
            genotype1r.addAll(genotype1);
        }

        Genotype genotype2r = new Genotype();
        if (genotype1.size() > 0) {
            genotype2r.addAll(genotype1.subList(genotype1s, genotype1.size() - 1));
            genotype2r.addAll(genotype2.subList(0, genotype2s));
        } else {
            genotype2r.addAll(genotype2);
        }

        return Arrays.asList(genotype1r, genotype2r);
    }

}
