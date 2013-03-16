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
	static hasMany = [theaters: Theater,shows:Show]
	
    static constraints = {

    	movId 			blank:false,matches:/\d{4}/
    	movName			blank:false
    	longTime		null:false
    	movPicture640	nullable:true
		movPicture140	nullable:true


    }
}
