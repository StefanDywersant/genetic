package pl.czystybeton.genetic.recipe;

import pl.czystybeton.genetic.Population;
import pl.czystybeton.genetic.selection.ISelection;
import pl.czystybeton.genetic.util.MathTool;

import java.util.List;

public class CrossPopulationIngredient implements IIngredient {

    private int amount;

    private ISelection selection;

    public CrossPopulationIngredient(int amount, ISelection selection) {
        this.amount = amount;
        this.selection = selection;
    }

    public Population offspring(Population population, int count, List<Population> populations) {
        Population result = new Population();

        for (int i = 0; i < count; i++) {
            result.addAll(
                    selection.select(
                            populations.get(MathTool.random(populations.size())),
                            1
                    )
            );
        }

        return result;
    }

    public int getAmount() {
        return amount;
    }

}
