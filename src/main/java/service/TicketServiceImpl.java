package service;

import domain.Ticket;
import domain.User;
import repository.TicketRepository;

import java.util.List;

public class TicketServiceImpl extends BaseServiceImpl<Ticket,Long, TicketRepository> implements TicketService  {

  public TicketServiceImpl(TicketRepository repository) {
    super(repository);
  }

  @Override
  public List<Ticket> findAllUserTickets(User user) {
    return repository.getEntityManager().
      createQuery("select t from Ticket  t where t.user=:user",Ticket.class).
      setParameter("user",user).getResultList();
  }
}
