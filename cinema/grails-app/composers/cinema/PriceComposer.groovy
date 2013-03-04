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

        }
        def movie1 = new Movie(movType:"Action",movName:"spiderman",)
        def cycle1 = new Cycle(cycTime:"13/12/13",cycDay:"12.30-14.20 น.")
        def rooms1 = new Rooms(roomId:"Room3",movie:movie1,cycle:cycle1)
        def non = new Seats(seatNumber:'k1',tel:"123456",rooms:rooms1)
        
        // initialize components here
        $('#moviename1').val(non.rooms.movie.movName)
        $('#moviename2').val(non.rooms.movie.movType)
        $('#blanch').val("Team13")
        $('#runt').val(non.rooms.cycle.cycTime[0]+" "+"เวลา"+non.rooms.cycle.cycDay[0])
        $('#seat').val(non.seatNumber)
        $('#plant').val(non.rooms.roomId)
        $('#promotion').val("ไม่มีโปรโมชั่น")
        int sumprice = 120;
        $('#sum').val(sumprice)
        $('#IDPnuknanSearch').val("Ironman3")
        $('#namePanukngan').val(session.user.firstName + " " + session.user.lastName)
        $('#livePanukngan').val(session.user.address + " " + session.user.moo + " "+session.user.county)
        $('#telePhPanukngan').val(session.user.phone)

        //=====================================================================================================

        //=====================================================================================================


        $('#send').on('click',{
            $('#mov').val(non.rooms.movie.movName)
            $('#rob').val(non.rooms.cycle.cycTime[0]+" "+"เวลา"+non.rooms.cycle.cycDay[0])
            $('#teenung').val(non.seatNumber)
            $('#rong').val(non.rooms.roomId)
            $('#mony').val(sumprice)

            $('#mov2').val(non.rooms.movie.movName)
            $('#rob2').val(non.rooms.cycle.cycTime[0]+" "+"เวลา"+non.rooms.cycle.cycDay[0])
            $('#teenung2').val(non.seatNumber)
            $('#rong2').val(non.rooms.roomId)
            $('#mony2').val(sumprice)
        	$('#C').setSelected(true)

		})

		$('#clear').on('click',{
        	redirect(uri:'SeatsTicket.zul')
		})

		$('#bak').on('click',{
        	redirect(uri:'SeatsTicket.zul')
		})
        $('#bak2').on('click',{
            $('#B').setSelected(true)
        })
        $('#bun').on('click',{
            redirect(uri:'SeatsTicket.zul')
        })
    }
}
