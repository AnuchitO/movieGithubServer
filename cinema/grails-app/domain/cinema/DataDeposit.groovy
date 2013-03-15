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

     idDep blank: false,unique: true,maxSize: 7
	 numDep blank: false,unique: true,maxSize: 7    
	 timeDep blank: false,unique: true
	 nameDep blank: false,unique: true
	 lnameDep blank: false,unique: true
	 genderDep blank: false,unique: true
	 inDep blank: false,unique: true
	 phoneDep blank: false,unique: true
	 addressDep blank: false,unique: true
	 emailDep blank: false,unique: true,minSize: 11
	 statusDep blank: false,unique: true,maxSize: 11

    }
}
