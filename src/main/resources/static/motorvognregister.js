/*$(function () {
    hentBilmerker();
});
function hentBilmerker() {
    $.get("/hentBilmerker", function (Bilmerker) {
        formaterBilmerker(Bilmerker);

    });
}
function formaterBilmerker(Bilmerker) {
    let ut ="<select id=ValgtMerke>";
    for(const Bilmerke of Bilmerker){
        ut+="<option value='"+Bilmerke.merke+"'>"+"</option>";
    }
    ut+= "</select>";
     $("bilmerkeInn").html(ut)

}

 */
//Bilmerke dropdown
$(function() {  // kjøres når dokumentet er ferdig lastet
    hentAlleBilmerker();
    hentAlleBilTyper();
});
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

// typeBil(modell) dropdown
function hentAlleBilTyper() {
    $.get("/hentBiltyper", function(typer) {
        formaterBilTyper(typer);
    });
}function formaterBilTyper(typer) {
    let ut = "<select id='valgtBilType'>";
    for(const BilType of typer) {
        ut += "<option value='" + BilType.typebil+"'>" + BilType.typebil+ "</option>";
    }
    ut += "</select>";
    $("#biltypene").html(ut);
}

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

    $("#personnummerInn").val("");
    $("#navInn").val("");
    $("#adresseInn").val("");
    $("#kjenetegnInn").val("");
    $("#bilmerkeInn").val("");
    $("#biltypeInn").val("");
}
function hentAlle() {
    $.get("/hentAlle", function (data) {
        formaterData(data);
    });

}
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
function slettArrey() {
    $.get("/slettAllekjoretoy",function () {
        hentAlle()

    });
}