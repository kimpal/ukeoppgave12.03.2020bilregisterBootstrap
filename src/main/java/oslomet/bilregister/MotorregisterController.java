package oslomet.bilregister;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MotorregisterController {

    public final List<kjoretoyregister> allekjoretoy = new ArrayList<> (  );

    @PostMapping("/lagre")
    public void lagrekjoretoyregister(kjoretoyregister innkjoretoyregister){
        allekjoretoy.add ( innkjoretoyregister );
    }
    @GetMapping("/hentAlle")
    public List<kjoretoyregister> hentAlle(){
        return allekjoretoy;
    }

    @GetMapping("/slettAllekjoretoy")
    public void slettArrey(){
        allekjoretoy.clear ();
    }




}

