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
	String inTime

	static 	belongsTo  = [individual:Individual]

    static constraints = {
     individual nullable:true

     idDep blank: false,unique: true,maxSize: 7
	 numDep blank: false,unique: true,maxSize: 7    
	 timeDep blank: false
	 nameDep blank: false
	 lnameDep blank: false
	 genderDep blank: false
	 inDep blank: false
	 phoneDep blank: false
	 addressDep blank: false
	 emailDep blank: false,minSize: 11
	 statusDep blank: false

    }
}
