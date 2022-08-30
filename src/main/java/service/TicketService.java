package service;

import domain.Ticket;
import domain.User;

import java.util.List;

public interface TicketService extends BaseService<Ticket,Long> {


  List<Ticket> findAllUserTickets(User user);
}
