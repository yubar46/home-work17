package repository;

import domain.Ticket;

import javax.persistence.EntityManager;

public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket,Long> implements TicketRepository {
  public TicketRepositoryImpl(EntityManager entityManager) {
    super(entityManager);
  }

  @Override
  Class<Ticket> getClassObject() {
    return Ticket.class;
  }
}
