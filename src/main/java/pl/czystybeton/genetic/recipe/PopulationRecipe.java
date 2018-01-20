package pl.czystybeton.genetic.recipe;

import pl.czystybeton.genetic.Population;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PopulationRecipe {

    private List<IIngredient> ingredients;

    public PopulationRecipe(List<IIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Population offspring(Population population, int count, List<Population> populations) {
        int sum = ingredients
                .stream()
                .mapToInt(IIngredient::getAmount)
                .sum();

        return ingredients
                .stream()
                .map(ingredient -> ingredient.offspring(
                        population,
                        (int)Math.round(ingredient.getAmount() * 1.0 / sum * count),
                        populations
                ))
                .flatMap(Collection::stream)
                .sorted((i1, i2) -> Double.compare(i2.getFitness(), i1.getFitness()))
                .collect(Collectors.toCollection(Population::new));
    }

}
