package context;

import domain.Travel;
import domain.TravelCompany;
import domain.User;
import repository.*;
import service.*;
import util.HibernateUtil;

import javax.persistence.EntityManager;

public class ApplicationContext {

  public static ApplicationContext Instance = new ApplicationContext();
  private EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
  private PassengerRepository passengerRepository = new PassengerRepositoryImpl(entityManager);
  private TravelRepository travelRepository = new TravelRepositoryImpl(entityManager);
  private BankCardRepository bankCardRepository = new BankCardRepositoryImpl(entityManager);
  private TravelCompanyRepository travelCompanyRepository = new TravelCompanyRepositoryImpl(entityManager);
  private UserService userService = new UserServiceImpl(passengerRepository);
  private TravelService travelService = new TravelServiceImpl(travelRepository);
  private TravelCompanyService travelCompanyService = new TravelCompanyServiceImpl(travelCompanyRepository);
  private BankCardService bankCardService = new BankCardServiceImpl(bankCardRepository);
  private TicketRepository ticketRepository = new TicketRepositoryImpl(entityManager);
  private TicketService ticketService = new TicketServiceImpl(ticketRepository);
  private User user ;
   private Travel travel;

  public Travel getTravel() {
    return travel;
  }

  public void setTravel(Travel travel) {
    this.travel = travel;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public TicketRepository getTicketRepository() {
    return ticketRepository;
  }

  public void setTicketRepository(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  public TicketService getTicketService() {
    return ticketService;
  }

  public void setTicketService(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  public TravelCompany getTravelCompany() {
    return travelCompany;
  }

  public void setTravelCompany(TravelCompany travelCompany) {
    this.travelCompany = travelCompany;
  }

  private TravelCompany travelCompany;

  public static ApplicationContext getInstance() {
    return Instance;
  }

  public static void setInstance(ApplicationContext instance) {
    ApplicationContext.Instance = instance;
  }

  public PassengerRepository getPassengerRepository() {
    return passengerRepository;
  }

  public void setPassengerRepository(PassengerRepository passengerRepository) {
    this.passengerRepository = passengerRepository;
  }

  public TravelRepository getTravelRepository() {
    return travelRepository;
  }

  public void setTravelRepository(TravelRepository travelRepository) {
    this.travelRepository = travelRepository;
  }

  public TravelCompanyRepository getTravelCompanyRepository() {
    return travelCompanyRepository;
  }

  public void setTravelCompanyRepository(TravelCompanyRepository travelCompanyRepository) {
    this.travelCompanyRepository = travelCompanyRepository;
  }

  public UserService getUserService() {
    return userService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public TravelService getTravelService() {
    return travelService;
  }

  public void setTravelService(TravelService travelService) {
    this.travelService = travelService;
  }

  public TravelCompanyService getTravelCompanyService() {
    return travelCompanyService;
  }

  public void setTravelCompanyService(TravelCompanyService travelCompanyService) {
    this.travelCompanyService = travelCompanyService;
  }

  public BankCardRepository getBankCardRepository() {
    return bankCardRepository;
  }

  public void setBankCardRepository(BankCardRepository bankCardRepository) {
    this.bankCardRepository = bankCardRepository;
  }

  public BankCardService getBankCardService() {
    return bankCardService;
  }

  public void setBankCardService(BankCardService bankCardService) {
    this.bankCardService = bankCardService;
  }

  private ApplicationContext() {

  }


  public EntityManager getEntityManager() {
    return entityManager;
  }

  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

}
