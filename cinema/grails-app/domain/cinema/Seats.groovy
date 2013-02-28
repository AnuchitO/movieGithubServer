package cinema

class Seats {

	String	seatNumber
	String 	tel

	Amount	amount

	static belongsTo = [rooms:Rooms]

	

    static constraints = {
    }
}
