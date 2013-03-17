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

    	price 				blank:false,matches:/\d/
    	name				blank:false
    	movieName			blank:false
    	showtime			blank:false
    	theaTer				blank:false
    	seat 				blank:false

    	seats 				nullable:true
    	individual 			nullable:true

    }
}
