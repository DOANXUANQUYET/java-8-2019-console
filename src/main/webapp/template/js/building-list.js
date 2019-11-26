function assigmentBuilding() {
	openAssigmentBuilding();
}
function openAssigmentBuilding() {
	$('#buildingModal').modal();
}

$('#searchBuilding').click(function(e) {
	e.preventDefault();
	$('#mode').val('SEARCH');
	$('#buildingForm').submit();
});
