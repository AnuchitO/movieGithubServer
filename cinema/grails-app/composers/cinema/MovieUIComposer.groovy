package cinema

import org.zkoss.zk.grails.composer.*

import cinema.Movie
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class MovieUIComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here
        $("#btnSave").on('click',{
            def id = $('#movieId').getText()
            def type = $('#movieType')getText()
            def name = $('#movieName').getText()
            def superp = $('#super').getText()
            def detail = $('#movieDetail').getText()
            def cost = $('#movieCost').getText()
            def date = $('#movieDate').getText()
            def dateE = $('#movieDateEnd').getText()
            def pict140 = $('#pic140').getText()
            def pict640 = $('#pic640').getText()
            def time = $('#longTime').val()

            //alert(pict140)

            def c = new Movie(
                movId:id,
                movType:type,
                movName:name,
                movSuperintendent:superp,
                movDetail:detail,
                movCost:cost,
                movDate:date,
                movDateEnd:dateE,
                movPicture640:pict640,
                movPicture140:pict140,
                longTime:time    
            ).save()
            
        })


        $('#btnSearch').on('click',{

            def g = $('#txtSearch').getText()
            def s = Movie.findByMovId(g)
            $('#txtSearch').val("")
    
            $('#txtId').val(s.movId)
            $('#txtType').val(s.movType)
            $('#txtName').val(s.movName)
            $('#txtSuperintendent').val(s.movSuperintendent)
            $('#txtCost').val(s.movCost)
            $('#txtDetail').val(s.movDetail)
            $('#txtDate').val(s.movDate)
            $('#txtDateEnd').val(s.movDateEnd)
            $('#txtPic')[0].src = s.movPicture140
            $('#txtTime').val(s.longTime)

            $('#btnSubmit').on('click',{

                def a = $('#room').text()

                if(a=="")
                    alert("Please Selected Room")
                else {
                    def r = new Rooms(
                        roomId:a,
                        movie:s
                    ).save()
                }

            })
        })

    }
}
