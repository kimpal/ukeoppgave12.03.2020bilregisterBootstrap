function regKjoretøy() {
    const kjoretoyregister ={
        personnummer: $("#personnummerInn").val(),
        navn : $("#navInn").val(),
        adresse: $("#adresseInn").val(),
        kjenetegn: $("#kjenetegnInn").val(),
        bilmerke: $("#bilmerkeInn").val(),
        biltype: $("#biltypeInn").val()
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
function formaterData(kjoretøyregistere) {
    let ut = "<table class='table table-striped'>" +
        "<thead>" +
        "<tr>" +
            "<th scope ='col'>Personnr</th>" +
            "<th scope='col'>Navn</th>" +
            "<th scope='col'>Adresse</th>" +
            "<th scope='col'>Kjenetegn</th>" +
            "<th scope='col'>Merke</th>" +
            "<th scope='col'>Type</th>" +
        "</tr>" +
        "</thead>"

    for(const kjoretoyregister of kjoretøyregistere){
        ut+="<tbody class = 'table-striped '>" +
            "<tr>" +
            "<th scope='row'>"+kjoretoyregister.personnummer+"</th>" +
            "<td>"+kjoretoyregister.navn+"</td>" +
            "<td>"+kjoretoyregister.adresse+"</td>" +
            "<td>"+kjoretoyregister.kjenetegn+"</td>" +
            "<td>"+kjoretoyregister.bilmerke+"</td>" +
            "<td>"+kjoretoyregister.biltype+"</td>" +
            "<tr/>" +
            "</tbody>"
    }
    ut+= "</table>"
    //ut+="<table class='table table-striped'>";
    $("#kjoretoyregisterut").html(ut);
}
function slettArrey() {
    $.get("/slettAllekjoretoy",function () {
        hentAlle()

    });
}