package cinema

import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.Executions
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
        		if(user.position=="Ticker"){
	        		session.user = user
	        		redirect(uri:'/showTimesTicket.zul')
        		}
        		if(user.position=="Market"){
	        		session.user = user
	        		redirect(uri:'/indexmarket.zul')
        		}
        		if(user.position=="Room"){
	        		session.user = user
	        		redirect(uri:'/movieUI.zul')
        		}
        		if(user.position=="Deposit"){
	        		session.user = user
	        		redirect(uri:'/indexDeposit.zul')
        		}
        	}else {
				$("#user").val(null)
				$("#pass").val(null)
			}
        })
       $("#register").on('click',{
    
      Executions.sendRedirect("/indexIndividual.zul");
      })
        
		
		$("#clear").on("click", {

				$("#user").val(null)
				$("#pass").val(null)
			
        })
    }
}
