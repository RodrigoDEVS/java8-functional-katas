package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        int smallest = movieLists.stream().map(element -> element.getVideos())
                .flatMap(Collection::stream)
                .map(ele -> ele.getBoxarts())
                .flatMap(List::stream)
                .mapToInt(e -> e.getWidth())
                .reduce(Integer::min)
                .getAsInt();

        List<Map> pelis = movieLists.stream().flatMap(list -> list.getVideos().stream())
                .map(element -> ImmutableMap.of("id", element.getId(), "title",
                        element.getTitle(), "time", new Date(),
                        "url", element.getBoxarts().stream().filter(elem -> elem.getWidth() == smallest).map(ele -> ele.getUrl()).findAny().get()))
                .collect(Collectors.toList());

        System.out.println(pelis);

        return pelis;
    }
}
