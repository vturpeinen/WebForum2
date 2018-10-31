package fi.academy.oauthkokeilu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
//@RequestMapping("/messages")
@CrossOrigin("*")
public class ForumController {
    private ViestiDAO dao;

    @Autowired
    public ForumController(ViestiDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/messages")
    public List<Messages> kaikkiViestit(
            @RequestParam(name = "filtteri", required = false) String label) {
        if (label == null) {
            List viestit = dao.haeKaikkiViestit();
            return viestit;
        }
        return dao.haeKaikkiViestit();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id")Integer id){
        dao.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/messages")
    public ResponseEntity<?>lisaa(@RequestBody Messages label) throws URISyntaxException {
        dao.lisaa(label);
        return ResponseEntity.created(new URI("/messages")).build();
    }
//    @PostMapping("/messages")
//    public ResponseEntity<?>lisaa(@RequestBody Messages messages) {
//        dao.lisaa(messages);
//        String url = "http://localhost:8080/messages/" + messages.getLabel();
//        return ResponseEntity.created(URI.create(url)).build();
//    }

}

