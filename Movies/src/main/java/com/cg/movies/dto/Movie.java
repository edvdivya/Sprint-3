package com.cg.movies.dto;
import java.util.Date;
import java.util.Objects;

	public class Movie {
		private Integer movieId;
		private String movieName;
		private String genre;
		private String director;
		private Integer movieLength;
		private Date movieReleaseDate;
		private String language;
		private Integer theaterid;
		

		public Movie(String movieName, String genre, String director, Integer movieLength, Date movieReleaseDate,
				String language, Integer theaterid) {
			
			this.movieName = movieName;
			this.genre = genre;
			this.director = director;
			this.movieLength = movieLength;
			this.movieReleaseDate = movieReleaseDate;
			this.language = language;
			this.theaterid=theaterid;
		}

		public Integer getMovieId() {
			return movieId;
		}
		public Integer getTheatreId() {
			return theaterid;
		}
		public String getMovieName() {
			return movieName;
		}

		public String getGenre() {
			return genre;
		}

		public String getDirector() {
			return director;
		}

		public Integer getTheatreid() {
			return theaterid;
		}

		public void setTheatreid(Integer theatreid) {
			this.theaterid = theatreid;
		}

		public void setMovieId(Integer movieId) {
			this.movieId = movieId;
		}

		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public void setDirector(String director) {
			this.director = director;
		}

		public void setMovieLength(Integer movieLength) {
			this.movieLength = movieLength;
		}

		public void setMovieReleaseDate(Date movieReleaseDate) {
			this.movieReleaseDate = movieReleaseDate;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public Integer getMovieLength() {
			return movieLength;
		}

		public Date getMovieReleaseDate() {
			return movieReleaseDate;
		}

		public String getLanguage() {
			return language;
		}


		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof Movie))
				return false;
			Movie movie = (Movie) o;
			return getMovieName().equals(movie.getMovieName()) && getGenre().equals(movie.getGenre())
					&& getDirector().equals(movie.getDirector()) && getMovieLength().equals(movie.getMovieLength())
					&& getMovieReleaseDate().equals(movie.getMovieReleaseDate())
					&& getLanguage().equals(movie.getLanguage());
		}

		@Override
		public int hashCode() {
			return Objects.hash(getMovieName(), getGenre(), getDirector(), getMovieLength(), getMovieReleaseDate(),
					getLanguage(),getTheatreid());
		}

		@Override
		public String toString() {
			return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", genre=" + genre + ", director="
					+ director + ", movieLength=" + movieLength + ", movieReleaseDate=" + movieReleaseDate
					+ ", language=" + language + ", theatreid=" + theaterid + "]";
		}
	}

