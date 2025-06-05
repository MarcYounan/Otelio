package com.otelio.service;

import com.otelio.model.Hotel;
import com.otelio.model.Room;
import com.otelio.model.RoomType;
import com.otelio.repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Transactional
    public void createSampleHotel() {
        Hotel hotel = new Hotel();
        hotel.setName("Hôtel du Chat");
        hotel.setAddress("123 Rue des Chats, Paris");

        Room room1 = new Room();
        room1.setNumber("101");
        room1.setType(RoomType.SIMPLE);
        room1.setHotel(hotel);

        Room room2 = new Room();
        room2.setNumber("102");
        room2.setType(RoomType.DOUBLE);
        room2.setHotel(hotel);

        hotel.setRooms(Arrays.asList(room1, room2));

        hotelRepository.save(hotel);

        System.out.println("Hôtel créé : " + hotel);
    }
}
