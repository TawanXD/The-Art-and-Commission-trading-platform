package Controller;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import Entity.Artist;
import Entity.Customer;
import org.springframework.stereotype.Controller;
//import Service.FeedServiceImpl;
import Service.ArtistService;

import java.io.IOException;

@Controller
@CrossOrigin(maxAge = 3600)
@RequiredArgsConstructor
public class ArtistController {
    final ArtistService artistService;
//    final FeedServiceImpl feedService;

    @GetMapping("artists")
    public ResponseEntity<?> getArtistLists(@RequestParam(value = "_limit", required = false) Integer perPage
            ,@RequestParam(value = "_page",required = false)Integer page) {
        Page<Artist> pageOutput = artistService.getArtists(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",
                String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(pageOutput.getContent(),responseHeader,HttpStatus.OK);
    }

    @GetMapping("artists/{id}")
    public ResponseEntity<?> getArtist(@PathVariable("id") Long id) {
        Artist output = artistService.getArtist(id);
        if (output != null){
            return ResponseEntity.ok(output);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The Given id is not found");
        }
    }

    @PostMapping("/artists")
    public ResponseEntity<?> addArtist(@RequestBody Artist artist){
        Artist output = artistService.save(artist);
        return ResponseEntity.ok(output);
    }

    @PutMapping("/updateArtist/{id}")
    public ResponseEntity<?> updateArtist(@PathVariable("id") Long id, @RequestBody Artist updatedArtist) {
        Artist old = artistService.getArtist(id);
        if (updatedArtist.getName() != null || updatedArtist.getName() != ""){
            old.setName(updatedArtist.getName());
        }
        if (updatedArtist.getSurname() != null){
            old.setSurname(updatedArtist.getSurname());
        }
        if (updatedArtist.getDepartment() != null){
            old.setDepartment(updatedArtist.getDepartment());
        }
        if (updatedArtist.getPosition() != null){
            old.setPosition(updatedArtist.getPosition());
        }
        if (updatedArtist.getImage() != null){
            old.setImage(updatedArtist.getImage());
        }

        Artist output = artistService.save(updatedArtist);
        return ResponseEntity.ok(output);
    }
//    @PostMapping("/uploadFile")
//    public ResponseEntity<?> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
//        String uploadImage = feedService.uploadImage(file);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(uploadImage);
//    }
//
//    @GetMapping("/uploadFile/{fileName}")
//    public ResponseEntity<?> downloadFile(@PathVariable String fileName){
//        byte[] fileData = feedService.downloadImage(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .body(fileData);
//    }
}
