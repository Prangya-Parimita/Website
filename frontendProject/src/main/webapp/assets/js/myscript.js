
$(function() {

	switch (menu) 
	{

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		break;
	}
 
	var products = [  [1, "SMARTPHONE"],
	                  [2, "TV"],
	                  [3, "AC"],
	                  [4, "LAPTOP"],
	                  [5, "DESKTOP"],
	                  [6, "FRIDGE"],
	                  [7, "HEADPHONE"],
	                  [8, "KEYBOARD"],
	                  [9, "COOLER"],
	                  [10,"MUSIC sYSTEM"]
	  
                   ];
	
	var $table = $('#productTable');
	
	if($table.length)
	{ 
		$table.DataTable({
		data:products
		});
	}
});