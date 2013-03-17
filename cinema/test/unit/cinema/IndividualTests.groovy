package cinema



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Individual)
class IndividualTests {

    void testIndividual() {
       def individual = new Individual(firstName:"A",
          lastName:"B",
          number:"1234567890123",
          date:"mm/dd/yy",
          status:"single",
          address:"address",
          moo:"12",
          district:"district",
          canton:"canton",
          county:"county",
          post:"30000",
          phone:"1234567890",
          degree:"degree",
          major:"major",
          university:"university",
          position:"position",
          userId:"user",
          password:"password",
          rePassword:"rePassword")
       assert individual.firstName=="A"
       assert individual.lastName=="B"
       individual.validate()==true 
    }
    void testFirstNameCannotBeBlank(){
    	def individual = new Individual(firstName:"",lastName:"B")
    	assert individual.validate()==false
    }
    void testLastNameCannotBeBlank(){
    	def individual = new Individual(firstName:"A",lastName:"")
    	assert individual.validate()==false
    }
    void testNumber(){
    	def individual = new Individual(firstName:"A",lastName:"B",number:"1234567890ABC")
    	assert individual.validate()==false
    }
    void testDateCannotBeBlank(){
      def individual = new Individual(firstName:"A",lastName:"B",date:"")
      assert individual.validate()==false
    }
    void testStatusCannotBeBlank(){
      def individual = new Individual(firstName:"A",lastName:"B",status:"")
      assert individual.validate()==false
    }
    void testMooCannotBeBlank(){
      def individual = new Individual(firstName:"A",lastName:"B",moo:"")
      assert individual.validate()==false
    }
    void testAddressCannotBeBlank(){
      def individual = new Individual(firstName:"A",lastName:"B",address:"")
      assert individual.validate()==false
    }
    void testDistrictCannotBeBlank(){
      def individual = new Individual(firstName:"A",lastName:"B",district:"")
      assert individual.validate()==false
    }
    void testCantonCannotBeBlank(){
      def individual = new Individual(firstName:"A",lastName:"B",canton:"")
      assert individual.validate()==false
    }
    void testCountyCannotBeBlank(){
      def individual = new Individual(firstName:"A",lastName:"B",county:"")
      assert individual.validate()==false
    }
    void testPost(){
      def individual = new Individual(firstName:"A",lastName:"B",post:"3000")
      assert individual.validate()==false
    }
    void testPhone(){
      def individual = new Individual(firstName:"A",lastName:"B",post:"123456789")
      assert individual.validate()==false
    }
    void testDegreeCannotBeBlank(){
      def individual = new Individual(firstName:"A",lastName:"B",degree:"")
      assert individual.validate()==false
    }
    void testMajorCannotBeBlank(){
      def individual = new Individual(firstName:"A",lastName:"B",major:"")
      assert individual.validate()==false
    }
    void testUniversityCannotBeBlank(){
      def individual = new Individual(firstName:"A",lastName:"B",university:"")
      assert individual.validate()==false
    }
    void testPositionCannotBeBlank(){
      def individual = new Individual(firstName:"A",lastName:"B",position:"")
      assert individual.validate()==false
    }
    void testCharactorUnique(){
      def individual = new Individual(firstName:"A",lastName:"B",userId:"user")
      individual.save()
      def individual2 = new Individual(firstName:"A",lastName:"B",studentId:"user")
      assert individual2.validate()==false

    }
    void testPasswordCannotBeBlank(){
      def individual = new Individual(firstName:"A",lastName:"B",password:"")
      assert individual.validate()==false
    }
    void testRePasswordCannotBeBlank(){
      def individual = new Individual(firstName:"A",lastName:"B",rePassword:"")
      assert individual.validate()==false
    }

}
