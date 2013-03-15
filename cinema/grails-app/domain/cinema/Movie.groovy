package cinema

class Movie {

	String	movId
	String 	movType
	String 	movName
	String 	movSuperintendent
	String 	movDetail
	String 	movCost
	String 	movDate
	String	movDateEnd
	String 	movPicture640
	String 	movPicture140
	String	promotion
	Integer	longTime
	//static hasOne = [rooms: Rooms]
	static hasMany = [theaters: Theater]
	
    static constraints = {

    	movId 		blank:false,matches:/\d{4}/
    	movName		blank:false
    	longTime	null:false

    }
}
