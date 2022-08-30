package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Travel implements Comparable<Travel> , Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer TicketCost;
  private String busModel;
  private String sourceCity;
  private String destinationCity;
  @OneToMany(mappedBy = "travel")
  List<User> users = new ArrayList<>();
  private LocalTime travelTime;
  private LocalDate travelDate;
  @ManyToOne
  private TravelCompany travelCompany;


  public Travel() {
  }

  public Travel(Integer TicketCost, String busModel, String sourceCity, String destinationCity, LocalTime TravelTime, LocalDate travelDate) {
    this.TicketCost = TicketCost;
    this.busModel = busModel;
    this.sourceCity = sourceCity;
    this.destinationCity = destinationCity;
    this.travelTime = TravelTime;
    this.travelDate = travelDate;
  }


  public TravelCompany getTravelCompany() {
    return travelCompany;
  }

  public void setTravelCompany(TravelCompany travelCompany) {
    this.travelCompany = travelCompany;
  }

  public LocalTime getTravelTime() {
    return travelTime;
  }

  public void setTravelTime(LocalTime flyTime) {
    this.travelTime = flyTime;
  }

  public LocalDate getTravelDate() {
    return travelDate;
  }

  public void setTravelDate(LocalDate flyDate) {
    this.travelDate = flyDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getTicketCost() {
    return TicketCost;
  }

  public void setTicketCost(Integer flyCost) {
    this.TicketCost = flyCost;
  }

  public String getBusModel() {
    return busModel;
  }

  public void setBusModel(String airplaneModel) {
    this.busModel = airplaneModel;
  }

  public String getSourceCity() {
    return sourceCity;
  }

  public void setSourceCity(String sourceCity) {
    this.sourceCity = sourceCity;
  }

  public String getDestinationCity() {
    return destinationCity;
  }

  public void setDestinationCity(String destinationCity) {
    this.destinationCity = destinationCity;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }


  @Override
  public String toString() {
    return "Fly{" +
      "id=" + id +
      ", flyCost='" + TicketCost + '\'' +
      ", airplaneModel='" + busModel + '\'' +
      ", sourceCity='" + sourceCity + '\'' +
      ", destinationCity='" + destinationCity + '\'' +
      ", flyTime=" + travelTime +
      ", flyDate=" + travelDate +
      ", airLine=" + travelCompany.getName() +
      '}';
  }

  public int compareToFlyCost(Travel o) {
    return this.TicketCost.compareTo(o.TicketCost);
  }

  public int compareToSourceCity(Travel o) {
    return this.sourceCity.compareTo(o.sourceCity);
  }
  public int compareToDesCity(Travel o) {
    return this.destinationCity.compareTo(o.destinationCity);
  }
  public int compareToAirlineCompany(Travel o) {
    return this.travelCompany.getName().compareTo(o.travelCompany.getName());
  }

  @Override
  public int compareTo(Travel o) {
    return 0;
  }
}
