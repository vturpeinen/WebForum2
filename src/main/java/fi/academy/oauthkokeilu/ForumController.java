package fi.academy.oauthkokeilu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ForumController {
    private ViestiDAO dao;
    private KayttajaDAO dak;

    @Autowired
    public ForumController(ViestiDAO dao, KayttajaDAO dak) {
        this.dao = dao;
        this.dak = dak;
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
    @GetMapping("/users")
    public List<Users> kaikkiKayttajat(
            @RequestParam(name = "filtteri", required = false) String name) {
        if (name == null) {
            List kayttajat = dak.haeKaikkiKayttajat();
            return kayttajat;
        }
        return dak.haeKaikkiKayttajat();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "name")String name){
        dak.deleteByName(name);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/users")
    public ResponseEntity<?>lisaapa(@RequestBody Users username) throws URISyntaxException {
        dak.lisaapa(username);
        return ResponseEntity.created(new URI("/users")).build();
    }
}

