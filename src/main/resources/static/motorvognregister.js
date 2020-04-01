//Document ready function
$(function() {  // kjøres når dokumentet er ferdig lastet
    hentAlleBilmerker();
});
//Bilmerke dropdown
function hentAlleBilmerker() {
    $.get("/hentBilmerker", function(merker) {
        formaterBiler(merker);
    });
}function formaterBiler(merker) {
    let ut = "<select id='valgtBil'>";
    for(const BilMerke of merker) {
        ut += "<option value='" + BilMerke.merke+"'>" + BilMerke.merke+ "</option>";
    }
    ut += "</select>";
    $("#bilmerkene").html(ut);
}
// sjekerr hvilke merke som er vagt og gir riktig type der etter
function merke() {
    console.log($("#valgtBil").val());
    if ($("#valgtBil").val() === ('Audi')){
        Audi()
    }
    else {
        volvo()
    }

}

function Audi() {
    hentAlleBilTyperA();
    // Audi
// typeBilA(modell) dropdown
    function hentAlleBilTyperA() {
        $.get("/hentBiltyperA", function(typer) {
            formaterBilTyperA(typer);
        });
    }function formaterBilTyperA(typer) {
        let ut = "<select id='valgtBilType'>";
        for(const BilTypeA of typer) {
            ut += "<option value='" + BilTypeA.typebil+"'>" + BilTypeA.typebil+ "</option>";
        }
        ut += "</select>";
        $("#biltypene").html(ut);
    }

}

function volvo() {
    hentAlleBilTyperV()
    //Volvo
// typeBilV(modell) dropdown
    function hentAlleBilTyperV() {
        $.get("/hentBiltyperV", function(typer) {
            formaterBilTyperV(typer);
        });
    }function formaterBilTyperV(typer) {
        let ut = "<select id='valgtBilType'>";
        for(const BilTypeV of typer) {
            ut += "<option value='" + BilTypeV.typebil+"'>" + BilTypeV.typebil+ "</option>";
        }
        ut += "</select>";
        $("#biltypene").html(ut);
    }

}

// tar verdiene og sender til serveren
function regKjoretøy() {
    const kjoretoyregister ={
        personnummer: $("#personnummerInn").val(),
        navn : $("#navInn").val(),
        adresse: $("#adresseInn").val(),
        kjenetegn: $("#kjenetegnInn").val(),
        bilmerke: $("#valgtBil").val(),
        biltype: $("#valgtBilType").val()
    };

    $.post("/lagre",kjoretoyregister, function (){
        hentAlle();
    });

   // blanker input felter
    $("#personnummerInn").val("");
    $("#navInn").val("");
    $("#adresseInn").val("");
    $("#kjenetegnInn").val("");
    $("#valgtBil").val("");
    $("#valgtBilType").val("");
}
function hentAlle() {
    $.get("/hentAlle", function (data) {
        formaterData(data);
    });

}
// Tabbel header for kjøretoyregister
function formaterData(kjoretoyregistere) {
    let ut = "<table class='table table-striped'>" +
            "<tr>" +
            "<th>Personnr</th>" +
            "<th>Navn</th>" +
            "<th>Adresse</th>" +
            "<th>Kjenetegn</th>" +
            "<th>Merke</th>" +
            "<th>Type</th>" +
             "</tr>";
    // luper igjennom  Arreyet for kjoretoyregister med en for lup
    for(const kjoretoyregister of kjoretoyregistere){
        ut+=
            "<tr>" +
            "<td>"+kjoretoyregister.personnummer+"</td>" +
            "<td>"+kjoretoyregister.navn+"</td>" +
            "<td>"+kjoretoyregister.adresse+"</td>" +
            "<td>"+kjoretoyregister.kjenetegn+"</td>" +
            "<td>"+kjoretoyregister.bilmerke+"</td>" +
            "<td>"+kjoretoyregister.biltype+"</td>" +
            "</tr>";
    }
    ut += "</table>";
    $("#kjoretoyregisterut").html(ut);
}

// function som tommer arreyet
function slettArrey() {
    $.get("/slettAllekjoretoy",function () {
        hentAlle()

    });
}