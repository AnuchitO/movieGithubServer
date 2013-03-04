package cinema

import org.zkoss.zk.grails.composer.*

import cinema.Movie
import cinema.Rooms
import cinema.Cycle
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class MovieUIComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here
        $('#logout').on('click',{
            session.user = null
            redirect(uri:'/login.zul')
        })

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
        
        def g
        def s

        $('#btnSearch').on('click',{

            g = $('#txtSearch').getText()
            s = Movie.findByMovId(g)
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

        })

        def a
        def d
        def c
        def r

        $('#btnSubmit').on('click',{

            a = $('#room').text()

            if(a=="")
                alert("Please Selected Room")
            else {
                d = Rooms.findByRoomId(a)
                d.delete()

                r = new Rooms(
                    roomId:a,
                    movie:s
                ).save()

                if(s.longTime>=100&&s.longTime<=120){
                    c = new Cycle(
                        cycTime:"09.00-11.00",
                        rooms:r
                    ).save()

                    c = new Cycle(
                        cycTime:"11.30-13.30",
                        rooms:r
                    ).save()

                    c = new Cycle(
                        cycTime:"14.00-16.00",
                        rooms:r
                    ).save()

                    c = new Cycle(
                        cycTime:"16.30-18.30",
                        rooms:r
                    ).save()

                    c = new Cycle(
                        cycTime:"19.00-21.00",
                        rooms:r
                    ).save()

                    c = new Cycle(
                        cycTime:"21.30-23.30",
                        rooms:r
                    ).save()
                }else if(s.longTime>120&&s.longTime<=180){
                    c = new Cycle(
                        cycTime:"09.00-12.00",
                        rooms:r
                    ).save()

                    c = new Cycle(
                        cycTime:"12.30-15.30",
                        rooms:r
                    ).save()

                    c = new Cycle(
                        cycTime:"16.00-19.00",
                        rooms:r
                    ).save()

                    c = new Cycle(
                        cycTime:"19.30-22.30",
                        rooms:r
                    ).save()

                }else(s.longTime>180){
                    c = new Cycle(
                        cycTime:"09.00-12.30",
                        rooms:r
                    ).save()

                    c = new Cycle(
                        cycTime:"13.00-16.30",
                        rooms:r
                    ).save()

                    c = new Cycle(
                        cycTime:"17.00-20.30",
                        rooms:r
                    ).save()

                    c = new Cycle(
                        cycTime:"21.00-00.30",
                        rooms:r
                    ).save()
                }
            }

        })
    }
}
