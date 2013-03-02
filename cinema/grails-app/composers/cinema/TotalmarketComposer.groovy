package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class TotalmarketComposer extends GrailsComposer {

    def afterCompose = { window ->
        $("#backbtn").on("click", {
				redirect(uri:'indexmarket.zul')
			})

    }
}
