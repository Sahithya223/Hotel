package com.roomservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roomservice.entity.Room;
import com.roomservice.entity.RoomList;
import com.roomservice.service.RoomService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@PostMapping("/add")
	public ResponseEntity<Room> saveRoom(@RequestBody Room room) {
		Room savedRoom = roomService.addRoom(room);
		return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Room> modifyRoom(@RequestBody Room room) {
		Room updatedRoom = roomService.updateRoom(room);
		return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
	}

	@GetMapping("/find/{roomId}")
	public ResponseEntity<Room> getByRoomId(@PathVariable("roomId") int id) {
		Room room = roomService.findByRoomId(id);
		return new ResponseEntity<>(room, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Room>> fetchAllRooms() {
		List<Room> list = roomService.getAllRooms();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{roomId}")
	public ResponseEntity<String> removeRoom(@PathVariable("roomId") int id) {
		String msg = roomService.deleteRoom(id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
     @GetMapping("/available")
	public ResponseEntity<List<Room>> fetchAllAvailableRooms() {
		List<Room> list = roomService.getRoomsAvail();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
     @GetMapping("/{roomType}/{roomDesc}")
     public ResponseEntity<List<Room>> fetchRooms(@PathVariable("roomType") String roomType, @PathVariable("roomDesc") String roomDesc)
     {
    	 List<Room> list=roomService.findByRoomType(roomType, roomDesc);
    	 return new ResponseEntity<>(list,HttpStatus.OK);
     }
     @GetMapping("/{roomNo}")
     public ResponseEntity<Room> getByRoomNo(@PathVariable("roomNo") int roomNo)
     {
    	 Room room=roomService.getByRoomNo(roomNo);
    	 return new ResponseEntity<>(room,HttpStatus.OK);
     }
     @PutMapping("/checkout/{roomNo}")
     public ResponseEntity<Room> doCheckOut(@PathVariable("roomNo") int roomNo)
     {
    	 Room room=roomService.checkOut(roomNo);
    	 return new ResponseEntity<>(room,HttpStatus.OK);
     }

}
