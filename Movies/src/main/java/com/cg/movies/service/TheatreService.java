package com.cg.movies.service;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cg.movies.dto.Movie;
import com.cg.movies.dto.Screen;
import com.cg.movies.dto.Show;
import com.cg.movies.dto.Theatre;
public interface TheatreService {


		public Map<Integer,String> getCities();
	    public Map<Integer, Theatre> getTheatres() throws Exception;
	    public Boolean addTheatre(Theatre theatre) throws Exception;
	    public List<Theatre> getTheatres(Integer cityPincode) throws Exception;
	    public Theatre searchTheatre(Integer theatreId) throws Exception;
	    public Theatre deleteTheatre(Integer theatreId) throws Exception;
	    public Set<Movie> getMovies(Integer cityPincode) throws Exception;
	    public List<Movie> getMoviesinTheatre(Integer theatreId) throws Exception;
	    public Show addShow(Integer theatreId, Integer screenId, Show show) throws Exception;
	    public Show deleteShow(Integer theatreId,Integer screenId,Integer showId) throws Exception;
	    public Show updateShow(Integer theatreId,Integer screenId,Show show) throws Exception;
	    public List<String> getSeatsAvailability(Integer theatreId, Integer showId, String date) throws Exception;
	    public List<String> updateSeats(Integer theatreId,Integer showId,String date,List<String> seats) throws Exception;
	    public List<String> cancelSeats(Integer theatreId, Integer showId,String date,List<String> seats) throws Exception;
	    public List<Screen> getScreensInTheatre(Integer theatreId) throws Exception;
	    public List<Show> getShowsInTheatre(Integer theatreId) throws Exception;
	    public List<Show> getShowsInScreen(Integer theatreId, Integer screenId) throws Exception;
	    public List<Show> getShowsForMovieInTheatre(Integer theatreId,Integer moviename) throws Exception;
	    public List<String> getAvailableSeats(Show show) throws Exception;
		public Map<Integer, Theatre> getTheatres(int option) throws Exception;
		public Boolean addMovie(Movie movie) throws Exception;
		public Boolean addScreen(int i, int j, int theatreid) throws Exception;
		public Map<Integer, Screen> getScreens(int theaterid) throws Exception;

	}


