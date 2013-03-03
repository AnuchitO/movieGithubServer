package cinema

class Seats {

	String	seatNumber
	String 	tel

	Amount	amount

	static belongsTo = [rooms:Rooms]

	

    static constraints = {
    	seatNumber nullable:true
    	tel nullable:true
    	amount 	nullable:true
    	rooms 	nullable:true 
    }
}
