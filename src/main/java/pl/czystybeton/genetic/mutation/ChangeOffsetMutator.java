package pl.czystybeton.genetic.mutation;

import pl.czystybeton.genetic.Genotype;
import pl.czystybeton.genetic.gene.IOffsetGene;
import pl.czystybeton.genetic.util.MathTool;

import java.util.List;
import java.util.stream.Collectors;

public class ChangeOffsetMutator implements IMutator, IDegreeMutator {

    private int range;

    public ChangeOffsetMutator(int range) {
        this.range = range;
    }

    public Genotype mutate(Genotype genotype, double degree) {
        List<IOffsetGene> genes = genotype
                .stream()
                .filter(gene -> gene instanceof IOffsetGene)
                .map(gene -> (IOffsetGene) gene)
                .collect(Collectors.toList());

        if (genes.size() == 0) {
            return genotype;
        }

        IOffsetGene gene = genes.get(MathTool.random(genes.size()));

        int offset = gene.getOffset() + (int)MathTool.random(Math.floor(degree * range / 2), Math.floor(degree * range / -2));

        if (offset > range) {
            offset = range;
        }

        if (offset < 0) {
            offset = 0;
        }

        gene.setOffset(offset);

        genotype.add(gene);

        return genotype;
    }

    public Genotype mutate(Genotype genotype) {
        return mutate(genotype, 1.0);
    }

}
