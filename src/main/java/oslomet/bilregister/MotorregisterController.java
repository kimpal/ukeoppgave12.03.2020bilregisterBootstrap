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
        listBiler.add(new BilMerke ("Audi", "A4"));
        listBiler.add(new BilMerke ("Bmw", "A8"));
        listBiler.add(new BilMerke ("Ford", "A8"));
        listBiler.add(new BilMerke ("Opel", "A8"));
        listBiler.add(new BilMerke ("Subaru", "A8"));
        listBiler.add(new BilMerke ("Volvo", "T8"));
        return listBiler;
    }




    @GetMapping("hentBiltyper")
    public List<BilType> hentAlleBilTyper() {
        List<BilType> listBityper= new ArrayList<>();
        listBityper.add(new BilType("A4", "Audi"));
        listBityper.add(new BilType("A5", "Audi"));
        listBityper.add(new BilType("A6", "Audi"));
        listBityper.add(new BilType("Z4", "Bmw"));
        listBityper.add(new BilType("M5", "Bmw"));
        listBityper.add(new BilType("escort", "Ford"));
        listBityper.add(new BilType("ascona", "Opel"));
        listBityper.add(new BilType("legacy", "Subaru"));
        listBityper.add(new BilType("outback", "Subaru"));
        listBityper.add(new BilType("T8", "Volvo"));
        listBityper.add(new BilType("XC70", "Volvo"));
        return listBityper;
    }




    @GetMapping("/slettAllekjoretoy")
    public void slettArrey(){
        allekjoretoy.clear ();
    }




    }

