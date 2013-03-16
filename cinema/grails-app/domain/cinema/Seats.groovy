package cinema

class Seats {

	String	seatNumber
	String 	time
    String  movName
	static belongsTo = [theaters:Theater,amount:Amount]

    static constraints = {
    	seatNumber matches: /[ABCDEFGHIJK]\d{0,2}/
    	time 	nullable:false
    	amount 	nullable:true    	 
    	theaters nullable:false
        movName        nullable:true
    }
}
