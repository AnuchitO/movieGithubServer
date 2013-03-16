package cinema

import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class IndexShowIndividualComposer extends GrailsComposer {

    def afterCompose = { window ->

    	 if (!session['user'])
            redirect(uri:'/login.zul')
        else {
            window.visible = true

            $("#logonName").val(session.user.firstName + " " + session.user.lastName)
           

            $("#logout").on("click", {
                session.user = null
                redirect(uri:'/login.zul')

            })

           
        }

    	  $("#add").on('click',{
    
      Executions.sendRedirect("/indexIndividual.zul");
      })
          $("#logout").on("click", {
                session.user = null
                redirect(uri:'/login.zul')

            })
               		def d = Individual.findAllByVersion(0)
               			for(x in d){
								$('#gid > rows').append{
									row(){ 
                                        int c=x.id
										label(value:x.firstName)
										label(value:x.lastName) 
                                        label(value:x.phone)
										label(value:x.position)
                                        button(label: "Del" ,height: "20",width : "50px",mold:"trendy",onClick : {e ->

                                        def button = e.target
                                         button.parent.detach()
                            
                                         def r = Individual.findById(c)
                                        
                                        
                                        r.delete()
                            
                                     })
										
									}
								}
						}

	$("#movie").on('click',{
    
     	 Executions.sendRedirect("/movieUI.zul");
     	 })
		
		$("#ticket").on('click',{
    
     	 Executions.sendRedirect("/showTimesTicket.zul");
     	 })

		$("#deposite").on('click',{
    
     	 Executions.sendRedirect("/indexDeposit.zul");
     	 })

		$("#maket").on('click',{
    
     	 Executions.sendRedirect("/indexmarket.zul");
     	 })

		

		$("#person").on('click',{
    
     	 Executions.sendRedirect("/indexShowIndividual.zul");
     	 })
			
    }
}
