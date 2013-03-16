package cinema



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Individual)
class IndividualTests {

    void testSomething() {
       def individual = new Individual(firstName:"A",lastName:"B",userId:"user")
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
    void testUserIdCannotBeBlank(){
    	def individual = new Individual(firstName:"A",lastName:"B",userId:"")
    	assert individual.validate()==false
    }
}
