package com.cg.movies.dto;
import java.util.List;

	public class Screen {
	    private Integer screenId;
	    private Integer rows;
	    private Integer columns;
	    private Integer showid;
	    private Integer theatreid;
	    

	    public Screen(Integer rows, Integer columns) {
	        
	        this.rows = rows;
	        this.columns = columns;
	    }

	    public Screen(Integer rows, Integer columns, Integer showid,Integer theatreid) {
	        
	        this.rows = rows;
	        this.columns = columns;
	        this.showid = showid;
	    }

	    public Screen() {
			// TODO Auto-generated constructor stub
		}

		public Integer getScreenId() {
	        return screenId;
	    }

	    public Integer getRows() {
	        return rows;
	    }

	    public Integer getColumns() {
	        return columns;
	    }

	    public Integer getShows() {
	        return showid;
	    }

	    public void setShows(Integer showid) {
	        this.showid = showid;
	    }

	    public Integer getShowid() {
			return showid;
		}

		public void setShowid(Integer showid) {
			this.showid = showid;
		}

		public Integer getTheatreid() {
			return theatreid;
		}

		public void setTheatreid(Integer theatreid) {
			this.theatreid = theatreid;
		}

		public void setScreenId(Integer screenId) {
			this.screenId = screenId;
		}

		public void setRows(Integer rows) {
			this.rows = rows;
		}

		public void setColumns(Integer columns) {
			this.columns = columns;
		}

		@Override
	    public String toString() {
	        return "Screen{" +
	                "screenId=" + screenId +
	                ", rows=" + rows +
	                ", columns=" + columns +
	                ", shows=" + showid +
	                '}';
	    }
	}


