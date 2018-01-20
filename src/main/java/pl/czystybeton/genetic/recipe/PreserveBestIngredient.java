package pl.czystybeton.genetic.recipe;

import pl.czystybeton.genetic.Population;

import java.util.List;

public class PreserveBestIngredient implements IIngredient {

    private int amount;

    public PreserveBestIngredient(int amount) {
        this.amount = amount;
    }

    public Population offspring(Population population, int count, List<Population> populations) {
        return population.subList(0, count);
    }

    public int getAmount() {
        return amount;
    }

}
