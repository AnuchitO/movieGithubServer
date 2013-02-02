package cinema

class Amount {
		Date	date
		String	firstName
		String	price


		Seats	seats
		
		static 	belongsTo  = [individual:Individual]

    static constraints = {
    }
}
