import cinema.*
class BootStrap {

    def init = { servletContext ->

    	def movie
    	def seats
        def account1
		def account2
		def account3
		def account4
       

        account1 = new Individual(
            firstName:"apichat",
            lastName:"eakwongsa",
            number:"1234567890123",
          date:"mm/dd/yy",
          status:"single",
          address:"address",
          moo:"12",
          district:"district",
          canton:"canton",
          county:"county",
          post:"30000",
          phone:"1234567890",
          degree:"degree",
          major:"major",
            university:"123",
            position:"Ticker",
            userId:"admin1",
            password:"admin1",
            rePassword:"admin1"
            ).save()
			
		account2 = new Individual(
            firstName:"โอเด้ง",
            lastName:"โชติชัย",
            number:"1234567890123",
            date:"mm/dd/yy",
            status:"single",
            address:"address",
            moo:"12",
            district:"district",
            canton:"canton",
            county:"county",
            post:"30000",
            phone:"1234567890",
            degree:"degree",
            major:"major",
            university:"123",
            position:"Market",
            userId:"admin2",
            password:"admin2",
            rePassword:"admin2"
            ).save()
		account3 = new Individual(
            firstName:"ต้อม",
            lastName:"นะ",
            number:"1234567890123",
            date:"mm/dd/yy",
            status:"single",
             address:"address",
            moo:"12",
            district:"district",
            canton:"canton",
            county:"county",
            post:"30000",
            phone:"1234567890",
            degree:"degree",
            major:"major",
            university:"123",
            position:"Room",
            userId:"admin3",
            password:"admin3",
            rePassword:"admin3"
            ).save()
		account4 = new Individual(
            firstName:"เก๋",
            lastName:"โหด",
            number:"1234567890123",
            date:"mm/dd/yy",
            status:"single",
            address:"address",
            moo:"12",
            district:"district",
            canton:"canton",
            county:"county",
             post:"30000",
             phone:"1234567890",
             degree:"degree",
             major:"major",
            university:"123",
            position:"Deposit",
            userId:"admin4",
            password:"admin4",
            rePassword:"admin4"
            ).save()
    	movie = new Movie(
    		movId:"0000",
		 	movType:"Drama",
		 	movName:'Demo',
		 	movSuperintendent:"pad Nong",
		 	movDetail:"Love",
		 	movCost:"2000k",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
		 	movPicture640:"./ext/logoMovie/1200725803.jpg",
		 	movPicture140:"./ext/logoMovie/1200725803.jpg",
            promotion:"Empty",
			longTime:120	
    	).save()

        def movie2 = new Movie(
            movId:"0001",
            movType:"Action",
            movName:"COCO",
            movSuperintendent:"9Deng",
            movDetail:"BOOM",
            movCost:"3000k",
            movDate:"1/2/1111",
            movDateEnd:"1/3/1111", 
            movPicture640:"./ext/logoMovie/coco.jpg",
            movPicture140:"./ext/logoMovie/coco.jpg",
            promotion:"Empty",
            longTime:160   
        ).save()

        def movie3 = new Movie(
            movId:"0002",
            movType:"SiFi",
            movName:"Core",
            movSuperintendent:"Kopeeno",
            movDetail:"Earth",
            movCost:"2000k",
            movDate:"1/3/1111",
            movDateEnd:"1/4/1111", 
            movPicture640:"./ext/logoMovie/core.jpg",
            movPicture140:"./ext/logoMovie/core.jpg",
            promotion:"Empty",
            longTime:180   
        ).save()

        def t1 = new Theater(
            theaterId:"1",
            movies:movie
        ).save()

        def t2 = new Theater(
            theaterId:"2",
            movies:movie2
        ).save()

        def t3 = new Theater(
            theaterId:"3",
            movies:movie3
        ).save()

        def s = new Show(
            showTime:"09.00",
            theaters:t1,
            movies:movie
        ).save()

        def s2 = new Show(
            showTime:"09.00",
            theaters:t2,
            movies:movie2
        ).save()

        def s3 = new Show(
            showTime:"09.00",
            theaters:t3,
            movies:movie3
        ).save()

        



    //seats= new Seats(seatNumber:"AA",tel:"123456",amount:null,rooms:null)
 	//if (seats.validate()) {
    //    seats.save()
    // }else println seats.errors














    }
    def destroy = {
    }
}
