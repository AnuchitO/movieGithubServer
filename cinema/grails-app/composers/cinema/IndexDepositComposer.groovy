package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zk.ui.Executions

class IndexDepositComposer extends GrailsComposer {

	def depositComet  // inject the IssueCommet 
    
    def lblTest
    def lblBefore
    def lblAfter

    def afterCompose = { window ->
        // initialize components here

         //println($('#submit'))

		

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


		    //depositComet.start()

		$('#submit').on('click',{

			if($('#idep')[0].getText().size()==0||
			   $('#numdep')[0].getText().size()==0||
			   $('#name')[0].getText().size()==0||
			   $('#lname')[0].getText().size()==0||   
			   $('#gender > radio[checked=true]').size()==0||
			   $('#indep')[0].getText().size()==0||
			   $('#time')[0].getText().size()==0||
			   $('#phone')[0].getText().size()==0||
			   $('#email')[0].getText().size()==0||
			   $('#address')[0].getText().size()==0){
			   
				alert('กรอกข้อมูลไม่ครบ')
				
			}

			else{
	
				def s = new DataDeposit()

					s.idDep = ($('#idep').getText())
					s.numDep = ($('#numdep').getText())
					s.timeDep = ($('#time').getText())
					s.nameDep = ($('#name').getText())
					s.lnameDep = ($('#lname').getText())
					s.genderDep = ( $('#gender > radio[checked=true]').getLabel())
					s.inDep = ($('#indep').getText())
					s.phoneDep = ($('#phone').getText())
					s.addressDep = ($('#address').getText())
					s.emailDep = ($('#email').getText())
					s.statusDep = ("no")

					def t=$('#time').getText()
					def b=t.getAt(0..1) as int
					int x=b+3
					s.inTime =x+":00:00"
					
				s.save()

				alert('กรอกข้อมูลเรียบร้อย')

				$('#idep').val(null)
			    $('#numdep').val(null)
			    $('#name').val(null)
			    $('#lname').val(null)
			    $('#gender > radio[checked=true]').val(null)
			    $('#indep').val(null)
			    $('#time').val(null)
			    $('#phone').val(null)
			    $('#email').val(null)
			    $('#address').val(null)
				
				def X = DataDeposit.findAllByStatusDep("no")

				

				$('#grow > row').detach()
				for(f in X){
				
				$('#grow').append{

						row (){

							
							Integer c = f.id

							label( value: f.inDep)
							label( value: f.numDep)
							label( value: f.nameDep)
							label( value: f.lnameDep)
							label( value: f.genderDep)
							label( value: f.addressDep)
							label( value: f.phoneDep)
							label( value: f.inTime)

							
							button(label: "คืน" ,height: "20",width : "50px",mold:"trendy",onClick : {e ->

							def button = e.target
							button.parent.detach()
							
							def r = DataDeposit.findById(c)
							
							r.statusDep = "yes"
							r.save()
							
							})
						}
					}
				}

			}
		})
        $('#check').on('click',{

        		def X = DataDeposit.findAllByStatusDep("no")


				$('#grow > row').detach()
				for(f in X){
				
				$('#grow').append{

						row (){

							Integer c = f.id

							label( value: f.inDep)
							label( value: f.numDep)
							label( value: f.nameDep)
							label( value: f.lnameDep)
							label( value: f.genderDep)
							label( value: f.addressDep)
							label( value: f.phoneDep)
							label( value: f.inTime)
							
							
							button(label: "คืน" ,height: "20",width : "50px",mold:"trendy",onClick : {e ->

							def button = e.target
							button.parent.detach()
							
							def r = DataDeposit.findById(c)
							
							r.statusDep = "yes"
							r.save()
							
							})
							
						}
					}
				}			
        })  
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
