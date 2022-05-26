package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        int largest = movies.stream().map(element -> element.getBoxarts())
                .flatMap(boxes -> boxes.stream())
                .mapToInt(ele -> ele.getWidth())
                .reduce(Integer::max)
                .getAsInt();

        String urlLargest = movies.stream().map(element -> element.getBoxarts())
                .flatMap(boxes -> boxes.stream())
                .filter(ele -> ele.getWidth() == largest)
                .map(e -> e.getUrl())
                .findFirst().get();

        System.out.println(urlLargest);
        return urlLargest;
    }
}
