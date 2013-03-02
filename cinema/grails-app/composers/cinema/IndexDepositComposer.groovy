package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

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
				alert('OK')

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

			

			}
		})
        
    }
}
