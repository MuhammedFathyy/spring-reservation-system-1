# spring reservation system
 graduation project


APIs:
=====

1- Request Booking : (new booking / rebook) 
--------------------
* URL : 
* function : request a new booking for user.
* request body  : userId , roomId , date , startTime , endTime.
* logic :
          1) check if room is avaliable for the request period.
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
* URL : "http://localhost:8080/api/bookings/bookingsHistory/[userID]"
* function : get history of all bookings of user.
* path variable : user ID .
* logic : return all data needed about the bookings of currently logged user(given its id) sorted by date fron new to old .
* response : BookingDTO (  userFirstName , userLastName ,startTime , endTime , date , roomName , spaceName , roomImage , price , spaceAddress ) 
 
 
