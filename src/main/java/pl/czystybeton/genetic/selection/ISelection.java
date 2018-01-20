package pl.czystybeton.genetic.selection;

import pl.czystybeton.genetic.Individual;
import pl.czystybeton.genetic.Population;

import java.util.List;

public interface ISelection {

    List<Individual> select(Population population, int count);

}
