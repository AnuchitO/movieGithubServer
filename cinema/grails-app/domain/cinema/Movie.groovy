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
	Integer	longTime
	static hasOne = [rooms: Rooms]
	static hasMany = [theaters: Theater]
	
    static constraints = {

	movId 		 			nullable:true
 	movType 				nullable:true
 	movName 				nullable:true
 	movSuperintendent 		nullable:true
 	movDetail 				nullable:true
 	movCost 				nullable:true
 	movDate 				nullable:true
	movDateEnd 				nullable:true
 	movPicture640 			nullable:true
 	movPicture140 			nullable:true
	longTime	 			nullable:true
	rooms 					nullable:true
    }
}
