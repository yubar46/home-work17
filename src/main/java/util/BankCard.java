package util;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class BankCard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long CardBalance;
    @Column(length = 4, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "2587")
    private Integer cvv2;
    @Column(name = "second_password")
    private String SecondPassword;
    @Column(name = "expire_date", columnDefinition = "date")
    LocalDate expireDate;

    @Column(name = "is_active",columnDefinition =  "tinyint default true")
    boolean active =true;

    public BankCard() {
        this.expireDate = LocalDate.now().plusYears(2);


    }

  public Long getCardBalance() {
    return CardBalance;
  }

  public void setCardBalance(Long cardBalance) {
    CardBalance = cardBalance;
  }

  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCvv2() {
        return cvv2;
    }

    public void setCvv2(Integer cvv2) {
        this.cvv2 = cvv2;
    }

    public String getSecondPassword() {
        return SecondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        SecondPassword = secondPassword;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
