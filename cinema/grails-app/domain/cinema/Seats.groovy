package cinema

class Seats {

	String	seatNumber
	String 	time

	static belongsTo = [theaters:Theater,amount:Amount]

    static constraints = {
    	seatNumber nullable:true
    	time 	nullable:true
    	amount 	nullable:true    	 
    	theaters nullable:true
    }
}
