package com.cg.movies.service;
import com.cg.movies.dao.*;
import com.cg.movies.dto.Movie;
import com.cg.movies.dto.Screen;
import com.cg.movies.dto.Show;
import com.cg.movies.dto.Theatre;
import com.cg.movies.exception.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class TheatreServiceImpl implements TheatreService {
		
	    private TheatreDao dao = new TheatreDaoImpl();

		    @Override
		    public Map<Integer, String> getCities() {
		        return dao.getCities();
		    }

		    @Override
		    public Map<Integer, Theatre> getTheatres() throws Exception {
		        return dao.getTheatres();
		    }
		    public Map<Integer, Theatre> getTheatres(int option) throws Exception {
		        return dao.getTheatres(option);
		    }

		    @Override
		    public Boolean addTheatre(Theatre theatre) throws Exception {
		        if(Validate.validate_theatre(theatre)) {
		        	return dao.addTheatre(theatre);
		        }
		        return false;
		            
		    }

		    @Override
		    public List<Theatre> getTheatres(Integer cityPincode) throws Exception {
		        if(Validate.validate_Ids(cityPincode)){
		           return dao.getTheatres(cityPincode);
		        }
		        return null;
		    }

		    @Override
		    public Theatre searchTheatre(Integer theatreId) throws Exception {
		        if(Validate.validate_Ids(theatreId)){
		            return dao.searchTheatre(theatreId);
		        }
		        return null;
		    }

		    @Override
		    public Theatre deleteTheatre(Integer theatreId) throws UserException {
		        if(Validate.validate_Ids(theatreId)){
		            return dao.deleteTheatre(theatreId);
		        }
		        return null;
		    }

		    @Override
		    public Set<Movie> getMovies(Integer cityPincode) throws UserException {
		        if(Validate.validate_Ids(cityPincode)){
		            return dao.getMovies(cityPincode);
		        }
		        return null;
		    }

		    @Override
		    public List<Movie> getMoviesinTheatre(Integer theatreId) throws Exception{
		        if(Validate.validate_Ids(theatreId)){
		            return dao.getMoviesinTheatre(theatreId);
		        }
		        return null;
		    }

		    @Override
		    public Show addShow(Integer theatreId, Integer screenId, Show show) throws Exception {
		        // TODO Auto-generated method stub
		        if((Validate.validate_Ids(theatreId)&&(Validate.validate_Ids(screenId)))) {
		            dao.addShow(theatreId, screenId, show);
		        }
		        return null;
		    }



		    @Override
		    public Show deleteShow(Integer theatreId, Integer screenId, Integer showId) throws Exception {
		        // TODO Auto-generated method stub
		        if((Validate.validate_Ids(theatreId)&&(Validate.validate_Ids(screenId)))) {

		           return  dao.deleteShow(theatreId, screenId, showId);
		        }
		        return null;
		    }



		    @Override
		    public Show updateShow(Integer theatreId,Integer screenId, Show show) throws Exception {
		        // TODO Auto-generated method stub
		        if(Validate.validate_Ids(theatreId)) {
		           return dao.updateShow(theatreId,screenId,show);
		        }
		        return null;
		    }



		    @Override
		    public List<String> getSeatsAvailability(Integer theatreId, Integer showId, String date) throws Exception {
		        // TODO Auto-generated method stub
		        if((!Validate.validate_Ids(theatreId)&&(!Validate.validate_Ids(showId)))) {
		            SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
		            Date user_date = sdfo.parse(date);
		            if(user_date.compareTo(dao.searchShow(theatreId, showId).getMovieEndDate())<0) {
		                return dao.getSeatsAvailability(theatreId, showId, sdfo.parse(date));
		            }
		            else {
		                throw new UserException("please enter a valid date");
		            }
		        }
		        return null;
		    }



		    @Override
		    public List<String> updateSeats(Integer theatreId, Integer showId, String date, List<String> seats) throws Exception{
		        // TODO Auto-generated method stub
		        if((Validate.validate_Ids(theatreId)&&(Validate.validate_Ids(showId)))) {
		            SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
		            Date user_date=sdfo.parse(date);
		            if(user_date.compareTo(dao.searchShow(theatreId, showId).getMovieEndDate())<0) {
		                return dao.updateSeats(theatreId, showId, sdfo.parse(date), seats);
		            }
		            else {
		                throw new UserException("please enter a valid date");
		            }

		        }
		        return null;
		    }

		    public List<String> cancelSeats(Integer theatreId, Integer showId,String date,List<String> seats) throws Exception{
		        if((!Validate.validate_Ids(theatreId)&&(!Validate.validate_Ids(showId)))) {
		            SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
		            Date user_date=sdfo.parse(date);
		            if(user_date.compareTo(dao.searchShow(theatreId, showId).getMovieEndDate())<0) {
		                return dao.cancelSeats(theatreId, showId, sdfo.parse(date), seats);
		            }
		            else {
		                throw new UserException("please enter a valid date");
		            }

		        }
		        return null;
		    }

		    @Override
		    public List<Screen> getScreensInTheatre(Integer theatreId) throws Exception {
		        if(Validate.validate_Ids(theatreId)){
		            return(dao.getScreensInTheatre(theatreId));
		        }
		        return null;
		    }

		    @Override
		    public List<Show> getShowsInTheatre(Integer theatreId) throws Exception {
		        if(Validate.validate_Ids(theatreId)){
		            return dao.getShowsInTheatre(theatreId);
		        }
		        return null;
		    }

		    @Override
		    public List<Show> getShowsInScreen(Integer theatreId, Integer screenId) throws Exception {
		        if(Validate.validate_Ids(theatreId)&&Validate.validate_Ids(screenId)){
		            return dao.getShowsInScreen(theatreId,screenId);
		        }
		        return null;
		    }

		    @Override
		    public List<Show> getShowsForMovieInTheatre(Integer theatreId, Integer moviename) throws Exception {
		        List<Show> shows=getShowsInTheatre(theatreId);
		        List<Show> ret = new ArrayList<>();
		        for(int i=0;i<shows.size();i++){
		            if(shows.get(i).getCurrentMovie().getMovieId().equals(moviename)){
		                ret.add(shows.get(i));
		            }
		        }
		        return ret;
		    }

		    @Override
		    public List<String> getAvailableSeats(Show show) throws Exception {
		        List<String> seats=new ArrayList<>();
		        return null;
		    }

			@Override
		
			  public Boolean addMovie(Movie movie) throws Exception {
			        if(Validate.validate_movie(movie)) {
			        	return dao.addMovie(movie);
			        }
			        return false;
			            
			    }

			@Override
			public Boolean addScreen(int i, int j,int theatreid) throws Exception {
				return dao.addScreen(i,j,theatreid);
				
			}

			@Override
			public Map<Integer,Screen> getScreens(int theaterid) throws Exception {
				// TODO Auto-generated method stub
				return dao.getScreens(theaterid);
			}
		}



	

