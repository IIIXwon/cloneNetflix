package be.shwan.clonenetflix.graphql.controller;

import be.shwan.clonenetflix.graphql.dto.Movie;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GraphQLController {
    @QueryMapping
    public List<Movie> movies() {
        return Movie.get();
    }

    @QueryMapping
    public Movie movie(@Argument(name = "id") int id) {
        return Movie.getById(id);
    }

    @GetMapping("/test")
    public ModelAndView test(ModelAndView mav) {
        mav.setViewName("resources/static/index.html");
        return mav;
    }

}
