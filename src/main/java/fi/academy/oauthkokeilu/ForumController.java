package fi.academy.oauthkokeilu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@RequestMapping("/messages")

public class ForumController {
    private ForumDAO dao;

    @Autowired
    public ForumController(ForumDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/messages")
    public List<Viestit> kaikkiViestit(
            @RequestParam(name = "filtteri", required = false) String label) {
        if (label == null) {
            List viestit = dao.haeKaikkiViestit();
            return viestit;
        }
        return dao.haeKaikkiViestit();
    }
}
  /*



    @DeleteMapping("/{code}")
    public ResponseEntity<?> jokuKyla(@PathVariable(name= "code")String code){
        dao.jokKyla(code);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/Cityt")
    public ResponseEntity<?>asetaKyla(@RequestBody Cityt kyla) {
        dao.asetakyla(kyla);
        return ResponseEntity.noContent().build();
    }
}
}
/*
    @PostMapping
    @RequestBody Cityt,
    public List<Cityt> kaikkiMaat() {
        List maat = dao.haeKaikkiMaat();
        return maat;
    }
}
*/
    /*
    // FILTTEROINTI ja hakuparametriinn LIKE%
        public List<Maa> kaikkiMaat(@RequestParam(name="filtteri",required = false)String nimi) {
        if (nimi = null){
        List <Maa> maat = dao.haeKaikkiMaat();
        return maat;
    }
    return  dao.haeKaikkiMaat(nimi);
    @GetMapping
    public List<City> kaupungit(){
        List kylat = dao.haeKaupungit();
        return kylat;
    }
}
*/
