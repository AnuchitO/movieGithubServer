package cinema

class Rooms {

	String	roomId

	Movie	movie
	static hasMany = [cycle:Cycle,seats:Seats]

    static constraints = {
    	roomId 	nullable:true
    	cycle 	nullable:true
    	seats 	nullable:true
    	movie 	nullable:true
    	cycle 	nullable:true
    	seats 	nullable:true
    }
}
