package cinema

class Theater {

    String	theaterId
    
	static hasMany = [shows:Show,seats:Seats,bufferSeats:BufferSeats]
	static belongsTo = [movies:Movie]

    static constraints = {
    	theaterId 	blank:false,matches:/\d{1}/ 		
    	movies 		nullable:false
    }
}
