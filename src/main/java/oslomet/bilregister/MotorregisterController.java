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
    @GetMapping("hentBilmerker")
    public List<BilMerke> hentAlleBilmerker() {
        List<BilMerke> listBiler= new ArrayList<>();
        listBiler.add(new BilMerke ("Audi"));
        listBiler.add(new BilMerke ("Bmw"));
        listBiler.add(new BilMerke ("Ford"));
        listBiler.add(new BilMerke ("Opel"));
        listBiler.add(new BilMerke ("Subaru"));
        listBiler.add(new BilMerke ("Volvo"));
        return listBiler;
    }

    @GetMapping("hentBiltyper")
    public List<BilType> hentAlleBilTyper() {
        List<BilType> listBityper= new ArrayList<>();
        listBityper.add(new BilType("A4"));
        listBityper.add(new BilType("A5"));
        listBityper.add(new BilType("A6"));
        listBityper.add(new BilType("Z4"));
        listBityper.add(new BilType("M5"));
        listBityper.add(new BilType("escort"));
        listBityper.add(new BilType("ascona"));
        listBityper.add(new BilType("legacy"));
        listBityper.add(new BilType("outback"));
        listBityper.add(new BilType("T8"));
        listBityper.add(new BilType("XC70"));
        return listBityper;
    }

    @GetMapping("/slettAllekjoretoy")
    public void slettArrey(){
        allekjoretoy.clear ();
    }
}

