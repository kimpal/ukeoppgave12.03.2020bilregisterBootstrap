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
        listBiler.add(new BilMerke ("VelgBil!","0"));
        listBiler.add(new BilMerke ("Audi","A"));
        listBiler.add(new BilMerke ("Volvo", "V"));
        return listBiler;
    }

    @GetMapping("hentBiltyperA")
    public List<BilTypeA> hentAlleBilTyperA() {
        List<BilTypeA> listBityperA= new ArrayList<>();
        listBityperA.add(new BilTypeA ("A1"));
        listBityperA.add(new BilTypeA ("A3"));
        listBityperA.add(new BilTypeA ("A4"));
        listBityperA.add(new BilTypeA ("A5"));
        listBityperA.add(new BilTypeA ("A6"));
        listBityperA.add(new BilTypeA ("A7"));
        listBityperA.add(new BilTypeA ("A8"));
        listBityperA.add(new BilTypeA ("Q2"));
        listBityperA.add(new BilTypeA ("Q3"));
        listBityperA.add(new BilTypeA ("Q7"));
        listBityperA.add(new BilTypeA ("Q8"));
        listBityperA.add(new BilTypeA ("R8"));
        return listBityperA;
    }
    @GetMapping("hentBiltyperV")
    public List<BilTypeV> hentAlleBilTyperV() {
        List<BilTypeV> listBityperV = new ArrayList<> ();
        listBityperV.add ( new BilTypeV ( "V8" ) );
        listBityperV.add ( new BilTypeV ( "XC70" ) );
        return listBityperV;
    }


    @GetMapping("/slettAllekjoretoy")
    public void slettArrey(){
        allekjoretoy.clear ();
    }
}

