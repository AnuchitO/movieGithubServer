package cinema

class BufferSeats {

	String	bSeatNumber
	String 	bTime
	String 	bMovName
	
	static belongsTo = [theaters:Theater]
    static constraints = {

    	bSeatNumber nullable:true
		bTime		nullable:true
		theaters		nullable:true
		bMovName		nullable:true
    }

}
