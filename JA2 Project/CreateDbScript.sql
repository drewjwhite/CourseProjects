create database ufly;

use ufly;

create table flight (FlightNumber varchar(10) not null, DepartureAirport varchar(5) not null,
 DestinationAirport varchar(5) not null, Price decimal(10,2) not null, DateTime datetime not null,
 Plane varchar(20) not null, SeatsTaken int(11), primary key(FlightNumber));

create table location (City varchar(45) not null, AirportCode varchar(5) not null, 
 primary key(AirportCode));
 
create table booking (BookingNumber int(11) not null auto_increment, FlightNumber varchar(10) not null,
 Price decimal(10,2) not null, CabinClass varchar(20) not null, Quantity int(11) not null,
 Insurance bit(1) not null, primary key(BookingNumber));
 