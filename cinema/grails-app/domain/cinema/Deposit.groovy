package cinema

class Deposit {

	String	firstName
	String	lastName
	String	genderDep
	String	addressDep
	String	phoneDep
	String	emailDep

	DataDeposit		dataDeposit
	
	
	static 	belongsTo  = [individual:Individual]
    static constraints = {
    }
}
