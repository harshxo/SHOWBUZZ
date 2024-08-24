package dev.harsh.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController

@RequestMapping("/api/v1/movies")
@CrossOrigin({
    "http://localhost:3000",
    "https://showbuzz-al4kz4ku9-harshs-projects-ebeda428.vercel.app"
} )

public class MovieController {
	@Autowired
	private MovieService movieService;
  @GetMapping
  public ResponseEntity<List<Movie>> getallMovies() {
	  return new ResponseEntity<List<Movie>>(movieService.allMovies() , HttpStatus.OK) ;
  }

  @GetMapping("/{imdbId}")
  public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
      return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
  }
  @GetMapping("/test")
  public String test() {
      return "Movie API is working!";
  }
public MovieService getMovieService() {
	return movieService;
}
public void setMovieService(MovieService movieService) {
	this.movieService = movieService;
}
}
