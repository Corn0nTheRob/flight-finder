/**
 * 
 */

function isEmpty(str) {
    return (!str || 0 === str.length);
}

function validateLogin() {
  var x = document.forms["login"]["user"].value;
  if  (isEmpty(x)) {
    alert("Name must be filled out");
    return false;
  }

 var y = document.forms["login"]["password"].value;
  if  (isEmpty(y)) {
    alert("Password must be filled out");
    return false;
  }
}

function validateflightsearch() {
  var from = document.forms["search"]["cityFrom"].value;
  if  (isEmpty(from)) {
    alert("From must be filled out");
    return false;
  }

 var to = document.forms["search"]["cityTo"].value;
  if  (isEmpty(to)) {
    alert("To must be filled out");
    return false;
  }

 var travelDate = document.forms["search"]["departDate"].value;
  if  (isEmpty(travelDate)) {
    alert("Travel date must be filled out");
    return false;
  }
  var travelDate = document.forms["search"]["returnDate"].value;
  var flightType = document.forms["search"]["options"].value;
  if  (isEmpty(travelDate)) {
    alert("Travel date must be filled out");
    return false;
  }

 var numPass = document.forms["search"]["numPass"].value;
  if  (isEmpty(numPass)) {
    alert("Number of passengers must be filled out");
    return false;
  }
}