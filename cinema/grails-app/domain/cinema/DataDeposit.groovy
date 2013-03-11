package cinema

class DataDeposit {

	String idDep
	String numDep
	String timeDep
	String nameDep
	String lnameDep
	String genderDep
	String inDep
	String phoneDep
	String addressDep
	String emailDep
	String statusDep

	static 	belongsTo  = [individual:Individual]

    static constraints = {
    	individual nullable:true
    }
}
