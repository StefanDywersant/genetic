package pl.czystybeton.genetic;

import pl.czystybeton.genetic.gene.IGene;
import pl.czystybeton.genetic.gene.IOffsetGene;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Genotype extends ArrayList<IGene> {

    public static int compare(IGene g1, IGene g2) {
        if (g1 instanceof IOffsetGene && g2 instanceof IOffsetGene) {
            return Integer.compare(((IOffsetGene) g1).getOffset(), ((IOffsetGene) g2).getOffset());
        }

        if (g1 instanceof IOffsetGene) {
            return -1;
        }

        if (g2 instanceof IOffsetGene) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return this.stream()
                .sorted(Genotype::compare)
                .map(IGene::toString)
                .collect(Collectors.joining(" "));
    }

    public Genotype clone() {
        return stream()
                .map(IGene::clone)
                .collect(Collectors.toCollection(Genotype::new));
    }

}
