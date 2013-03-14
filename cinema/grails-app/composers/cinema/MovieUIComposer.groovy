package cinema

import org.zkoss.zk.grails.composer.*

import cinema.*
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class MovieUIComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here
        $('#logout').on('click',{
            session.user = null
            redirect(uri:'/login.zul')
        })

        //===============================================================================
        // Save new Movie
        //===============================================================================

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
            def pro = $('#promotion').text()
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
                promotion:pro,
                longTime:time    
            )

            if (c.validate()) {
               c.save()

                alert("Save Complite")

                $('#movieId').val("")
                $('#movieType')val("")
                $('#movieName').val("")
                $('#super').val("")
                $('#movieDetail').val("")
                $('#movieCost').val("")
                $('#movieDate').setText("")
                $('#movieDateEnd').setText("")
                $('#pic140').val("")
                $('#pic640').val("")
                $('#promotion').setText("")
                $('#longTime').setText("")

            }else alert("Save False")

            
        })
        //===============================================================================
        // Search Movie
        //===============================================================================

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

        //===============================================================================
        // Add Time
        //===============================================================================
            if(s.longTime<=120){
                $('#show').append{
                    comboitem(label:"09.00")
                    comboitem(label:"11.30")
                    comboitem(label:"14.00")
                    comboitem(label:"16.30")
                    comboitem(label:"19.00")
                    comboitem(label:"21.30")
                }
            } else if(s.longTime>120&&s.longTime<=180){
                $('#show').append{
                    comboitem(label:"09.00")
                    comboitem(label:"12.30")
                    comboitem(label:"16.00")
                    comboitem(label:"19.30")
                    comboitem(label:"22.00")
                }
            }else(s.longTime>180){
                $('#show').append{
                    comboitem(label:"09.00")
                    comboitem(label:"13.00")
                    comboitem(label:"17.00")
                    comboitem(label:"21.00")
                }
            }

        })

        //===============================================================================
        // Save Theater & Show
        //===============================================================================

        def a
        def d
        def c
        def t
        def b

        $('#btnSubmit').on('click',{

            a = $('#theater').text()
            b = $('#show').text()

            if(a=="") {
                alert("Please Selected Theater")
                if(b==""){
                    alert("Please Selected Show")
                }else {
                    t = new Theater(
                    theaterId:a,
                    movie:s
                    )

                    if (t.validate()) {
                       t.save()

                        alert("Save Complite")

                        $('#txtId').val("")
                        $('#txtType').val("")
                        $('#txtName').val("")
                        $('#txtSuperintendent').val("")
                        $('#txtCost').val("")
                        $('#txtDetail').val("")
                        $('#txtDate').val("")
                        $('#txtDateEnd').val("")
                        $('#txtPic').val("")
                        $('#txtTime').val("")

                    }else alert("Save False") 
                }
            }else if (b==""){
                alert("Please Selected Show") 
            }else {
                t = new Theater(
                theaterId:a,
                movie:s
                )

                if (t.validate()) {
                   t.save()

                    alert("Save Complite")

                    $('#txtId').val("")
                    $('#txtType').val("")
                    $('#txtName').val("")
                    $('#txtSuperintendent').val("")
                    $('#txtCost').val("")
                    $('#txtDetail').val("")
                    $('#txtDate').val("")
                    $('#txtDateEnd').val("")
                    $('#txtPic').val("")
                    $('#txtTime').val("")

                }else alert("Save False")                 
            }
        })
    }
}
