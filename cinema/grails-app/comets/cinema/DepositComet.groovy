package cinema

import org.zkoss.zk.grails.*

class DepositComet extends GrailsComet {

     int i = 10

    static trigger = [startDelay: 0L, every: 1000L]

    def beforeExecute = { desktop, page ->
        lblBefore.value = "Before"
    }

    def execute = { desktop, page ->
        i--
        lblTest.value = "time : ${i}"
        
        if(i == 0) stop()
    }

    def afterExecute = { desktop, page ->
        lblAfter.value = "After"
    }
}
