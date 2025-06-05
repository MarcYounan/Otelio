package com.otelio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otelio.dto.RoomDTO;
import com.otelio.model.Hotel;
import com.otelio.model.Room;
import com.otelio.repository.HotelRepository;
import com.otelio.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public Room createRoom(RoomDTO roomDTO) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(roomDTO.getHotelId());

        if (optionalHotel.isEmpty()) {
            throw new RuntimeException("Hotel not found with ID : " + roomDTO.getHotelId());
        }

        Hotel hotel = optionalHotel.get();

        Room room = new Room();
        room.setNumber(roomDTO.getNumber());
        room.setType(roomDTO.getType());
        room.setPrice(roomDTO.getPrice());
        room.setHotel(hotel);

        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
