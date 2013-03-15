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
		 	movCost:"2M",
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
	 	assert a.movCost=="2M"
	 	assert a.movDate=="1/1/1111"
		assert a.movDateEnd=="1/2/1111"
		assert a.movPicture640=="???"
		assert a.movPicture140=="???"
		assert a.promotion=="Empty"
		assert a.longTime==120

		assert a.validate() == true
   	}

   	void testMovIdNull() {
   		def a = new Movie(
   			movId:"",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2M",
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
		 	movCost:"2M",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
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
		 	movCost:"2M",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
   		)

   		assert a.validate() == false
   	}

   	void testDigitMovId() {
   		def a = new Movie(
   			movId:"00a01",
		 	movType:"Action",
		 	movName:"XXX",
		 	movSuperintendent:"OD Chotichai",
		 	movDetail:"Mafia",
		 	movCost:"2M",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
			movPicture640:"???",
		 	movPicture140:"???",
			promotion:"Empty",
			longTime:120
   		)

   		assert a.validate() == false
   	}
}
