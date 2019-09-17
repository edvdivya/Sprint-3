package com.cg.movies.dao;
import com.cg.movies.exception.MyException;

import com.cg.movies.util.DBUtil;
import com.cg.movies.dto.*;
import com.cg.movies.exception.*;
import com.cg.movies.dto.Movie;
import com.cg.movies.dto.Screen;
import com.cg.movies.dto.Show;
import com.cg.movies.dto.Theatre;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TheatreDaoImpl implements TheatreDao{

	private static Connection connection;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	private static Logger myLogger;
	static {
		Properties props = System.getProperties();
		String userDir = props.getProperty("user.dir") + "/src/main/resources/";
		System.out.println("Current working directory is " + userDir);
		PropertyConfigurator.configure(userDir + "log4j.properties");
		myLogger = Logger.getLogger("TheatreDaoImpl.class");
	}

	static {
		try {
			connection = DBUtil.getConnection();
			myLogger.info("connection Obtained!!");
		} catch (MyException e) {
			myLogger.error("Connection Not Obtained at authorDao : " + e);
		}
	}
		    private static Map<Integer, Theatre> theatres = new HashMap<>();

		    @Override
		    public Map<Integer,String> getCities() {

		        Map<Integer,String> cities = new TreeMap<>();
		        List<Map.Entry<Integer,Theatre>> temp = new ArrayList<>(theatres.entrySet());
		        for(int i=0;i<temp.size();i++){
		            cities.put(temp.get(i).getValue().getCityPincode(),temp.get(i).getValue().getCityName());
		        }
		        return cities;
		    }

//		    @Override
		    public Map<Integer,Theatre> getTheatres(int option) {
//		    	
//		    		// TODO Auto-generated method stub
//		    		String sql ="select * from theatre where delete_flag = 0";
//		    		Map<Integer, Theatre> theatreMap = new HashMap<Integer, Theatre>();	
//		    		try {
//		    			ps= connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
//		    			//for select queries we have executeQuery method which returns ResultSet
//		    			rs= ps.executeQuery();
//		    			Theatre theatre = new Theatre();
//		    			while (rs.next()) {
//		    				theatre.setTheatreId(rs.getInt("theatre_id"));
//		    				theatre.setTheatreName(rs.getString("theatre_name"));
//		    				theatre.setCityName(rs.getString("theatre_city"));
//		    				theatre.setCityPincode(rs.getInt("city_pincode"));
//		    				theatre.setScreens(rs.getInt("screens"));
//		    				theatreMap.put(rs.getInt("theatre_id"),theatre);
//		    			}
//		    		} catch (SQLException e) {
//		    			System.out.println(" Error at getTheatrs Dao method : "+e);
//		    		}finally {
//		    			if(ps!=null) {
//		    				try {
//		    					ps.close();
//		    				} catch (SQLException e) {
//		    					System.out.println(" Error at getTheatres  Dao method : "+e);
//		    				}
//		    			}
//		    		}
		    		return null;
		    	}
//		    
//		    public List<Theatre> getTheatres() throws Exception {
//				String sql = "Select * from theatre where delete_flag=0";
//				List<Theatre> theatreList = new ArrayList<Theatre>();
//				try {
//					ps = connection.prepareStatement(sql);
//					rs = ps.executeQuery();
//					while (rs.next()) {
//						Theatre theatre = new Theatre();
//						theatre.setTheatreId(rs.getInt("theatre_id"));
//						theatre.setTheatreName(rs.getString("theatre_name"));
//						theatre.setCityName(rs.getString("theatre_city"));
//					}
//				} catch (SQLException e) {
//					System.out.println("Exception occured at listTheatres dao method: "+e);
//				} finally {
//					if (ps != null) {
//						try {
//							ps.close();
//						} catch (SQLException e1) {
//							System.out.println(" 2nd Error at list theatres dao method");
//						}
//					}
//
//					return theatreList;
//				}
//			}
//		    
		    public Map<Integer,Theatre> getTheatres() throws Exception {
					String sql = "Select * from theatre";
					Map<Integer,Theatre> theatremap = new HashMap<Integer,Theatre>();
					try {
						ps = connection.prepareStatement(sql);
						rs = ps.executeQuery();
						Theatre theatre = new Theatre();
						while (rs.next()) {
							theatre.setTheatreId(rs.getInt("theatre_id"));
							theatre.setTheatreName(rs.getString("theatre_name"));
							theatre.setCityName(rs.getString("theatre_city"));
		    				theatre.setCityPincode(rs.getInt("city_pincode"));
		    				theatre.setScreens(rs.getInt("screens"));
							theatremap.put(rs.getInt("theatre_id"), theatre);
							System.out.println(theatre);
						}
					} catch (SQLException e) {
						System.out.println("Exception occured at listTheatrenames dao method: "+e);
					} finally {
						if (ps != null) {
							try {
								ps.close();
							} catch (SQLException e1) {
								System.out.println(" 2nd Error at list theatres names dao method");
							}
						}
						
					}
					return theatremap;
				}
		    

		    public Boolean addTheatre(Theatre theatre) throws MyException {
				// TODO Auto-generated method stub
				int noOfRec = 0;
				System.out.println(theatre);
				String sql = "insert into theatre(theatre_name,theatre_city,city_pincode,screens,delete_flag) values(?,?,?,?,?)";
				try {
					// step1 : obtain psz
					ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					// step 2: set the ps placeholder values
					ps.setString(1, theatre.getTheatreName());
					ps.setString(2, theatre.getCityName());
					ps.setLong(3, theatre.getCityPincode());
					ps.setInt(4, theatre.getScreens());
					ps.setInt(5, 0);
					// step 3: execute Query (for DML we have executeUpdate method )
					noOfRec = ps.executeUpdate();
				} catch (SQLException e) {
					myLogger.error(" Error at addTheatre Dao method : " + e);
					throw new MyException(" Error at addTheatre Dao method : " + e);
				} finally {
					if (ps != null) {
						try {
							ps.close();
						} catch (SQLException e) {
							myLogger.error(" Error at addTheatre Dao method : " + e);
						}
					}
				}
				if (noOfRec > 0) {
					return true;

				} else {
					return false;
				}

			}
//		    @Override
//		    public Theatre addTheatre(Theatre theatre) {
//		        theatres.put(theatre.getTheatreId(),theatre);
//		        return theatre;
//		    }

		    @Override
		    public List<Theatre> getTheatres(Integer cityPincode) {
		        List<Theatre> theatreList = new LinkedList<>();
		        List<Map.Entry<Integer,Theatre>> temp = new LinkedList<>(theatres.entrySet());
		        for(int i=0;i<temp.size();i++){
		            if(cityPincode.equals(temp.get(i).getValue().getCityPincode())){
		                theatreList.add(temp.get(i).getValue());
		            }
		        }
		        return theatreList;
		    }

		    @Override
		    public Theatre searchTheatre(Integer theatreId) {
		        Theatre theatre = theatres.get(theatreId);
		        return theatre;
		    }

		    @Override
		    public Theatre deleteTheatre(Integer theatreId) {
		        Theatre theatre =theatres.get(theatreId);
		        theatres.remove(theatreId);
		        return theatre;
		    }
		    public List<Movie> removeMovie(Integer theatreId, Integer movieId) {
//		        Movie = theatres.get(theatreId);
//		        theatres.remove(theatreId);
		        return null;
		    }

		    @Override
		    public Set<Movie> getMovies(Integer cityPincode) {
//		        Set<Movie> ret = new HashSet<>();
//		        List<Theatre> temp = getTheatres(cityPincode);
//		        for (int i=0;i<temp.size();i++){
//		            ret.addAll(temp.get(i).getMovies());
//		        }
		        return null;
		    }

	    @Override
		    public List<Movie> getMoviesinTheatre(Integer theatreId) {
		        return null; 
		    //theatres.get(theatreId).getMovies();
		    }

		    public Screen searchScreen(Integer theatreId,Integer screenId){
//		        for(int i=0;i<theatres.get(theatreId).getScreens().size();i++){
//		            if(theatres.get(theatreId).getScreens().get(i).getScreenId().equals(screenId)){
//		                return theatres.get(theatreId).getScreens().get(i);
//		            }
//		        }
		        return null;
		    }
		    @Override
		    public Show addShow(Integer theatreId, Integer screenId, Show show) {
//		        Screen sc = searchScreen(theatreId,screenId);
//		        if(sc!=null){
//		            searchTheatre(theatreId).getMovies().add(show.getCurrentMovie());
//		            sc.getShows().add(show);
//		            return show;
//		        }
		        return null;
//
		    }

		    @Override
		    public Show deleteShow(Integer theatreId, Integer screenId, Integer showId) {
//		        Screen sc= searchScreen(theatreId,screenId);
//		        if(sc!=null){
//		            for(int i=0;i<sc.getShows().size();i++){
//		                if(sc.getShows().get(i).getShowId().equals(showId)){
//		                    Show show = sc.getShows().get(i);
//		                    searchTheatre(theatreId).getMovies().remove(show.getCurrentMovie());
//		                    sc.getShows().remove(show);
//		                    return show;
//		                }
//		            }
//		        }
		        return null;
		    }

		    public Show searchShow(Integer theatreId,Integer showId) {
//		        Theatre theatre = searchTheatre(theatreId);
//		        List<Screen> screens = theatre.getScreens();
//		        for(int i=0;i<screens.size();i++) {
//		            for(int j=0;j<screens.get(i).getShows().size();j++) {
//		                if(screens.get(i).getShows().get(j).getShowId().equals(showId)) {
//		                    return screens.get(i).getShows().get(j);
//		                }
//		            }
//		        }
		        return null;
//
		    }
//
		    public List<Screen> getScreensInTheatre(Integer theatreId){
		        return null;
		        		//searchTheatre(theatreId).getScreens();
		    }


		    @Override
		    public Show updateShow(Integer theatreId,Integer screenId, Show show) {
		        deleteShow(theatreId, screenId, show.getShowId());
		        addShow(theatreId, screenId, show);
		        return null;
		    }

		    @Override
		    public List<String> getSeatsAvailability(Integer theatreId, Integer showId, Date date) {
		        Show show = searchShow(theatreId, showId);
		        if(show != null) {
		            show.getBookedSeats().get(date);
		        }
		        return null;
		    }
//
		    @Override
		    public List<String> updateSeats(Integer theatreId, Integer showId, Date date,List<String> seats) {
//		        Show show = searchShow(theatreId, showId);
//		        //System.out.println(show);
//		        show.getBookedSeats().get(date).addAll(seats);
		        return null;
		        		//seats;
		    }
//
		    public List<String> cancelSeats(Integer theatreId, Integer showId,Date date,List<String> seats){
//		        Show show = searchShow(theatreId, showId);
//		        for(int i=0;i<seats.size();i++){
//		            show.getBookedSeats().get(date).remove(seats.get(i));
//		        }
		        return null; 
		    	//seats;
		    }

		    @Override
		    public List<Show> getShowsInTheatre(Integer theatreId) {
//		        List<Show> shows = new ArrayList<>();
//		        List<Screen> screens = getScreensInTheatre(theatreId);
//		        for(int i=0;i<screens.size();i++){
//		            shows.addAll(screens.get(i).getShows());
//		        }
		        return null;
		    }

		    @Override
		    public List<Show> getShowsInScreen(Integer theatreId, Integer screenId) {
//		        List<Show> shows = new ArrayList<>();
//		        for(int i=0;i<searchTheatre(theatreId).getScreens().size();i++){
//		            if(searchTheatre(theatreId).getScreens().get(i).getScreenId().equals(screenId)){
//		                shows.addAll(searchTheatre(theatreId).getScreens().get(i).getShows());
//		                return shows;
//		            }
//		        }
		        return null;
//		    }
		}

			@Override
			public Boolean addMovie(Movie movie) throws Exception {
				
				int noOfRec1 = 0;
				System.out.println(movie);
				String sql = "insert into movie(movie_name,movie_genre,movie_director,movie_length,movie_language,theatre_id) values(?,?,?,?,?,?)";
				try {
					// step1 : obtain psz
					ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					// step 2: set the ps placeholder values
					ps.setString(1, movie.getMovieName());
					ps.setString(2, movie.getGenre());
					ps.setString(3, movie.getDirector());
					ps.setInt(4, movie.getMovieLength());
					ps.setString(5, movie.getLanguage());
					//ps.setLong(6, (movie.getMovieReleaseDate()));
					ps.setInt(6, movie.getTheatreid());
					// step 3: execute Query (for DML we have executeUpdate method )
					noOfRec1 = ps.executeUpdate();
				} catch (SQLException e) {
					myLogger.error(" Error at add Movie Dao method : " + e);
					throw new MyException(" Error at add Movie Dao method : " + e);
				} finally {
					if (ps != null) {
						try {
							ps.close();
						} catch (SQLException e) {
							myLogger.error(" Error at add Movie Dao method : " + e);
						}
					}
				}
				if (noOfRec1 > 0) {
					return true;

				} else {
					return false;
				}

				
			}

			@Override
			public Boolean addScreen(int i, int j,int theatreid) throws MyException {
				int noOfRec = 0;
				String sql = "insert into screen(rows,columns,theatre) values(?,?,?)";
				try {
					// step1 : obtain psz
					ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					// step 2: set the ps placeholder values
					ps.setInt(1, 5);
					ps.setInt(2, 5);
					ps.setInt(3, theatreid);
					// step 3: execute Query (for DML we have executeUpdate method )
					noOfRec = ps.executeUpdate();
				} catch (SQLException e) {
					myLogger.error(" Error at addScreen method : " + e);
					throw new MyException(" Error at addScreen Dao method : " + e);
				} finally {
					if (ps != null) {
						try {
							ps.close();
						} catch (SQLException e) {
							myLogger.error(" Error at addScreen Dao method : " + e);
						}
					}
				}
				if (noOfRec > 0) {
					return true;

				} else {
					return false;
				}
			}

			@Override
			public Map<Integer,Screen> getScreens(int theatreid) throws Exception {
						String sql = "Select screen_id from screen where theater_id=?";
						Map<Integer,Screen> screenmap = new HashMap<Integer,Screen>();
						try {
							ps = connection.prepareStatement(sql);
							rs = ps.executeQuery();
							Screen screen = new Screen();
							while (rs.next()) {
								screen.setScreenId(rs.getInt("screen_id"));
								
								screenmap.put(rs.getInt("screen_id"), screen);
								System.out.println(screen);
							}
						} catch (SQLException e) {
							System.out.println("Exception occured at listTheatrenames dao method: "+e);
						} finally {
							if (ps != null) {
								try {
									ps.close();
								} catch (SQLException e1) {
									System.out.println(" 2nd Error at list theatres names dao method");
								}
							}
							
						}
						return screenmap;
					}
			}




