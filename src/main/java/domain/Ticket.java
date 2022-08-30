package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ticket  implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @ManyToOne
 private User user;

  @ManyToOne
  private Travel travel;

  private String passengerFullName;
  private  Gender passengerSex;

  public String getPassengerFullName() {
    return passengerFullName;
  }

  public void setPassengerFullName(String passengerFullName) {
    this.passengerFullName = passengerFullName;
  }

  public Gender getPassengerSex() {
    return passengerSex;
  }

  public void setPassengerSex(Gender passengerSex) {
    this.passengerSex = passengerSex;
  }

  public Ticket() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Travel getTravel() {
    return travel;
  }

  public void setTravel(Travel travel) {
    this.travel = travel;
  }
}
