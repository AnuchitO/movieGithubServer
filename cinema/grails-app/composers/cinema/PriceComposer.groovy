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
        // initialize components here
        $('#moviename1').val("Ironman3")
        $('#moviename2').val("Ironman3")
        $('#blanch').val("Ironman3")
        $('#runt').val("Ironman3")
        $('#seat').val("Ironman3")
        $('#plant').val("Ironman3")
        $('#promotion').val("Ironman3")
        $('#sum').val("Ironman3")
        $('#IDPnuknanSearch').val("Ironman3")
        $('#namePanukngan').val(session.user.firstName + " " + session.user.lastName)
        $('#livePanukngan').val(session.user.address + " " + session.user.moo + " "+session.user.county)
        $('#telePhPanukngan').val(session.user.phone)


        $('#send').on('click',{
        	$('#C').setSelected(true)
		})

		$('#clear').on('click',{
        	redirect(uri:'SeatsTicket.zul')
		})

		$('#bak').on('click',{
        	redirect(uri:'SeatsTicket.zul')
		})
    }
}
