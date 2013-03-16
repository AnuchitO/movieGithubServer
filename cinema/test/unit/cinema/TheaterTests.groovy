package cinema


import cinema.Movie
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Theater)
class TheaterTests {

	def m = new Movie()

    void testTheaterDomain() {

       def a = new Theater(theaterId:"1",movies:m)
       assert a.theaterId == "1"
       assert a.movies == m

       assert a.validate() == true
    }

    //=====================================================================================
    // Blank Test
    //=====================================================================================
    void testNullTheaterId() {

       def a = new Theater(theaterId:"",movies:m)

       assert a.validate() == false
    }

    void testNullMovies() {

       def a = new Theater(theaterId:"1")

       assert a.validate() == false
    }

    //=====================================================================================
    // Matches Digit Test
    //=====================================================================================
    void testMoreDigit() {

       def a = new Theater(theaterId:"11",movies:m)

       assert a.validate() == false
    }

    void testNonDigit() {

       def a = new Theater(theaterId:"a",movies:m)

       assert a.validate() == false
    }
}
