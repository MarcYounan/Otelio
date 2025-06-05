package com.otelio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.otelio.dto.RoomDTO;
import com.otelio.model.Room;
import com.otelio.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    
    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms(); 
    }
    
    @PostMapping
    public Room createRoom(@RequestBody RoomDTO roomDTO) {
        return roomService.createRoom(roomDTO);
    }
}
