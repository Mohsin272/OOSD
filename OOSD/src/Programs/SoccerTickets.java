package Programs;

public class SoccerTickets {

	public static void main(String[] args) {
		
		Ticket soccerTicket1=new Ticket();
		Ticket soccerTicket2=new Ticket();
		
		System.out.println("Tickets Sold: "+ Ticket.getNoTicketsSold());
		
		System.out.println(soccerTicket1.getInfo());
		System.out.println(soccerTicket2.getInfo());
		
		
	}

}
