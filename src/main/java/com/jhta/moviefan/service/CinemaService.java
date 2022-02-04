package com.jhta.moviefan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.moviefan.dao.CinemaDao;
import com.jhta.moviefan.dto.CinemaDto;
import com.jhta.moviefan.dto.MovieTimeTableDto;
import com.jhta.moviefan.form.ScheduleUpdateForm;
import com.jhta.moviefan.vo.Cinema;
import com.jhta.moviefan.vo.City;

@Service
@Transactional
public class CinemaService {
	
	@Autowired
	private CinemaDao cinemaDao;
	private CinemaService cinemaService;
	
	public List<City> getAllCityList() {
		return cinemaDao.getAllCities();
	}
	
	public List<City> getCityByNo(int no) {
		return cinemaDao.getCityByNo(no);
	}

	public List<CinemaDto> getAllCinemaList() {
		return cinemaDao.getAllCinemas();
	}

	public List<Cinema> getCinemaListByCityNo(int cityNo) {
		return cinemaDao.getCinemaListByCityNo(cityNo);
	}
	
	public List<MovieTimeTableDto> getMovieTimeTableByCinemaNo(int cinemaNo) {
		return cinemaDao.getMovieTimeTableByCinemaNo(cinemaNo);
	}
	
	public MovieTimeTableDto getMovieTimeTableByShowNo(int showNo) {
		return cinemaDao.getMovieTimeTableByShowNo(showNo);
	}
	
	
	public void updateSchedule(int showNo, int movieNo) {
		
		MovieTimeTableDto timetable = cinemaDao.getMovieTimeTableByShowNo(showNo);
		timetable.setMovieNo(showNo);
		cinemaService.updateSchedule(showNo, movieNo);
	}
	
}
