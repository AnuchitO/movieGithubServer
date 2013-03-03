package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen
import org.zkoss.zk.ui.Executions

class IndexDepositComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here

         //println($('#submit'))
       

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
				alert('กรอกข้อมูลเรียบร้อย')

				def s = new DataDeposit()

					s.idDep = ($('#idep').getText())
					s.numDep = ($('#numdep').getText())
					s.timeDep = ($('#time').getText())
					s.nameDep = ($('#name').getText())
					s.lnameDep = ($('#lname').getText())
					s.sexDep = ( $('#gender > radio[checked=true]').getLabel())
					s.inDep = ($('#indep').getText())
					s.phoneDep = ($('#phone').getText())
					s.addressDep = ($('#address').getText())
					s.emailDep = ($('#email').getText())


				s.save()
				//redirect(uri: "indexDeposit.zul")
				def X = DataDeposit.findAll()

				

				$('#grow > row').detach()
				for(f in X){
				
				$('#grow').append{

						row (){

							
							Integer c = f.id

							label( value: f.inDep)
							label( value: f.numDep)
							label( value: f.nameDep)
							label( value: f.lnameDep)
							label( value: f.sexDep)
							label( value: f.addressDep)
							label( value: f.phoneDep)
							label( value: f.emailDep)
							
							button(label: "ลบ" ,height: "20",width : "50px",mold:"trendy",onClick : {e ->

							def button = e.target
							button.parent.detach()
							
							def r = DataDeposit.findById(c)
							
							r.delete()
							
							})
						}
					}
				}

			}
		})
        $('#check').on('click',{

        		def X = DataDeposit.findAll()

				

				$('#grow > row').detach()
				for(f in X){
				
				$('#grow').append{

						row (){

							Integer c = f.id

							label( value: f.inDep)
							label( value: f.numDep)
							label( value: f.nameDep)
							label( value: f.lnameDep)
							label( value: f.sexDep)
							label( value: f.addressDep)
							label( value: f.phoneDep)
							label( value: f.emailDep)
							
							
							button(label: "ลบ" ,height: "20",width : "50px",mold:"trendy",onClick : {e ->

							def button = e.target
							button.parent.detach()
							
							def r = DataDeposit.findById(c)
							
							r.delete()
							
							})
							
						}
					}
				}			
        })       
    }
}
