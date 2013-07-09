package br.com.dishup.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Lucas Biccio Ribeiro
 * @since 10/03/2013
 * @version 1.0 Class responsible for represent the restaurant schedule entity
 */
@Entity
@Table(name="horario_restaurante")
public class RestaurantScheduleEntity implements Serializable{
	
	private static final long serialVersionUID = -7287088316540268839L;

	@Id
	@OneToOne
	@JoinColumn(name="id_restaurante")
	private RestaurantEntity restaurant;
	
	@Id
	@Column(name="id_horario")
	private int idSchedule;
	
	@JoinColumn(name="id_tipo_dia_semana_ini")
	private WeekdayTypeEntity startWeekday;
	
	@JoinColumn(name="id_tipo_dia_semana_fim")
	private WeekdayTypeEntity endWeekday;
	
	@Column(name="hr_ini")
	private String startTime;
	
	@Column(name="hr_fim")
	private String endTime;
	
	public RestaurantScheduleEntity(){
		
	}

	public RestaurantScheduleEntity(RestaurantEntity restaurant,
			int idHorario, WeekdayTypeEntity tipoDiaInicio,
			WeekdayTypeEntity tipoDiaFinal, String horaInicio, String horaFim) {
		this.restaurant = restaurant;
		this.idSchedule = idHorario;
		this.startWeekday = tipoDiaInicio;
		this.endWeekday = tipoDiaFinal;
		this.startTime = horaInicio;
		this.endTime = horaFim;
	}

	public RestaurantEntity getRestaurante() {
		return restaurant;
	}

	public void setRestaurante(RestaurantEntity restaurante) {
		this.restaurant = restaurante;
	}

	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}

	public WeekdayTypeEntity getStartWeekday() {
		return startWeekday;
	}

	public void setStartWeekday(WeekdayTypeEntity startWeekday) {
		this.startWeekday = startWeekday;
	}

	public WeekdayTypeEntity getEndWeekday() {
		return endWeekday;
	}

	public void setEndWeekday(WeekdayTypeEntity endWeekday) {
		this.endWeekday = endWeekday;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}