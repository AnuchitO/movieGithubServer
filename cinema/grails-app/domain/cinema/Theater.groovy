package cinema

class Theater {

    String	theaterId
    
	static hasMany = [shows:Show,seats:Seats,bufferSeats:BufferSeats]
	static belongsTo = [movies:Movie]

    static constraints = {
    	theaterId 	nullable:true
    	shows		nullable:true
    	seats 		nullable:true
    	movies 		nullable:true
    }
}
