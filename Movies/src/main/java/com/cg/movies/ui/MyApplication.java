package com.cg.movies.ui;
import com.cg.movies.dto.Movie;

import com.cg.movies.dto.Screen;
import com.cg.movies.dto.Show;
import com.cg.movies.dto.Theatre;
import com.cg.movies.service.*;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class MyApplication {

	public static void main(String[] args) throws Exception {

		TheatreService service = new TheatreServiceImpl();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date releaseDate = sdf.parse("2019-06-28");
		java.util.Date movieEndDate = sdf.parse("2020-07-05");
		java.util.Date releaseDate1 = sdf.parse("2019-09-10");
		java.util.Date movieEndDate1 = sdf.parse("2019-09-17");
		SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
		java.util.Date showStartTimeSM11 = sdf1.parse("2:05:00");// screen1
		java.util.Date showEndTimeSM11 = sdf1.parse("16:00:00");
		java.util.Date showStartTimeSM12 = sdf1.parse("10:05:00");// screen2
		java.util.Date showEndTimeSM12 = sdf1.parse("1:00:00");
		java.util.Date showStartTimeSM21 = sdf1.parse("05:05:00");// screen2
		java.util.Date showEndTimeSM21 = sdf1.parse("08:00:00");
		java.util.Date showStartTimeSM22 = sdf1.parse("18:05:00");// screen 1
		java.util.Date showEndTimeSM22 = sdf1.parse("21:00:00");
		java.util.Date showStartTimeSM23 = sdf1.parse("19:05:00");
		java.util.Date showEndTimeSM23 = sdf1.parse("22:00:00");
		
		Map<Date, List<String>> bookedSeats = new HashMap<Date, List<String>>();
		
		ArrayList<Show> listofShowsMovie1 = new ArrayList<Show>();
		ArrayList<Show> listofShowsMovie2 = new ArrayList<Show>();
		ArrayList<Movie> listofMovies = new ArrayList<Movie>();

		try {
//			Movie movie1 = new Movie("Article 15", "Comedy Drama", "Rajkumar Hirani", 125, releaseDate, "English");
//			Movie movie2 = new Movie("Romeo Akbar Walter", "Thriller Drama", "SiddraJ Films", 195, releaseDate1,"Hindi");
//			listofMovies.add(movie1);
//			listofMovies.add(movie2);
//			Show showM11 = new Show(movie1, movieEndDate, "English", showStartTimeSM11, showEndTimeSM11, bookedSeats);
//			Show showM12 = new Show(movie1, movieEndDate, "English", showStartTimeSM12, showEndTimeSM12, bookedSeats);
//			Show showM21 = new Show(movie2, movieEndDate, "English", showStartTimeSM21, showEndTimeSM21, bookedSeats);
//			Show showM22 = new Show(movie2, movieEndDate, "English", showStartTimeSM22, showEndTimeSM22, bookedSeats);
//			Show showM23 = new Show(movie2, movieEndDate, "English", showStartTimeSM23, showEndTimeSM23, bookedSeats);
//			listofShowsMovie1.add(showM11);
//			listofShowsMovie1.add(showM12);
//			listofShowsMovie2.add(showM21);
//			listofShowsMovie2.add(showM22);
//			listofShowsMovie2.add(showM23);
		} catch (Exception e) {
			System.out.println("Check date format");

		}
		ArrayList<Screen> listofScreensT1 = new ArrayList<Screen>();
		ArrayList<Screen> listofScreensT2 = new ArrayList<Screen>();
		ArrayList<Screen> listofScreensT3 = new ArrayList<Screen>();
//		Screen screenT11 = new Screen(10, 10, listofShowsMovie1);
//		Screen screenT21 = new Screen(10, 10, listofShowsMovie2);
//		Screen screenT22 = new Screen(10, 10, listofShowsMovie1);
//		Screen screenT31 = new Screen(10, 10, listofShowsMovie2);
//		Screen screenT32 = new Screen(10, 10, listofShowsMovie2);
//		listofScreensT1.add(screenT11);
//		listofScreensT2.add(screenT21);
//		listofScreensT2.add(screenT22);
//		listofScreensT3.add(screenT31);
//		listofScreensT3.add(screenT32);
//		Theatre theatre1 = new Theatre("Elante Mall", 160087, "Chandigarh",listofScreensT1, listofMovies);
//		Theatre theatre2 = new Theatre("Wave Cinemas", 160023, "Chandigarh",listofScreensT2, listofMovies);
//		Theatre theatre3 = new Theatre("Saket CityMall", 140078, "Chandigarh",listofScreensT3, listofMovies);
//		Theatre theatre1 = new Theatre("Elante Mall", 160087, "Chandigarh","null","null");
//		Theatre theatre2 = new Theatre("Wave Cinemas", 160023, "Chandigarh","null","null");
//		Theatre theatre3 = new Theatre("Saket CityMall", 140078, "Chandigarh","null", "null");

//		service.addTheatre(theatre1);
//		service.addTheatre(theatre2);
//		service.addTheatre(theatre3);
		Scanner scanner = new Scanner(System.in);
		int count = 2;
		while ((count--) > 0) {
			System.out.println("BELOW ARE THE PREFERRED ROLES");
			System.out.println("1. Admin");
			System.out.println("2. Registered User");
			System.out.println("3. Unregistered User");
			System.out.println("4. Exit");
			System.out.println("Enter the type of User you are: ");
			int choice = scanner.nextInt();
			switch (choice) {

			case 1:
				System.out.println("1. Add Movie To Theater");
				System.out.println("2. Remove Movie Show From Theater");
				System.out.println("3. Add Theater");
				System.out.println("4. Delete Theater");
				System.out.println("5. Get Cities");
				System.out.println("6. Get Theatres");
				System.out.println("7. Quit");
				System.out.println("Enter Function Number you want to perform: ");
				int input = scanner.nextInt();
				switch (input) {

				case 1:
					// show theater list
					service.getTheatres();
					System.out.println("Enter The Theater Id to which you want to add movie: ");
					int theaterid = scanner.nextInt();
					System.out.println("Enter the Movie Details as asked: ");
					scanner.nextLine();
					System.out.println("Enter the movie name");
					String name = scanner.nextLine();
					System.out.println("Enter the genre name");
					String genre = scanner.nextLine();
					System.out.println("Enter the director name");
					String director = scanner.nextLine();
					System.out.println("Enter the movie length ");
					Integer movieLength = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the movie release date");
					Date date = sdf.parse(scanner.nextLine());
					System.out.println("Enter the movie language");
					String language = scanner.nextLine();
					Movie movie = new Movie(name, genre, director, movieLength, date, language,theaterid);
					System.out.println("");
					try {
						service.addMovie(movie);
						System.out.println("Movie Added");
						//System.out.println(service.getScreens(theaterid));
						//System.out.println("ScreenId to add movie");
					} catch (Exception exception) {
						System.out.println(exception.getMessage());
					}
					
					break;
				case 2:
					service.getTheatres();
					System.out.println("Enter the theatre Id to remove Movie: ");
					int theatreId = scanner.nextInt();
					for (int i = 0; i < service.getMoviesinTheatre(theatreId).size(); i++) {
						System.out.println(service.getMoviesinTheatre(theatreId).get(i).getMovieId() + " "
								+ service.getMoviesinTheatre(theatreId).get(i).getMovieName());
						}
					
					for (int i = 0; i < service.getScreensInTheatre(theatreId).size(); i++) {
						System.out.println(service.getScreensInTheatre(theatreId).get(i));
					}
					System.out.println("Enter the screen id in which you want to delete");
					Integer screenId = scanner.nextInt();
					for (int i = 0; i < service.getShowsInScreen(theatreId, screenId).size(); i++) {
						System.out.println(service.getShowsInScreen(theatreId, screenId).get(i));
					}
					System.out.println("Enter the show id to delete");
					service.deleteShow(theatreId, screenId, scanner.nextInt());
					scanner.nextLine();
					break;
				case 3:
					System.out.println("Enter the Theatre Details as asked: ");
					scanner.nextLine();
					System.out.println("Enter the Theatre name");
					String theatreName = scanner.nextLine();
					System.out.println("Enter the Theatre City");
					String theatreCity = scanner.nextLine();
					System.out.println("Enter the City Pincode");
					Integer city_pincode = scanner.nextInt();
					System.out.println("Enter the number of screens in theatre ");
					Integer screens = scanner.nextInt();
					scanner.nextLine();
					Theatre theatre = new Theatre(theatreName,theatreCity,city_pincode,screens);
					System.out.println("");
					try {
						service.addTheatre(theatre);
//						int theatreid=theatre.getTheatreId();
//						System.out.println(theatreid);
//						for(int i=0;i<screens;i++) {
//							service.addScreen(5,5,theatreid);
//						}
						
					} catch (Exception exception) {
						System.out.println(exception.getMessage());
					}
					break;
				case 4:
					System.out.println("Enter the theatre id");
					service.deleteTheatre(scanner.nextInt());
					break;
				case 5:
					List<Map.Entry<Integer, String>> cities = new ArrayList<>(service.getCities().entrySet());
					for (int i = 0; i < cities.size(); i++) {
						System.out.println(cities.get(i).getKey() + " " + cities.get(i).getValue());
					}
					break;
				case 6:
					service.getTheatres();
					break;
				
				case 7:
					exit(1);

				}
				break;

			case 2:
				System.out.println("1. Login");
				System.out.println("2. Book tickets");
				System.out.println("3. Cancel tickets");
				System.out.println("4. Quit");
				System.out.println("Enter Your choice: ");
				int userChoice = scanner.nextInt();
				switch (userChoice) {

				case 1:
					System.out.println("Enter the UserId: ");
					System.out.println("Enter the Password: ");
				case 2:
					List<Map.Entry<Integer, String>> cities = new ArrayList<>(service.getCities().entrySet());
					for (int i = 0; i < cities.size(); i++) {
						System.out.println(cities.get(i).getKey() + " " + cities.get(i).getValue());
					}
					System.out.println("choose city pincode");
					Integer pincode = scanner.nextInt();
					System.out.println("enter your option ");
					System.out.println("1 for search by theatre");
					System.out.println("2 for search by movie");
					Integer option = scanner.nextInt();
					if (option == 1) {
						for (int i = 0; i < service.getTheatres(pincode).size(); i++) {
							System.out.println(service.getTheatres(pincode).get(i).getTheatreName() + " "
									+ service.getTheatres(pincode).get(i));
						}
						System.out.println("enter the theatre id");
						Integer id = scanner.nextInt();
						for (int i = 0; i < service.getMoviesinTheatre(id).size(); i++) {
							System.out.println(service.getMoviesinTheatre(id).get(i).getMovieName() + " "
									+ service.getMoviesinTheatre(id).get(i).getMovieId());
						}
						Integer movieId = scanner.nextInt();
						List<Show> shows = service.getShowsForMovieInTheatre(id, movieId);
						for (int i = 0; i < shows.size(); i++) {
							System.out.println(shows.get(i).getShowStartTime() + " " + shows.get(i).getShowId() + " "
									+ shows.get(i).getMovieEndDate());
						}
						System.out.println("Enter show id");
						Integer showId = scanner.nextInt();
						List<String> seats = new ArrayList<>(3);
						String date = (scanner.next());
						for (int i = 0; i < 3; i++) {
							seats.add(scanner.next());
						}
						service.updateSeats(id, showId, date, seats);
						for (int i = 0; i < shows.size(); i++) {
							if (shows.get(i).getShowId().equals(showId)) {
								for (int j = 0; j < shows.get(i).getBookedSeats().get(sdf.parse(date)).size(); j++) {
									System.out.println(shows.get(i).getBookedSeats().get(sdf.parse(date)));
								}
							}
						}

					} else if (option == 2) {
						for (Movie movie : service.getMovies(pincode)) {
							System.out.println(movie.getMovieName());
						}
					}
					break;
				case 3:
					// prints list of movies
					System.out.println("Select movie you want to see shows for");
					String bookMovie = scanner.next();
					// method call by movie name
					// print list of theaters that showcase that movie
					System.out.println("Select Theater");
					String bookTheater = scanner.next();
					// print show for that movie id in this theater id by fetching theater id from
					// theater name
					System.out.println("Select Show");
					// method call to book show
					break;

				}
				break;

			case 3:
				System.out.println("1. Register");
				System.out.println("2. View Movies Shows");
				System.out.println("3. Exit");
				int viewerChoice = scanner.nextInt();
				switch (viewerChoice) {

				case 1:
					System.out.println("Enter Your name");
					System.out.println("Enter your contact");

					System.out.println("Enter the password");
					System.out.println("Confirm password");
					break;
				case 2:
					// prints list of movies
					System.out.println("Select movie you want to see shows for");
					for (int i = 0; i < listofMovies.size(); i++) {
						System.out.println(listofMovies.get(i));
					}
					String choseMovie = scanner.next();

					// print list of theaters that showcase that movie
					System.out.println("Select Theater");
					String choseTheater = scanner.next();
					// print show for that movie id in this theater id by fetching theater id from
					// theater name
					break;
				case 3:
					exit(1);
				}
				break;
			case 4:
				exit(1);
			}

		}

	}

	private static void exit(int i) {
		// TODO Auto-generated method stub

	}

}
