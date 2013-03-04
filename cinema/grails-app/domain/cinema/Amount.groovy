package cinema

class Amount {
		int		price
		String	name
		String  movie1
		String	rop
		String	rong
		String	sit
		

		static hasMany = [seats: Seats]
		static 	belongsTo  = [individual:Individual]

    static constraints = {
    	price 	nullable:true
    	seats 	nullable:true
    	individual nullable:true

    }
}
