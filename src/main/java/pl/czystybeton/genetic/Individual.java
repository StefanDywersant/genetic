package pl.czystybeton.genetic;

public class Individual {

    private Genotype genotype;

    private double fitness;

    public Individual(Genotype genotype, double fitness) {
        this.genotype = genotype;
        this.fitness = fitness;
    }

    public Genotype getGenotype() {
        return genotype;
    }

    public double getFitness() {
        return fitness;
    }

    public String toString() {
        return String.format("Individual[%.02f %s]", getFitness(), getGenotype());
    }

}
