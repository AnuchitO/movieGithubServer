package cinema

class Amount {
		int		price
		String	name
		String  movieName
		String	showtime
		String	theaTer
		String	seat
		

		static hasMany = [seats: Seats]
		static 	belongsTo  = [individual:Individual]

    static constraints = {
    	price 	nullable:true
    	seats 	nullable:true
    	individual nullable:true

    }
}
