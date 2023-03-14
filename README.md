# spring reservation system
 graduation project


APIs:
=====

1- Request Booking : (new booking / rebook) 
--------------------
* URL : 
* function : request a new booking for user.
* request body  : userId , roomId , date , startTime , endTime.
* logic : 1) check if room is avaliable for the request period.
          2) reply with booking if sucessfully created and send mail or error status if already booked.
* response : avaliable --> status: ok  , message: successfully booked ,code : 200 
             not avaliable --> status : error , message : room is booked in this time slot.
     
             
2- Cancel Booking:
------------------
* URL : "_____/bookingId=value"
* function : cancel booking already submitted.
* request  body :
* logic : 
  1) check if booking can be cancelled.
  2) cancel booking and send response.
* response : canceled --> status : ok  , message : successfully cancelled , code : 200.
             not canceled --> status : error , message : booking can't be canceled.
             
3- Booking History:
-------------------
* URL : "                 /userId=value"
* function : get history of all bookings of user.
* request body : 
* logic : return all booking of currently logged user sorted by date.
* response : list of (  startTime , endTime , date , roomName , spaceName , roomImage , price , spaceAddress ) 
 
 
