package cinema

class Amount {
		Date	date
		String	firstName
		int	price
		Seats	seats
		static 	belongsTo  = [individual:Individual]

    static constraints = {
    }
}
