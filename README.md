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
* response :
    * avaliable --> status: ok , message: successfully booked ,code : 200
    * not avaliable --> status : Bad Request , message : room is booked in this time slot.
     
             
2- Cancel Booking:
------------------
* URL : "_____/bookingId=value"
* function : cancel booking already submitted.
* request body :
* logic :
    1) check if booking exists
    2) check if booking can be cancelled (duration left).
    2) cancel booking and send response.
* response :
    * doesn't exist --> status: Bad Request, message: booking with id {id} doesn't exist
    * canceled --> status : ok , message : successfully cancelled , code : 200.
    * not canceled --> status : Bad Request , message : booking can't be canceled.
             
3- Booking History:
-------------------
* URL : "http://localhost:8080/api/bookings/bookingsHistory/[userID]"
* function : get history of all bookings of user.
* path variable : user ID .
* logic : return all data needed about the bookings of currently logged user(given its id) sorted by date fron new to old .
* response : BookingDTO (  userFirstName , userLastName ,startTime , endTime , date , roomName , spaceName , roomImage , price , spaceAddress ) 


4- Our Spaces:
-------------------
* URL : "localhost:8080/api/spaces/allspaces/[pagenumber]"
* function : get all spaces.
* path variable : page number .
* logic : return all the data in AllSpacesDTO(name,address,rating,images), without fetching all the spaces, fetching 8 by 8 according to the page number

5- View space:
-------------------
* URL : "localhost:8080/api/spaces/[spaceId]"
* function : get the data of specific space.
* path variable : spaceId .
* logic : return all the data in spaceDTO,(all the space data except rooms,owner), and longitude latitude of the space


6- Delete space:
-------------------
* URL : "localhost:8080/api/spaces/[spaceId]"
* function : delete the space.
* path variable : spaceId .
* logic : delete a space.

7- Modify space:
-------------------
* URL : "localhost:8080/api/spaces/[spaceId]"
* function : update the data of specific space.
* path variable : spaceId .
* logic : the data that we want to modify will be passed as json format in the request body

8- View profile:
-------------------
* URL : "localhost:8080/api/user/[userId]"
* function : get the data of specific user.
* path variable : userId .
* logic : return all the data in userDTO,(all the space data except password,requests,booking)

9- update profile:
-------------------

* URL : "localhost:8080/api/user/[userId]"
* function : update the data of specific user.
* path variable : userId.
* logic : the data that we want to modify will be passed as json format in the request body except(
  email,password,points(modified by the system))

10- View User's Bookings:
---------------------------

* URL: "localhost:8080/api/user/{userId}/bookings"
* function: View all bookings of specific user