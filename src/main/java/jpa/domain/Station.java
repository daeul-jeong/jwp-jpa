package jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "STATION")
public class Station extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String name;

	@OneToMany(mappedBy = "station")
	private List<StationLine> lineList = new ArrayList<>();

	@Embedded
	@Column
	private Distance distance;

	public Station(String name) {
		this.name = name;
	}

	public Station(String name,  List<StationLine> lineList) {
		this.name = name;
		this.lineList = lineList;
	}

	public Station(String name, Distance distanceMeter) {
		this.name = name;
		this.distance = distanceMeter;
	}
	public Station(String name, List<StationLine> lineList, Distance distanceMeter) {
		this.name = name;
		this.lineList = lineList;
		this.distance = distanceMeter;
	}

	public Station() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StationLine> getLineList() {
		return lineList;
	}

	public void setLineList(List<StationLine> lineList) {
		this.lineList = lineList;
	}

	public Distance getDistance() {
		return distance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Station station = (Station) o;
		return Objects.equals(name, station.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
