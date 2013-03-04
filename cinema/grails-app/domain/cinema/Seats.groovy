package cinema

class Seats {

	String	seatNumber
	String 	tel

	static belongsTo = [rooms:Rooms,amount:Amount]

    static constraints = {
    	seatNumber nullable:true
    	tel 	nullable:true
    	amount 	nullable:true
    	rooms 	nullable:true 
    }
}
