package cinema

class Cycle {

	String	cycId
	String 	cycTime
	



	static  belongsTo = [rooms:Rooms]

    static constraints = {
    }
}
