package com.cg.movies.service;
import com.cg.movies.dao.*;
import com.cg.movies.dto.Movie;
import com.cg.movies.dto.Theatre;
import com.cg.movies.exception.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
public class Validate {
	
	    private static TheatreDao dao = new TheatreDaoImpl();

	    static boolean validate_theatre(Theatre theatre) throws UserException {
	        String str;
	        str=""+theatre.getCityPincode();
	        if(!str.matches("\\d+")){
	            throw new UserException("Exception Occured: City pincode contains only digits");
	        }
	        
	        if(!theatre.getCityName().matches("[a-zA-Z]+")){
	            throw new UserException("Exception Occured: City name can not have special charecters");
	        }
	        str=""+theatre.getScreens();
	        if(!str.matches("\\d+")){
	            throw new UserException("Exception Occured: Only digits allowed");
	        }
	        return true;
	    }
	    static boolean validate_movie(Movie movie) throws UserException {
	        String str;  
	        if(!movie.getDirector().matches("[a-zA-Z]") && !movie.getGenre().matches("[a-zA-Z]") && !movie.getLanguage().matches("[a-zA-Z]")){
	            throw new UserException("Exception Occured: Only Characters allowed in genre, director name and language");
	        }
	        str=""+movie.getMovieLength();
	        if(!str.matches("\\d+")){
	            throw new UserException("Exception Occured: Only digits allowed in length");
	        }
	        return true;
	    }
	    static boolean validate_Ids(Integer id) throws UserException {
	        String str=""+id;
	        if(!str.matches("\\d+")){
	            throw new UserException("city pincode contains only digits");
	        }
	        return true;
	    }
	    static boolean validate_name(String str) throws UserException {
	        if(!str.matches("[a-zA-Z]+")){
	            throw new UserException("name can not contain special charecters");
	        }
	        return false;
	    }
	}



