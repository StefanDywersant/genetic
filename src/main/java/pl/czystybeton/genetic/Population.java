package pl.czystybeton.genetic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Population extends ArrayList<Individual> {

    public Population() {
        super();
    }

    public Population(List<Individual> individuals) {
        super(individuals);
    }

    public Population subList(int fromIndex, int toIndex) {
        return new Population(super.subList(fromIndex, toIndex));
    }

    public Population addAll(List<Individual> items) {
        super.addAll(items);
        return this;
    }

    public void sort() {
        super.sort((i1, i2) -> Double.compare(i2.getFitness(), i1.getFitness()));
    }

    public String toString() {
        return this.stream()
                .map(Individual::toString)
                .collect(Collectors.joining("\n"));
    }

}
