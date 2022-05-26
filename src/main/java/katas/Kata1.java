package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();

        //crear una nueva lista con un Map como argumento
        List<Map> pelis = new ArrayList<>();

        //llamar stream usando la lista "movies" que trae todo el arreglo inicial
        pelis = movies.stream()
                //recorrer el arreglo para obtener el id y el tittle
                .map(element -> ImmutableMap.of(element.getId(), element.getTitle()))
                //convertir el arreglo a una lista
                .collect(Collectors.toList());

        return pelis;
    }
}
