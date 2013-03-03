package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class LoginComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here
        if (session['user'])
			redirect(uri:'/showTimesTicket.zul')
		else
			window.visible = true
		
		$("#login").on("click", {

        	def user = Individual.findByUserIdAndPassword($("#user").val(), $("#pass").val())
        	if (user) {
        		session.user = user
        		redirect(uri:'/showTimesTicket.zul')
        	}else {
				$("#user").val(null)
				$("#pass").val(null)
			}
        })
        
		
		$("#clear").on("click", {

				$("#user").val(null)
				$("#pass").val(null)
			
        })
    }
}
