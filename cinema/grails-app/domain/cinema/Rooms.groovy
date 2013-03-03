package cinema

class Rooms {

	String	roomId

	Movie	movie
	static hasMany = [cycle:Cycle,seats:Seats]

    static constraints = {
    }
}
