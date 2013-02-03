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
			   $('#sex > radio[checked=true]').size()==0||
			   $('#in')[0].getText().size()==0||
			   $('#call')[0].getText().size()==0||
			   $('#email')[0].getText().size()==0||
			   $('#address')[0].getText().size()==0){
			   
				alert('กรอกข้อมูลไม่ครบ')
			}

			else{
				alert('OK')

			}
		})
        
    }
}
