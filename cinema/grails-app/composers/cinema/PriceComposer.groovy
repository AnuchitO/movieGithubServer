package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class PriceComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here
        if (!session['user'])
            redirect(uri:'/login.zul')
        else {
            window.visible = true

            $("#nameBuncee").val(session.user.firstName + " " + session.user.lastName)
            $("#nameBuncee2").val(session.user.firstName + " " + session.user.lastName)
            $("#nameBuncee3").val(session.user.firstName + " " + session.user.lastName)
           

            $("#logOut").on("click", {
                session.user = null
                redirect(uri:'/login.zul')

            })

            $("#logOut2").on("click", {
                session.user = null
                redirect(uri:'/login.zul')

            })

            $("#logOut3").on("click", {
                session.user = null
                redirect(uri:'/login.zul')

            })

            //==============================================================
        def results = Amount.findAll()
        
        int sumpri = 0;
        int i =0;
        if(results){
                //$("grid > rows").detach()
                for(c in results)
                    $("grid > rows").append{
                                row{
                                    label(value:c.movie1)
                                    label(value:c.rop)
                                    label(value:c.rong)
                                    label(value:c.sit)
                                    label(value:c.price)
                                    i++
                                }
                    }
        }
        sumpri = 120*i;

        //===============================================================
        //def movie = new Movie(movType:"Action",movName:"spiderman")
        //def cycle = new Cycle(cycTime:"12.00-13.00 น.")
        //def rooms = new Rooms(roomId:"Room3",movie:movie,cycle:cycle)
        //def non = new Seats(seatNumber:'k1',tel:"123456",rooms:rooms)
        def non = session.namepp
        def rooms = session.namepp2
        // initialize components here
        $('#moviename1').val()
        $('#moviename2').val()
        $('#blanch').val("Team13")
        $('#runt').val()
        $('#seat').val()
        $('#plant').val()
        $('#promotion').val("ไม่มีโปรโมชั่น")
        int sumprice = 120;
        $('#sum').val()
        $('#IDPnuknanSearch').val()
        $('#namePanukngan').val(session.user.firstName + " " + session.user.lastName)
        $('#livePanukngan').val(session.user.address + " " + session.user.moo + " "+session.user.county)
        $('#telePhPanukngan').val(session.user.phone)

        //=====================================================================================================
    

        
        //=====================================================================================================


        $('#send').on('click',{
            $('#mov').val('')
            $('#rob').val('')
            $('#teenung').val('')
            $('#rong').val('')
            $('#mony').val('')

            $('#mov2').val('')
            $('#rob2').val('')
            $('#teenung2').val('')
            $('#rong2').val('')
            $('#mony2').val('')
            $('#C').setSelected(true)
         //====================================================================================================   
            //def amount = new Amount(
            //    price:sumprice,
            //    name:session.user.firstName + " " + session.user.lastName,
            //    movie1:rooms.movie.movName,
            //    rop:non.time,
            //    rong:rooms.roomId,
            //    sit:non.seatNumber,
            //    seats:non,
            //    individual:session.user
            //    )
            //amount.save()
        //===================================================================================================
        })

        $('#clear').on('click',{
            redirect(uri:'showTimesTicket.zul')
        })

        $('#bak').on('click',{
            redirect(uri:'showTimesTicket.zul')
        })
        $('#bak2').on('click',{
            $('#B').setSelected(true)
        })
        $('#bun').on('click',{
            redirect(uri:'showTimesTicket.zul')
        })
        

        }
        
    }
}
