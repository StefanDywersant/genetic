package pl.czystybeton.genetic.recipe;

import pl.czystybeton.genetic.Individual;
import pl.czystybeton.genetic.Population;

import java.util.ArrayList;
import java.util.List;

public interface IIngredient {

    ArrayList<Individual> offspring(Population population, int count, List<Population> populations);

    int getAmount();

}
