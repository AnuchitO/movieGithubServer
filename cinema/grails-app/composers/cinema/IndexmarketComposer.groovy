package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class IndexmarketComposer extends GrailsComposer {

    def afterCompose = { window ->
        $("#nextbtn").on("click", {
				redirect(uri:'totalmarket.zul')
			})


    }
}
