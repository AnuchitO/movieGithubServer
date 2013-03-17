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
	static hasMany = [theaters: Theater,shows:Show]
	
    static constraints = {

    	movId 				blank:false,matches:/\d{4}/,unique:true
    	movType				blank:false
    	movName				blank:false,unique:true
    	movSuperintendent	blank:false
    	movDetail			blank:false
    	movCost				blank:false,matches:/\d{4,7}[k]/
    	movDate 			blank:false
    	movDateEnd 			blank:false
    	movPicture640		nullable:true
		movPicture140		nullable:true
		promotion 			blank:false
		longTime			null:false,matches:/\d/
		
    }
}
