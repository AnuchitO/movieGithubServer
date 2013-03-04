package cinema

class Amount {
		Date	date
		int		price

		static hasMany = [seats: Seats]
		static 	belongsTo  = [individual:Individual]

    static constraints = {
    	date 	nullable:true
    	price 	nullable:true
    	seats 	nullable:true
    	individual nullable:true

    }
}
