/* Submit only works if all fields have values
Bug: Works if text is deleted again and field is left empty.
Fix this in the backend*/
$(document).ready(function() {
     $('button[type="submit"]').prop('disabled', true);
     $('input[type="text"]' && 'input[type="password"]').keyup(function() {
        if($(this).val() != '') {
           $('button[type="submit"]').prop('disabled', false);
        }
     });
 });

//$( ".selector" ).button( "refresh" );
