package bestWorstList.hiltonws.github.com.app.service;

import bestWorstList.hiltonws.github.com.app.controller.dto.MinMaxDTO;
import bestWorstList.hiltonws.github.com.app.controller.dto.MoviesDTO;
import bestWorstList.hiltonws.github.com.app.model.Movies;
import bestWorstList.hiltonws.github.com.app.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository repository;

    //Pega cada produtor
    private List<Movies> getProducer() {
        List<Movies> transformedMovies = new ArrayList<>();
        Movies moviesSample = new Movies();
        moviesSample.setWinner("yes");
        //Filtra os filmes que tiverem anhadores
        repository.findAll(Example.of(moviesSample)).forEach(element -> {
            String producers = element.getProducers();
            //Verifica se possui virgula ou possui and, pois significa que há mais de um produtor
            //Após disso o separa e retorna
            if (producers.contains(", ")) {
                String[] commaSplits = producers.split(", ");
                for (String commaSplit : commaSplits) {
                    Movies movies = new Movies();
                    movies.setWinner(element.getWinner());
                    movies.setYear(element.getYear());
                    movies.setProducers(commaSplit);
                    transformedMovies.add(movies);
                }
            } else if (producers.contains(" and ")){
                String[] split = producers.split(" and ");
                for (String andSplit : split) {
                    Movies movies = new Movies();
                    movies.setWinner(element.getWinner());
                    movies.setYear(element.getYear());
                    movies.setProducers(andSplit);
                    transformedMovies.add(movies);
                }
            }else{
                Movies movies = new Movies();
                movies.setWinner(element.getWinner());
                movies.setYear(element.getYear());
                movies.setProducers(producers);
                transformedMovies.add(movies);
            }



        });

        return transformedMovies;
    }

    public MinMaxDTO get() {
        List<Movies> producer = getProducer();
        //Maior ano e menor ano por produtor
        Map<String, Movies> max = producer.stream()
                .collect(Collectors
                        .toMap(Movies::getProducers, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Movies::getYear))));
        Map<String, Movies> min = producer.stream()
                .collect(Collectors
                        .toMap(Movies::getProducers, Function.identity(), BinaryOperator.minBy(Comparator.comparing(Movies::getYear))));
        //Guardar os produtores com os intervalos
        List<MoviesDTO> dtos = new ArrayList<>();
        max.forEach((producer_, movie) -> {
            Movies movieMin = min.get(producer_);
            Integer interval = movie.getYear() - movieMin.getYear();
            //Se o intervalo for maior que 0 tem mais de uma vitoria
            if (interval > 0) {
                MoviesDTO dto = new MoviesDTO();
                dto.setPrevisiousWin(movieMin.getYear());
                dto.setFollowingWin(movie.getYear());
                dto.setInterval(interval);
                dto.setProducer(producer_);
                dtos.add(dto);
            }

        });
        //Pega o maximo e o minimo
        MoviesDTO dtoMin = dtos.stream().min(Comparator.comparing(MoviesDTO::getInterval)).get();
        MoviesDTO dtoMax = dtos.stream().max(Comparator.comparing(MoviesDTO::getInterval)).get();
        //Returna para a APi
        MinMaxDTO minMaxDTO = new MinMaxDTO();
        minMaxDTO.setMax(new ArrayList<>());
        minMaxDTO.getMax().add(dtoMax);
        minMaxDTO.setMin(new ArrayList<>());
        minMaxDTO.getMin().add(dtoMin);

        return minMaxDTO;
    }
}
