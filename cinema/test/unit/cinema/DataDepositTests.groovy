package cinema



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DataDeposit)
class DataDepositTests {

    void testSetting() {

    
    def a = new DataDeposit(
	     idDep:"ID-1234",
		 numDep:"No.0001",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-1234567",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes",
		 inTime:""
	    )
	     assert a.idDep=="ID-1234"
		 assert a.numDep=="No.0001"
		 assert a.timeDep=="13:00:00"
		 assert a.nameDep=="Masker"
		 assert a.lnameDep=="Watermark"
		 assert a.genderDep=="ชาย"||"หญิง"		 
		 assert a.inDep=="1/1/2556"
		 assert a.phoneDep=="080-1234567"
		 assert a.addressDep=="111 ถนนมุกดาอุทิศ"
		 assert a.emailDep=="aabba@hotmail.com"
		 assert a.statusDep=="no"||"yes"
		 assert	a.inTime==""
		 assert a.validate()==true
	}

	void testidDepNull() {

	    def a = new DataDeposit(
	     idDep:"",
		 numDep:"No.0001",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-1234567",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes"
	    )
	    assert a.validate()==false	
	}
	
	void testnumDepNull() {

	    def a = new DataDeposit(
	     idDep:"ID-1234",
		 numDep:"",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-1234567",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes"
	    )
	    assert a.validate()==false	
	}

	void testtimeDepNull() {

	    def a = new DataDeposit(
	     idDep:"ID-1234",
		 numDep:"No.0001",
		 timeDep:"",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-1234567",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes"
	    )
	    assert a.validate()==false	
	}

	void testnameDepNull() {

	    def a = new DataDeposit(
	     idDep:"ID-1234",
		 numDep:"No.0001",
		 timeDep:"13:00:00",
		 nameDep:"",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-1234567",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes"||"yes"
	    )
	    assert a.validate()==false	
	}

	void testlnameDepNull() {

	    def a = new DataDeposit(
	     idDep:"ID-1234",
		 numDep:"No.0001",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-1234567",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes"
	    )
	    assert a.validate()==false	
	}

	void testgenderDepNull() {

	    def a = new DataDeposit(
	     idDep:"ID-1234",
		 numDep:"No.0001",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"",
		 inDep:"1/1/2556",
		 phoneDep:"080-1234567",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes"
	    )
	    assert a.validate()==false	
	}

	void testinDepNull() {

	    def a = new DataDeposit(
	     idDep:"ID-1234",
		 numDep:"No.0001",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"",
		 phoneDep:"080-1234567",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes"
	    )
	    assert a.validate()==false	
	}

	void testphoneDepNull() {

	    def a = new DataDeposit(
	     idDep:"ID-1234",
		 numDep:"No.0001",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes"
	    )
	    assert a.validate()==false	
	}

	void testaddressDepNull() {

	    def a = new DataDeposit(
	     idDep:"ID-1234",
		 numDep:"No.0001",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-1234567",
		 addressDep:"",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes"
	    )
	    assert a.validate()==false	
	}

	void testemailDepNull() {

	    def a = new DataDeposit(
	     idDep:"ID-1234",
		 numDep:"No.0001",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-1234567",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"",
		 statusDep:"no"||"yes"
	    )
	    assert a.validate()==false	
	}

	void teststatusDepNull() {

	    def a = new DataDeposit(
	     idDep:"ID-1234",
		 numDep:"No.0001",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-1234567",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:""
	    )
	    assert a.validate()==false	
	}

	void testDataNotDuliplicate() {

	    def a = new DataDeposit(
	     idDep:"ID-1234",
		 numDep:"No.0001",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-1234567",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes"
	    )
	    a.save()

	    def b = new DataDeposit(
	     idDep:"ID-1234",
		 numDep:"No.0001",
		 
		 
	    )
	    b.save()

	    assert b.validate()==false
	}

	void testmaxSizeidDep() {

	    def a = new DataDeposit(
	     idDep:"ID-12345",
		 numDep:"No.0001",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-1234567",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes"
	    )
	    assert a.validate()==false	
	}

	void testmaxSizenumDep() {

	    def a = new DataDeposit(
	     idDep:"ID-12345",
		 numDep:"No.00012",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-1234567",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes"
	    )
	    assert a.validate()==false	
	}

	void testmaxSizephoneDep() {

	    def a = new DataDeposit(
	     idDep:"ID-12345",
		 numDep:"No.00012",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-123456789",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"aabba@hotmail.com",
		 statusDep:"no"||"yes"
	    )
	    assert a.validate()==false	
	}

	void testminSizeemailDep() {

	    def a = new DataDeposit(
	     idDep:"ID-12345",
		 numDep:"No.00012",
		 timeDep:"13:00:00",
		 nameDep:"Masker",
		 lnameDep:"Watermark",
		 genderDep:"ชาย"||"หญิง",
		 inDep:"1/1/2556",
		 phoneDep:"080-123456789",
		 addressDep:"111 ถนนมุกดาอุทิศ",
		 emailDep:"a@mail.com",
		 statusDep:"no"||"yes"
	    )
	    assert a.validate()==false	
	}

	
	    
}
