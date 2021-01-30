package com.cybertek.controller;

import com.cybertek.entity.Genre;
import com.cybertek.entity.Movie;
import com.cybertek.entity.MovieCinema;
import com.cybertek.repo.GenreRepository;
import com.cybertek.repo.MovieCinemaRepository;
import com.cybertek.repo.MovieRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebFluxController {
private WebClient webClient=WebClient.builder().baseUrl("http://localhost:8080").build();

private MovieCinemaRepository movieRepository;
private GenreRepository genreRepository;

    public WebFluxController(MovieCinemaRepository movieRepository, GenreRepository genreRepository) {

        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }
    @GetMapping("flux-movie-cinemas")
    public Flux<MovieCinema>readAllCinemas(){
        return Flux.fromIterable(movieRepository.findAll());
    }
    @GetMapping("/mono-movie-cinema/{id}")
    public Mono<MovieCinema>readById(@PathVariable("id") Long id){
        return Mono.just(movieRepository.findById(id).get());
    }
    @GetMapping("/mono-movie-cinema")
    public Mono<MovieCinema>readByIdReequestParam(@RequestParam("id") Long id){
        return Mono.just(movieRepository.findById(id).get());
    }
    @PostMapping("/create-genre")
    public Mono<Genre>createGentre(@RequestBody Genre genre){
        Genre createdGenre=genreRepository.save(genre);
        return Mono.just(createdGenre);
    }
    @PutMapping("/update-genre")
    public Mono<Genre>updateGenre(@RequestBody Genre genre){
        Genre updateGenre = genreRepository.save(genre);

        return Mono.just(updateGenre);
    }
    @DeleteMapping("/delete-genre/{id}")
    public Mono<Void>deleteGenre(@PathVariable("id") Long id){
        genreRepository.deleteById(id);
        return Mono.empty();

    }
    //------------------------------------------------------------------------------------/////
    @GetMapping("/flux")
    public Flux<MovieCinema>readWithWebClient(){
        return webClient.get().uri("/flux-movie-cinemas")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve().bodyToFlux(MovieCinema.class);

    }
    @GetMapping("/mono/{id}")
    public Mono<MovieCinema>readMonoWithWebClient(@PathVariable("id") Long id){
        return webClient.get()
                .uri("/mono-movie-cinema/{id}",id)
                .retrieve()
                .bodyToMono(MovieCinema.class);


    }
    @GetMapping("/mono-rp")
    public Mono<MovieCinema>readMonoWithWebClientRequestParam(@RequestParam("id") Long id){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/mono-movie-cinema").queryParam("id",id).build())
                .retrieve().bodyToMono(MovieCinema.class);
    }
    @PostMapping("create")
    public Mono<Genre>createWebClient(@RequestBody Genre genre){
        return webClient.post()
                .uri("/create-genre")
                .body(Mono.just(genre), Genre.class)
                .retrieve().bodyToMono(Genre.class);

    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void>deleteWebClient(@PathVariable("id") Long id){
        return webClient.delete()
                .uri("/delete-genre/{id}",id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
