package cinema

class Seats {

	String	seatNumber
	String 	time

	static belongsTo = [theaters:Theater,rooms:Rooms,amount:Amount]

    static constraints = {
    	seatNumber nullable:true
    	time 	nullable:true
    	amount 	nullable:true
    	rooms 	nullable:true 
    }
}
