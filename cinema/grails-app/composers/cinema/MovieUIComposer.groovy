package cinema

import org.zkoss.zk.grails.composer.*

import cinema.Movie
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class MovieUIComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here
        $("#btnSave").on('click',{
            alert("hello")
            })
        /*def id = $('#movieId').getText()
            def type = $('#moveType').getText()
            def name = $('#moviename').getText()
            def superp = $('#super').getText()
            def detail = $('#movieDetail').getText()
            def cost = $('#movieCost').getText()
            def date = $('#movieDate').getText()
            def dateE = $('#movieDateEnd').getText()
            def pic146 = $('#pic140').getText()
            def pic640 = $('#pic640').getText()
            def time = $('#longtime').val()*/


            /*def m = new Movie(
                movieId :id,
                movType :type,
                movName :name,
                movSuperintendent :superp,
                movDetail :detail,
                movCost :cost,
                movDate :date,
                movDateEnd :dateE,
                movPicture640 :pic140,
                movPicture140 :pic640,
                longTime :time 
            ).save()*/
    }
}
