package cinema

class DataDeposit {

	String idDep
	String numDep
	String timeDep
	String nameDep
	String lnameDep
	String sexDep
	String inDep
	String phoneDep
	String addressDep
	String emailDep

	static 	belongsTo  = [individual:Individual]

    static constraints = {
    	individual nullable:true
    }
}
