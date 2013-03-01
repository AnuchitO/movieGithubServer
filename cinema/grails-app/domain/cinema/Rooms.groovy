package cinema

class Rooms {

	String	roomId
	String 	roomName

	Movie	movie
	static hasMany = [cycle:Cycle,seats:Seats]

    static constraints = {
    }
}
