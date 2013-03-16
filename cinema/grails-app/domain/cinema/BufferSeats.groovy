package cinema

class BufferSeats {

	String	bSeatNumber
	String 	bTime
	String 	bMovName
	
	static belongsTo = [theaters:Theater]
    static constraints = {

    	bSeatNumber matches: /[ABCDEFGHIJK]\d{0,2}/
		bTime		nullable:false
		theaters		nullable:false
		bMovName		nullable:true
    }

}
