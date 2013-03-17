package cinema



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Movie)
class MovieTests {

    void testSomething() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)	
   		assert a.movId=="0001"
	 	assert a.movType=="Action"
	 	assert a.movName=="XXX"
	 	assert a.movSuperintendent=="OD Chotichai"
	 	assert a.movDetail=="Mafia"
	 	assert a.movCost=="2000k"
	 	assert a.movDate=="1/1/1111"
		assert a.movDateEnd=="1/2/1111"
		assert a.movPicture640=="???"
		assert a.movPicture140=="???"
		assert a.promotion=="Empty"
		assert a.longTime==120

		assert a.validate() == true
   	}

   	//=================================================================================================
   	// Blank Test
   	//=================================================================================================
   	void testMovIdNull() {
   		def a = new Movie(
   			movId:"",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)

   		assert a.validate() == false
   	}

   	void testMovTypeNull() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)

   		assert a.validate() == false
   	}

   	void testMovNameNull() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)

   		assert a.validate() == false
   	}

   	void testMovSupNull() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)

   		assert a.validate() == false
   	}

   	void testMovDetailNull() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)

   		assert a.validate() == false
   	}

   	void testMovCostNull() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)

   		assert a.validate() == false
   	}

   	void testMovDateNull() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)

   		assert a.validate() == false
   	}

   	void testMovDateEndNull() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)

   		assert a.validate() == false
   	}

   	void testPromotionNull() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"",
			longTime:120
   		)

   		assert a.validate() == false
   	}

   	void testLongTimeNull() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
   		)

   		assert a.validate() == false
   	}

   	//=================================================================================================
   	// 4 Digit Only for ID Test
   	//=================================================================================================
   	void testDigitMovId() {
   		def a = new Movie(
   			movId:"00a01",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)

   		assert a.validate() == false
   	}

   	//=================================================================================================
   	// Digit M for Cost Test
   	//=================================================================================================
   	void testDigitCost() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"AB",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)	

   		assert a.validate() == false
   	}

   	//=================================================================================================
   	// Digit for Time Test
   	//=================================================================================================
   	void testDigitTime() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:"AAA"
   		)	

   		assert a.validate() == false
   	}

   	//=================================================================================================
   	// Unique Test
   	//=================================================================================================
   	void testUniqueId() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		).save()

   		def b = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"YYY",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)

   		assert b.validate() == false
   	}

   	void testUniqueName() {
   		def a = new Movie(
   			movId:"0001",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		).save()

   		def b = new Movie(
   			movId:"0002",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)

   		assert b.validate() == false
   	}
}